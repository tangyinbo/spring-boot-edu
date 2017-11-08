package com.cowboy.sbe.web.controller;/**
 * Created by Administrator on 2017/11/8/0008.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-08 11:22
 **/
@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(){
        return "hello";
    }
}
