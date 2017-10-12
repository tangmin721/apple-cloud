/**
 *
 */
package com.cachexic.cloud.security.app.server;

import java.util.HashMap;
import java.util.Map;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

/**
 * @author tangmin
 * @Description:
 * @date 2017-10-12 21:37:26
 */
public class TokenJwtEnhancer implements TokenEnhancer {

  /**
   * 自定义一些额外信息，增强
   * @param accessToken
   * @param authentication
   * @return
   */
  @Override
  public OAuth2AccessToken enhance(OAuth2AccessToken accessToken,
      OAuth2Authentication authentication) {
    Map<String, Object> info = new HashMap<>();
    info.put("company", "cachexic");
    info.put("server", "eshop");

    ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);

    return accessToken;
  }

}
