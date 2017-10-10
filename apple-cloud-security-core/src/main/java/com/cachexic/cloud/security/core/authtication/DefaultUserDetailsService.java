/**
 *
 */
package com.cachexic.cloud.security.core.authtication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author tangmin
 * @Description: 默认的 UserDetailsService 实现 不做任何处理，只在控制台打印一句日志，然后抛出异常，提醒业务系统自己配置 UserDetailsService。
 * @date 2017-10-10 22:16:35
 */
public class DefaultUserDetailsService implements UserDetailsService {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    logger.warn("请配置 UserDetailsService 接口的实现.");
    throw new UsernameNotFoundException(username);
  }

}
