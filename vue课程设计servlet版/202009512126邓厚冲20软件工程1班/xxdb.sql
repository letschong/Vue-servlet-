/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306_1
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : xxdb

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 24/06/2022 15:48:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`  (
  `clsId` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `clsName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `clsMajor` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `depId` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院编号',
  `clsGrade` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年级',
  PRIMARY KEY (`clsId`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '班级' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('2020095121', '20软件工程1班', '软件工程', 'J01', '20级');
INSERT INTO `classes` VALUES ('2020095123', '20计科1班', '计算机与科学专业', 'J01', '20级');
INSERT INTO `classes` VALUES ('2020095122', '20软件工程2班', '软件工程', 'J01', '20级');
INSERT INTO `classes` VALUES ('2020095124', '20计科2班', '计算机与科学', 'J01', '20级');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `depId` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门编号',
  `depName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `depaType` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门类型-X：行政，J：教学',
  PRIMARY KEY (`depId`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('J01', '大数据与软件工程学院', 'J');
INSERT INTO `department` VALUES ('J02', '电子信息工程', 'J');

-- ----------------------------
-- Table structure for instructor
-- ----------------------------
DROP TABLE IF EXISTS `instructor`;
CREATE TABLE `instructor`  (
  `insNo` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `insName` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `insPwd` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `depId` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学院编号',
  `telephone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`insNo`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '辅导员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of instructor
-- ----------------------------
INSERT INTO `instructor` VALUES ('09512', '吴欣桦', '123456', 'J01', '15677413760');
INSERT INTO `instructor` VALUES ('09513', '郑大大', '123456', 'J01', '15912345622');
INSERT INTO `instructor` VALUES ('09514', '肖大', '123456', 'J01', '1578790369');

-- ----------------------------
-- Table structure for instructortask
-- ----------------------------
DROP TABLE IF EXISTS `instructortask`;
CREATE TABLE `instructortask`  (
  `insNo` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '辅导员编号',
  `clsId` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级编号',
  `startTime` date NULL DEFAULT NULL COMMENT '开始时间',
  `startTerm` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开始学年（2021-2022-2）',
  PRIMARY KEY (`insNo`, `clsId`) USING BTREE,
  INDEX `clsid`(`clsId`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '辅导员带班表' ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of instructortask
-- ----------------------------
INSERT INTO `instructortask` VALUES ('09512', '2020095122', '2020-10-17', '2020-2021-1');
INSERT INTO `instructortask` VALUES ('09512', '2020095121', '2020-10-17', '2020-2021-1');
INSERT INTO `instructortask` VALUES ('09512', '202095124', '2020-10-17', '2020-2021-1');
INSERT INTO `instructortask` VALUES ('09512', '2020095123', '2020-10-17', '2020-2021-1');

-- ----------------------------
-- Table structure for leave
-- ----------------------------
DROP TABLE IF EXISTS `leave`;
CREATE TABLE `leave`  (
  `leaveNo` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `types` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reason` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `startTime` datetime(0) NULL DEFAULT NULL,
  `endTime` datetime(0) NULL DEFAULT NULL,
  `stuNo` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `days` float NULL DEFAULT NULL,
  `insNo` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` datetime(0) NULL DEFAULT NULL,
  `flag` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`leaveNo`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '请假表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of leave
-- ----------------------------
INSERT INTO `leave` VALUES ('20220620152000333', '事假', '家里有事', '2022-06-20 00:00:00', '2022-06-20 15:20:14', '202009512126', 0.1, '09512', '2022-06-20 15:24:10', '1');
INSERT INTO `leave` VALUES ('c58bdcc231d04fdeb1c8483b166a27b7', '事假', '有事', '2022-06-20 00:00:00', '2022-06-21 10:41:06', '202009512122', 1, '09512', '2022-06-20 18:41:13', '3');
INSERT INTO `leave` VALUES ('a2f9e640314b460590347b75b9c49fb4', '事假', '有事', '2022-06-21 00:00:00', '2022-06-22 16:00:00', '202009512126', 1, '09512', '2022-06-21 01:39:59', '1');
INSERT INTO `leave` VALUES ('638538305f5e4fa7a1dd3012a58f9b67', '事假', '有事', '2022-06-23 00:00:10', '2022-06-24 16:00:00', '202009512126', 1, '09512', '2022-06-23 20:00:26', '0');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `psid` int(0) NOT NULL,
  `psName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `psPid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `path` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `psLevel` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`psid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (100, '系统设置', '0', NULL, '0');
INSERT INTO `menu` VALUES (101, '请假管理', '0', NULL, '0');
INSERT INTO `menu` VALUES (102, '数据分析', '0', NULL, '0');
INSERT INTO `menu` VALUES (103, '用户管理', '100', 'user', '1');
INSERT INTO `menu` VALUES (104, '权限管理', '100', 'role', '1');
INSERT INTO `menu` VALUES (105, '部门管理', '100', 'department', '1');
INSERT INTO `menu` VALUES (106, '班级管理', '100', 'class', '1');
INSERT INTO `menu` VALUES (107, '学生管理', '100', 'students', '1');
INSERT INTO `menu` VALUES (108, '辅导员管理', '100', 'instructor', '1');
INSERT INTO `menu` VALUES (109, '辅导员带班管理', '100', 'instructortask', '1');
INSERT INTO `menu` VALUES (110, '填写请假条', '101', 'leave', '1');
INSERT INTO `menu` VALUES (111, '审核请假条', '101', 'auditleave', '1');
INSERT INTO `menu` VALUES (112, '请假情况统计', '102', 'statistics', '1');
INSERT INTO `menu` VALUES (113, '请假名单导出', '102', 'daoleave', NULL);

-- ----------------------------
-- Table structure for relepower
-- ----------------------------
DROP TABLE IF EXISTS `relepower`;
CREATE TABLE `relepower`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `psid` int(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of relepower
-- ----------------------------
INSERT INTO `relepower` VALUES ('4', 101);
INSERT INTO `relepower` VALUES ('4', 111);
INSERT INTO `relepower` VALUES ('4', 102);
INSERT INTO `relepower` VALUES ('4', 112);
INSERT INTO `relepower` VALUES ('4', 113);
INSERT INTO `relepower` VALUES ('3', 102);
INSERT INTO `relepower` VALUES ('3', 112);
INSERT INTO `relepower` VALUES ('3', 113);
INSERT INTO `relepower` VALUES ('5', 110);
INSERT INTO `relepower` VALUES ('5', 101);
INSERT INTO `relepower` VALUES ('1', 100);
INSERT INTO `relepower` VALUES ('1', 103);
INSERT INTO `relepower` VALUES ('1', 104);
INSERT INTO `relepower` VALUES ('1', 105);
INSERT INTO `relepower` VALUES ('1', 106);
INSERT INTO `relepower` VALUES ('1', 107);
INSERT INTO `relepower` VALUES ('1', 108);
INSERT INTO `relepower` VALUES ('1', 109);
INSERT INTO `relepower` VALUES ('1', 102);
INSERT INTO `relepower` VALUES ('1', 112);
INSERT INTO `relepower` VALUES ('1', 113);
INSERT INTO `relepower` VALUES ('2', 106);
INSERT INTO `relepower` VALUES ('2', 107);
INSERT INTO `relepower` VALUES ('2', 108);
INSERT INTO `relepower` VALUES ('2', 109);
INSERT INTO `relepower` VALUES ('2', 102);
INSERT INTO `relepower` VALUES ('2', 112);
INSERT INTO `relepower` VALUES ('2', 113);
INSERT INTO `relepower` VALUES ('2', 100);

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id',
  `rolesname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rolesdescribe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1', '系统管理员', '系统负责人');
INSERT INTO `roles` VALUES ('2', '二级学院管理员', NULL);
INSERT INTO `roles` VALUES ('3', '学工处工作人员', NULL);
INSERT INTO `roles` VALUES ('4', '辅导员', NULL);
INSERT INTO `roles` VALUES ('5', '学生', NULL);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stuNo` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stuName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stuSex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '男:2,女:1',
  `clsId` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stuPwd` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`stuNo`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('202009512126', '邓厚冲', '男', '2020095121', '123456');
INSERT INTO `student` VALUES ('202009512127', '肖豪俊', '男', '2020095121', '123456');
INSERT INTO `student` VALUES ('202009512122', '邓超', '男', '2020095122', '123456');
INSERT INTO `student` VALUES ('2020095121', '作者', '女', '2020095121', '123456');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fullname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `depId` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2022', '二级管理员', '123456', 'X01', '15778790369', '2');
INSERT INTO `user` VALUES ('2023', '学工处', '123456', 'X01', '1578790369', '3');
INSERT INTO `user` VALUES ('admin', '系统管理员', '123456', 'X01', '15778790369', '1');

SET FOREIGN_KEY_CHECKS = 1;
