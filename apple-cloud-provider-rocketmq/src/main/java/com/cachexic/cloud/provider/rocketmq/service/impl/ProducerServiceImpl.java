package com.cachexic.cloud.provider.rocketmq.service.impl;

import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import com.cachexic.cloud.feign.msg.exceptions.MsgBizException;
import com.cachexic.cloud.feign.msg.exceptions.MsgBizExceptionEnum;
import com.cachexic.cloud.provider.rocketmq.service.ProducerService;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * Created by tangm on 2017/9/9.
 */
@Service("producerService")
public class ProducerServiceImpl implements ProducerService {

    private static final Logger log = LoggerFactory.getLogger(ProducerServiceImpl.class);

    @Autowired
    private DefaultMQProducer producer;


    @Override
    public void directSendMsg(MsgPersistent msgPersistent) {
        try {
//            producer.setProducerGroup(msgPersistent.getGroup());
//            producer.start();

            Message msg = new Message(msgPersistent.getTopic() /* Topic */,
                    msgPersistent.getTags()/* Tag */,
                    (msgPersistent.getMsgBody()).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );

            SendResult sendResult = producer.send(msg);
            log.debug(JsonUtil.toJson(sendResult));
        } catch (MQClientException | InterruptedException | RemotingException | MQBrokerException | UnsupportedEncodingException e) {
            log.warn("====> MQClientException:", e);
            throw new MsgBizException(MsgBizExceptionEnum.MQ_CLIENT_EXCEPTION);
        }
    }
}
