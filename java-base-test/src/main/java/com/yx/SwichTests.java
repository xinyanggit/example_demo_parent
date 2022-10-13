package com.yx;

/**
 * @author test
 * @date 2021年04月30日
 * @time 3:58 下午
 * @since JDK1.8
 */
public class SwichTests {

    public static void main(String[] args) {

        try {
            testSwitch(2);
            System.out.println(11);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void testSwitch(int i) {
        while (true) {
            switch (i) {
                case 1:
                    System.out.println(1);
                    return;
                case 2:
                    System.out.println(2);
                    throw new RuntimeException("error");
                case 3:
                    System.out.println(3);
            }
            System.out.println(12345);
        }
    }
}
