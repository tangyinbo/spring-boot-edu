package com.cowboy.sbe.web.common.config;/**
 * Created by Administrator on 2017/11/6/0006.
 */

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-06 14:34
 **/
@Configuration
public class JsonConfig {
    /**
     * fastjson 作为json转换对象
     * @return
     */
    @Bean
    public HttpMessageConverters fastjsonHttpMessageConverters(){
        //fastjson 消息转换对象
        FastJsonHttpMessageConverter messageConverter = new FastJsonHttpMessageConverter();
        //配置对象
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
        messageConverter.setFastJsonConfig(config);
        return new HttpMessageConverters(messageConverter);
    }
}
