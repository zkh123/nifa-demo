/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : db_mybatis

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-11-30 16:42:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `supplier_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '供应商id',
  `supplier_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '供应商名称',
  `paymentType_key` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '付费类型',
  `company_addr` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '公司地址',
  `contact_person` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '联系人',
  `contact_number` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '手机号',
  `contact_email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '联系邮箱',
  `contract_startTime` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '合同开始时间',
  `contract_endTime` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '合同结束时间',
  `contract_code` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '合同编号',
  `status` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'ENABLE' COMMENT '供应商状态',
  `operator` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '操作人',
  `inserttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isactive` tinyint(1) NOT NULL DEFAULT '1' COMMENT '逻辑删除',
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='供应商表 /*# Owner: huanglijun ;Manager: cuican #*/';

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('SUa89a3f2587ab438e93b103d7f4ce9982', '拍你', 'PREPAID_PaymentType', '上海市浦东新区', '黄大', '15723463052', '849302931@qq.com', '2019-11-05', '2019-11-29', '2222222222222222222222', 'ENABLE', 'test', '2019-11-15 10:58:43', '2019-11-30 16:41:59', '1');
INSERT INTO `supplier` VALUES ('SUceffc22f2fd840bdb2ccbc4f9713a5f0', '陆金所', 'POSTPAID_PaymentType', '深圳市南山区平安大厦', '陆小妹', '15721463999', 'luxiaomei@qq.com', '2019-11-04', '2019-11-29', '555555555555555555', 'ENABLE', 'test', '2019-11-15 15:38:26', '2019-11-15 15:38:26', '1');

-- ----------------------------
-- Table structure for t_address
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sheng` varchar(20) DEFAULT NULL,
  `shi` varchar(20) DEFAULT NULL,
  `qu` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_address
-- ----------------------------
INSERT INTO `t_address` VALUES ('1', '江苏省', '苏州市', '姑苏区');
INSERT INTO `t_address` VALUES ('2', '江苏省', '南京市', '鼓楼区');

-- ----------------------------
-- Table structure for t_grade
-- ----------------------------
DROP TABLE IF EXISTS `t_grade`;
CREATE TABLE `t_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gradeName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_grade
-- ----------------------------
INSERT INTO `t_grade` VALUES ('1', '大学一年级');
INSERT INTO `t_grade` VALUES ('2', '大学二年级');

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `addressId` int(11) DEFAULT NULL,
  `gradeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_student` (`gradeId`),
  KEY `FK_t_student2` (`addressId`),
  CONSTRAINT `FK_t_student` FOREIGN KEY (`gradeId`) REFERENCES `t_grade` (`id`),
  CONSTRAINT `FK_t_student2` FOREIGN KEY (`addressId`) REFERENCES `t_address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', '张三', '10', '1', '1');
INSERT INTO `t_student` VALUES ('2', '李四', '11', '2', '2');
INSERT INTO `t_student` VALUES ('3', '王五', '12', '2', '2');
