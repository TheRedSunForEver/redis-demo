package org.x.redisdemo.single;

import redis.clients.jedis.Jedis;

/**
 * @author Hong-Yang Xiao
 */
public class BasicDemo {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.31.135", 6379);
        jedis.auth("123456");
        jedis.set("tk", "test");
        System.out.println(jedis.get("tk"));
    }
}
