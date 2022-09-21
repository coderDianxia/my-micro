package com.coderdianxia.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: RedisUtil
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/9/21 11:51
 */
@Component
public class RedisUtil {

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 缓存对象
     * @param key
     * @param value
     */
    public void setObject(Object key,Object value){
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     *
     * @param key
     * @param value
     * @param timeout 时间
     * @param timeUnit 时间单位
     */
    public void setObjectExpire(Object key, Object value, long timeout, TimeUnit timeUnit){
        redisTemplate.opsForValue().set(key,value,timeout,timeUnit);
    }

    /**
     * key自增1
     * @param key
     * @return 自增后的值
     */
    public Long increment(Object key){
        return redisTemplate.opsForValue().increment(key);
    }

    /**
     * key自增delta
     * @param key
     * @param delta 步长
     * @return
     */
    public Long incrBy(Object key,long delta){
        return redisTemplate.opsForValue().increment(key,delta);
    }

    /**
     * 添加hash集合
     * @param key
     * @param map
     */
    public void setMap(Object key, Map map){
        redisTemplate.opsForHash().putAll(key,map);
    }

    /**
     * 修改或添加map集合数据
     * @param key Redis键
     * @param hKey  hash键
     * @param value 值
     */
    public void updateMap(Object key, Object hKey,Object value){
        redisTemplate.opsForHash().put(key,hKey,value);
    }

    /**
     * 获取map集合中key的value
     * @param key redis键
     * @param hKey hash键
     */
    public Object getMapValue(Object key, Object hKey){
        return redisTemplate.opsForHash().get(key, hKey);
    }

    /**
     * hash是否存在hKey
     * @param key
     * @param hKey
     * @return
     */
    public Boolean existHashKey(Object key, Object hKey){
        return redisTemplate.opsForHash().hasKey(key, hKey);
    }

    /**
     * 设置过期时间
     * @param key redis键
     * @param timeout 秒
     * @return
     */
    public Boolean expireSecond(Object key, long timeout){
        return redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 添加list
     * @param key
     * @param list
     * @return
     */
    public <T> Long setList(Object key, List<T> list){
        Long aLong = redisTemplate.opsForList().leftPushAll(key, list);
        return aLong == null ?0:aLong;
    }

    /**
     * 获取list
     * @param key
     * @param <T>
     * @return
     */
    public <T> List getList(Object key){
        return redisTemplate.opsForList().range(key, 0, -1);
    }

}
