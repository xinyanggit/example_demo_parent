package com.yx.test.tour;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/** 旅游平台处理问题
 * CompletableFuture 处理能力更强些
 * @author yangxin@webull.com
 * @date 2020年12月09日
 * @time 9:37 上午
 * @since JDK1.8
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws InterruptedException {
        CompletableFutureDemo theadPoolCountDownLatch = new CompletableFutureDemo();
        Set<Integer> prices = theadPoolCountDownLatch.getPrices();
        System.out.println(prices);
    }

    /**
     * @return
     * @throws InterruptedException
     */
    private Set<Integer> getPrices() throws InterruptedException {
        long start = System.currentTimeMillis();
        Set<Integer> prices = Collections.synchronizedSet(new HashSet<Integer>());
        CompletableFuture<Void> p1 = CompletableFuture.runAsync(new Task(prices, 123));
        CompletableFuture<Void> p2 =CompletableFuture.runAsync(new Task(prices,456));
        CompletableFuture<Void> p3 =CompletableFuture.runAsync(new Task(prices,789));
     //   CompletableFuture.allOf(p1,p2,p3).join();
        CompletableFuture<Void> all = CompletableFuture.allOf(p1, p2, p3);
        try {
            // 设置超时处理时间
            all.get(3, TimeUnit.MINUTES);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("完成消费："+(end-start)/1000 +" s");
        return prices;
    }

    private class Task implements Runnable{

        private Set<Integer> prices;
        private Integer productId;


        public Task(Set<Integer> prices, Integer productId) {
            this.prices = prices;
            this.productId = productId;
        }

        @Override
        public void run() {
            int  price = 0 ;
            double random = Math.random()*1000;
            try {
                Thread.sleep((long) random);
                price = (int) (Math.random()*400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            prices.add(price);
        }
    }
}
