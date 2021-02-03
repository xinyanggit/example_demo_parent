package com.yx.test.tour;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author yangxin
 * @date 2020年12月09日
 * @time 9:37 上午
 * @since JDK1.8
 */
public class TwoTheadPoolCountDownLatch {

    public static final int THEAD_COUNT = 3;
    ExecutorService executorService = Executors.newFixedThreadPool(THEAD_COUNT);

    public static void main(String[] args) throws InterruptedException {
        TwoTheadPoolCountDownLatch theadPoolCountDownLatch = new TwoTheadPoolCountDownLatch();
        Set<Integer> prices = theadPoolCountDownLatch.getPrices();
        System.out.println(prices);
    }

    /**
     * countdownLatch 完成 ,解决了需要固定时间问题
     *
     * @return
     * @throws InterruptedException
     */
    private Set<Integer> getPrices() throws InterruptedException {
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(THEAD_COUNT);
        Set<Integer> prices = Collections.synchronizedSet(new HashSet<Integer>());
        executorService.submit(new Task(prices, 123, countDownLatch));
        executorService.submit(new Task(prices, 456, countDownLatch));
        executorService.submit(new Task(prices, 789, countDownLatch));
//        countDownLatch.await();
        // 设置超时处理时间
        countDownLatch.await(3, TimeUnit.MINUTES);
        long end = System.currentTimeMillis();
        System.out.println("完成消费：" + (end - start) / 1000 + " s");
        return prices;
    }

    private class Task implements Runnable {

        private Set<Integer> prices;
        private Integer productId;
        private CountDownLatch countDownLatch;

        public Task(Set<Integer> prices, Integer productId, CountDownLatch countDownLatch) {
            this.prices = prices;
            this.productId = productId;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            int price = 0;
            double random = Math.random() * 1000;
            try {
                Thread.sleep((long) random);
                price = (int) (Math.random() * 400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
            prices.add(price);
        }
    }
}
