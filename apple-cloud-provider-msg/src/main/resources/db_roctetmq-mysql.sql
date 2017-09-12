-- create database zipkin--
-- DROP DATABASE IF EXISTS zipkin;

CREATE DATABASE ds_rocketmq DEFAULT CHARACTER
SET utf8mb4 COLLATE utf8mb4_unicode_ci;
-- SET utf8 COLLATE utf8_general_ci;

USE ds_rocketmq;

DROP TABLE IF EXISTS `t_msg_persistent`;

CREATE TABLE `t_msg_persistent` (
  `id` bigint AUTO_INCREMENT,
  `topic` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT ''  COMMENT 'topic描述',
  `tags` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT ''  COMMENT 'tags描述',
  `msg_data_type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT ''  COMMENT 'msgDataType描述',
  `msg_body` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT ''  COMMENT 'msgBody描述',
  `msg_send_times` int  COMMENT 'msgSendTimes描述',
  `msg_status` enum('waiting_confirm','sending')  COMMENT 'msgStatus描述',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `create_user_name` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建人name',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `update_user_name` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新人name',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='持久化消息';