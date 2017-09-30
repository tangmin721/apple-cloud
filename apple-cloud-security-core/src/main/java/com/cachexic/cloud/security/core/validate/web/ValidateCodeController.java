package com.cachexic.cloud.security.core.validate.web;

import com.cachexic.cloud.security.core.validate.code.ValidateCodeGenerator;
import com.cachexic.cloud.security.core.validate.code.entity.ImageCode;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author tangmin
 * @Description: 校验码controller
 * @date 2017-09-29 13:29:52
 */
@RestController
public class ValidateCodeController {

  public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";

  @Autowired
  private ValidateCodeGenerator defaultImageCodeGenerator;

  private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

  @GetMapping("/code/image")
  public void codeImage(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    //1.创建图片验证码对象
    ImageCode imageCode = defaultImageCodeGenerator.generate(new ServletWebRequest(request));
    //2.向session中存放图片验证码对象,指定key
    sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, imageCode);
    //3.把图片写到响应中
    ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
  }


}
