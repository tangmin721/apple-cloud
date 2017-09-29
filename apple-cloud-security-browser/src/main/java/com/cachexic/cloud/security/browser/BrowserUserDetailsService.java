package com.cachexic.cloud.security.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author tangmin
 */
@Component
public class BrowserUserDetailsService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(BrowserUserDetailsService.class);

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
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
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
}
