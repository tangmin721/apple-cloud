package com.cachexic.cloud.security.core.social.weixin.config;

import com.cachexic.cloud.security.core.config.properties.SecurityProperties;
import com.cachexic.cloud.security.core.config.properties.WeixinProperties;
import com.cachexic.cloud.security.core.social.view.AppleConnectView;
import com.cachexic.cloud.security.core.social.weixin.connect.WeixinConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.web.servlet.View;

/**
 * 微信登录配置
 *
 * @author zhailiang
 */
@Configuration
@ConditionalOnProperty(prefix = "apple.security.social.weixin", name = "app-id")
public class WeixinAutoConfiguration extends SocialAutoConfigurerAdapter {

  @Autowired
  private SecurityProperties securityProperties;

  @Override
  protected ConnectionFactory<?> createConnectionFactory() {
    WeixinProperties weixinConfig = securityProperties.getSocial().getWeixin();
    return new WeixinConnectionFactory(weixinConfig.getProviderId(), weixinConfig.getAppId(),
        weixinConfig.getAppSecret());
  }

  @Bean({"connect/weixinConnect", "connect/weixinConnected"})
  @ConditionalOnMissingBean(name = "weixinConnectedView")
  public View weixinConnectedView() {
    return new AppleConnectView();
  }

}
