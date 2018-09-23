package org.DaoTest.AddHetong;

/**
 * @Author: yanshilong
 * @Date: 18-8-21 下午1:31
 * @Version 1.0
 */
public class HetongDao {
    public String getFengxian() {
        return fengxian;
    }

    public void setFengxian(String fengxian) {
        this.fengxian = fengxian;
    }

    public String getJianyi() {
        return jianyi;
    }

    public void setJianyi(String jianyi) {
        this.jianyi = jianyi;
    }

    private int id;
    private String url;
    private  String fengxian;
    private String jianyi;
    private int userid;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String message;



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    private String time;


    private String title;

}
