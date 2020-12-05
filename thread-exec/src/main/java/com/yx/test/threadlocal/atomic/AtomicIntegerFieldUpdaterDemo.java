package com.yx.test.threadlocal.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**测试 AtomicIntegerFieldUpdater int 使其线程安全
 * @date 2020年12月05日
 * @time 3:40 下午
 * @since JDK1.8
 */
public class AtomicIntegerFieldUpdaterDemo  implements Runnable{
    static Score math ;
    static Score computer ;


    public static AtomicIntegerFieldUpdater<Score> scoreUpdater = AtomicIntegerFieldUpdater.newUpdater(Score.class,"score");

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            computer.score++;
            scoreUpdater.getAndIncrement(math);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static class Score{
        volatile int score;
    }

    public static void main(String[] args) {
        math = new Score();
        computer = new Score();
        AtomicIntegerFieldUpdaterDemo atomicIntegerFieldUpdaterDemo = new AtomicIntegerFieldUpdaterDemo();
        Thread t1 = new Thread(atomicIntegerFieldUpdaterDemo);
        Thread t2 = new Thread(atomicIntegerFieldUpdaterDemo);
        t1.start();
        t2.start();
        System.out.println("normal " + computer.score);
        System.out.println("升级之后的 " +math.score);
    }
}
