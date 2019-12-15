package com.scs.web.space.api.service.impl;

import com.scs.web.space.api.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName RedisServiceImpl
 * @Description TODO
 * @Author 田震
 * @Date 2019/12/6
 **/

@Component
public class RedisServiceImpl implements RedisService {

    @Resource

    private RedisTemplate redisTemplate;
    @Override
    public boolean set(final String key, Object value) {

        boolean result = false;

        try {

// 创建对简单值(Redis术语中的string类型)执行操作的对象

            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();

            operations.set(key, value);

            result = true;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return result;

    }

    @Override
    public boolean set(final String key, Object value, Long expireTime) {

        boolean result = false;

        try {

// 创建对简单值(Redis术语中的string类型)执行操作的对象

            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();

            operations.set(key, value);

            redisTemplate.expire(key, expireTime, TimeUnit.MINUTES);

            result = true;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return result;

    }
    @Override
    public boolean existsKey(final String key) {

        return redisTemplate.hasKey(key);

    }

    @Override
    public <T> T getValue(final String key, Class<T> type) {

        Object result = null;

        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();

        try {

            result = operations.get(key);

            if (result == null) {

                return null;

            }

// 将 Object 类型强转成 type 对应的类型

            return type.cast(result);

        } catch (Exception e) {

            return null;

        }

    }





    @Override
    public void removeKey(final String key) {

// 检查 key 是否存在

        if (existsKey(key)) {

            redisTemplate.delete(key);

        }

    }




    @Override
    public void remove(final String... keys) {

        for (String key : keys) {

            removeKey(key);

        }

    }




    @Override
    public void removePattern(final String pattern) {

// 获取所有匹配的键

        Set<Serializable> keys = redisTemplate.keys(pattern);

        if (keys != null && keys.size() > 0) {

            redisTemplate.delete(keys);

        }

    }
}