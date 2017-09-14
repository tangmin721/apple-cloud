/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cachexic.cloud.provider.msg.example.rocketmq;

import java.util.List;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * @author tangmin
 * @Description: 只需要把 groupId换成别的，就是另一个消费组
 * @date 2017-09-09 09:25:58
 */
public class ConsumerOtherGroup3 {

    public static void main(String[] args) throws InterruptedException, MQClientException {


        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("order_group_3");
        consumer.setNamesrvAddr("apple01:9876");

        /**
         * 设置consumer第一次启动是从队列头部开始，还是尾部开始消费
         * 如果非第一次启动，那么按上次消费的位置继续消费
         */
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        consumer.subscribe("orderTopic", "orderCreateTag");

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
    }
}
