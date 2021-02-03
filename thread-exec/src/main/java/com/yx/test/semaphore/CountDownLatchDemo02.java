package com.yx.test.semaphore;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 场景一：
 * 多个人等一个
 * @author yangxin@webull.com
 * @date 2021年02月03日
 * @time 6:42 下午
 * @since JDK1.8
 */
public class CountDownLatchDemo02 {

    /**
     * 运动员 开始跑步
     */
   static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            int finalInt = i ;
            executorService.submit(()->{
                System.out.println("等待裁判员发信号！");
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("第" + finalInt + "号run ");
            });
        }
        Thread.sleep(3000);
        countDownLatch.countDown();
        System.out.println("3s过后 枪响，运动员开始跑步");
        executorService.shutdown();
    }

}
