import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

/**
 * @Author: yanshilong
 * @Date: 18-8-14 上午11:50
 * @Version 1.0
 */
public class RedisTest {
    public  void run() {
        Jedis jedis = new Jedis("127.0.0.1");
         jedis.set("111","Hjhhh");
        Set s=jedis.keys("*");
        Iterator ss=s.iterator();
        while (ss.hasNext()){
            String key= (String) ss.next();
            String value=jedis.get(key);
            System.out.println("KEY: "+key+"V: "+value);

        }


    }

    public static void main(String[] args) {
        RedisTest rr=new RedisTest();
        rr.run();
    }
}
