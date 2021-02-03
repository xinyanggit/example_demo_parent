package com.yx.test.future;

import java.util.concurrent.*;

/**
 * 演示 get() isDonw()
 *第一件事情，即便任务抛出异常，isDone 方法依然会返回 true；
 * 第二件事情，虽然抛出的异常是 IllegalArgumentException，但是对于 get 而言，它抛出的异常依然是 ExecutionException；
 * 第三个事情，虽然在任务执行一开始时就抛出了异常，但是真正要等到我们执行 get 的时候，才看到了异常。
 * @author yangxin
 * @date 2021年02月03日
 * @time 4:03 下午
 * @since JDK1.8
 */
public class FutureDemo01 {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future future = executorService.submit(new CallableThread());
        for (int i = 0; i < 8; i++) {
            System.out.println(i);
            Thread.sleep(500);
        }
        System.out.println(future.isDone());
        future.get();
    }


}

class CallableThread implements Callable {

    @Override
    public Object call() throws Exception {
        Thread.sleep(400);
        throw new RuntimeException("error");

    }
}