package com.yx.test.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author yangxin
 * @date 2021年02月03日
 * @time 4:45 下午
 * @since JDK1.8
 */

public class SemaphoreDemo01 {

    static Semaphore semaphore = new Semaphore(3);

    /**
     * Semaphore 许可证
     * 1、可以限制每个资源同时处理能力 比如：一个API接口、限制只能同时两个线程响应请求，其余的线程需要等待
     * 处理逻辑：
     * a.获取线程之后semaphore.acquire() -- 如果没有获取，则会阻塞
     * b.用完之后释放 semaphore.release();
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            int  finalInt = i ;
            executorService.submit(() -> {
                try {
                    // 获取许可证 如果没有获取，则会阻塞
                    semaphore.acquire();
//                    semaphore.acquire(2); // 可以一次性获取2个授权
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"拿到许可证，耗时2 s");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("慢服务执行完成："+Thread.currentThread().getName());
                // 释放许可证
                semaphore.release();
            });
        }
        executorService.shutdown();
    }
}
