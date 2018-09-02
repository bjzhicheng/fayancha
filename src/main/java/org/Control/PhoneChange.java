package org.Control;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.exceptions.ClientException;
import org.Util.JDBCConnection;
import org.DaoTest.PhoneChange.PhoneDao;
import org.Util.Send;
import org.Util.State;
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
    String HOST="127.0.0.1";


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

    public State Phonechange(PhoneDao changer){
        Send send=new Send();
        State state=new State();
        int mess=0;
        try {
            mess=send.sendSms(changer.getPhonenumber());
            Jedis jedis6382=new Jedis(HOST,6382);
            jedis6382.set(changer.getPhonenumber(), String.valueOf(mess));
            jedis6382.close();
            if(mess!=0){
                state.setState(1);
            }else{
                state.setState(0);
            }
        } catch (ClientException e) {
            e.printStackTrace();
        }

return  state;
    }

    //3  获取验证码  判断get 验证码 余 redis 李存储的是否.equals  return state=1

    public State PhoneChackchange(PhoneDao checker){
        State state=new State();
             String realmessage=null;


              // int gemessage=checker.getSendmessage();
        Jedis redis6382=new Jedis(HOST,6782);
        Set ss=redis6382.keys(checker.getPhonenumber());
          Iterator iterator=ss.iterator();
          while(iterator.hasNext()){
               String ii= (String) iterator.next();
               realmessage=redis6382.get(ii);
          }
          redis6382.close();
          if (realmessage.equals(checker.getYanzhengma())){


              state.setState(1);
               return state;
          }
          else {
              state.setState(0);

              return  state;
          }

    }
    // 4  输入新的手机号 发送验证码
    public State Change(PhoneDao phoneDao){
        State state=new State();
       String phonenumber=phoneDao.getPhonenumber();
       Send send=new Send();
       int yanzhengma=0;
        try {
            yanzhengma=send.sendSms(phonenumber);


        } catch (ClientException e) {
            LOGGER.warn("this is in send message:"+e);
        }
Jedis redijs6382=new Jedis(HOST,6382);
        redijs6382.set(phonenumber, String.valueOf(yanzhengma));
        if (yanzhengma!=0){
            state.setState(1);
        }else {state.setState(0);}
        redijs6382.close();

      return state;
     }




    //接受到前段验证码，若正确，数据罗盘 redis 更新

    public State SaveChange(PhoneDao newphoneuser) throws SQLException {
        Connection connection=null;
        State state = new State();
        String getphone = newphoneuser.getPhonenumber();
        String getyanzhengma = newphoneuser.getYanzhengma();
        String phone = null;
        String yanzhengma = null;


        int getid = newphoneuser.getId();
        Jedis redis6382 = new Jedis(HOST, 6382);
        Set set = redis6382.keys(getphone);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            phone = (String) iterator.next();
            yanzhengma = redis6382.get(phone);
        }

        redis6382.close();
        LOGGER.info("redis  get phone+message= " + phone + "  " + yanzhengma);
        if (phone.equals(getphone) && (yanzhengma.equals(getyanzhengma))) {
            PreparedStatement pstm = null;
            connection = JDBCConnection.getconnection();
            String sql = "update user set phonenumber=" + "'" + getphone + "'" + "where id =" + getid;
            LOGGER.info("this is my update sql " + sql);
            try {

                Statement statement = connection.createStatement();
                int iii = statement.executeUpdate(sql);
                state.setState(iii);
            } catch (SQLException e) {
                LOGGER.warn("this is in create statement " + e);
            }connection.close();


            return state;




        }else {


            state.setState(0);
        return state;

        }
    }

    }







