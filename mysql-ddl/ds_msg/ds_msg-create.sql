-- DROP DATABASE IF EXISTS ds_msg;
CREATE DATABASE ds_msg DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
-- SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE ds_msg;
-- DROP TABLE IF EXISTS `t_msg_persistent`;

CREATE TABLE `t_msg_persistent` (
  `id` bigint AUTO_INCREMENT,
  `consumer_queue` varchar(255) NOT NULL DEFAULT '' COMMENT '消费对应的队列',
  `topic` varchar(255) NOT NULL DEFAULT '' COMMENT '消息topic',
  `tag` varchar(255) DEFAULT '' COMMENT 'rocketMq tag',
  `msg_id` varchar(255) NOT NULL DEFAULT '' COMMENT '消息Id',
  `mq_msg_id` varchar(255) DEFAULT '' COMMENT 'rocketmq的消息Id',
  `msg_class_name` varchar(255) DEFAULT '' COMMENT '消息的数据类型',
  `msg_body` text NOT NULL COMMENT '消息主体',
  `msg_send_times` int  COMMENT '消息发送次数',
  `areadly_dead` enum('yes','no')  COMMENT '是否是死亡消息',
  `msg_status` enum('waiting_confirm','sending')  COMMENT '消息状态',
  `field_long1` bigint  COMMENT 'Long备用字段1',
  `field_long2` bigint  COMMENT 'Long备用字段2',
  `field_string1` varchar(255) DEFAULT '' COMMENT 'String备用字段1',
  `field_string2` varchar(255) DEFAULT '' COMMENT 'String备用字段2',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '创建时间',
  `create_user_id` bigint COMMENT '创建人id',
  `create_user_name` varchar(32) DEFAULT '' COMMENT '创建人name',
  `update_time` datetime COMMENT '最后修改时间',
  `update_user_id` bigint COMMENT '修改人id',
  `update_user_name` varchar(32) DEFAULT '' COMMENT '修改人name',
  `status` enum ('invalid','normal','deleted','disabled','frozen') DEFAULT 'invalid' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci COMMENT='消息持久化';

ALTER TABLE `t_msg_persistent` ADD INDEX(`consumer_queue`) COMMENT 'for select by consumer_queue';
ALTER TABLE `t_msg_persistent` ADD INDEX(`topic`) COMMENT 'for select by topic';
ALTER TABLE `t_msg_persistent` ADD INDEX(`tag`) COMMENT 'for select by tag';
ALTER TABLE `t_msg_persistent` ADD INDEX(`msg_id`) COMMENT 'for select by msg_id';