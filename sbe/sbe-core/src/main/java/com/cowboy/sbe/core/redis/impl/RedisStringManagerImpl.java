package com.cowboy.sbe.core.redis.impl;/**
 * Created by Administrator on 2017/11/7/0007.
 */

import com.alibaba.fastjson.JSONObject;
import com.cowboy.sbe.core.redis.RedisConstants;
import com.cowboy.sbe.core.redis.RedisStringManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-07 15:23
 **/
@Repository
public class RedisStringManagerImpl implements RedisStringManager {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void set(String key, Object value) {
        Assert.notNull(key, RedisConstants.KEY_NOT_NULLABLE);
        Assert.notNull(value,RedisConstants.VALUE_NOT_NULLABLE);
        stringRedisTemplate.opsForValue().set(key,getStringValue(value));
    }

    @Override
    public void setEx(String key, Object value,long time, TimeUnit timeUnit) {
        Assert.notNull(key, RedisConstants.KEY_NOT_NULLABLE);
        Assert.notNull(value,RedisConstants.VALUE_NOT_NULLABLE);
        stringRedisTemplate.opsForValue().set(key,getStringValue(value),time,timeUnit);
    }

    @Override
    public boolean setIfAbsent(String key, Object value) {
        Assert.notNull(key, RedisConstants.KEY_NOT_NULLABLE);
        Assert.notNull(value,RedisConstants.VALUE_NOT_NULLABLE);
        return stringRedisTemplate.opsForValue().setIfAbsent(key,getStringValue(value));
    }

    @Override
    public long increment(String key, long value) {
        Assert.notNull(key, RedisConstants.KEY_NOT_NULLABLE);
        return stringRedisTemplate.opsForValue().increment(key,value);
    }

    @Override
    public String get(String key) {
        Assert.notNull(key, RedisConstants.KEY_NOT_NULLABLE);
        String result = stringRedisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] redisKey = stringRedisTemplate.getStringSerializer().serialize(key);
                byte[] value = connection.get(redisKey);
                return stringRedisTemplate.getStringSerializer().deserialize(value);
            }
        });
        return result;
    }

    @Override
    public <T> T getObject(String key, Class<T> clazz) {
        String value = get(key);
        if(StringUtils.isEmpty(value)){return null;};
        return JSONObject.parseObject(value,clazz);
    }
}
