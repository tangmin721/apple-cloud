package com.cachexic.cloud.provider.system.dao;

import com.cachexic.cloud.common.base.dao.BaseDao;
import com.cachexic.cloud.config.mybatis.annotation.MybatisDao;
import com.cachexic.cloud.feign.system.entity.User;
import com.cachexic.cloud.feign.system.entity.query.UserQuery;

/**
 * @Description: 用户管理
 * @author tangmin
 * @date 2017-11-07 15:38:01
 */
@MybatisDao
public interface UserDao extends BaseDao<User, UserQuery>{

}
