package com.cachexic.cloud.config.ehcache;

import com.cachexic.cloud.common.base.entity.PojoBaseEntity;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 缓存Service实现类（只是样例）
 *
 * @author Administrator
 */
@Service
public class EhCacheServiceImpl<T extends PojoBaseEntity> implements EhCacheService<T> {

  public static final String CACHE_NAME = "local";

  /**
   * 将商品信息保存到本地缓存中
   */
  @CachePut(value = CACHE_NAME, key = "t.getClass()+':'+#t.getId()")
  public T saveLocalCache(T t) {
    System.out.println("local cache:" + JsonUtil.toJson(t));
    return t;
  }

  /**
   * 从本地缓存中获取信息
   */
  @Cacheable(value = CACHE_NAME, key = "t.getClass()+':'+#id")
  public T getLocalCache(Long id) {
    System.out.println("local cache...");
    return null;
  }

  @CacheEvict(value = CACHE_NAME, key = "t.getClass()+':'+#t.getId()")
  public void removeLocalCache(Long id) {
  }

}
