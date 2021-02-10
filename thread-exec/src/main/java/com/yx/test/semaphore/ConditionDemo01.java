package com.yx.test.semaphore;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangxin
 * @date 2021年02月04日
 * @time 9:58 上午
 * @since JDK1.8
 */
public class ConditionDemo01 {
    /***
     * 模拟一下：停车场  出来需要兑换停车票
     * 用户A B 、 商量
     * 用户A 去 开车，用户B  去客服中心兑换电子停车券（兑换之后就可以免费出停车场了）
     */
    ReentrantLock reentrantLock = new ReentrantLock();
    Condition condition = reentrantLock.newCondition();

    /**
     * 开车
     */
    private void driveCar(){
        System.out.println("execution driveCar ");
        reentrantLock.lock();
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" 已经启动车辆，准备离场");
            condition.await();
            System.out.println(Thread.currentThread().getName()+" ok ,已经离场");
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
    }

    /**
     * 兑换电子停车券
     */
    private void freeExchange(){
        System.out.println("execution freeExchange ");
        reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"开始兑换停车券");
            Thread.sleep(1000);
            condition.signal();
            System.out.println(Thread.currentThread().getName()+"兑换完成，可以出场");
        } catch (InterruptedException e) {

            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        ConditionDemo01 conditionDemo01 = new ConditionDemo01();
        new Thread(()->{
            conditionDemo01.freeExchange();
        }).start();
        conditionDemo01.driveCar();
    }
}
