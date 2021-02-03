package com.yx.test.threadlocal.part1;

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
public class ThreadLocalDemo02 {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
    private static ExecutorService executorService = Executors.newFixedThreadPool(20);

    /**
     * 线程处理不安全，会出现资源抢夺情况
     * static 修饰的资源在常量池中。共用同一个
     * *
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int j = i;
            executorService.submit(() -> {
                String date = new ThreadLocalDemo02().date(j);
                System.out.println(j + "===>" + date);
            });
        }
        executorService.shutdown();
    }


    public synchronized String date(int i) {
        Date date = new Date(1000 * i);
      // 方式1 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss"); // 每次调用都会创建一个对象、创建了1000个对象调用
        //方式2 添加Synchronize 关键字、但是有点得不偿失、其他线程都得等待
        synchronized (ThreadLocalDemo02.class){
            return simpleDateFormat.format(date);
        }
        /*** 共用同一个日期格式对象 ，出现线程不安全问题
         * return simpleDateFormat.format(date);
         */
    }


}
