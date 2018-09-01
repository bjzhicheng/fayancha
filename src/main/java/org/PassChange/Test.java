package org.PassChange;

import org.Control.PassChangeSend;
import org.Util.State;
import org.apache.log4j.PropertyConfigurator;

/**
 * @Author: yanshilong
 * @Date: 18-9-1 上午7:51
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        PropertyConfigurator.configure("/home/syl/Law/src/main/java/org/log4j.properties");

        PassChangeSend passChangeSend = new PassChangeSend();
//        PassDao passDao = new PassDao();
//          passDao.setPhonenumber("17695569629");
//          passDao.setId(1566297945);
//          State state=passChangeSend.ChangeSend(passDao);
//        System.out.println("发送状态： "+state.getState());




        PassDao newuser=new PassDao();
        newuser.setId(1566297945);
        newuser.setYanzhengma(7317);
        newuser.setPass("123456tttt");
        newuser.setPhonenumber("17695569629");
        State state= passChangeSend.PassChange(newuser);
        System.out.println("发送状态： "+state.getState());
    }

}
