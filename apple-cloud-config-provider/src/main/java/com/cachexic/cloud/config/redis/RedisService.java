package com.cachexic.cloud.config.redis;

import java.util.Set;

/**
 * @author tangmin
 * @Description: Redis操作类，通过redisTemplate实现，使其拥有事务功能
 * @date 2017-05-05 11:07:15
 */
public interface RedisService {

  /**
   * 获取缓存<br>
   * 注：基本数据类型(Character除外)，请直接使用get(String key, Class<T> clazz)取值
   */
  String get(String key);

  /**
   * 将value对象写入缓存
   */
  void set(String key, String value);

  /**
   * 将value对象写入缓存
   *
   * @param expireTime 失效时间(秒)
   */
  void set(String key, String value, long expireTime);

  /**
   * 递减操作
   */
  double decr(String key, double by);

  /**
   * 递增操作
   */
  double incr(String key, double by);

  /**
   * 递减操作
   */
  double decr(String key, long by);

  /**
   * 递增操作
   */
  double incr(String key, long by);

  /**
   * 递减操作
   */
  double decr(String key, int by);

  /**
   * 递增操作
   */
  double incr(String key, int by);

  /**
   * 删除缓存<br>
   * 根据key精确匹配删除
   */
  void del(String... key);

  /**
   * 指定缓存的失效时间
   *
   * @param key 缓存KEY
   * @param expireTime 失效时间(秒)
   * @author FangJun
   * @date 2016年8月14日
   */
  void expire(String key, long expireTime);

  /**
   * set重命名
   */
  void srename(String oldkey, String newkey);

  /**
   * 模糊查询keys
   */
  Set<String> keys(String pattern);

}
