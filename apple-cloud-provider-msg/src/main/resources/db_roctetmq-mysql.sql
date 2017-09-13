-- create database zipkin--
-- DROP DATABASE IF EXISTS zipkin;

CREATE DATABASE ds_rocketmq DEFAULT CHARACTER
SET utf8mb4 COLLATE utf8mb4_unicode_ci;
-- SET utf8 COLLATE utf8_general_ci;

USE ds_rocketmq;

DROP TABLE IF EXISTS `t_msg_persistent`;

CREATE TABLE `t_msg_persistent` (
  `id` bigint AUTO_INCREMENT,
  `consumer_queue` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT ''  COMMENT 'consumerQueue描述',
  `topic` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT ''  COMMENT 'topic',
  `tag` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT ''  COMMENT 'tag',
  `msg_id` char(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT ''  COMMENT '消息id，uuid',
  `mq_msg_id` char(32) COLLATE utf8mb4_unicode_ci DEFAULT ''  COMMENT 'rocketmq生成的id',
  `msg_class_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT ''  COMMENT 'msgBod的ClassName',
  `msg_body` text COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '消息体（JSON格式）',
  `msg_send_times` int  COMMENT '消息发送次数',
  `areadly_dead` enum('yes','no')  COMMENT '是否是死亡消息',
  `msg_status` enum('waiting_confirm','sending')  COMMENT '消息状态：待确认，发送中',
  `field_long1` bigint  COMMENT 'long类型备用字段1',
  `field_long2` bigint  COMMENT 'long类型备用字段2',
  `field_string1` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT ''  COMMENT 'string类型备用字段1',
  `field_string2` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT ''  COMMENT 'string类型备用字段2',
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