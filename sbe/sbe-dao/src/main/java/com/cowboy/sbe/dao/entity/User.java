package com.cowboy.sbe.dao.entity;/**
 * Created by Administrator on 2017/11/6/0006.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-06 16:37
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId;
    private String userName;
    private Integer age;
}
