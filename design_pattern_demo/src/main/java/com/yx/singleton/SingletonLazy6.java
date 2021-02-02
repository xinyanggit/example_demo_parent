package com.yx.singleton;

/**
 * 懒汉
 * 静态内部类实现
 *
 * @author yx start
 * @create 2020/6/20,23:23
 */
public class SingletonLazy6 {

    private static class SingletonInstance {
        private static final SingletonLazy6 instance = new SingletonLazy6();
    }

    public static SingletonLazy6 getInstance() {
        return SingletonInstance.instance;
    }

    private SingletonLazy6() {

    }

    // 实现对应的方法
    public void sayHi() {
        // 输入对应的内容地址对象
        System.out.println(this.toString() + "hi java- 懒汉");
    }


}
