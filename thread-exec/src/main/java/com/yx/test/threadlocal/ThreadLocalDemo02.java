package com.yx.test.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
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
        return simpleDateFormat.format(date);
    }


}
