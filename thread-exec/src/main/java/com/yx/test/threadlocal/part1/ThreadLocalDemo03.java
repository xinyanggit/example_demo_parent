package com.yx.test.threadlocal.part1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 判断
 *
 * @author yangxin@webull.com
 * @date 2020年11月17日
 * @time 4:55 下午
 * @since JDK1.8
 */
public class ThreadLocalDemo03 {

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    static  Map map = new ConcurrentHashMap();

    /**
     * *
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int j = i;
            executorService.submit(() -> {
                String date = new ThreadLocalDemo03().date(j);
                System.out.println(j + "===>" + date);
            });
        }
        executorService.shutdown();
        TheadLocalHolder.clear();
    }

    public String date(int i) {
        Date date = new Date(1000 * i);
        SimpleDateFormat simpleDateFormat = TheadLocalHolder.dateFormatThreadLocal.get();
        // 验证是否同一个对象（开多少个线程就会有多少个对象）
        if (map.containsKey(simpleDateFormat)) {
            System.out.println("命中一次");
        } else {
            map.put(simpleDateFormat, 1);
            System.out.println("创建dateFormat对象");
        }
        // System.out.println(System.identityHashCode(simpleDateFormat));
        return simpleDateFormat.format(date);
    }
}

class TheadLocalHolder {
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("mm:ss"));

    public static void clear() {
        dateFormatThreadLocal.remove();
    }

}