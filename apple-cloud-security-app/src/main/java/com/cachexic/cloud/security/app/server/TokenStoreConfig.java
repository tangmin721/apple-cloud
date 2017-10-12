package com.cachexic.cloud.security.app.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @Description: 配置token存储介质
 * @author tangmin
 * @date 2017-10-12 21:24:41
 */
@Configuration
public class TokenStoreConfig {

  /**
   * 使用redis存储token的配置，只有在apple.security.oauth2.tokenStore配置为redis时生效
   */
  @Configuration
  @ConditionalOnProperty(prefix = "apple.security.oauth2", name = "tokenStore", havingValue = "redis")
  public static class RedisConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    /**
     * @return
     */
    @Bean
    public TokenStore redisTokenStore() {
      return new RedisTokenStore(redisConnectionFactory);
    }

  }


}
