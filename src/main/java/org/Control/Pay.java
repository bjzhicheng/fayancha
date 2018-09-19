package org.Control;

import org.CustomerJilu.AddCustomer;
import org.CustomerJilu.CustomerDao;
import org.Pay.GetBalancePass;
import org.Pay.PayUser;
import org.Pay.Update;
import org.Pay.User;
import org.Util.GetTime;
import org.Util.State;
import org.Util.WorkThreadPool;
import org.apache.log4j.Logger;

import java.math.BigDecimal;

/**
 * @Author: yanshilong
 * @Date: 18-9-5 下午9:09
 * @Version 1.0
 */
//state=0  密码错误
    //state=2  余额不足
    //state=1 支付成功



public class Pay {
    private  static Logger LOGGER=Logger.getLogger(Pay.class);


    public State PayMoney(PayUser payser){

        int  qianid=payser.getId();
        State state1=new State();
        String qianpass=payser.getPassword();
        double qianaccount=payser.getShouldaccount();
        BigDecimal xuqiuaccount=new BigDecimal(qianaccount);
        State state=new State();


        state=GetBalancePass.getbalancepass(payser);

         String realpass=state.getPass();
         double realaccount=state.getAccount();
         BigDecimal account=new BigDecimal(realaccount);
         BigDecimal temp=account.subtract(xuqiuaccount);

         final User user=new User();
         user.setId(qianid);
         user.setAccount(temp.doubleValue());


        final CustomerDao customerDao=new CustomerDao();
        customerDao.setId(String.valueOf(qianid));
        GetTime getTime=new GetTime();
        customerDao.setTime(getTime.GetnowTime());
        customerDao.setType("消费");
        customerDao.setUseaccount(xuqiuaccount.doubleValue());
        customerDao.setYuaccount(account.doubleValue());



         if(qianpass.equals(realpass)){


            if (temp.doubleValue()>0){
              Runnable run=new Runnable() {
                  @Override
                  public void run() {

                       Update.Doupdate(user);
                      AddCustomer.AddoneCustomer(customerDao);

                  }
              };
              WorkThreadPool.pool.submit(run);


            //WorkThreadPool.pool.execute(run);



              //  WorkThreadPool.pool.shutdown();
                state1.setState(1);


            }else {
                state1.setState(2);
            }


         }else {
             state1.setState(0);
         }

        return state1;
    }


}
