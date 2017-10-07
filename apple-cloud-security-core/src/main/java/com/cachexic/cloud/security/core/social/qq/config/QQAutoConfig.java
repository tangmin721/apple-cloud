package com.cachexic.cloud.security.core.social.qq.config;

import com.cachexic.cloud.security.core.config.properties.QQProperties;
import com.cachexic.cloud.security.core.config.properties.SecurityProperties;
import com.cachexic.cloud.security.core.social.qq.connect.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/**
 * @author tangmin
 * @Description: 注入自定义的配置,只有在配置了apple.security.social.qq.app-id时，才生效
 * @date 2017-10-03 22:47:07
 */
@Configuration
@ConditionalOnProperty(prefix = "apple.security.social.qq", name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

  @Autowired
  private SecurityProperties securityProperties;

  @Override
  protected ConnectionFactory<?> createConnectionFactory() {
    QQProperties qqConfig = securityProperties.getSocial().getQq();
    return new QQConnectionFactory(qqConfig.getProviderId(), qqConfig.getAppId(),
        qqConfig.getAppSecret());
  }
}
