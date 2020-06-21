package com.yx.singleton;

/**
 * 饿汉
 *
 * @author yx start
 * @create 2020/6/20,23:23
 */
public class SingletonHungry {

    // 声明私有对象
    private static SingletonHungry singleton = new SingletonHungry();

    // 获取实例（单例对象）
    public static SingletonHungry getInstance() {
        return singleton;
    }

    private SingletonHungry() {

    }

    // 实现对应的方法
    public void sayHi() {
        // 输入对应的内容地址对象
        System.out.println(this.toString() + "hi java - 饿汉");
    }

}
