package com.yx.singleton;

/**
 * 懒汉
 *
 * @author yx start
 * @create 2020/6/20,23:23
 */
public class SingletonLazy {

    private static SingletonLazy instance;

    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

    // 实现对应的方法
    public void sayHi() {
        // 输入对应的内容地址对象
        System.out.println(this.toString() + "hi java- 懒汉");
    }


}
