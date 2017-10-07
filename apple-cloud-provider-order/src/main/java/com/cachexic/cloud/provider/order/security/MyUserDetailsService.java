package com.cachexic.cloud.provider.order.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/**
 * @Description: UserDetailsService自定义实现.
 * @author tangmin
 * @date 2017-09-30 10:09:53
 */
@Component
public class MyUserDetailsService implements UserDetailsService,SocialUserDetailsService {

  private static final Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);

  /**
   * 给密码加密
   */
  @Autowired
  private PasswordEncoder passwordEncoder;

  /**
   * enabled: 用户已失效
   * accountNonExpired:用户帐号已过期
   * credentialsNonExpired:用户凭证已过期
   * accountNonLocked:用户帐号已被锁定
   */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.info("===>登录用户名:" + username);
    String encode = passwordEncoder.encode("123456");
    log.info("====>数据库密码是:" + encode);
    return new User(username, encode,
        true, true, true, true,
        AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
  }

  /**
   * 第三方登录，根据userId获取登入人信息
   * @param userId 把唯一用户名作为userid也是可以的
   * @return
   * @throws UsernameNotFoundException
   */
  @Override
  public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {

    //@todo 暂时用登录用户名作为userId，等有自己的用户表的时候，改为用户表的id
    log.info("===>登录用户名:" + userId);
    String encode = passwordEncoder.encode("123456");
    log.info("====>数据库密码是:" + encode);
    return new SocialUser(userId, encode,
        true, true, true, true,
        AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
  }
}
