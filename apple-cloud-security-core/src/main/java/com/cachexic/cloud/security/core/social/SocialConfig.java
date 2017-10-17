package com.cachexic.cloud.security.core.social;


import com.cachexic.cloud.security.core.config.properties.SecurityProperties;
import com.cachexic.cloud.security.core.social.support.AppleSpringSocialConfigurer;
import com.cachexic.cloud.security.core.social.support.SocialAuthenticationFilterPostProcessor;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @author tangmin
 * @Description: 激活Social，配置JdbcUsersConnectionRepository 社交登录配置主类
 * @date 2017-10-03 21:54:32
 */
@Configuration
@EnableSocial
@Order(10)
public class SocialConfig extends SocialConfigurerAdapter {

  @Autowired
  private DataSource dataSource;

  @Autowired
  private SecurityProperties securityProperties;

  @Autowired(required = false)
  private ConnectionSignUp connectionSignUp;

  @Autowired(required = false)
  private SocialAuthenticationFilterPostProcessor socialAuthenticationFilterPostProcessor;


  /**
   * 建表语句在JdbcUsersConnectionRepository源码对应的文件夹里 userId: 自己业务系统的userId providerId:

   create table sys_UserConnection (userId varchar(255) not null,
   providerId varchar(255) not null,
   providerUserId varchar(255),
   rank int not null,
   displayName varchar(255),
   profileUrl varchar(512),
   imageUrl varchar(512),
   accessToken varchar(512) not null,
   secret varchar(512),
   refreshToken varchar(512),
   expireTime bigint,
   primary key (userId, providerId, providerUserId));
   create unique index UserConnectionRank on sys_UserConnection(userId, providerId, rank);

   * 服务提供商Id，比如qq,weixin providerUserId：也就是对应的openId://用户的ID，与QQ号码一一对应。可通过调用https://graph.qq.com/oauth2.0/me?access_token=YOUR_ACCESS_TOKEN
   * 来获取。 primary key (userId, providerId, providerUserId)作为唯一主键。意思就是服务商与本身系统的user系统建立的对应关系
   *
   * rank 等级 displayName，profileUrl,imageUrl就是QQAdapter设置的值
   *
   * accessToken,refreshToken,expireTime，secret都是OAuth协议的字段
   */
  @Override
  public UsersConnectionRepository getUsersConnectionRepository(
      ConnectionFactoryLocator connectionFactoryLocator) {
    //connectionFactoryLocator 会根据条件去自动查找相应的connectionFactory。比如qq，weixin
    //第三个参数是对一些隐私信息加解密，这里暂时设置为不加密
    JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(
        dataSource, connectionFactoryLocator, Encryptors.noOpText());

    //可以配置表的前缀，但是不能修改表名
    repository.setTablePrefix("sys_");

    //如果有自定义注册
    if(connectionSignUp != null) {
      repository.setConnectionSignUp(connectionSignUp);
    }

    return repository;
  }

  /**
   * @Description: 社交登录配置类，供浏览器或app模块引入设计登录配置用。过滤器链
   * 注意：bean的名字
   */
  @Bean
  public SpringSocialConfigurer appleSocialSecurityConfig() {
    String filterProcessesUrl = securityProperties.getSocial().getFilterProcessesUrl();
    AppleSpringSocialConfigurer configurer = new AppleSpringSocialConfigurer(filterProcessesUrl);
    configurer.signupUrl(securityProperties.getBrowser().getSignUpUrl());
    configurer.setSocialAuthenticationFilterPostProcessor(socialAuthenticationFilterPostProcessor);
    return configurer;
  }


  /**
   * 用来处理注册流程的工具类
   * @param connectionFactoryLocator
   * @return
   */
  @Bean
  public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator) {
    return new ProviderSignInUtils(connectionFactoryLocator,
        getUsersConnectionRepository(connectionFactoryLocator)) {
    };
  }
}
