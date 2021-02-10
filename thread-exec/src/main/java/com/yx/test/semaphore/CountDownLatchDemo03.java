package com.yx.test.semaphore;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 场景一：
 *  所有场景统一汇合之后然后进行
 * @author yangxin
 * @date 2021年02月03日
 * @time 6:42 下午
 * @since JDK1.8
 */
public class CountDownLatchDemo03 {

    /**
     * 运动员 到达终点
     */
   static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            int finalInt = i ;
            executorService.submit(()->{
                try {
                    Thread.sleep((long) (Math.random()*100));
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("第" + finalInt + "号 到达终点 ");
            });
        }
        System.out.println("等待所有运动员跑完");
        countDownLatch.await();
        System.out.println("所有人都跑完了");
        executorService.shutdown();
    }

}
