package com.cachexic.cloud.security.core.authorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * @Description: 授权信息管理器,子项目只需要实现这个接口就可以做自己的授权
 * 用于收集系统中所有 AuthorizeConfigProvider 并加载其配置
 * @author tangmin
 * @date 2017-10-13 13:45:22
 */
public interface AuthorizeConfigManager {

  /**
   * 封装授权配置 也就是 .authorizeRequest() 返回的对象
   * @param config
   */
  void config(
      ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config);

}
