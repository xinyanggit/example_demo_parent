package com.yx.test.threadlocal.part1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 判断
 *
 * @author yangxin@webull.com
 * @date 2020年11月17日
 * @time 4:55 下午
 * @since JDK1.8
 */
public class ThreadLocalDemo01 {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");

    /**
     * 当前不存存在线程抢夺的情况，因为创建了1000个线程
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int j = i;
            new Thread(() -> {
                String date = new ThreadLocalDemo01().date(j);
                System.out.println(j + "===>" + date);
            }).start();
        }
    }


    public String date(int i) {
        Date date = new Date(1000 * i);
        return simpleDateFormat.format(date);
    }


}
