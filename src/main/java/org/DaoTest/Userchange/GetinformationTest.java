package org.DaoTest.Userchange;

import org.Control.GetInformation;
import org.Util.State;
import org.apache.log4j.PropertyConfigurator;

/**
 * @Author: yanshilong
 * @Date: 18-9-23 下午3:29
 * @Version 1.0
 */
public class GetinformationTest {
    public static void main(String[] args) {
         PropertyConfigurator.configure("/home/syl/project/Law/src/main/java/org/log4j.properties");

        UserDao user=new UserDao();
        user.setId(11);


        GetInformation getInformation=new GetInformation();
        State state=getInformation.Getmetion(user);

        System.out.println(state.getMessage());



    }
}
