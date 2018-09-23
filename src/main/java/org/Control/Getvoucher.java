package org.Control;

import org.CustomerJilu.AddCustomer;
import org.CustomerJilu.CustomerDao;
import org.Pay.User;
import org.Util.GetTime;
import org.Util.State;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

/**
 * @Author: yanshilong
 * @Date: 18-9-22 下午9:06
 * @Version 1.0
 */
public class Getvoucher {
    private static Logger LOGGER = Logger.getLogger(Getvoucher.class);

    public State getvoucher(User user) {
        State state = new State();
        int iid = user.getId();
        String id = String.valueOf(iid);
        Jedis jedis6385 = new Jedis("127.0.0.1", 6385);

        String getid = null;
        String getnum = null;
        Set set = jedis6385.keys(id);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            getid = (String) iterator.next();
            getnum = jedis6385.get(getid);
        }


        int num = Integer.parseInt(getnum);
        if (num > 0) {


//            CustomerDao customer=new CustomerDao();
//            customer.setId(iid);
//            GetTime getTime = new GetTime();
//            customer.setTime(getTime.GetnowTime());
//            customer.setType("优惠券消费");
//            customer.setUseaccount(0);
//            //customerDao.setYuaccount(account.doubleValue());
//
//
//            jedis6385.set(getid, String.valueOf(num - 1));
//            AddCustomer.AddoneCustomer(customer);
//            //添加一条消费记录。。。
            state.setState(num);


            jedis6385.close();


        }
 return state;

    }
}
