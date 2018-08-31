package org.PhoneChange;

/**
 * @Author: yanshilong
 * @Date: 18-8-21 下午5:23
 * @Version 1.0
 */
public class PhoneDao {
    private String changephonenumber;
    private int id;
    private int sendmessage;

    public int getSendmessage() {
        return sendmessage;
    }

    public void setSendmessage(int sendmessage) {
        this.sendmessage = sendmessage;
    }

    public String getChangephonenumber() {
        return changephonenumber;
    }

    public void setChangephonenumber(String changephonenumber) {
        this.changephonenumber = changephonenumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
