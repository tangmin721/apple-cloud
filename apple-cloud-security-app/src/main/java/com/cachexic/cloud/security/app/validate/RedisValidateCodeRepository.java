package com.cachexic.cloud.security.app.validate;


import com.cachexic.cloud.security.core.config.contants.SecurityConstants;
import com.cachexic.cloud.security.core.config.enums.ValidateCodeType;
import com.cachexic.cloud.security.core.validate.code.ValidateCodeRepository;
import com.cachexic.cloud.security.core.validate.code.entity.ValidateCode;
import com.cachexic.cloud.security.core.validate.exceptions.ValidateCodeException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author tangmin
 * @Description: 基于redis的验证码存取器，避免由于没有session导致无法存取验证码的问题
 * @date 2017-10-11 18:45:54
 */
@Component
public class RedisValidateCodeRepository implements ValidateCodeRepository {

  private static final Logger log = LoggerFactory.getLogger(RedisValidateCodeRepository.class);

  @Autowired
  private RedisTemplate<Object, Object> redisTemplate;

  @Override
  public void save(ServletWebRequest request, ValidateCode code, ValidateCodeType type) {
    redisTemplate.opsForValue().set(buildKey(request, type), code, 30, TimeUnit.MINUTES);
  }

  @Override
  public ValidateCode get(ServletWebRequest request, ValidateCodeType type) {
    Object value = redisTemplate.opsForValue().get(buildKey(request, type));
    if (value == null) {
      return null;
    }
    return (ValidateCode) value;
  }

  @Override
  public void remove(ServletWebRequest request, ValidateCodeType type) {
    redisTemplate.delete(buildKey(request, type));
  }

  /**
   * @param request
   * @param type
   * @return
   */
  private String buildKey(ServletWebRequest request, ValidateCodeType type) {
    /*//用requestParam还是requestBody传参数,由前后端协商
    try {
      String requestBody = IOUtils.toString(request.getRequest().getInputStream(), "UTF-8");
      log.debug("request body:{}",requestBody);
    } catch (IOException e) {
      e.printStackTrace();
    }*/
//    String deviceId = request.getHeader("deviceId");
    String deviceId = request.getParameter(SecurityConstants.DEFAULT_PARAMETER_NAME_MOBILE);
    if (StringUtils.isBlank(deviceId)) {
      throw new ValidateCodeException("手机号不能为空");
    }
    return "code:" + type.toString().toLowerCase() + ":" + deviceId;
  }

}
