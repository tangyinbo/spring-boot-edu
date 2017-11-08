package com.cowboy.sbe.web.common.config;/**
 * Created by Administrator on 2017/11/8/0008.
 */

import com.cowboy.sbe.web.common.filter.SecurityFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器配置类
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-08 10:06
 **/
@Configuration
public class FilterConfig {
    /**
     *安全连接过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean securityFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new SecurityFilter());
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/*");
        filterRegistrationBean.setUrlPatterns(urlPatterns);
        filterRegistrationBean.setOrder(-1);
        return filterRegistrationBean;
    }
}
