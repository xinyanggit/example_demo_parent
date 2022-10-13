package com.yx.service;

/**
 * 收营员
 * @author test
 * @date 2021年04月21日
 * @time 5:47 下午
 * @since JDK1.8
 */
public class PaperBoy {

    public void charge(Customer customer ,float bill){
        float pay = customer.pay(bill);
        if(bill == pay){
            System.out.println("支付成功");
        }else{
            System.out.println("余额不足");
        }
    }
}
