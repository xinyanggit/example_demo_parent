package com.yx.test.threadlocal.part1;

import org.apache.commons.lang3.time.StopWatch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 重新练习一下ThreadLocal处理方式
 * 模拟一下 入参毫秒数，然后DateFormat格式化日期打印处理
 *
 * @author yangxin
 * @date 2021年02月02日
 * @time 4:11 下午
 * @since JDK1.8
 */
public class ThreadLocalDemo05CountDownLatch {

    /**
     * 生产中禁用这种创建多线程的方式，应该采用线程池构建函数的方式创建
     */
    static ExecutorService executorService = Executors.newFixedThreadPool(7);
    static Map map = new ConcurrentHashMap();
    private static  Integer number = 1000;


    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        CountDownLatch countDownLatch = new CountDownLatch(number);
        for (int i = 0; i < number; i++) {
            int millSecond = i;
            executorService.submit(() -> {
                SimpleDateFormat simpleDateFormat =  ThreadLocal.withInitial(() -> new SimpleDateFormat("mm:ss")).get();
                Date date = new Date(millSecond * 1000);
                if (map.containsKey(simpleDateFormat)) {
                    System.out.println("命中一次");
                } else {
                    map.put(simpleDateFormat, 1);
                    System.out.println("创建dateFormat对象");
                }
                String date2 =  simpleDateFormat.format(date);
                countDownLatch.countDown();
               // String date = new ThreadLocalDemo04().date(millSecond);
                System.out.println(millSecond + "==" + date2);
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopWatch.stop();
        long time = stopWatch.getNanoTime();
        System.out.println("cost time : "+ time/1000 /1000 + " ms ");
        executorService.shutdown();
    }

}