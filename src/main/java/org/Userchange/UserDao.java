package org.Userchange;

/**
 * @Author: yanshilong
 * @Date: 18-8-21 下午4:26
 * @Version 1.0
 */
public class UserDao {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getNativespace() {
        return nativespace;
    }

    public void setNativespace(String nativespace) {
        this.nativespace = nativespace;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    private String weixin;
    private String nativespace;
    private String companyname;
    private String position;

}
