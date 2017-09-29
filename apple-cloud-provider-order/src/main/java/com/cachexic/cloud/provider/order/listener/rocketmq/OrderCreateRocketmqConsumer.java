package com.cachexic.cloud.provider.order.listener.rocketmq;

import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.feign.msg.enums.RocketmqMsgQueueEnum;
import com.cachexic.cloud.feign.order.entity.query.OrderQuery;
import com.cachexic.cloud.provider.order.service.OrderService;
import java.util.List;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author tangmin
 * @Description: rocketmq监听消费队列
 * @date 2017-09-15 10:23:06
 */
//@Component
public class OrderCreateRocketmqConsumer {

  @Autowired
  private OrderService orderService;

  @Value("${rocketmq.namesrv}")
  private String namesrv;

  @Value("${rocketmq.consumer.group-id.order}")
  private String consumerGroup;

  private DefaultMQPushConsumer consumer;

  public void start() {
    System.out
        .println("start::::::::::" + JsonUtil.toJson(orderService.selectList(new OrderQuery())));
    consumer();
    //Runtime.getRuntime().addShutdownHook(shutdownThread);
  }

  public void stop() {
    System.out
        .println("stop::::::::::" + JsonUtil.toJson(orderService.selectList(new OrderQuery())));
    consumer.shutdown();
  }

  public void consumer() {
    try {
      consumer = new DefaultMQPushConsumer(consumerGroup);
      consumer.setNamesrvAddr(namesrv);

      /**
       * 设置consumer第一次启动是从队列头部开始，还是尾部开始消费
       * 如果非第一次启动，那么按上次消费的位置继续消费
       */
      consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
      consumer.subscribe(RocketmqMsgQueueEnum.testTopic.getTopic(),
          RocketmqMsgQueueEnum.testTopic.getTag());
      //默认是1条，设置push模式一次拉取多少条。
      consumer.setConsumeMessageBatchMaxSize(10);

      //设置监听器
      consumer.registerMessageListener(new MessageListenerConcurrently() {

        @Override
        public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
            ConsumeConcurrentlyContext context) {
          MessageExt msg = msgs.get(0);
          try {

            String topic = msg.getTopic();
            String msgBody = new String(msg.getBody(), "utf-8");
            String tags = msg.getTags();
            System.out.println("收到消息：topic:" + topic + ",tags:" + tags + ",msg:" + msgBody);

            System.out.println("==========>consumer:" + JsonUtil
                .toJson(orderService.selectList(new OrderQuery())));

          } catch (Exception e) {
            e.printStackTrace();
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
          }
          //返回消费状态
          //CONSUME_SUCCESS 消费成功
          //RECONSUME_LATER 消费失败，需要稍后重新消费
          return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
      });
      consumer.start();
      System.out.printf("Consumer Started.%n");
    } catch (MQClientException e) {
      e.printStackTrace();
    }
  }

}
