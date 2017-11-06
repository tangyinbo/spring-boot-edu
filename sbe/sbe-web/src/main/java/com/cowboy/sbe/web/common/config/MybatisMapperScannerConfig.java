package com.cowboy.sbe.web.common.config;/**
 * Created by Administrator on 2017/11/6/0006.
 */

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-06 16:18
 **/
@Configuration
@AutoConfigureAfter(MybatisConfig.class)
public class MybatisMapperScannerConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.cowboy.sbe.dao");
        return mapperScannerConfigurer;
    }
}
