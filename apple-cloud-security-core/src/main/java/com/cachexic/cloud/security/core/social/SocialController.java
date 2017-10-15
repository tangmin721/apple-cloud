/**
 * 
 */
package com.cachexic.cloud.security.core.social;

import com.cachexic.cloud.security.core.social.support.SocialUserInfo;
import org.springframework.social.connect.Connection;

/**
 * @Description: 
 * @author tangmin
 * @date 2017-10-15 17:52:36
 */
public abstract class SocialController {

	/**
	 * 根据Connection信息构建SocialUserInfo
	 * @param connection
	 * @return
	 */
	protected SocialUserInfo buildSocialUserInfo(Connection<?> connection) {
		SocialUserInfo userInfo = new SocialUserInfo();
		userInfo.setProviderId(connection.getKey().getProviderId());
		userInfo.setProviderUserId(connection.getKey().getProviderUserId());
		userInfo.setNickname(connection.getDisplayName());
		userInfo.setHeadimg(connection.getImageUrl());
		return userInfo;
	}
	
}
