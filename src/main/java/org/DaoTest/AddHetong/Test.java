package org.DaoTest.AddHetong;

import org.Control.Addhetong;
import org.Util.State;
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

        hetongDao.setId(52010101);
       // hetongDao.setLoves(1020);
        hetongDao.setTitle("test121hhhh");
        hetongDao.setJianyi("哈哈哈哈");
       // hetongDao.setUrl("http:uiw/wew/eww/ewwrw221/");

        hetongDao.setMessage("这是一个合同文见2");
        hetongDao.setFengxian("本合同的风险3");


        Addhetong addhetong=new Addhetong();
        State state=addhetong.addhetong(hetongDao);
        System.out.println(state.getState());

    }
}
