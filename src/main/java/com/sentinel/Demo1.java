package com.sentinel;

import com.jedis.JedisPoolUtil;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class Demo1 {
    public static void main(String[] args) {
        //Jedis jedis = new Jedis("hadoop102", 6379);
        Jedis jedis = JedisSentinel.getJedisFromSentinel();

        /*jedis.set("name","kous");

        String name = jedis.get("name");
        System.out.println(name);*/

       /* jedis.mset("cup","36d","age","18");
        System.out.println(jedis.mget("cup","age"));*/

        /*List<String> xuanxuan = jedis.lrange("xuanxuan", 0, -1);

        for (String s : xuanxuan) {
            System.out.println(s);
        }*/

       /* jedis.sadd("orders","order01");
        jedis.sadd("orders","order02");
        jedis.sadd("orders","order03");
        jedis.sadd("orders","order04");

        Set<String> sm = jedis.smembers("orders");
        for (String order : sm) {
            System.out.println(order);
        }
*/
       /* jedis.hset("hash1","userName","lisi");
        System.out.println(jedis.hget("hash1","userName"));
        Map<String,String> map = new HashMap<String,String>();
        map.put("telphone","13810169999");
        map.put("address","liangzi");
        map.put("email","abc@163.com");
        jedis.hmset("hash2",map);
        List<String> result = jedis.hmget("hash2", "telphone","email");
        for (String element : result) {
            System.out.println(element);
        }*/

       jedis.zadd("zset01", 100d, "z3");
        jedis.zadd("zset01", 90d, "l4");
        jedis.zadd("zset01", 80d, "w5");
        jedis.zadd("zset01", 70d, "z6");
       Set<String> zrange = jedis.zrange("zset01", 0, -1);
        for (String e : zrange) {
            System.out.println(e);
        }
        String girl = jedis.get("girl");
        System.out.println(girl);


    }
}
