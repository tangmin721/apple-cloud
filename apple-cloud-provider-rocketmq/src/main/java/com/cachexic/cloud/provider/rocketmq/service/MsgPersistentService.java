package com.cachexic.cloud.provider.rocketmq.service;

import com.cachexic.cloud.common.base.service.BaseService;
import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import com.cachexic.cloud.feign.msg.entity.query.MsgPersistentQuery;

/**
 * 持久化消息管理
 * @author tangmin
 * @date 2017-09-12 19:01:50
 */
public interface MsgPersistentService extends BaseService<MsgPersistent, MsgPersistentQuery>{

}
