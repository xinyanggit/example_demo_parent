package com.yx.service;

/**
 * 顾客
 *
 * @author test
 * @date 2021年04月21日
 * @time 5:45 下午
 * @since JDK1.8
 */
public class Customer {
    private String firstName;
    private String lastName;
    private MyWallet myWallet;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public MyWallet getMyWallet() {
        return myWallet;
    }

    public void setMyWallet(MyWallet myWallet) {
        this.myWallet = myWallet;
    }

    /**
     * 支付
     *
     * @param bill
     * @return
     */
    public float pay(float bill) {
        if (myWallet != null) {
            if (myWallet.getValue() > bill) {
                myWallet.subtractMoney(bill);
                return bill;
            }else{
                return 0;
            }
        }
        return 0;
    }

}
