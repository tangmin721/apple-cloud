package com.cachexic.cloud.config.redis;

import java.util.Set;

/**
 * @author tangmin
 * @version V1.0
 * @Title: RedisService.java
 * @Package com.gasq.cloud.common.provider.config.redis
 * @Description: Redis操作类，通过redisTemplate实现，使其拥有事务功能
 * @date 2017-05-05 11:07:15
 */
public interface RedisService {

    /**
     * 获取缓存<br>
     * 注：基本数据类型(Character除外)，请直接使用get(String key, Class<T> clazz)取值
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 将value对象写入缓存
     * @param key
     * @param value
     */
    void set(String key, String value);

    /**
     * 将value对象写入缓存
     * @param key
     * @param value
     * @param expireTime 失效时间(秒)
     */
    void set(String key, String value, long expireTime);

    /**
     * 递减操作
     * @param key
     * @param by
     * @return
     */
    double decr(String key, double by);

    /**
     * 递增操作
     * @param key
     * @param by
     * @return
     */
    double incr(String key, double by);

    /**
     * 递减操作
     * @param key
     * @param by
     * @return
     */
    double decr(String key, long by);

    /**
     * 递增操作
     * @param key
     * @param by
     * @return
     */
    double incr(String key, long by);

    /**
     * 递减操作
     * @param key
     * @param by
     * @return
     */
    double decr(String key, int by);

    /**
     * 递增操作
     * @param key
     * @param by
     * @return
     */
    double incr(String key, int by);

    /**
     * 删除缓存<br>
     * 根据key精确匹配删除
     * @param key
     */
    void del(String... key);

    /**
     * 指定缓存的失效时间
     * @author FangJun
     * @date 2016年8月14日
     * @param key 缓存KEY
     * @param expireTime 失效时间(秒)
     */
    void expire(String key, long expireTime);

    /**
     * set重命名
     * @param oldkey
     * @param newkey
     */
    void srename(String oldkey, String newkey);

    /**
     * 模糊查询keys
     * @param pattern
     * @return
     */
    Set<String> keys(String pattern);

}
