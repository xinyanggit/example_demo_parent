package com.yx;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author test
 * @date 2021年04月12日
 * @time 5:22 下午
 * @since JDK1.8
 */
public class BigDecimalTest {
    public static void main2(String[] args) {
        BigDecimal b1 = new BigDecimal("1.2300000");
        BigDecimal b2 = new BigDecimal("1.120000");
        BigDecimal b3 = new BigDecimal("1.233000");
        BigDecimal b4 = new BigDecimal("1.23500");
        b1 = b1.setScale(2, RoundingMode.HALF_UP);
        System.out.println(b1.toPlainString());
        b2 = b2.setScale(0, RoundingMode.HALF_UP);
        System.out.println(b2);
        b3.setScale(2, RoundingMode.HALF_UP);
        System.out.println(b3);
        b4.setScale(2, RoundingMode.HALF_UP);
        System.out.println(b4);
        BigDecimal b5 = new BigDecimal("1000.23500");
        System.out.println(b5.stripTrailingZeros().toEngineeringString());
        b5 = new BigDecimal("1000.00");
        System.out.println(b5.stripTrailingZeros().toPlainString());
        System.out.println(b5.toString());
        b5.setScale(0, RoundingMode.HALF_UP);
        System.out.println(b5.toString());
    }


    public static void main(String[] args) {
//        BigDecimal a = new BigDecimal(3);
//        BigDecimal b = new BigDecimal(2);
//        BigDecimal[] bigDecimals = a.divideAndRemainder(b);
//        System.out.println(bigDecimals[0]+"==="+bigDecimals[1]);
        BigDecimal a = new BigDecimal("0");
        BigDecimal b = new BigDecimal("22");
        BigDecimal multiply = a.multiply(b);
        System.out.println(multiply);
          a = new BigDecimal("8771.700000000000");
          b = new BigDecimal("87.55");
         multiply = a.multiply(b);
        System.out.println(multiply);

    }
}
