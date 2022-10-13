package com.yx;

/**
 * @author test
 * @date 2021年03月17日
 * @time 4:30 下午
 * @since JDK1.8
 */
public class LongTest {

    public static void main2(String[] args) {
        Long aa = -1L;
        Long bb = new Long(-1);
        System.out.println(aa.equals(bb));
    }

    public static void main3(String[] args) {
        long n = 1614671529;
        Long a  = new Long(n*1000);

        System.out.println(a);
    }

    public static void main(String[] args) {
        long  now = 1618475423188L;
        if (now - 1618468210000L > 1 * 60 * 1000L){
            System.out.println(1);
        }
        System.out.println(2);
    }


}
