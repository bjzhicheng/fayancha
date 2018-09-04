package org.Control;


import com.aliyuncs.exceptions.ClientException;
import org.Util.JDBCConnection;
import org.DaoTest.Register.UserDao;
import org.Util.State;
import org.Util.MakeUuid;
import org.Util.Send;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: yanshilong
 * @Date: 18-8-20 上午10:13
 * @Version 1.0
 */
public class Register1 {
    static Logger LOGGER=Logger.getLogger(Register1.class);

    //===========获取验证码==========================================
    public State Getmessage(UserDao userDao){
        State state=new State();
        int n=0;
        String yanzhengma = null;
       Jedis jedis6382=new Jedis("127.0.0.1",6382);
        String phone=userDao.getPhonenumber();
        Send send=new Send();
        try {
           n=send.sendSms(phone);
           if (n!=0){
               state.setState(1);
           }else {
               state.setState(0);
              }

              yanzhengma=String.valueOf(n);
           jedis6382.set(phone,yanzhengma);
           jedis6382.expire(phone,300);
           jedis6382.close();

        } catch (ClientException e) {
            e.printStackTrace();
        }

        return state;

    }

    //注册==================================================================


       public State Regesit(UserDao newuser) throws SQLException {
           PreparedStatement pstm=null;
           State state=new State();//表示是否插入成功

        String tuserpass=newuser.getPass();
        String tuserphone=newuser.getPhonenumber();
        String tyanzhengma=newuser.getYanzhengma();

        int  tid=MakeUuid.Make();

        LOGGER.info("接受电话为： "+tuserphone +"的生成id为："+tid+"接受到的验证码是："+tyanzhengma);




//           Set ss=jedis.keys(String.valueOf(id));
//           Iterator iterator=ss.iterator();
//           while(iterator.hasNext()){
//               uid=iterator.next();
//               upass=jedis.get(String.valueOf(uid));
//               System.out.println(uid+upass+"12121212");
//
//           }
//           if((uid.equals(String.valueOf(id)))&&(pass.equals(upass))){
           Jedis jedis6382=new Jedis("127.0.0.1",6382);
           Set ss=jedis6382.keys(tuserphone);
           Iterator iterator=ss.iterator();
           String yanzhengma=null;
           while (iterator.hasNext()){
               String phone1= (String) iterator.next();
               yanzhengma=jedis6382.get(phone1);
               System.out.println("redis里面查询出 这位用户的电话是： "+phone1+"验证码是 "+yanzhengma);
               LOGGER.info("this is user"+newuser);
               System.out.println("用户"+newuser);
           }
        if(yanzhengma.equals(tyanzhengma)){
               //数据罗苦罗盘
            Connection connection=JDBCConnection.getconnection();
            LOGGER.info("register insert jdbc");
            String sql="insert into user(id,password,phonenumber) values"+"(?,?,?)";
            try {
                pstm=(PreparedStatement) connection.prepareStatement(sql);
                pstm.setInt(1,tid);
                pstm.setString(2,tuserpass);
                pstm.setString(3,tuserphone);
                state.setState(pstm.executeUpdate());
            } catch (SQLException e) {
                LOGGER.debug("this is in patm"+e);
            }
                pstm.close();
            connection.close();
        }





return state;
    }

}
