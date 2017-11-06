package com.cowboy.sbe.web.controller;/**
 * Created by Administrator on 2017/11/6/0006.
 */

import com.cowboy.sbe.dao.entity.User;
import com.cowboy.sbe.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-06 16:01
 **/
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/getUser")
    public List<User> getUsers(){
        PageHelper.startPage(1,2,false);
        List<User> users =  userService.getUsers(new User());
        Page<User> page = (Page<User>) users;
        int pageNum = page.getPageNum();
        int total = (int) page.getTotal();
        int pages = page.getPages();
        return users;
    }
}
