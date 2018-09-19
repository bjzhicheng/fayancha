package org.Pay;

import org.Control.Pay;
import org.Util.State;
import org.apache.log4j.PropertyConfigurator;

/**
 * @Author: yanshilong
 * @Date: 18-9-5 下午9:09
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        PropertyConfigurator.configure("/home/syl/project/Law/src/main/java/org/log4j.properties");
        Pay pay=new Pay();
        PayUser payUser=new PayUser();
        payUser.setId(1234);
        payUser.setPassword("yan1234");
        payUser.setShouldaccount(40);
        State state=pay.PayMoney(payUser);
        System.out.println(state.getState());
    }
}
