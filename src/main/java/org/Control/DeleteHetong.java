package org.Control;

import org.DaoTest.DeleteHetong.DeleteDao;
import org.Util.JDBCConnection;
import org.Util.State;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

/**
 * @Author: yanshilong
 * @Date: 18-8-21 下午3:34
 * @Version 1.0
 */
public class DeleteHetong {
    static Logger LOGGER=Logger.getLogger(DeleteHetong.class);
    public int delete(DeleteDao delete){
        String hetongid=delete.getHetongid();
        Jedis  jedis6381=new Jedis("127.0.0.1",6381);
        Set kye=jedis6381.keys(hetongid);
        jedis6381.del(String.valueOf(kye));

//mysql   delete
        PreparedStatement pstm=null;
        State state=new State();
        Connection connection=JDBCConnection.getconnection();
        String sql="delete from hetong where id="+"'"+hetongid+"'";
        LOGGER.info("this is my delete sql   "+sql);


        try {
           pstm=connection.prepareStatement(sql);
             int i=pstm.executeUpdate();
            System.out.println("state= "+i);
            state.setId(1);


//            String sql = "delete from changef where id=" + id;
//            PreparedStatement pst;
//            try {
//                pst = (PreparedStatement) conn.prepareStatement(sql);
//                i = pst.executeUpdate();
//                System.out.println("resutl: " + i);
//                pst.close();
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            return i;

        } catch (SQLException e) {
            LOGGER.warn("this is in createstatement  "+e);
        }
        try {
            pstm.close();
            connection.close();
        } catch (SQLException e) {
            LOGGER.warn("this is in close pstm&&conn  "+e);
        }


        return  state.getId();
    }
}
