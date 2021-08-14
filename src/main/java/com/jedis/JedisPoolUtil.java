package com.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {

    private static JedisPool jedisPool = null;

    public static Jedis getJedisFromPool() {
        if(jedisPool == null){
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(10); //最大可用连接数
            jedisPoolConfig.setMaxIdle(5); //最大闲置连接数
            jedisPoolConfig.setMinIdle(1); //最小闲置连接数
            jedisPoolConfig.setBlockWhenExhausted(true);//连接耗尽是否等待
            jedisPoolConfig.setMaxWaitMillis(2000);//等待时间
            jedisPoolConfig.setTestOnBorrow(true);//取连接的时候测试一下ping

            JedisPool jedisPool = new JedisPool(jedisPoolConfig, "192.168.2.102", 6379);

            return jedisPool.getResource();
        }
        else {
            return jedisPool.getResource();
        }

    }
}
