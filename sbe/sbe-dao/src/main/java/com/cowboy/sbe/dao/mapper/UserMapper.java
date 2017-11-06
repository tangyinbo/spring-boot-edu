package com.cowboy.sbe.dao.mapper;/**
 * Created by Administrator on 2017/11/6/0006.
 */

import com.cowboy.sbe.dao.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-06 16:38
 **/
public interface UserMapper {
    @Select("select * from t_user")
    List<User> getUsers();
}
