package com.cowboy.sbe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */
@RestController
@SpringBootApplication
@Slf4j
public class SbeWebApplicaiton extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SbeWebApplicaiton.class, args);

    }
}
