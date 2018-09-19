package org.DaoTest.AddHetong;

import org.Control.Addhetong;
import org.apache.log4j.PropertyConfigurator;

/**
 * @Author: yanshilong
 * @Date: 18-8-31 下午2:16
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {


        PropertyConfigurator.configure("/home/syl/project/Law/src/main/java/org/log4j.properties");

        HetongDao hetongDao=new HetongDao();

        hetongDao.setId("1243");
        hetongDao.setLoves(1020);
        hetongDao.setTitle("test121hhhh");
        hetongDao.setUrl("http:uiw/wew/eww/ewwrw221/");



        Addhetong addhetong=new Addhetong();
        addhetong.addhetong(hetongDao);


    }
}
