package com.yx;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author yangxin@webull.com
 * @date 2021年04月12日
 * @time 5:22 下午
 * @since JDK1.8
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal b1  = new BigDecimal("1.2300000");
        BigDecimal b2  = new BigDecimal("1.120000");
        BigDecimal b3  = new BigDecimal("1.233000");
        BigDecimal b4  = new BigDecimal("1.23500");
       b1= b1.setScale(2, RoundingMode.HALF_UP);
        System.out.println(b1.toPlainString());
       b2= b2.setScale(0, RoundingMode.HALF_UP);
        System.out.println(b2);
        b3.setScale(2, RoundingMode.HALF_UP);
        System.out.println(b3);
        b4.setScale(2, RoundingMode.HALF_UP);
        System.out.println(b4);
    }
}
