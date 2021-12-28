/*
Navicat MySQL Data Transfer

Source Server         : db
Source Server Version : 80027
Source Host           : localhost:3333
Source Database       : bookmanagement

Target Server Type    : MYSQL
Target Server Version : 80027
File Encoding         : 65001

Date: 2021-12-29 02:55:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bookcode` varchar(255) DEFAULT NULL,
  `bookname` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `bookstype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `entrydate` date DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `bookstatus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `amount` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'XS-00059', '鲁滨逊漂流记', '丹尼尔·笛福', '小说', '2021-12-08', '2楼B区11排B面', '可借', '30');
INSERT INTO `book` VALUES ('2', 'XS-00162', '龙族', '江南', '小说', '2021-12-02', '2楼B区13排A面', '可借', '15');
INSERT INTO `book` VALUES ('3', 'XS-00023', '西游记', '吴承恩', '小说', '2020-05-13', '2楼D区6排A面', '可借', '20');
INSERT INTO `book` VALUES ('4', 'XS-00031', '三国演义', '罗贯中', '小说', '2019-05-25', '2楼C区3排A面', '可借', '32');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '李明', '123', '18', '男', '15964521649', '武汉');
INSERT INTO `user` VALUES ('2', '王磊', '12345', '18', '男', '13265488324', '北京');
INSERT INTO `user` VALUES ('3', '叶蕾', '12345', '18', '女', '15856321564', '西安');
INSERT INTO `user` VALUES ('4', '张峰', '12345', '19', '男', '16328564218', '上海');
INSERT INTO `user` VALUES ('5', '楚晓月', '12345', '19', '女', '16523489564', '深圳');
INSERT INTO `user` VALUES ('9', '张1', null, null, null, null, null);
INSERT INTO `user` VALUES ('10', '张2', null, null, null, null, null);
INSERT INTO `user` VALUES ('11', '张3', null, null, null, null, null);
INSERT INTO `user` VALUES ('12', '张4', null, null, null, null, null);
