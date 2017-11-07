package com.cowboy.sbe.core;/**
 * Created by Administrator on 2017/11/7/0007.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-07 16:35
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestObj {
    private int id;
    private String name;
    private Date birthDay;
}
