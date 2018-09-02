package org.DaoTest.Login;

import org.Control.Login1;
import org.Util.State;
import org.apache.log4j.PropertyConfigurator;

/**
 * @Author: yanshilong * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        PropertyConfigurator.configure("/home/syl/Law/src/main/java/org/log4j.properties");
        User user=new User();
        user.setPhonenumber("17695569629");
        user.setPassword("yan123456");


        Login1 login1=new Login1();
        State state=login1.Login(user);
        System.out.println(state.getState());
    }
}
