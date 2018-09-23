package org.Control;


import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.ServerPreparedStatement;
import org.DaoTest.Userchange.UserDao;
import org.Util.JdbcPool;
import org.Util.State;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @Author: yanshilong
 * @Date: 18-9-23 下午2:32
 * @Version 1.0
 */
public class GetInformation {
    private static Logger LOGGER=Logger.getLogger(GetInformation.class);


    public State Getmetion(UserDao userDao){
        int id=userDao.getId();
        State state=new State();
        Connection coon= (Connection) JdbcPool.get();

        ArrayList<UserDao>  list=new ArrayList<>();
//name
        //phonenumber
        //nativespace  weixin


        String sql="select name,phonenumber,nativespace,weixin from user where id="+id;
        LOGGER.info("this is my search sql "+sql);

        String json = null;
        try {
            Statement statement=coon.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            UserDao userDao1=new UserDao();
                  while (rs.next()){

                      userDao1.setName(rs.getString("name"));

                      System.out.println(userDao1.getName());
                      userDao1.setNativespace(rs.getString("nativespace"));
                      userDao1.setWeixin(rs.getString("weixin"));
                      userDao1.setPhonenumber(rs.getString("phonenumber"));
                      list.add(userDao1);

                  }
            String ss = JSON.toJSONString(userDao1);
            System.out.println("这是我的字符串： "+ss);




        } catch (SQLException e) {
            LOGGER.info("this is a error when create statement ",e);
        }

        System.out.println("长度=======" + list.size());

        json = JSON.toJSONString(list);
       // System.out.println("这是我的返回json: "+json);
        LOGGER.info("这是我的返回json: "+json);
        state.setMessage(json);
        state.setState(1);

        return state;



    }




}
