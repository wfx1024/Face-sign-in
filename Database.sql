/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50137
Source Host           : localhost:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 50137
File Encoding         : 65001

Date: 2017-11-11 21:41:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `counttime`
-- ----------------------------
DROP TABLE IF EXISTS `counttime`;
CREATE TABLE `counttime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `time` int(11) NOT NULL DEFAULT '0',
  `this_time` int(10) unsigned zerofill NOT NULL DEFAULT '0000000000',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of counttime
-- ----------------------------
INSERT INTO `counttime` VALUES ('1', 'xxx', '0', '0000000000');
INSERT INTO `counttime` VALUES ('2', 'wxx', '3', '0000000001');
INSERT INTO `counttime` VALUES ('3', 'wrr', '0', '0000000000');

-- ----------------------------
-- Table structure for `customer_pass`
-- ----------------------------
DROP TABLE IF EXISTS `customer_pass`;
CREATE TABLE `customer_pass` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`sid`),
  CONSTRAINT `sid` FOREIGN KEY (`sid`) REFERENCES `stu_ifo` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of customer_pass
-- ----------------------------

-- ----------------------------
-- Table structure for `stu_ifo`
-- ----------------------------
DROP TABLE IF EXISTS `stu_ifo`;
CREATE TABLE `stu_ifo` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `姓名` varchar(255) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of stu_ifo
-- ----------------------------
INSERT INTO `stu_ifo` VALUES ('1', '刘泽');
INSERT INTO `stu_ifo` VALUES ('2', '杨泽辉');
INSERT INTO `stu_ifo` VALUES ('3', '张传铜');
INSERT INTO `stu_ifo` VALUES ('4', '周梦龙');
INSERT INTO `stu_ifo` VALUES ('5', '高玉丁');
INSERT INTO `stu_ifo` VALUES ('6', '韩旭');
INSERT INTO `stu_ifo` VALUES ('7', '刘扬');
INSERT INTO `stu_ifo` VALUES ('8', '张波');
INSERT INTO `stu_ifo` VALUES ('9', '李相楠');
INSERT INTO `stu_ifo` VALUES ('10', '郝莹生');
INSERT INTO `stu_ifo` VALUES ('11', '孙震');
INSERT INTO `stu_ifo` VALUES ('12', '吴奇威');
INSERT INTO `stu_ifo` VALUES ('13', '王发新');
INSERT INTO `stu_ifo` VALUES ('14', '王兴鑫');
INSERT INTO `stu_ifo` VALUES ('15', '周健心');
INSERT INTO `stu_ifo` VALUES ('16', '侯佳明');
INSERT INTO `stu_ifo` VALUES ('17', '王金宇');
INSERT INTO `stu_ifo` VALUES ('18', '聂同鑫');
INSERT INTO `stu_ifo` VALUES ('19', '王鑫');
INSERT INTO `stu_ifo` VALUES ('20', '贾承霖');
INSERT INTO `stu_ifo` VALUES ('21', '王洋');
INSERT INTO `stu_ifo` VALUES ('22', '杜明亮');
INSERT INTO `stu_ifo` VALUES ('23', '曲成龙');
INSERT INTO `stu_ifo` VALUES ('24', '张茹茹');
INSERT INTO `stu_ifo` VALUES ('25', '单美兰');
INSERT INTO `stu_ifo` VALUES ('26', '周彤');
INSERT INTO `stu_ifo` VALUES ('27', '栾好楠');
INSERT INTO `stu_ifo` VALUES ('28', '张涛');
INSERT INTO `stu_ifo` VALUES ('29', '周宇迪');
INSERT INTO `stu_ifo` VALUES ('30', '许健');
INSERT INTO `stu_ifo` VALUES ('31', '闫明');
INSERT INTO `stu_ifo` VALUES ('32', '李登峰');
INSERT INTO `stu_ifo` VALUES ('33', '许志林');
INSERT INTO `stu_ifo` VALUES ('34', '和晨');
INSERT INTO `stu_ifo` VALUES ('35', '郑旭');
INSERT INTO `stu_ifo` VALUES ('36', '单英杰');
INSERT INTO `stu_ifo` VALUES ('37', '于健');
INSERT INTO `stu_ifo` VALUES ('38', '王志东');
INSERT INTO `stu_ifo` VALUES ('39', '张真挚');
INSERT INTO `stu_ifo` VALUES ('40', '李国栋');
INSERT INTO `stu_ifo` VALUES ('41', '郭洋钰');
INSERT INTO `stu_ifo` VALUES ('42', '孙永淳');
INSERT INTO `stu_ifo` VALUES ('43', '李想');
INSERT INTO `stu_ifo` VALUES ('44', '于强');
INSERT INTO `stu_ifo` VALUES ('45', '栾志明');
INSERT INTO `stu_ifo` VALUES ('46', '李旭文');
INSERT INTO `stu_ifo` VALUES ('47', '佟士宇');
INSERT INTO `stu_ifo` VALUES ('48', '梅红岩');
INSERT INTO `stu_ifo` VALUES ('49', '冷瑞');
INSERT INTO `stu_ifo` VALUES ('50', '朱雷');
INSERT INTO `stu_ifo` VALUES ('51', '程鑫');
INSERT INTO `stu_ifo` VALUES ('52', '刘其松');
INSERT INTO `stu_ifo` VALUES ('53', '曹云瑞');
INSERT INTO `stu_ifo` VALUES ('54', '刘哲');
INSERT INTO `stu_ifo` VALUES ('55', '栾志明');
