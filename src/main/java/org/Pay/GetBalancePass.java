package org.Pay;

import org.Util.JdbcPool;
import org.Util.State;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: yanshilong
 * @Date: 18-9-5 下午9:21
 * @Version 1.0
 */
public class GetBalancePass {
    private static Logger LOGGER=Logger.getLogger(GetBalancePass.class);
    public static State getbalancepass(PayUser payUser){
        int id=payUser.getId();
        State state=new State();
        Connection connection= (Connection) JdbcPool.get();
        String sql="select password,account from user where id="+id;
        LOGGER.info("this is my sql :"+sql);
        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                state.setAccount(resultSet.getDouble("account"));
                state.setPass(resultSet.getString("password"));
                state.setState(1);


            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            LOGGER.error("this is an error when create statement  ",e);
        }


        return state;
    }


}
