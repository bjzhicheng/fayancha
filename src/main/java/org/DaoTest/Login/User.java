package org.DaoTest.Login;

/**
 * @Author: yanshilong
 * @Date: 18-8-12 上午11:08
 * @Version 1.0
 */
public class User {
    private String phonenumber;

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
}
