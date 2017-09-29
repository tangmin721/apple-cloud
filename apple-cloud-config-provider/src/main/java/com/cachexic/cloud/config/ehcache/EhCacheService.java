package com.cachexic.cloud.config.ehcache;

/**
 * @author tangmin
 */
public interface EhCacheService<T> {

  /**
   * 将对象信息保存到本地缓存中
   */
  T saveLocalCache(T object);

  /**
   * 从本地缓存中获取信息
   */
  T getLocalCache(Long id);

  /**
   * 删除缓存
   */
  void removeLocalCache(Long id);

}
