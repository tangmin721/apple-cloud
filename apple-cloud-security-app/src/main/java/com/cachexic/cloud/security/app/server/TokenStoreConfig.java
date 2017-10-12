package com.cachexic.cloud.security.app.server;

import com.cachexic.cloud.security.core.config.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
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

  /**
   * 使用jwt时的配置，。如果没有配置apple.security.oauth2.tokenStore时。默认生效 matchIfMissing = true
   */
  @Configuration
  @ConditionalOnProperty(prefix = "apple.security.oauth2", name = "tokenStore", havingValue = "jwt", matchIfMissing = true)
  public static class JwtConfig {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * @return
     */
    @Bean
    public TokenStore jwtTokenStore() {
      return new JwtTokenStore(jwtAccessTokenConverter());
    }

    /**
     * @Description: 配置的密签
     * @author tangmin
     * @date 2017-10-12 21:46:40
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
      JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
      converter.setSigningKey(securityProperties.getOauth2().getJwtSigningKey());//配置秘钥
      return converter;
    }

    /**
     * 子模块可以自定义实现，去增强jwt自包含信息
     * @return
     */
    @Bean
    @ConditionalOnBean(TokenEnhancer.class)
    public TokenEnhancer jwtTokenEnhancer(){
      return new TokenJwtEnhancer();
    }

  }

}
