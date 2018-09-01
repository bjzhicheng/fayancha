package org.DaoTest.Userchange;

import org.Control.Userchange;
import org.Util.State;
import org.apache.log4j.PropertyConfigurator;

/**
 * @Author: yanshilong
 * @Date: 18-8-21 下午5:05
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        PropertyConfigurator.configure("/home/syl/Law/src/main/java/org/log4j.properties");


        UserDao userDao = new UserDao();
          userDao.setId(2);
          userDao.setName("change");
          userDao.setWeixin("yan1234567");
          userDao.setNativespace("beijing test");
          userDao.setCompanyname("yi jia gou ");
          userDao.setPosition("leader");

       Userchange userchange=new Userchange();
       State state=userchange.Userchange(userDao);
        System.out.println(state.getState());
    }
}
