package org.x.redisdemo.sentinel;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Hong-Yang Xiao
 */
public class Demo {
    public static void main(String[] args) {
        Set<String> sentinels = new HashSet<>();
        sentinels.add("192.168.31.135:27379");
        sentinels.add("192.168.31.135:28379");
        sentinels.add("192.168.31.135:29379");

        JedisSentinelPool sentinelPool = new JedisSentinelPool("mymaster", sentinels);
        Jedis jedis = sentinelPool.getResource();
        jedis.auth("123456");
        System.out.println("current Host: " + sentinelPool.getCurrentHostMaster());

        jedis.set("xtestkey", "hello sentinel@" + new Date());
        System.out.println(jedis.get("xtestkey"));
    }
}
