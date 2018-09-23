package org.ShenHe;

/**
 * @Author: yanshilong
 * @Date: 18-9-20 上午10:30
 * @Version 1.0
 */
public class UserDao {
    private int state;
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private int userid;
    private String message;
}
