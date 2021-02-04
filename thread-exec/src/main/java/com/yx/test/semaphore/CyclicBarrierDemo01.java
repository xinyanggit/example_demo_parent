package com.yx.test.semaphore;

import java.util.concurrent.*;

/**
 * 场景：
 * 比如去海边游玩，三人自行车、需要等待三人才能开始
 * 下大巴车之后到海边有一段距离，所以就出现了必须要三个人之后才能启动自行车
 * @author yangxin@webull.com
 * @date 2021年02月04日
 * @time 9:17 上午
 * @since JDK1.8
 */
public class CyclicBarrierDemo01 {

    // 参数构建 还可以添加其他的
   // 方式1// private static CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
   // 方式2 循环一次(在开闸的时候) 打印一次
    private static CyclicBarrier cyclicBarrier =  new CyclicBarrier(4,()->{
        System.out.println("凑够人数了。 出发！");
    });

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 16; i++) {
            int finalInt = i ;
            System.out.println("第" + finalInt +" 前往，等待启动");
            executorService.submit(()->{
                try {
                    Thread.sleep((long) (Math.random()*1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("第" + finalInt +" 到达驿站，等待启动");
                try {
                    cyclicBarrier.await(10, TimeUnit.SECONDS);// 当不足时，超过时间区间。则会抛出异常
                    System.out.println("第" + finalInt +" 开始骑车");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }

}
