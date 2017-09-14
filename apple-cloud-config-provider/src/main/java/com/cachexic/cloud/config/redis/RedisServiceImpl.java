package com.cachexic.cloud.config.redis;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author tangmin
 * @Description: Redis常用工具类
 * @date 2017-05-05 09:48:31
 */
@Component
public class RedisServiceImpl implements RedisService{

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 取得缓存
     * @param key
     * @return
     */
    public String get(String key){
        String value = stringRedisTemplate.boundValueOps(key).get();
        if(StringUtils.isNotBlank(value)){
            return String.valueOf(value);
        }
        return null;
    }

    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key,value);
    }

    @Override
    public void set(String key, String value, long expireTime) {
        stringRedisTemplate.opsForValue().set(key,value);
        if(expireTime>0){
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
        }
    }

    /**
     * 递减操作
     * @param key
     * @param by
     * @return
     */
    public double decr(String key, double by){
        return redisTemplate.opsForValue().increment(key, -by);
    }
    public double decr(String key, long by){
        return redisTemplate.opsForValue().increment(key, -by);
    }
    public double decr(String key, int by){
        return redisTemplate.opsForValue().increment(key, -by);
    }

    /**
     * 递增操作
     * @param key
     * @param by
     * @return
     */
    public double incr(String key, double by){
        return redisTemplate.opsForValue().increment(key, by);
    }
    public double incr(String key, long by){
        return redisTemplate.opsForValue().increment(key, by);
    }
    public double incr(String key, int by){
        return redisTemplate.opsForValue().increment(key, by);
    }

    /**
     * 指定缓存的失效时间
     *
     * @author FangJun
     * @date 2016年8月14日
     * @param key 缓存KEY
     * @param expireTime 失效时间(秒)
     */
    public void expire(String key, long expireTime) {
        if(expireTime > 0){
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
        }
    }

    /**
     * 删除缓存<br>
     * 根据key精确匹配删除
     * @param key
     */
    public void del(String... key){
        if(key!=null && key.length > 0){
            if(key.length == 1){
                redisTemplate.delete(key[0]);
            }else{
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * set重命名
     * @param oldkey
     * @param newkey
     */
    public void srename(String oldkey, String newkey){
        redisTemplate.boundSetOps(oldkey).rename(newkey);
    }

    /**
     * 模糊查询keys
     * @param pattern
     * @return
     */
    public Set<String> keys(String pattern){
        return redisTemplate.keys(pattern);
    }

}
