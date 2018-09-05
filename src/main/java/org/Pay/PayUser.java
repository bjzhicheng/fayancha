package org.Pay;

/**
 * @Author: yanshilong
 * @Date: 18-9-5 下午9:09
 * @Version 1.0
 */
public class PayUser {
    private  int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getShouldaccount() {
        return shouldaccount;
    }

    public void setShouldaccount(double shouldaccount) {
        this.shouldaccount = shouldaccount;
    }

    private String password;
    private  double shouldaccount;


}
