package org.Control;

import org.Util.JDBCConnection;
import org.DaoTest.Login.User;
import org.Util.State;
import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


/**
 * @Author: yanshilong
 * @Date: 18-8-12 上午10:58
 * @Version 1.0
 *
 * port=3769 注册登陆redis
 * 返回state  state=0登陆失败
 *            state=1登陆成功
 *            phonenumber   pass 是前段传入数据
 *
 */
public class Login1{

    static Logger LOGGER=Logger.getLogger(Login1.class);

    public State Login(User user){
        Statement statement=null;
        State state=new State();
        state.setState(0);

        System.out.println("前段传入的手机号是："+user.getPhonenumber()+"  密码是"+user.getPassword());
        String unimber="";
        String upass="";
        int uid=0;
        String pass=user.getPassword();
        Jedis jedis6379=new Jedis("127.0.0.1",6379);
        Set ss=jedis6379.keys(user.getPhonenumber());
        Iterator iterator=ss.iterator();
        while(iterator.hasNext()){
            unimber= (String) iterator.next();
              String map=jedis6379.get(unimber);
            String bb=map.replaceAll("\\{|}","");
            System.out.println(bb);

            String [] result=bb.split("=");
            System.out.println(result[0]);
            System.out.println(result[1]);
              upass=result[0];
              uid=Integer.parseInt(result[1]);




            System.out.println("redis获取到手机号："+unimber+"   密码："+upass+"用户id： "+uid);

        }
        if(upass.equals(user.getPassword())&&(unimber.equals(user.getPhonenumber()))){

            state.setState(1);
            state.setId(uid);
            System.out.println("从redis内匹配到用户");
            LOGGER.info("redis Login");


        }else {
            System.out.println("JEDIS 没有匹配到");
            System.out.println("==========================开始查询sql");
            LOGGER.info("MYSQL login");
            Connection conn=JDBCConnection.getconnection();
            String sql="select * from user where phonenumber="+user.getPhonenumber();
            System.out.println("sql="+sql);
            LOGGER.debug("this is in search mysql"+sql);
            try {
                statement=conn.createStatement();
                ResultSet rs=statement.executeQuery(sql);
                if (rs.next()){
                    unimber=rs.getString("phonenumber");
                    upass=rs.getString("password");
                    uid=rs.getInt("id");

                    if((unimber.equals(user.getPhonenumber()))&&(pass.equals(upass))){
                        state.setState(1);
                        state.setId(uid);


//                        ArrayList array=new ArrayList();
//                        array.add(user.getPassword());
//                        array.add(uid);
                        HashMap hashMap=new HashMap();
                        hashMap.put(upass,uid);//key= pass value=id


                        jedis6379.set(user.getPhonenumber(),String.valueOf(hashMap));

                        jedis6379.expire(user.getPhonenumber(),30*24*60);
                        //设置失效时间
                        System.out.println("JEDIS更新了一条数据  key="+user.getPhonenumber()+"value="+String.valueOf(hashMap));
                          jedis6379.close();
                    }

                }
            } catch (SQLException e) {
              LOGGER.debug("THIS IS IN CREATE STATEMENT"+e);
            }

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


return state;
    }
}
