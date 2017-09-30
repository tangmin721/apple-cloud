package com.cachexic.cloud.security.core.validate.web;

import com.cachexic.cloud.security.core.validate.code.ValidateCodeProcessor;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author tangmin
 * @Description: 校验码controller
 * @date 2017-09-29 13:29:52
 */
@RestController
public class ValidateCodeController {

  @Autowired
  private Map<String,ValidateCodeProcessor> validateCodeProcessors;

  /**
   * 图片验证码
   * @param request
   * @param response
   * @throws IOException
   */
  @GetMapping("/code/{type}")
  public void createCode(@PathVariable String type, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    validateCodeProcessors.get(type+ValidateCodeProcessor.class.getSimpleName()).create(new ServletWebRequest(request,response));
  }

}
