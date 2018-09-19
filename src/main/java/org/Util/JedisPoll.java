package org.Util;

import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author: yanshilong
 * @Date: 18-9-9 上午10:21
 * @Version 1.0
 */
public class JedisPoll {
    public static void main(String[] args) {
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setBlockWhenExhausted(true);

    }
}
