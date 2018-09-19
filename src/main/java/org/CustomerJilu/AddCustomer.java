package org.CustomerJilu;


import org.Util.GetTime;
import org.Util.JdbcPool;
import org.Util.State;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: yanshilong
 * @Date: 18-9-6 上午12:39
 * @Version 1.0
 */
public class AddCustomer {
    private static Logger LOGGER=Logger.getLogger(AddCustomer.class);
       public static State AddoneCustomer(CustomerDao customerDao){
           State state=new State();
           String iid=customerDao.getId();
           String id=iid+GetTime.GetnowTime();
           double yuaccount=customerDao.getYuaccount();
           double useaccount=customerDao.getUseaccount();
           String time=customerDao.getTime();
           String type=customerDao.getType();
//           String sql="insert into customerjilu ( id,yuaccount,useaccount,time,type) values"+"("+"'"+newid+"',"+
//                   newyuanaccount+","+newuseaccount+",'"+newtime+"','"+newtype+")";
        //   String sql="insert into customerjilu(id,yuaccount,useaccount,time,type) values"+"(?,?,?,?,?)";
           String sql="insert into customerjilu (id,yuaccount,useaccount,time,type)"+"values"+"(?,?,?,?,?)";
           LOGGER.info("this is my insert sql  "+sql);
           PreparedStatement pstm=null;
           Connection connection= (Connection) JdbcPool.get();
           try {
               pstm=(PreparedStatement)connection.prepareStatement(sql);
                pstm.setString(1,id);
                pstm.setDouble(2,yuaccount);
                pstm.setDouble(3,useaccount);
                pstm.setString(4,time);
                pstm.setString(5,type);
                int i=pstm.executeUpdate();
                state.setState(1);

           } catch (SQLException e) {
            LOGGER.info("this is an error when create statement ",e);
           }
           try {
                     pstm.close();
               connection.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }


           return state;
       }

}
