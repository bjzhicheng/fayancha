package org.Util;

/**
 * @Author: yanshilong
 * @Date: 18-8-19 下午2:28
 * @Version 1.0
 */
public class State {
    private int id;
    private int state;
    private double account;
    private String message;
    private  String one;


    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String another;
    private String type;
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    private String pass;

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
