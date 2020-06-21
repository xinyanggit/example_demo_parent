package com.yx.singleton;

/**
 * 懒汉
 *静态内部类实现
 *
 * @author yx start
 * @create 2020/6/20,23:23
 */
public class SingletonLazy7 {
    // 枚举类型是线程安全的，并且只会装载一次
    private enum SingletonEnum {
        INSTANCE;
        // 声明单例对象
        private final SingletonLazy7 instance;
        // 实例化
        SingletonEnum() {
            instance = new SingletonLazy7();
        }
        private SingletonLazy7 getInstance() {
            return instance;
        }
    }
    // 获取实例（单例对象）
    public static SingletonLazy7 getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }
    // 实现对应的方法
    public void sayHi() {
        // 输入对应的内容地址对象
        System.out.println(this.toString() + "hi java- 懒汉");
    }


}
