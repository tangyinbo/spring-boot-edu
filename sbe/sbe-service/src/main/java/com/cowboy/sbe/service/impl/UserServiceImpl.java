package com.cowboy.sbe.service.impl;/**
 * Created by Administrator on 2017/11/6/0006.
 */

import com.cowboy.sbe.dao.entity.User;
import com.cowboy.sbe.dao.mapper.UserMapper;
import com.cowboy.sbe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-06 16:33
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUsers(User user) {
        return userMapper.getUsers();
    }


    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
