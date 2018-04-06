/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : bms

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-03-04 14:05:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(10) NOT NULL,
  `book_name` varchar(50) NOT NULL,
  `book_author` varchar(50) NOT NULL,
  `book_publisher` varchar(50) DEFAULT NULL,
  `book_publish_time` date DEFAULT NULL,
  `book_price` decimal(10,2) DEFAULT NULL,
  `book_sort` int(10) NOT NULL,
  `book_comm` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`book_id`),
  KEY `book` (`book_sort`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`book_sort`) REFERENCES `sort` (`sort_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sort
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort` (
  `sort_id` int(10) NOT NULL,
  `sort_name` varchar(50) NOT NULL,
  PRIMARY KEY (`sort_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `user_id_card` varchar(18) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
