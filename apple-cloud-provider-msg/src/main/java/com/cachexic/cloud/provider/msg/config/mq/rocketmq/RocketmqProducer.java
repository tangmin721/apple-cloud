package com.cachexic.cloud.provider.msg.config.mq.rocketmq;

import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.feign.msg.entity.MsgPersistent;
import com.cachexic.cloud.feign.msg.exceptions.MsgBizException;
import com.cachexic.cloud.feign.msg.exceptions.MsgBizExceptionEnum;
import com.cachexic.cloud.provider.msg.config.mq.Producer;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tangmin
 * @Description: Rocketmq实现
 * @date 2017-09-13 22:23:20
 */
@Service("rocketmqProducer")
public class RocketmqProducer implements Producer {

    private static final Logger log = LoggerFactory.getLogger(RocketmqProducer.class);

    @Autowired
    private DefaultMQProducer producer;

    /**
     * 同步发送消息
     * @param msgPersistent
     * @return
     */
    @Override
    public String send(MsgPersistent msgPersistent) {
        String mqMsgId = "";
        try {
            Message msg = new Message(msgPersistent.getTopic() /* Topic */,
                msgPersistent.getTag()/* Tag */,
                (msgPersistent.getMsgBody()).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            SendResult sendResult = producer.send(msg);
            log.debug(JsonUtil.toJson(sendResult));
            if(sendResult.getSendStatus().equals(SendStatus.SEND_OK)){
                mqMsgId = sendResult.getMsgId();
            }else {
                throw new MsgBizException(MsgBizExceptionEnum.SEND_MESSAGE_RESULT_IS_NOTOK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new MsgBizException(MsgBizExceptionEnum.MQ_CLIENT_EXCEPTION);
        }
        return mqMsgId;
    }

}
