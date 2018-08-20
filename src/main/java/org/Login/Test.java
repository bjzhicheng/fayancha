package org.Login;

import org.State.State;
import org.apache.log4j.PropertyConfigurator;

/**
 * @Author: yanshilong
 * @Date: 18-8-19 下午2:43
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        PropertyConfigurator.configure("/home/syl/Law/src/main/java/org/log4j.properties");
        User user=new User();
        user.setId(2);
        user.setPassword("123");
        Login1 login1=new Login1();
        State state=login1.Login(user);
        System.out.println(state.getState());
    }
}
