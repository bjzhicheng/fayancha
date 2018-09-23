package org.CustomerJilu;

/**
 * @Author: yanshilong
 * @Date: 18-9-6 下午1:15
 * @Version 1.0
 */
public class CustomerDao {
    public String getCusnumber() {
        return cusnumber;
    }

    public void setCusnumber(String cusnumber) {
        this.cusnumber = cusnumber;
    }

    private int id;
    private String cusnumber;
    private double  yuaccount;
    private double useaccount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getYuaccount() {
        return yuaccount;
    }

    public void setYuaccount(double yuaccount) {
        this.yuaccount = yuaccount;
    }

    public double getUseaccount() {
        return useaccount;
    }

    public void setUseaccount(double useaccount) {
        this.useaccount = useaccount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String time;
    private String type;
}
