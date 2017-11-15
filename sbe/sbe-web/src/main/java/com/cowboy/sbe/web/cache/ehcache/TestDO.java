package com.cowboy.sbe.web.cache.ehcache;/**
 * Created by Administrator on 2017/11/14/0014.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-14 16:16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestDO implements Serializable {
    private int id;
    private String name;
    private int age;
}
