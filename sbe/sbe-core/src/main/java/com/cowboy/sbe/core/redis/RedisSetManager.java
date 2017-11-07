package com.cowboy.sbe.core.redis;/**
 * Created by Administrator on 2017/11/7/0007.
 */

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-07 17:02
 **/
public interface RedisSetManager {
    /**
     * 添加指定的值到set
     * @param key
     * @param value
     */
    public long add(String key,Object...value);
}
