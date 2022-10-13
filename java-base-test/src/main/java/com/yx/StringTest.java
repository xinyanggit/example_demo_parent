package com.yx;

/**
 * @author test
 * @date 2021年04月13日
 * @time 3:22 下午
 * @since JDK1.8
 */
public class StringTest {
    public static void main2(String[] args) {
        String ver = "202101171USINLOCAL";
        System.out.println(ver.substring(0,8));
    }

    public static void main(String[] args) {
        String str = "2021-02-02";
        System.out.println(str.replace("-", ""));

        String str2 = "0123456";
        StringTest s = new StringTest();
        String s1 = s.doHandlerAccount(str2);
        System.out.println(s1);
    }

    public String doHandlerAccount(String acct) {
        int length = acct.length();
        acct = acct.substring(0, length - 2);
        return acct;
    }
    
}
