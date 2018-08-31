package org.PhoneChange;

import com.alibaba.fastjson.JSON;
import org.JDBC.JDBCConnection;
import org.State.State;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

import java.sql.*;
import java.util.Iterator;
import java.util.Set;


/**
 * @Author: yanshilong
 * @Date: 18-8-21 下午5:22
 * @Version 1.0
 *
 * 1----getphone(PhoneDao getphone)传入id 返回phonenumber
 *
 *
 *
 * 2------Phonechange(PhoneDao changer)//发送信息，获取电话，发送验证码
 *
 *
 * 3-------- PhoneChackchange(PhoneDao checker)//验证验证码，正确
 *
 *
 * 4----------- Change(PhoneDao phoneDao)//传新的number  发送验证码，存入redids(60s) 6383
 *
 * 5--------------- SaveChange(PhoneDao newphoneuser)//获取验证码 redis判断 若对 redis 更新 mysql  update
 *                      return 1;
 *
 *
 */
public class PhoneChange{
    static Logger LOGGER=Logger.getLogger(PhoneChange.class);


  //  1----getphone(PhoneDao getphone)传入id 返回phonenumber========================================================================

    public String getphone(PhoneDao getphone){
        String phonenumber=null;
        int id=getphone.getId();
        LOGGER.info("this is user id：  "+id);
        String sql="select phonenumber from user where id="+id;
        Connection connection=JDBCConnection.getconnection();
        try {
            Statement statement=connection.createStatement();
            ResultSet re=statement.executeQuery(sql);
            while(re.next()){
                phonenumber=re.getString("phonenumber");
            }
        } catch (SQLException e) {
            LOGGER.warn("this is in create statemengt "+e);
        }

        LOGGER.info("这是获取的手机号码： "+phonenumber);
        String json=JSON.toJSONString(phonenumber);
        return  json;

    }


    //================================================================================================================================


     // 2------Phonechange(PhoneDao changer)//发送信息，获取电话，发送验证码=================================================================

    public  String Phonechange(PhoneDao changer){

         String sendmessage="1234";

        return  sendmessage;


    }
//3  获取验证码  判断get 验证码 余 redis 李存储的是否.equals  return state=1

    public State PhoneChackchange(PhoneDao checker){
        State state=new State();

                 String realmessage=null;
               int  id=checker.getId();
               int gemessage=checker.getSendmessage();
        Jedis redis6383=new Jedis("127.0.0.1",6783);
        Set ss=redis6383.keys(String.valueOf(id));
          Iterator iterator=ss.iterator();
          while(iterator.hasNext()){
               String ii= (String) iterator.next();
               realmessage=redis6383.get(ii);
          }
          if (realmessage.equals(gemessage)){
              state.setId(id);

              state.setState(1);
               return state;
          }
          else {
              state.setState(0);
              state.setId(id);
              return  state;
          }

    }
    // state=1   1 change mysql   user biao
    public void  Change(PhoneDao phoneDao){

        //zheli fasong xinshoouji haode yanzhgma



    }
    public State SaveChange(PhoneDao newphoneuser){
        State state=new State();
        int id=newphoneuser.getId();
        int getsendmessage=newphoneuser.getSendmessage();

        //redis panduan




        String newphonenumber=newphoneuser.getChangephonenumber();
        PreparedStatement pstm=null;
        Connection connection=JDBCConnection.getconnection();
        String sql="update user set phonenumber="+"'"+newphonenumber+"'"+"where id ="+id;
        LOGGER.info("this is my update sql "+sql);
        try {

            Statement statement=connection.createStatement();
            int iii=statement.executeUpdate(sql);
            state.setId(id);
            state.setState(iii);
        } catch (SQLException e) {
            LOGGER.warn("this is in create statement "+e);
        }
        return state;

    }
}
