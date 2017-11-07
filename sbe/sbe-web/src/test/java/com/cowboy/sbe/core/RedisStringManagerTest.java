package com.cowboy.sbe.core;/**
 * Created by Administrator on 2017/11/7/0007.
 */

import com.cowboy.sbe.SbeWebApplicaitonTest;
import com.cowboy.sbe.core.redis.RedisStringManager;
import com.cowboy.sbe.dao.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-07 15:31
 **/
public class RedisStringManagerTest extends SbeWebApplicaitonTest {
    @Autowired
    private RedisStringManager redisStringManager;
    @Test
    public void test1() {
        redisStringManager.set("myName","bobo");
    }


    @Test
    public void test2(){
        System.out.println(redisStringManager.setIfAbsent("name","tangyinboni hao y"));
    }
    @Test
    public void test3(){
        redisStringManager.setEx("name","tangyinboni v5",10, TimeUnit.SECONDS);
    }
    @Test
    public void test4(){
        System.out.println(redisStringManager.increment("myset2",-1));
    }

    @Test
    public void test5(){
        redisStringManager.set("user1",new TestObj(1,"bobo",new Date()));
    }

    @Test
    public void test6(){
        String value = redisStringManager.get("user1");
        System.out.println(value);
    }
    @Test
    public void test7(){
        TestObj obj = redisStringManager.getObject("user1",TestObj.class);
        System.out.println(obj);
    }
}
