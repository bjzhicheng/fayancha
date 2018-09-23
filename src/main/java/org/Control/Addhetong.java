package org.Control;

import org.DaoTest.AddHetong.HetongDao;
import org.Util.JDBCConnection;
import org.Util.MakeUuid;
import org.Util.State;
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
    //daodaolvfa
    //lvfadaodao6666
    //ssh root@60.205.0.237
    //22
    //805394

    //
    static Logger LOGGER=Logger.getLogger(Addhetong.class);

    public State addhetong(HetongDao hetong){
        int userid=hetong.getId();
        int id=MakeUuid.Make();



        State state=new State();
      //  int loves=0;
        //String url=hetong.getUrl();
        String title=hetong.getTitle();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy.MM.dd");
        String time= simpleDateFormat.format(new Date());
        String message=hetong.getMessage();
        String fenhxian=hetong.getFengxian();
        String jianyi=hetong.getJianyi();



        Connection connection=JDBCConnection.getconnection();
//        Jedis jedis=new Jedis("127.0.0.1",6381);
//        jedis.set(String.valueOf(id),url);
//        jedis.expire(String.valueOf(id),7*24*60*60);
//
//        jedis.close();




        String sql="insert into hetong (id,title,time,message,jianyi,fengxian,userid)"+"values"+"(?,?,?,?,?,?,?)";
        System.out.println(sql);
        PreparedStatement pstm=null;
        int i=0;
        try {
            pstm=(PreparedStatement)connection.prepareStatement(sql);
            pstm.setInt(1,id);
            //pstm.setString(2,url);
           // pstm.setInt(3,loves);
            pstm.setString(2,title);
            System.out.println(jianyi);
            System.out.println(fenhxian);
           // pstm.setString(4,title);
            pstm.setString(3,time);
            pstm.setString(4,message);
            pstm.setString(5,jianyi);
            pstm.setString(6,fenhxian);
            pstm.setInt(7,userid);
            i=pstm.executeUpdate();
            state.setState(i);
        } catch (SQLException e) {
            LOGGER.debug("this is in patm "+e);
        }
        try {
            pstm.close();
            connection.close();
        } catch (SQLException e) {
            LOGGER.debug("this is in close pstm coon"+e);
        }
        return state;
    }


}
