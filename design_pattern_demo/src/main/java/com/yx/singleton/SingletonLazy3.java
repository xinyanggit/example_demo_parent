package com.yx.singleton;

/**
 * 懒汉
 *
 * @author yx start
 * @create 2020/6/20,23:23
 */
public class SingletonLazy3 {

    private static SingletonLazy3 instance;

    public   static SingletonLazy3 getInstance() {
        if (instance == null) {
            //都排队到这里了，就会执行多次新建对象
            synchronized(SingletonLazy3.class){
              instance = new SingletonLazy3();
            }
        }
        return instance;
    }
    private SingletonLazy3(){

    }

    // 实现对应的方法
    public void sayHi() {
        // 输入对应的内容地址对象
        System.out.println(this.toString() + "hi java- 懒汉");
    }


}
