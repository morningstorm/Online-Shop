/*
Navicat MySQL Data Transfer

Source Server         : Javaweb
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : db_eshop

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-06-28 14:08:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_cart
-- ----------------------------
DROP TABLE IF EXISTS `tb_cart`;
CREATE TABLE `tb_cart` (
  `id` int(2) NOT NULL AUTO_INCREMENT COMMENT '卡片号',
  `auser_id` int(11) NOT NULL COMMENT '顾客号',
  `goods_id` int(11) NOT NULL COMMENT '商品号',
  `num` int(11) NOT NULL COMMENT '商品数量',
  `status` tinyint(4) NOT NULL COMMENT '购物车状态',
  `order_id` int(11) NOT NULL COMMENT '订单号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_cart
-- ----------------------------

-- ----------------------------
-- Table structure for tb_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods` (
  `id` int(2) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `gid` varchar(11) NOT NULL COMMENT '商品号',
  `gname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `gprice` double(50,2) NOT NULL COMMENT '商品价格',
  `gpicture` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品图片',
  `gmessage` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品信息',
  `gstatus` tinyint(4) NOT NULL COMMENT '商品状态（0-）',
  `type_id` int(11) DEFAULT '0' COMMENT '商品类别序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_goods
-- ----------------------------

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `amount` double NOT NULL COMMENT '价格合计',
  `status` tinyint(4) NOT NULL COMMENT '订单状态',
  `orderdate` datetime NOT NULL COMMENT '订单时间',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单信息',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货地址',
  `auser_id` int(11) NOT NULL COMMENT '顾客号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_order
-- ----------------------------

-- ----------------------------
-- Table structure for tb_sysuser
-- ----------------------------
DROP TABLE IF EXISTS `tb_sysuser`;
CREATE TABLE `tb_sysuser` (
  `id` int(2) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `sid` varchar(11) NOT NULL COMMENT '管理员工号',
  `sname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员用户名',
  `spass` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `smobile` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系方式',
  `status` tinyint(4) NOT NULL COMMENT '状态（1-启用，0-冻结）',
  `srole` tinyint(4) NOT NULL COMMENT '角色（0-系统管理员、1-商品管理员、2-用户管理员）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_sysuser
-- ----------------------------
INSERT INTO `tb_sysuser` VALUES ('1', 'S001', 'LiBai', '111', '15620350212', '1', '0');
INSERT INTO `tb_sysuser` VALUES ('2', 'S002', 'liu', '111', '15615165165', '1', '1');
INSERT INTO `tb_sysuser` VALUES ('3', 'S003', 'li', '111', '15151616516', '1', '1');
INSERT INTO `tb_sysuser` VALUES ('4', 'S004', 'fan', '515', '15115616516', '1', '2');

-- ----------------------------
-- Table structure for tb_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_type`;
CREATE TABLE `tb_type` (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '商品类别序号',
  `lbname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品类别名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_type
-- ----------------------------
INSERT INTO `tb_type` VALUES ('1', '电子数码');
INSERT INTO `tb_type` VALUES ('2', '家具');
INSERT INTO `tb_type` VALUES ('3', '日常用品');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(2) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `uid` varchar(11) NOT NULL COMMENT '顾客号',
  `uname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '顾客用户名',
  `upass` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `usex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '顾客性别',
  `umobile` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `uaddress` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '家庭地址',
  `uemail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `upicture` varchar(255) DEFAULT NULL,
  `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '0-冻结，1-可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'U001', 'libai', '123', '男', '15620350225', '河南', '1183157230@qq.com', '2000-01-22', null, '1');
INSERT INTO `tb_user` VALUES ('2', 'U002', 'shanshan', '321', '男', '15658465133', '沧州', '1816152056@qq.com', '1998-06-22', null, '1');
INSERT INTO `tb_user` VALUES ('3', 'U003', 'jiawei', '111', '男', '15615649886', '山西', '1564279826@qq.com', '2000-05-30', null, '1');
INSERT INTO `tb_user` VALUES ('4', 'U004', 'yuyu', '222', '女', '15568456431', '四川', '1546114651@qq.com', '1985-12-23', null, '1');
INSERT INTO `tb_user` VALUES ('5', 'U005', 'lichen', '333', '男', '51616518946', '福建', '1561561561@qq.com', '1987-12-26', null, '1');
