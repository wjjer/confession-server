/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : confession

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2021-02-25 21:00:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for param
-- ----------------------------
DROP TABLE IF EXISTS `param`;
CREATE TABLE "param" (
  "id" int(11) unsigned NOT NULL AUTO_INCREMENT,
  "name" varchar(255) DEFAULT NULL,
  "key" varchar(255) NOT NULL,
  "value" varchar(255) NOT NULL,
  "status" varchar(255) DEFAULT NULL,
  "info" varchar(512) DEFAULT NULL,
  PRIMARY KEY ("id")
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of param
-- ----------------------------
INSERT INTO `param` VALUES ('1', '系统更新', 'update', '1', 'https://www.baidu.com', '格办公东西啊粉色见识到了考核结果SD卡了');
INSERT INTO `param` VALUES ('2', '系统公告', 'notify', '这是公告', null, null);
INSERT INTO `param` VALUES ('3', '测试', 'test', '1', '1111', 'dtyhfuhfhfgh');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE "sys_user" (
  "id" bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  "email" varchar(32) NOT NULL,
  "devid" varchar(64) DEFAULT NULL,
  "passwd" varchar(64) DEFAULT NULL,
  "vip" int(11) DEFAULT NULL,
  "dtimes" int(11) NOT NULL,
  "create_time" varchar(64) DEFAULT NULL,
  PRIMARY KEY ("id")
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('121', '123456', null, '123456', '0', '0', '2020-08-02 09:53:32');
INSERT INTO `sys_user` VALUES ('122', 'fdfbffg', null, 'cvvdfg', '0', '0', '2020-08-02 10:00:21');
INSERT INTO `sys_user` VALUES ('123', '1750398075@qq.com', '27e49349270c418c84a0272bf6a01d4e', '123456', '0', '3', '2020-08-02 11:04:01');
INSERT INTO `sys_user` VALUES ('124', '1233@qq.com', 'sdgdrheasfdjn123dg2', '123456', '0', '2', '2021-02-24 21:52:20');
INSERT INTO `sys_user` VALUES ('125', '175039807@qq.com', '865166025425623', '111111', '0', '6', '2021-02-25 13:55:52');

-- ----------------------------
-- Table structure for template
-- ----------------------------
DROP TABLE IF EXISTS `template`;
CREATE TABLE "template" (
  "id" int(10) unsigned NOT NULL AUTO_INCREMENT,
  "name" varchar(128) NOT NULL,
  "cover" varchar(512) DEFAULT NULL,
  "durl" varchar(128) DEFAULT NULL,
  "purl" varchar(128) DEFAULT NULL,
  "info" varchar(512) DEFAULT NULL,
  "free" int(11) DEFAULT NULL,
  "create_time" varchar(64) DEFAULT NULL,
  PRIMARY KEY ("id")
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of template
-- ----------------------------
INSERT INTO `template` VALUES ('2', '开发部99', 'https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3544375238,114231233&fm=26&gp=0.jpg', 'http://103.80.18.245/test.zip', 'https://www.baidu.com/s?ie=UTF-8&wd=%E5%AE%89%E5%8D%93AlertDialog', '美图秀秀网页版是 美图秀秀 旗下图片处理软件中的在线版,不用下载直接使用,简单易 用,独有的图片特效、人像美容、拼图、场景、边框、饰品等功能可以使您的图片...', '1', '12-12 12:38');

-- ----------------------------
-- Table structure for user_confession
-- ----------------------------
DROP TABLE IF EXISTS `user_confession`;
CREATE TABLE "user_confession" (
  "id" int(11) unsigned NOT NULL AUTO_INCREMENT,
  "uid" varchar(64) NOT NULL,
  "name" varchar(255) DEFAULT NULL COMMENT '告白名',
  "url" varchar(512) DEFAULT NULL,
  "stimes" int(10) unsigned DEFAULT NULL,
  "create_time" varchar(16) DEFAULT NULL,
  PRIMARY KEY ("id")
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_confession
-- ----------------------------
INSERT INTO `user_confession` VALUES ('124', '1750398075@qq.com', '阿葵', '1750398075@qq.com\\%E9%98%BF%E8%91%B5', '1', '2020-08-02');
INSERT INTO `user_confession` VALUES ('125', '1750398075@qq.com', '金色第二你儿儿儿弟弟弟弟', '1750398075@qq.com\\%E9%87%91%E8%89%B2%E7%AC%AC%E4%BA%8C%E4%BD%A0%E5%84%BF%E5%84%BF%E5%84%BF%E5%BC%9F%E5%BC%9F%E5%BC%9F%E5%BC%9F', '1', '2020-08-02');
INSERT INTO `user_confession` VALUES ('126', '1750398075@qq.com', '表白吧', '1750398075@qq.com\\%E8%A1%A8%E7%99%BD%E5%90%A7', '1', '2020-08-02');
INSERT INTO `user_confession` VALUES ('127', '1750398075@qq.com', '丰富裕', '1750398075@qq.com\\%E4%B8%B0%E5%AF%8C%E8%A3%95', '1', '2020-08-02');
INSERT INTO `user_confession` VALUES ('130', '175039807@qq.com', 'Allan', '175039807@qq.com\\Allan', '1', '2021-02-25');
INSERT INTO `user_confession` VALUES ('131', '1750398075@qq.com', 'A', '1750398075@qq.com\\A', '1', '2021-02-25');
