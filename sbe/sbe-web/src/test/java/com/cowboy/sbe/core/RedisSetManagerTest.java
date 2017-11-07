package com.cowboy.sbe.core;/**
 * Created by Administrator on 2017/11/7/0007.
 */

import com.cowboy.sbe.SbeWebApplicaitonTest;
import com.cowboy.sbe.core.redis.RedisSetManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-07 17:15
 **/
public class RedisSetManagerTest extends SbeWebApplicaitonTest {
    @Autowired
    private RedisSetManager redisSetManager;
    @Test
    public void test1(){
        System.out.println(redisSetManager.add("myset2","tangyinbo",new TestObj(1,"bobo",new Date()),new TestObj(1,"bobo",new Date()),"kaka"));
    }
}
