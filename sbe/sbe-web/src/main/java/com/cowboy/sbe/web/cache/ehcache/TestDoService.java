package com.cowboy.sbe.web.cache.ehcache;/**
 * Created by Administrator on 2017/11/14/0014.
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * ehcache 测试
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-14 16:18
 **/
@Service
@Slf4j
public class TestDoService {
    @Autowired
    private CacheManager cacheManager;

    private volatile  int count =0;

 /*   @Cacheable(cacheNames = "testDo", key = "#testDO.id" )
    public void addTestDo(TestDO testDO){

    }*/
    @Cacheable(cacheNames = "testDo",key = "#id")
    public TestDO findTestDto(int id){
        if(count++ != 0){
            log.info("return null....");
            return null;
        }
        log.info("findTestDto ....");
        return new TestDO(id,"bobo",30);
    }







}
