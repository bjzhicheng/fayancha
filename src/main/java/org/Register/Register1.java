package org.Register;


import org.apache.log4j.Logger;

/**
 * @Author: yanshilong
 * @Date: 18-8-20 上午10:13
 * @Version 1.0
 */
public class Register1 {
    static Logger LOGGER=Logger.getLogger(Register1.class);
       public void Regesit(UserDao newuser){
        String userpass=newuser.getPass();
        String userphone=newuser.getPhonenumber();
        String  yanzheng=newuser.getYanzhengma();


    }
}
