package com.cachexic.cloud.provider.msg.service.impl;

import com.cachexic.cloud.common.base.service.impl.BaseServiceImpl;
import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import com.cachexic.cloud.feign.msg.entity.query.MsgPersistentQuery;
import com.cachexic.cloud.provider.msg.service.MsgPersistentService;
import org.springframework.stereotype.Service;

/**
 * 持久化消息管理
 *
 * @author tangmin
 * @date 2017-09-12 19:01:50
 */
@Service
public class MsgPersistentServiceImpl extends
    BaseServiceImpl<MsgPersistent, MsgPersistentQuery> implements MsgPersistentService {

}