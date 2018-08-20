package org.Login;

import org.JDBC.JDBCConnection;
import org.State.State;
import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;
import redis.clients.jedis.Jedis;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;
import org.*;



/**
 * @Author: yanshilong
 * @Date: 18-8-12 上午10:58
 * @Version 1.0
 *
 * port=3769 注册登陆redis
 * 返回state  0+id登陆失败
 *            1+id=登陆成功
 *            id pass 是前段传入数据
 *
 */
public class Login1{

    static Logger LOGGER=Logger.getLogger(Login1.class);

    public State Login(User user){
        Statement statement=null;
        State state=new State();
        state.setState(0);
        int id=user.getId();
        System.out.println(user.getId()+user.getPassword());
        Object uid=0;
        String upass=null;
        String pass=user.getPassword();
        Jedis jedis=new Jedis("127.0.0.1",6379);
        Set ss=jedis.keys(String.valueOf(id));
        Iterator iterator=ss.iterator();
        while(iterator.hasNext()){
            uid=iterator.next();
              upass=jedis.get(String.valueOf(uid));
            System.out.println(uid+upass+"12121212");

        }
        if((uid.equals(String.valueOf(id)))&&(pass.equals(upass))){
            state.setId(id);
            state.setState(1);
            System.out.println("从redis内匹配到用户");
            LOGGER.info("redis Login");


        }else {
            System.out.println("JEDIS 没有匹配到");
            LOGGER.info("MYSQL login");
            Connection conn=JDBCConnection.getconnection();
            String sql="select * from user where id="+id;
            System.out.println("sql="+sql);
            LOGGER.debug("this is in search mysql"+sql);
            try {
                statement=conn.createStatement();
                ResultSet rs=statement.executeQuery(sql);
                if (rs.next()){
                    uid=rs.getInt("id");
                    upass=rs.getString("password");
                    if((uid.equals(id))&&(pass.equals(upass))){
                        state.setState(1);
                        state.setId(id);
                        String ii=id+"";
                        String pp=pass;
                        jedis.set(ii,pass);
                        jedis.expire(ii,50000000);
                        //设置失效时间
                        System.out.println("JEDIS更新  key="+ii+"value="+pass);

                    }

                }
            } catch (SQLException e) {
              LOGGER.debug("THIS IS IN CREATE STATEMENT"+e);
            }


        }


return state;
    }
}
