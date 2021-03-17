package com.yx;

/**
 * @author yangxin@webull.com
 * @date 2021年03月17日
 * @time 4:30 下午
 * @since JDK1.8
 */
public class LongTest {

    public static void main(String[] args) {
        Long aa = -1L;
        Long bb = new Long(-1);
        System.out.println(aa.equals(bb));
    }

}
