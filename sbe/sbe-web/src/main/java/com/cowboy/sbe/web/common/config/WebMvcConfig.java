package com.cowboy.sbe.web.common.config;/**
 * Created by Administrator on 2017/11/8/0008.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 如果Spring Boot 提供的Spring MVC 不符合要求,则可以通过一个配置类(注解有@Configuration的类)，加上@EnableWebMvc注解来实现完全自己控制的MVC配置。
 *<p> 既需要保留Spring Boot提供的便利,又需要增加自己的额外的配置的时候,可以定义一个配置类并继承WebMvcConfigureAdapter,不用使用@EnableWebMvc注解。
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-08 11:17
 **/
@Configuration
/*@EnableWebMvc*/
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/public/**").addResourceLocations("classpath:/public/");
        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");
    }
    @Bean
    public InternalResourceViewResolver defaultViewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/page/");
        internalResourceViewResolver.setSuffix(".html");
        return internalResourceViewResolver;
    }
}
