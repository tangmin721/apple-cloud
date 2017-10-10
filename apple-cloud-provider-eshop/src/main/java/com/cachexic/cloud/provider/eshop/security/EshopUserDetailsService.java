package com.cachexic.cloud.provider.eshop.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
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
public class EshopUserDetailsService implements UserDetailsService,SocialUserDetailsService {

  private static final Logger log = LoggerFactory.getLogger(EshopUserDetailsService.class);

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
//		log.info("表单登录用户名:" + username);
//		Admin admin = adminRepository.findByUsername(username);
//		admin.getUrls();
//		return admin;
    return buildUser(username);
  }

  @Override
  public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
    log.info("设计登录用户Id:" + userId);
    return buildUser(userId);
  }

  private SocialUserDetails buildUser(String userId) {
    // 根据用户名查找用户信息
    //根据查找到的用户信息判断用户是否被冻结
    String password = passwordEncoder.encode("123456");
    log.info("数据库密码是:"+password);

    return new SocialUser(userId, password,
        true, true, true, true,
        AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_USER"));
  }
}
