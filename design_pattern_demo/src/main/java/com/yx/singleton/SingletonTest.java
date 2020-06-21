package com.yx.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**单例设计模式
 * @author yx start
 * @create 2020/6/20,23:21
 */
public class SingletonTest {

    static ExecutorService executorService =  Executors.newFixedThreadPool(10);
    // 分为懒汉和饿汉
    // 饿汉有相关的危机意识，会腾粮食
    // 懒汉就是等需要的时候去获取
    public static void main(String[] args) {
        for (int i = 0 ;i<30;i++){
            executorService.submit(new RunableDemo());
        }

    }

    /**
     * 利用多线程测试是否是同一内存地址
     */
    static class RunableDemo implements  Runnable{
    @Override
    public void run() {
        // 饿汉式
//        SingletonHungry singletonHungry = SingletonHungry.getInstance();
//        singletonHungry.sayHi();
        // 懒汉式 发现结果不一致 多线程并发问题
//        SingletonLazy singletonLazy = SingletonLazy.getInstance();
//        singletonLazy.sayHi();
        // 最終多线程安全版本
        SingletonLazy6 singletonLazy = SingletonLazy6.getInstance();
        singletonLazy.sayHi();
    }
}

}
