package com.cachexic.cloud.provider.system.service.impl;

import com.cachexic.cloud.common.base.service.impl.BaseServiceImpl;
import com.cachexic.cloud.feign.system.entity.User;
import com.cachexic.cloud.feign.system.entity.query.UserQuery;
import com.cachexic.cloud.provider.system.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户管理
 * @author tangmin
 * @date 2017-11-07 15:38:01
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, UserQuery> implements UserService{

}