package com.cachexic.cloud.security.app.server;

import com.cachexic.cloud.security.core.config.properties.OAuth2ClientProperties;
import com.cachexic.cloud.security.core.config.properties.SecurityProperties;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * @Description: 认证服务器配置
 * http://localhost:8002/oauth/authorize?response_type=code&client_id=apple&redirect_uri=http://example.com&scope=all
 *
 * 继承adater实现自定义token
 * @author tangmin
 * @date 2017-10-10 22:41:14
 */
@Configuration
@EnableAuthorizationServer
public class AppleAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  private SecurityProperties securityProperties;

  @Autowired
  private TokenStore tokenStore;

  /**
   * required = false如果有的时候才生效
   */
  @Autowired(required = false)
  private JwtAccessTokenConverter jwtAccessTokenConverter;

  @Autowired(required = false)
  private TokenEnhancer jwtTokenEnhancer;

  /**
   * {@link TokenEndpoint}
   * 默认的取token入口点
   * @param endpoints
   * @throws Exception
   */
  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints
        //token存储介质
        .tokenStore(tokenStore)
        .authenticationManager(authenticationManager)
        .userDetailsService(userDetailsService);

    if (jwtAccessTokenConverter != null && jwtTokenEnhancer != null) {
      TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
      List<TokenEnhancer> enhancers = new ArrayList<>();
      //自包含增强
      enhancers.add(jwtTokenEnhancer);
      //密签
      enhancers.add(jwtAccessTokenConverter);
      enhancerChain.setTokenEnhancers(enhancers);

      endpoints
          .tokenEnhancer(enhancerChain)
          .accessTokenConverter(jwtAccessTokenConverter);
    }
  }

  /**
   * 跟客户端相关的配置：有哪些应用会访问我们的系统。
   * org.springframework.boot.autoconfigure.security.oauth2.authserver.OAuth2AuthorizationServerConfiguration.BaseClientDetailsConfiguration#oauth2ClientDetails()
   * @param clients
   * @throws Exception
   */
  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    InMemoryClientDetailsServiceBuilder builder = clients.inMemory();
    if(ArrayUtils.isNotEmpty(securityProperties.getOauth2().getClients())){
      for (OAuth2ClientProperties client : securityProperties.getOauth2().getClients()) {
        builder.withClient(client.getClientId())
            .secret(client.getClientSecret())
            .authorizedGrantTypes("refresh_token", "authorization_code", "password")
            //token有效期
            .accessTokenValiditySeconds(client.getAccessTokenValidateSeconds())
            //刷新token
            .refreshTokenValiditySeconds(2592000)
            .scopes("all");
      }
    }
    /*clients
        .inMemory()//把应用的clientId和clientSecret存放在内存里
        *//*.jdbc() //把应用的clientId和clientSecret存放在数据库里，如果需要对外公司提供，可以实现jdbc*//*
        .withClient("apple")
        .secret("appleSecret")
        .accessTokenValiditySeconds(7200) //token有效期
        //所能支持的授权模式（5种授权模式"authorization_code","password", "client_credentials", "implicit", "refresh_token"）https://tools.ietf.org/html/rfc6749#section-4.1
        .authorizedGrantTypes("refresh_token","password")
        .scopes("all","read","write")//请求令牌的时候，scope参数必须是你定义的这几种的一种，如果不传，则会返回所有的scopes
    ;*/
  }
}
