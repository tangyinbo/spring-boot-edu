package com.cowboy.sbe.core.redis;/**
 * Created by Administrator on 2017/11/7/0007.
 */

import com.alibaba.fastjson.JSONObject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-07 15:17
 **/
public interface RedisStringManager {
    /**
     * 对象转换为字符串
     * @param obj
     * @return
     */
    default String getStringValue(Object obj){
        if(obj instanceof String){
            return (String)obj;
        }else if(obj != null){
            return JSONObject.toJSONString(obj);
        }
        return null;
    }
    /**
     * 指定key设置为字符串形式value
     * @param key
     * @param value
     */
    public void set(String key,Object value);

    /**
     * 设置键值对的有效时间
     * @param key
     * @param value
     */
    public void setEx(String key, Object value,long time, TimeUnit timeUnit);

    /**
     * 设置值如果不存在
     * @param key
     * @param value
     */
    public boolean setIfAbsent(String key,Object value);

    /**
     *
     * @param key
     * @param value
     */
    public long increment(String key,long value);

    /**
     *
     * @param key
     * @return
     */
    public String get(String key);

    /**
     * 获取值并转换为对象
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T>T getObject(String key,Class<T> clazz);


}
