package com.yx.test.tour;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 旅游公司-多线程实现
 *
 * @author yangxin
 * @date 2020年12月09日
 * @time 9:14 上午
 * @since JDK1.8
 */
public class OneTheadPoolDemo {

    ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {
        OneTheadPoolDemo oneTheadPoolDemo = new OneTheadPoolDemo();
        Set<Integer> prices = oneTheadPoolDemo.getPrices();
        System.out.println(prices);
    }

    private Set<Integer> getPrices() throws InterruptedException {
        long start = System.currentTimeMillis();

        Set<Integer> prices = Collections.synchronizedSet(new HashSet<Integer>());
        executorService.submit(new Task(prices, 123));
        executorService.submit(new Task(prices, 456));
        executorService.submit(new Task(prices, 789));
        Thread.sleep(3000);
        //臃肿， 采用这种方式实现 定时的方式
        long end = System.currentTimeMillis();
        System.out.println("完成消费：" + (end - start) / 1000 + " s");
        //有一个问题，无论task任务执行的时间长短，都是休眠3秒钟。如果响应慢，里面可能没有数据
        return prices;
    }

    private class Task implements Runnable {

        private Set<Integer> prices;
        private Integer productId;

        public Task(Set<Integer> prices, Integer productId) {
            this.prices = prices;
            this.productId = productId;
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
            prices.add(price);
        }
    }
}
