package com.cachexic.cloud.security.browser;

import com.cachexic.cloud.security.core.properties.SecurityConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author tangmin
 * @Description: PC浏览器的项目
 * @date 2017-09-28 14:56:02
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger log = LoggerFactory.getLogger(BrowserSecurityConfig.class);

    /**
     * 配置密码加密规则.也可以自己实现这个接口,用自己的加密规则
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 重载默认的HttpSecurity
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("====>>override WebSecurityConfigurerAdapter...");
        //http.httpBasic()// 弹框默认的方式登录
        http.formLogin()  //表单登录
//            .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL) //当请求需要身份认证时，默认跳转的url
//            .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM) //默认的用户名密码登录请求处理url
            .and()

            .authorizeRequests() //对请求做授权
            .antMatchers(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL).permitAll() //排除登录页的身份验证
            .anyRequest()  //对所有请求
            .authenticated() //都是要身份认证

            .and()
            .csrf().disable() //暂时禁用掉跨站伪造防护
            ;
    }
}
