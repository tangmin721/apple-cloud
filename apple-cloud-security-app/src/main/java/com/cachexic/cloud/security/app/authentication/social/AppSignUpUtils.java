package com.cachexic.cloud.security.app.authentication.social;

import com.cachexic.cloud.security.core.config.contants.SecurityConstants;
import com.cachexic.cloud.security.core.exceptions.SecurityBizException;
import com.cachexic.cloud.security.core.exceptions.SecurityBizExceptionEnum;
import com.cachexic.cloud.security.core.validate.exceptions.ValidateCodeException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

/**
 * @author tangmin
 * @Description: app环境下替换providerSignInUtils，避免由于没有session导致读不到社交用户信息的问题
 * @date 2017-10-17 10:09:26
 */
@Component
public class AppSignUpUtils {

  @Autowired
  private RedisTemplate<Object, Object> redisTemplate;

  @Autowired
  private UsersConnectionRepository usersConnectionRepository;

  @Autowired
  private ConnectionFactoryLocator connectionFactoryLocator;

  /**
   * 缓存社交网站用户信息到redis
   */
  public void saveConnectionData(WebRequest request, ConnectionData connectionData) {
    redisTemplate.opsForValue().set(getKey(request), connectionData, 10, TimeUnit.MINUTES);
  }

  /**
   * 将缓存的社交网站用户信息与系统注册用户信息绑定
   */
  public void doPostSignUp(WebRequest request, String userId) {
    String key = getKey(request);
    if (!redisTemplate.hasKey(key)) {
      throw new SecurityBizException(SecurityBizExceptionEnum.SOCIAL_CHACHE_INFO_NOT_FOUND);
    }
    ConnectionData connectionData = (ConnectionData) redisTemplate.opsForValue().get(key);
    Connection<?> connection = connectionFactoryLocator
        .getConnectionFactory(connectionData.getProviderId())
        .createConnection(connectionData);
    usersConnectionRepository.createConnectionRepository(userId).addConnection(connection);

    redisTemplate.delete(key);
  }

  /**
   * 获取redis key
   */
  private String getKey(WebRequest request) {
    /*String deviceId = request.getHeader("deviceId");
    if (StringUtils.isBlank(deviceId)) {
      throw new AppSecretException("设备id参数不能为空");
    }*/

    //    String deviceId = request.getHeader("deviceId");
    String deviceId = request.getParameter(SecurityConstants.DEFAULT_PARAMETER_NAME_MOBILE);
    if (StringUtils.isBlank(deviceId)) {
      throw new ValidateCodeException("手机号不能为空");
    }
    return "apple:security:social.connect." + deviceId;


  }

}
