package org.Pay;

import org.Util.JdbcPool;
import org.Util.State;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: yanshilong
 * @Date: 18-9-5 下午10:16
 * @Version 1.0
 */
public class Update {
    private  static Logger LOGGER=Logger.getLogger(Update.class);
    public static State Doupdate(User user){
        State state=new State();
        Connection connection= (Connection) JdbcPool.get();
        String sql="update user set account ="+user.getAccount()+" where id="+user.getId();
        LOGGER.info("this is my update sql "+sql);
        try {
            Statement statement=connection.createStatement();
            int a=statement.executeUpdate(sql);
            state.setState(1);
        } catch (SQLException e) {

        }
        System.out.println("111111111111");

        return state;
    }


}
