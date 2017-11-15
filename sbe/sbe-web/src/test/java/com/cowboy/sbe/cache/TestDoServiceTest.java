package com.cowboy.sbe.cache;/**
 * Created by Administrator on 2017/11/14/0014.
 */

import com.cowboy.sbe.SbeWebApplicaitonTest;
import com.cowboy.sbe.web.cache.ehcache.TestDO;
import com.cowboy.sbe.web.cache.ehcache.TestDoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.io.ByteArrayInputStream;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-14 16:25
 **/
public class TestDoServiceTest extends SbeWebApplicaitonTest {
    @Autowired
    private TestDoService testDoService;

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void test1(){
        testDoService.findTestDto(2);
        Cache cache = cacheManager.getCache("testDo");

        TestDO testDO = testDoService.findTestDto(2);
        System.out.println(testDO);
        System.out.println("====================");

    }
}
