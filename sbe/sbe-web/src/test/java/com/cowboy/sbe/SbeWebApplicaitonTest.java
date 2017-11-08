package com.cowboy.sbe;

import com.cowboy.sbe.service.UserService;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SbeWebApplicaitonTest {
    @Autowired
    private UserService userService;
/*    @Test
    public void test1(){
        System.out.println("kaka");
    }*/

   // public StringRedisTemplate
    /*@org.junit.Test
    public void test1(){
        log.info("kakak");
    }*/
}
