package com.yx.service;

/**
 * 钱包
 *
 * @author test
 * @date 2021年04月21日
 * @time 5:45 下午
 * @since JDK1.8
 */
public class MyWallet {
    private float value;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void addMoney(float deposit) {
        value += deposit;
    }

    public void subtractMoney(float debit) {
        value -= debit;
    }
}
