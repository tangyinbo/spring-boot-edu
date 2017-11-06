package com.cowboy.sbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */
@RestController
@SpringBootApplication
public class SbeWebApplicaiton extends SpringBootServletInitializer {
    @RequestMapping("/hello")
    public String hello(){
        return "hello tangyinbo fsfsffdfd234fsfsdddddfsffsf";
    }
    public static void main(String[] args) {
        SpringApplication.run(SbeWebApplicaiton.class,args);

    }
}
