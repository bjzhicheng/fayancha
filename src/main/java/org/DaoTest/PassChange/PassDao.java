package org.DaoTest.PassChange;

/**
 * @Author: yanshilong
 * @Date: 18-9-1 上午7:51
 * @Version 1.0
 */
public class PassDao {
    public int getYanzhengma() {
        return yanzhengma;
    }

    public void setYanzhengma(int yanzhengma) {
        this.yanzhengma = yanzhengma;
    }

    private String pass;
    private int yanzhengma;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    private int id;
    private String phonenumber;
}
