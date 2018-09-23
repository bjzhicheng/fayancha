package org.Control;

import org.CustomerJilu.AddCustomer;
import org.CustomerJilu.CustomerDao;
import org.Pay.PayUser;
import org.Util.GetTime;
import org.Util.State;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

/**
 * @Author: yanshilong
 * @Date: 18-9-19 上午12:07
 * @Version 1.0
 */
public class UuiPay {
    private static Logger LOGGER=Logger.getLogger(UuiPay.class);

    public State  Upay(PayUser payuser){
        State state=new State();
        int iid=payuser.getId();
        String id=String.valueOf(iid);
        Jedis jedis6385=new Jedis("127.0.0.1",6385);
//        Set ss=jedis6379.keys(user.getPhonenumber());
//        Iterator iterator=ss.iterator();
//        while(iterator.hasNext()){
//            unimber= (String) iterator.next();

         String getid = null;
         String getnum = null;
        Set set=jedis6385.keys(id);
        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            getid= (String) iterator.next();
            getnum=jedis6385.get(getid);
        }


         int num=Integer.parseInt(getnum);

        if(num>0){
            final CustomerDao customerDao=new CustomerDao();
            customerDao.setId(iid);
            GetTime getTime=new GetTime();
            customerDao.setTime(getTime.GetnowTime());
            customerDao.setType("优惠券消费");
            customerDao.setUseaccount(0);
            //customerDao.setYuaccount(account.doubleValue());




            jedis6385.set(getid,String.valueOf(num-1));
            jedis6385.close();

            AddCustomer.AddoneCustomer(customerDao);
           //添加一条消费记录。。。
            state.setState(1);
        }else {


//            Pay pay=new Pay();
//            state=pay.PayMoney(payuser);
            state.setState(0);
        }

        return state;

    }




}
