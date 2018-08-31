package org.Register;

import com.oracle.webservices.internal.api.message.PropertySet;
import org.State.State;
import org.apache.log4j.PropertyConfigurator;

import java.sql.SQLException;

/**
 * @Author: yanshilong
 * @Date: 18-8-20 上午10:13
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) throws SQLException {
        PropertyConfigurator.configure("/home/syl/Law/src/main/java/org/log4j.properties");
//        UserDao uuu = new UserDao();
//
//
//                 uuu.setPass("yan123456");
//                 uuu.setPhonenumber("17695569629");
//                 Register1 register1=new Register1();
//                 register1.Getmessage(uuu);




                 UserDao ruser=new UserDao();
                 ruser.setPhonenumber("17695569629");
                 ruser.setPass("yan123456");
                 ruser.setYanzhengma("2323");

                 Register1 register1=new Register1();
        State state=new State();
                 state=register1.Regesit(ruser);
        System.out.println(state.getState());

    }
}
