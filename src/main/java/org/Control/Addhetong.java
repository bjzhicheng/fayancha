package org.Control;

import org.DaoTest.AddHetong.HetongDao;
import org.Util.JDBCConnection;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Author: yanshilong
 * @Date: 18-8-21 下午1:23
 * @Version 1.0
 * 传输 用户id
 * 合同redis 6381 key :id  value url
 *
 * 用户id转化 id——
 */
public class Addhetong {
    static Logger LOGGER=Logger.getLogger(Addhetong.class);

    public  int addhetong(HetongDao hetong){
        String id=hetong.getId()+"_"+hetong.getUrl();
        int loves=0;
        String url=hetong.getUrl();
        String title=hetong.getTitle();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy.MM.dd");
        String time= simpleDateFormat.format(new Date());
        Connection connection=JDBCConnection.getconnection();
        Jedis jedis=new Jedis("127.0.0.1",6381);
        jedis.set(id,url);
        jedis.expire(id,7*24*60*60);

        jedis.close();




        String sql="insert into hetong (id,url,loves,title,time)"+"values"+"(?,?,?,?,?)";
        PreparedStatement pstm=null;
        int i=0;
        try {
            pstm=(PreparedStatement)connection.prepareStatement(sql);
            pstm.setString(1,id);
            pstm.setString(2,url);
            pstm.setInt(3,loves);
            pstm.setString(4,title);
            pstm.setString(5,time);
            i=pstm.executeUpdate();
        } catch (SQLException e) {
            LOGGER.debug("this is in patm "+e);
        }
        try {
            pstm.close();
            connection.close();
        } catch (SQLException e) {
            LOGGER.debug("this is in close pstm coon"+e);
        }
        return i;
    }


}
