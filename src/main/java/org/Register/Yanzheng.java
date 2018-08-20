package org.Register;

import org.State.State;
import redis.clients.jedis.Jedis;

/**
 * @Author: yanshilong
 * @Date: 18-8-20 下午8:04
 * @Version 1.0
 */
public class Yanzheng {
    public State Getyanzheng(UserDao userDao){
        State state=new State();
        int id=userDao.getId();

        //此处生成验证码
        String  yanzhengma=null;
        Jedis jedis6380=new Jedis("137.00.0.1",6380);
        jedis6380.set(String.valueOf(id),yanzhengma);
        String iid=id+"";
        jedis6380.expire(iid,60);
        state.setId(id);
        state.setState(1);



        return state;
    }
}
