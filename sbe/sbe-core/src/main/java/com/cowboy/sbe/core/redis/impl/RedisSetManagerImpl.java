package com.cowboy.sbe.core.redis.impl;/**
 * Created by Administrator on 2017/11/7/0007.
 */

import com.alibaba.fastjson.JSONObject;
import com.cowboy.sbe.core.redis.RedisConstants;
import com.cowboy.sbe.core.redis.RedisSetManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-07 17:03
 **/
@Repository
public class RedisSetManagerImpl implements RedisSetManager {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public long add(String key, Object... value) {
        Assert.notNull(value, RedisConstants.KEY_NOT_NULLABLE);
        Assert.notNull(value, RedisConstants.ARRAY_NOT_NULL_ABLE);
        List<String> values = new ArrayList<String>();
        for(Object obj:value){
            if(obj instanceof  String){
                values.add((String) obj);
            }else if(obj != null){
                values.add(JSONObject.toJSONString(obj));
            }
        }
        if(values.size()>0){
            return stringRedisTemplate.opsForSet().add(key,values.toArray(new String[values.size()]));
        }
        return 0L;
    }
}
