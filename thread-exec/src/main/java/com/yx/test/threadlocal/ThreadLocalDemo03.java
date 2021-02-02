package com.yx.test.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

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
        TheadLocalHolder.chear();
    }

    public String date(int i) {
        Date date = new Date(1000 * i);
        SimpleDateFormat simpleDateFormat = TheadLocalHolder.dateFormatThreadLocal.get();
        System.out.println(System.identityHashCode(simpleDateFormat)); // 验证是否同一个对象（开多少个线程就会有多少个对象）
        return simpleDateFormat.format(date);
    }
}

class TheadLocalHolder {
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("mm:ss"));

    public static void chear() {
        dateFormatThreadLocal.remove();
    }

}