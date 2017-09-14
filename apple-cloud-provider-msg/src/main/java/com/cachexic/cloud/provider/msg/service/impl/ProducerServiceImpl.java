package com.cachexic.cloud.provider.msg.service.impl;

import com.cachexic.cloud.common.enums.YesOrNoEnum;
import com.cachexic.cloud.common.exceptions.BizPreconditions;
import com.cachexic.cloud.common.utils.id.UUIDUtil;
import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import com.cachexic.cloud.feign.msg.enums.MsgStatusEnum;
import com.cachexic.cloud.provider.msg.config.mq.Producer;
import com.cachexic.cloud.provider.msg.service.MsgPersistentService;
import com.cachexic.cloud.provider.msg.service.ProducerService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author tangmin
 * @Description: 消息生产者对外提供的服务
 * @date 2017-09-13 17:55:52
 */
@Service("producerService")
public class ProducerServiceImpl implements ProducerService {

    private static final Logger log = LoggerFactory.getLogger(ProducerServiceImpl.class);

    @Autowired
    @Qualifier("kafkaProducer")
    private Producer producer;

    @Autowired
    private MsgPersistentService msgPersistentService;

    @Override
    public void saveMsgWaitingConfirm(MsgPersistent msgPersistent) {
        BizPreconditions.checkArgument(msgPersistent!=null,"保存消息为空");
        BizPreconditions.checkArgument(StringUtils.isNotBlank(msgPersistent.getTopic()),"消息topic不能为空");
        BizPreconditions.checkArgument(StringUtils.isNotBlank(msgPersistent.getTag()),"消息tags不能为空");
        BizPreconditions.checkArgument(StringUtils.isNotBlank(msgPersistent.getTag()),"消息tags不能为空");

        msgPersistent.setMsgId(UUIDUtil.get32UUID());
        msgPersistent.setMsgStatus(MsgStatusEnum.waiting_confirm);
        msgPersistent.setAreadlyDead(YesOrNoEnum.no);
        msgPersistent.setMsgSendTimes(0);

        msgPersistentService.insert(msgPersistent);
    }

    @Override
    public void confirmAndSendMsg(String msgId) {

    }

    @Override
    public void saveAndSendMsg(MsgPersistent msgPersistent) {

    }

    @Override
    public void directSendMsg(MsgPersistent msgPersistent){
        producer.send(msgPersistent);
    }

    @Override
    public void reSendMsg(MsgPersistent msgPersistent) {

    }

    @Override
    public void reSendMsgByMsgId(String msgId) {

    }

    @Override
    public void setMsgToDead(String msgId) {

    }

    @Override
    public MsgPersistent getMsgByMsgId(String msgId) {
        return null;
    }

    @Override
    public void deleteMsgByMsgId(String msgId) {

    }

    @Override
    public void reSendAllDeadMsgByTopic() {

    }

}
