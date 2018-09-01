package org.Control;

import org.DaoTest.Userchange.UserDao;
import org.Util.JDBCConnection;
import org.Util.State;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: yanshilong
 * @Date: 18-8-21 下午4:42
 * @Version 1.0
 */
public class Userchange {
    static Logger LOGGER =Logger.getLogger(Userchange.class);
    public State Userchange(UserDao userDao){
        Statement statement=null;
        State state=new State();
        int id=userDao.getId();
        Connection connection=null;
        PreparedStatement pstm=null;
String sql="update user set name="+"'"+userDao.getName()+"'"+","+"weixin="+"'"
        +userDao.getWeixin()+"'"
        +","+"nativespace="+"'"+userDao.getNativespace()+"'"+","+"companyname="+"'"
        +userDao.getCompanyname()+"'"+","
        +"position="+"'"+userDao.getPosition()+"'"+" where id="+id;



             LOGGER.info("this is my update sql   "+sql);
            connection=JDBCConnection.getconnection();
        try {
           statement=connection.createStatement();
             int ii=statement.executeUpdate(sql);
             state.setState(ii);
            System.out.println("修改的state= "+ii);
             state.setId(id);
        } catch (SQLException e) {
            LOGGER.warn("this is in create statement "+e);
        }


        return state;
    }
}
