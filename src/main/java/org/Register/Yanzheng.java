package org.Register;

import org.State.State;
import redis.clients.jedis.Jedis;

/**
 * @Author: yanshilong
 * @Date: 18-8-20 下午8:04
 * @Version 1.0
 */
public class Yanzheng {
    public UserDao Getyanzheng(UserDao userDao){
        State state=new State();
        userDao.setId(1);//这里是一个生成ID算法
        int id=userDao.getId();

        //此处生成验证码
        String  yanzhengma="1";//这里调用生成验证码的
        userDao.setYanzhengma(yanzhengma);

        Jedis jedis6380=new Jedis("137.00.0.1",6380);
        jedis6380.set(userDao.getPhonenumber(),yanzhengma);
        String iid=id+"";
        jedis6380.expire(iid,60);
        state.setId(id);
        state.setState(1);



        return userDao;
    }
}
