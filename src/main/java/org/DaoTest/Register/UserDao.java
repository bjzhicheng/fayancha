package org.DaoTest.Register;

/**
 * @Author: yanshilong
 * @Date: 18-8-20 上午10:13
 * @Version 1.0
 */
public class UserDao {
    public String getYanzhengma() {
        return yanzhengma;
    }

    public void setYanzhengma(String yanzhengma) {
        this.yanzhengma = yanzhengma;
    }

    private int id;
    private String pass;
    private String phonenumber;
    private  String yanzhengma;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
