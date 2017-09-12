package com.cachexic.cloud.provider.rocketmq.dao;

import com.cachexic.cloud.common.base.dao.BaseDao;
import com.cachexic.cloud.config.mybatis.annotation.MybatisDao;
import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import com.cachexic.cloud.feign.msg.entity.query.MsgPersistentQuery;

/**
 * 持久化消息管理
 * @author tangmin
 * @date 2017-09-12 19:01:50
 */
@MybatisDao
public interface MsgPersistentDao extends BaseDao<MsgPersistent, MsgPersistentQuery>{

}
