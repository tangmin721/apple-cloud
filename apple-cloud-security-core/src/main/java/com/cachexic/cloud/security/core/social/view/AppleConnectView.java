/**
 *
 */
package com.cachexic.cloud.security.core.social.view;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.AbstractView;

/**
 * @author tangmin
 * @Description: 绑定结果视图
 * @date 2017-10-15 17:22:02
 */
public class AppleConnectView extends AbstractView {

  @Override
  protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    response.setContentType("text/html;charset=UTF-8");
    if (model.get("connection") == null) {
      response.getWriter().write("<h3>解绑成功</h3>");
    } else {
      response.getWriter().write("<h3>绑定成功</h3>");
    }

  }

}
