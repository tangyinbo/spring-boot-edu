package com.cowboy.sbe.service;/**
 * Created by Administrator on 2017/11/6/0006.
 */

import com.cowboy.sbe.dao.entity.User;

import java.util.List;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-06 16:32
 **/
public interface UserService {

    List<User> getUsers(User user);

}
