package org.Control;

import com.aliyuncs.exceptions.ClientException;
import org.DaoTest.PassChange.PassDao;
import org.Util.JDBCConnection;
import org.Util.Send;
import org.Util.State;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: yanshilong
 * @Date: 18-9-1 上午7:51
 * @Version 1.0
 */
//1 手机验证码验证
    //2传入原id + 新的密码
public class PassChangeSend {
    String HOST="127.0.0.1";
    Logger LOGGER=Logger.getLogger(PassChangeSend.class);
    State state=new State();

    //获取验证码=============================================================================
    public State ChangeSend(PassDao user){
        int i=0;
        String phonenuber=user.getPhonenumber();
        Send send=new Send();
        try {
            i=send.sendSms(phonenuber);
        } catch (ClientException e) {
            LOGGER.warn("this is a warn in seng message:"+e);
        }
        if(i!=0){
            state.setState(1);
        }else {
            state.setState(0);
        }
        Jedis jedis6382=new Jedis(HOST,6382);
        jedis6382.set(String.valueOf(user.getId()),String.valueOf(i));
        jedis6382.close();


        Jedis jedis6379=new Jedis(HOST,6379);
        jedis6379.del(user.getPhonenumber());
        jedis6379.close();


        return state;
        }
  //修改
        public State PassChange(PassDao user){
        State state2=new State();
        String newphonenumber=user.getPhonenumber();

        String id=String.valueOf(user.getId());
        String yanzhengma=String.valueOf(user.getYanzhengma());
            String ii=null;
            String message=null;
        Jedis jedis6382=new Jedis(HOST,6382);
            Set ss=jedis6382.keys(id);
                Iterator iterator=ss.iterator();
                while(iterator.hasNext()){
                   ii= (String) iterator.next();
                     message=jedis6382.get(ii);

                }
                if(id.equals(ii)&&yanzhengma.equals(message)){

                    Connection connection=JDBCConnection.getconnection();
                    //PreparedStatement pstm=null;
                    String sql="update user set password="+"'"+user.getPass()+"'"+"where id="+user.getId();

                    LOGGER.info("this is my change pass sql"+sql);

                    try {
                        Statement statement =connection.createStatement();
                        int sssss=statement.executeUpdate(sql);
                        state2.setState(sssss);
                        return state2;
                    } catch (SQLException e) {
                        LOGGER.error("this is ian erroe when create statrment"+e);
                        state2.setState(0);

                    }
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }


                }else state2.setState(0);




        return state2;
        }
}
