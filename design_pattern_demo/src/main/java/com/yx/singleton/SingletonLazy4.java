package com.yx.singleton;

/**
 * 懒汉
 *
 * @author yx start
 * @create 2020/6/20,23:23
 */
public class SingletonLazy4 {

    private static SingletonLazy4 instance;

    public static SingletonLazy4 getInstance() {
        if (instance == null) {
            //都排队到这里了，就会执行多次新建对象
            synchronized (SingletonLazy4.class) {
                if (instance == null) {
                    // 这里其实还是会有问题cpu 指令重排 ，5版本解决
                    // new 对象分为
                    //1 分配内存空间 2、初始化类成员 3、将对象指向分配内存地址
                    instance = new SingletonLazy4();
                }
            }
        }
        return instance;
    }

    private SingletonLazy4() {

    }

    // 实现对应的方法
    public void sayHi() {
        // 输入对应的内容地址对象
        System.out.println(this.toString() + "hi java- 懒汉");
    }


}
