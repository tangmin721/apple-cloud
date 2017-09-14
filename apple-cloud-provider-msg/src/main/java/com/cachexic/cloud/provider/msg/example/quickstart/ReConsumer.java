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
package com.cachexic.cloud.provider.msg.example.quickstart;

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
 * @Description:
 * @date 2017-09-09 09:25:58
 */
public class ReConsumer {

    public static void main(String[] args) throws InterruptedException, MQClientException {


        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("order_group_1");
        consumer.setNamesrvAddr("apple01:9876");

        /**
         * 设置consumer第一次启动是从队列头部开始，还是尾部开始消费
         * 如果非第一次启动，那么按上次消费的位置继续消费
         */
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        //consumer.subscribe("orderTopic", "*");
        consumer.subscribe("orderTopic", "orderCreateTag");

        //默认是1条，设置push模式一次拉取多少条。
        consumer.setConsumeMessageBatchMaxSize(10);

        //设置监听器
        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {

                //批量拉取消息放到list
                //System.out.println("消息条数：" + msgs.size());
                //System.out.printf(Thread.currentThread().getName() + " Receive New Messages: " + msgs + "%n");

                MessageExt msg = msgs.get(0);
                try {

                    String topic = msg.getTopic();
                    String msgBody = new String(msg.getBody(), "utf-8");
                    String tags = msg.getTags();
                    System.out.println("收到消息：topic:" + topic + ",tags:" + tags + ",msg:" + msgBody);

                    //测试消息失败重试   注意msg里的reconsumeTimes=3表示重试次数
                    if ("订单[4]创建成功".equals(msgBody)) {
                        System.out.println("========消息失败开始========");
                        System.out.println(msg);
                        System.out.println("重试第【" + msg.getReconsumeTimes() + "】次！");
                        System.out.println("========消息失败结束========");
                        int i = 1 / 0;//模拟异常
                    }

                } catch (Exception e) {
                    e.printStackTrace();

                    //处理失败的消息业务逻辑
                    if (msg.getReconsumeTimes() > 2) {
                        //logger.error(.....)
                        //todo记录dao持久化到数据库
                        System.out.println("-->持久化到数据库，处理。");
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    }

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
