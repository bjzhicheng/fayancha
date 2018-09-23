package org.Control;

import com.alibaba.fastjson.JSON;
import org.CustomerJilu.AddCustomer;
import org.CustomerJilu.CustomerDao;
import org.Util.GetTime;
import org.Util.JdbcPool;
import org.Util.State;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

/**
 * @Author: yanshilong
 * @Date: 18-9-6 上午12:38
 * @Version 1.0
 */
public class GetCustomerjilu {
    private static Logger LOGGER=Logger.getLogger(AddCustomer.class);
    public  State GddoneCustomer(CustomerDao customerDao) {
        State state=new State();

       int id=customerDao.getId();
       Connection coon= (Connection) JdbcPool.get();
       String sql="select * from customerjilu where userid="+id;
        System.out.println(sql);

        try {
            Statement statement=coon.createStatement();
           ResultSet rs= statement.executeQuery(sql);
            ArrayList<CustomerDao> list=new ArrayList();
              while (rs.next()){
                  CustomerDao cus=new CustomerDao();
                  cus.setTime(rs.getString("time"));
                  cus.setType(rs.getString("type"));
                  cus.setUseaccount(rs.getDouble("useaccount"));
                  cus.setYuaccount(rs.getDouble("yuaccount"));
                  cus.setCusnumber(rs.getString("id"));

                    list.add(cus);
              }
           String ss=JSON.toJSONString(list);
              state.setMessage(ss);
        } catch (SQLException e) {
            LOGGER.info("this is an error when create atatement:  ",e);
        }


        return state;

    }
    }
//        State state=new State();
//        String iid=customerDao.getId();
//        String id=iid+GetTime.GetnowTime();
//        double yuaccount=customerDao.getYuaccount();
//        double useaccount=customerDao.getUseaccount();
//        String time=customerDao.getTime();
//        String type=customerDao.getType();
////           String sql="insert into customerjilu ( id,yuaccount,useaccount,time,type) values"+"("+"'"+newid+"',"+
////                   newyuanaccount+","+newuseaccount+",'"+newtime+"','"+newtype+")";
//        //   String sql="insert into customerjilu(id,yuaccount,useaccount,time,type) values"+"(?,?,?,?,?)";
//        String sql="insert into customerjilu (id,yuaccount,useaccount,time,type)"+"values"+"(?,?,?,?,?)";
//        LOGGER.info("this is my insert sql  "+sql);
//        PreparedStatement pstm=null;
//        Connection connection= (Connection) JdbcPool.get();
//        try {
//            pstm=(PreparedStatement)connection.prepareStatement(sql);
//            pstm.setString(1,id);
//            pstm.setDouble(2,yuaccount);
//            pstm.setDouble(3,useaccount);
//            pstm.setString(4,time);
//            pstm.setString(5,type);
//            int i=pstm.executeUpdate();
//            state.setState(1);
//
//        } catch (SQLException e) {
//            LOGGER.info("this is an error when create statement ",e);
//        }
//        try {
//            pstm.close();
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//        return state;
//    }

