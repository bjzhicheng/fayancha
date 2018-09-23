package org.CustomerJilu;

import org.Control.GetCustomerjilu;
import org.Util.State;
import org.apache.log4j.PropertyConfigurator;

/**
 * @Author: yanshilong
 * @Date: 18-9-6 上午12:39
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        PropertyConfigurator.configure("/home/syl/project/Law/src/main/java/org/log4j.properties");
        CustomerDao customerDao=new CustomerDao();
        customerDao.setId(123);
GetCustomerjilu getCustomerjilu=new GetCustomerjilu();
State state=getCustomerjilu.GddoneCustomer(customerDao);
        System.out.println(state.getMessage());

//        customerDao.setYuaccount(1000);
//        customerDao.setUseaccount(300);
//        customerDao.setType("消费");
//        customerDao.setTime(GetTime.GetnowTime());
//        customerDao.setId(123);
//
//        State state= new State();
//        state=AddCustomer.AddoneCustomer(customerDao);
//        System.out.println("扎入状态  "+state.getState());
    }
}
