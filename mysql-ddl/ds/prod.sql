ALTER TABLE `t_electronic_release_order` ADD is_owner enum('yes','no');

ALTER TABLE `t_resident` ADD (certificate_type enum('certificateOfOfficers','idCard','passport','others') DEFAULT 'idCard',nation_id varchar(20),city_id varchar(20),province_id varchar(20));

CREATE TABLE `t_nations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

ALTER TABLE `t_order_decoration`
ADD COLUMN `appointment_handle_time`  datetime NULL DEFAULT NULL COMMENT '预约办理时间' AFTER `application_time`;

ALTER TABLE `t_order_decoration`
MODIFY COLUMN `appointment_handle_time`  varchar(30) NULL DEFAULT NULL COMMENT '预约办理时间' AFTER `application_time`;

ALTER TABLE `t_goods_sku` ADD available_inventory int(11) DEFAULT '0';

ALTER TABLE `t_resident` ADD smart_password varchar(10) AFTER `smart_resident_id`;

--ALTER TABLE `t_house` drop column smart_password;

ALTER TABLE `t_farm_trust`
ADD COLUMN `house_id`  char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '房屋主键' AFTER `resident_id`;

ALTER TABLE `t_farm_lease`
ADD COLUMN `current`  enum('no','yes') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT 'yes' COMMENT '是否是当前租赁地块的租户' AFTER `lease_remark`;

ALTER TABLE `t_farm_trust`
ADD COLUMN `current`  enum('no','yes') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT 'yes' COMMENT '是否是当前租户所绑定的套餐' AFTER `remark`;

ALTER TABLE `t_charge_order`
ADD COLUMN `source`  varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '后台缴费的标记' AFTER `remark`;
-- ----------------------------
-- Records of t_nations
-- ----------------------------
INSERT INTO `t_nations` VALUES ('1', '汉族');
INSERT INTO `t_nations` VALUES ('2', '蒙古族');
INSERT INTO `t_nations` VALUES ('3', '回族');
INSERT INTO `t_nations` VALUES ('4', '藏族');
INSERT INTO `t_nations` VALUES ('5', '维吾尔族');
INSERT INTO `t_nations` VALUES ('6', '苗族');
INSERT INTO `t_nations` VALUES ('7', '彝族');
INSERT INTO `t_nations` VALUES ('8', '壮族');
INSERT INTO `t_nations` VALUES ('9', '布依族');
INSERT INTO `t_nations` VALUES ('10', '朝鲜族');
INSERT INTO `t_nations` VALUES ('11', '满族');
INSERT INTO `t_nations` VALUES ('12', '侗族');
INSERT INTO `t_nations` VALUES ('13', '瑶族');
INSERT INTO `t_nations` VALUES ('14', '白族');
INSERT INTO `t_nations` VALUES ('15', '土家族');
INSERT INTO `t_nations` VALUES ('16', '哈尼族');
INSERT INTO `t_nations` VALUES ('17', '哈萨克族');
INSERT INTO `t_nations` VALUES ('18', '傣族');
INSERT INTO `t_nations` VALUES ('19', '黎族');
INSERT INTO `t_nations` VALUES ('20', '傈僳族');
INSERT INTO `t_nations` VALUES ('21', '佤族');
INSERT INTO `t_nations` VALUES ('22', '畲族');
INSERT INTO `t_nations` VALUES ('23', '高山族');
INSERT INTO `t_nations` VALUES ('24', '拉祜族');
INSERT INTO `t_nations` VALUES ('25', '水族');
INSERT INTO `t_nations` VALUES ('26', '东乡族');
INSERT INTO `t_nations` VALUES ('27', '纳西族');
INSERT INTO `t_nations` VALUES ('28', '景颇族');
INSERT INTO `t_nations` VALUES ('29', '柯尔克孜族');
INSERT INTO `t_nations` VALUES ('30', '土族');
INSERT INTO `t_nations` VALUES ('31', '达斡尔族');
INSERT INTO `t_nations` VALUES ('32', '仫佬族');
INSERT INTO `t_nations` VALUES ('33', '羌族');
INSERT INTO `t_nations` VALUES ('34', ' 布朗族');
INSERT INTO `t_nations` VALUES ('35', ' 撒拉族');
INSERT INTO `t_nations` VALUES ('36', ' 毛难族');
INSERT INTO `t_nations` VALUES ('37', ' 仡佬族');
INSERT INTO `t_nations` VALUES ('38', ' 锡伯族');
INSERT INTO `t_nations` VALUES ('39', ' 阿昌族');
INSERT INTO `t_nations` VALUES ('40', ' 普米族');
INSERT INTO `t_nations` VALUES ('41', ' 塔吉克族');
INSERT INTO `t_nations` VALUES ('42', ' 怒族');
INSERT INTO `t_nations` VALUES ('43', ' 乌孜别克族');
INSERT INTO `t_nations` VALUES ('44', ' 俄罗斯族');
INSERT INTO `t_nations` VALUES ('45', ' 鄂温克族');
INSERT INTO `t_nations` VALUES ('46', ' 崩龙族');
INSERT INTO `t_nations` VALUES ('47', ' 保安族');
INSERT INTO `t_nations` VALUES ('48', ' 裕固族');
INSERT INTO `t_nations` VALUES ('49', ' 京族');
INSERT INTO `t_nations` VALUES ('50', ' 塔塔尔族');
INSERT INTO `t_nations` VALUES ('51', ' 独龙族');
INSERT INTO `t_nations` VALUES ('52', ' 鄂伦春族');
INSERT INTO `t_nations` VALUES ('53', ' 赫哲族');
INSERT INTO `t_nations` VALUES ('54', ' 门巴族');
INSERT INTO `t_nations` VALUES ('55', ' 珞巴族');
INSERT INTO `t_nations` VALUES ('56', ' 基诺族');
INSERT INTO `t_nations` VALUES ('57', ' 其他');




ALTER TABLE t_order_flow ADD INDEX (order_id);
ALTER TABLE t_order_flow ADD INDEX (operator_id);