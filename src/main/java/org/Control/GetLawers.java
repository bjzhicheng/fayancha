package org.Control;


import com.alibaba.fastjson.JSON;
import org.DaoTest.Lawers.*;
import org.Util.JdbcPool;
import org.Util.State;
import org.apache.log4j.Logger;

;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * @Author: yanshilong
 * @Date: 18-8-22 下午11:19
 * @Version 1.0
 */
//GetLawers /GetAll()获取所有
//GetLawers /Getsome(LawersDao aa)获取部分
//GetLawers/GetOne(LawersDao aa)  查看一个详情


public class GetLawers {
    Logger LOGGER=Logger.getLogger(GetLawers.class);
    public static Connection getcoon(){
        Connection coon=null;
        coon=(Connection) JdbcPool.get();
        return coon;
    }
    State state=new State();


    public State GetAll(){

       ArrayList<LawersDao> arrayList=new ArrayList<>();
        String json=null;

        Connection connection=null;
      connection=getcoon();

        String sql="select id,name,nativespace,belongs,shanchang,phonenumber from lawers ";
        LOGGER.info("this is my sql "+sql);
        try {
            LawersDao lawer=new LawersDao();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next()){
                lawer.setId(resultSet.getInt("id"));
                lawer.setName(resultSet.getString("name"));
                lawer.setNativespace(resultSet.getString("nativespace"));
                lawer.setBelongs(resultSet.getString("belongs"));
                lawer.setShanchang(resultSet.getString("shanchang"));
                lawer.setPhonenumber(resultSet.getString("phonenumber"));
               arrayList.add(lawer);
            }
             json=JSON.toJSONString(arrayList);
            state.setMessage(json);

connection.close();

        } catch (SQLException e) {
            LOGGER.error("this is an error when create statement "+e);
        }


        return state;
    }



    public State Getsome(LawersDao xianzhi){
        ArrayList <LawersDao> arrayList=new ArrayList<>();
        String json=null;

        Connection connection=null;
        connection=getcoon();

         String sql="select id,name,nativespace,belongs,shanchang,phonenumber from lawers " +
                "where nativespace like  "+"'"+xianzhi.getNativespace()+"%' and "+"shanchang " +
                "like"+"'"+xianzhi.getShanchang()+"%'";
          LOGGER.info("this is my sql "+sql);
        try {

            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next()){
                LawersDao lawer=new LawersDao();
                lawer.setId(resultSet.getInt("id"));
                lawer.setPhonenumber(resultSet.getString("phonenumber"));
                lawer.setName(resultSet.getString("name"));
                lawer.setNativespace(resultSet.getString("nativespace"));
                lawer.setBelongs(resultSet.getString("belongs"));
                lawer.setShanchang(resultSet.getString("shanchang"));

                arrayList.add(lawer);
            }
           json=JSON.toJSONString(arrayList);
            state.setState(1);
            state.setMessage(json);
            connection.close();

        } catch (SQLException e) {
            LOGGER.error("this is an error when create statement "+e);



        }


        return state;
    }



    public String GetOne(LawersDao lawer){
        String json=null;

        LawersDao rturn=new LawersDao();

        Connection coon=getcoon();
        String sql="select * from lawers where id ="+lawer.getId();
        LOGGER.info("this is my sql in getone : "+sql);
        try {
            Statement statement=coon.createStatement();
            ResultSet ss=statement.executeQuery(sql);
            while (ss.next()){
                rturn.setShanchang(ss.getString("shanchang"));
                rturn.setPhonenumber(ss.getString("phonenumber"));
                rturn.setBelongs(ss.getString("belongs"));
                rturn.setNativespace(ss.getString("nativespace"));
                rturn.setName(ss.getString("name"));
                rturn.setLoves(ss.getInt("loves"));
                rturn.setSees(ss.getInt("sees"));
                rturn.setJianjie(ss.getString("jianjie"));
                rturn.setAnli(ss.getString("anli"));
                rturn.setZhiwu(ss.getString("zhuwu"));
            }
            json=JSON.toJSONString(rturn);

        } catch (SQLException e) {
            LOGGER.error("this is an error when create statement  "+e);
        }
        try {
            coon.close();
        } catch (SQLException e) {
            LOGGER.error("this is an error when close coon "+e );
        }

        return json;

    }

    }




