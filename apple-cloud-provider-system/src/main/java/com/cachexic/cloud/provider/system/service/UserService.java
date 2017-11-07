package com.cachexic.cloud.provider.system.service;

import com.cachexic.cloud.common.base.service.BaseService;
import com.cachexic.cloud.feign.system.entity.User;
import com.cachexic.cloud.feign.system.entity.query.UserQuery;

/**
 * @Description: 用户管理
 * @author tangmin
 * @date 2017-11-07 15:38:01
 */
public interface UserService extends BaseService<User, UserQuery>{

}
