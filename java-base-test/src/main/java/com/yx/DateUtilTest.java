package com.yx;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Date;

/**
 * @author test
 * @date 2021年03月22日
 * @time 9:09 下午
 * @since JDK1.8
 */
public class DateUtilTest {
    public static void main2(String[] args) {
        String time = "19:00";
        String patten = "yyyy-MM-dd";
        String format = DateUtils.format(new Date(), DateUtils.ISO_DATE_FORMAT, DateUtils.getTimeZoneNY());
        String str1 = "2021-01-13 19:00:01" ;
        String str2 = "2021-01-14 19:00:02" ;
        System.out.println(str1.compareTo(str2));
        System.out.println(str2.compareTo(str1));
    }
    public static void main(String[] args) throws Exception {
        Long timestamp = System.currentTimeMillis();
        String secret = "this is secret";

        String stringToSign = timestamp + "\n" + secret;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        String sign = URLEncoder.encode(new String(Base64.getDecoder().decode(signData)),"UTF-8");
        System.out.println(sign);
    }



}
