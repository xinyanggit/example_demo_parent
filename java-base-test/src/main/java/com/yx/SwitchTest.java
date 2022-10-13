package com.yx;

/**
 * @author test
 * @date 2021年04月06日
 * @time 4:22 下午
 * @since JDK1.8
 */
public class SwitchTest {
    public static void main(String[] args) {
        String  aa = "";
        String c = "C";
        switch (c){
            case "C":
                aa="c";
                return;
            case "B":
                aa="b";
                return;
            default:
        }
        aa= aa+"--";
        System.out.println(aa);
    }
}
