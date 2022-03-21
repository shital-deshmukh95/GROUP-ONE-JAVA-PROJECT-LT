/*
MySQL Data Transfer
Source Host: localhost
Source Database: crs
Target Host: localhost
Target Database: crs
Date: 3/21/2022 11:43:56 AM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminId` varchar(32) NOT NULL default '',
  PRIMARY KEY  (`adminId`),
  KEY `adminId` (`adminId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for catalog
-- ----------------------------
DROP TABLE IF EXISTS `catalog`;
CREATE TABLE `catalog` (
  `courseCode` varchar(32) NOT NULL default '',
  `courseName` varchar(32) default NULL,
  `description` varchar(255) default NULL,
  PRIMARY KEY  (`courseCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseCode` varchar(32) NOT NULL,
  `courseName` varchar(32) NOT NULL,
  `instructorId` varchar(32) NOT NULL,
  `availableSeats` int(10) NOT NULL,
  `courseFee` double(32,0) default NULL,
  PRIMARY KEY  (`courseCode`),
  KEY `courseCode` (`courseCode`,`courseName`,`instructorId`,`availableSeats`),
  KEY `instructorId` (`instructorId`),
  CONSTRAINT `instructorId` FOREIGN KEY (`instructorId`) REFERENCES `professor` (`instructorId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for notification
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
  `referenceId` varchar(32) default NULL,
  `notificationType` varchar(32) default NULL,
  `notificationId` varchar(32) NOT NULL default '',
  PRIMARY KEY  (`notificationId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `referenceId` varchar(32) default NULL,
  `studentId` varchar(32) NOT NULL,
  `amount` float(32,0) default NULL,
  `modeOfPayment` varchar(32) default NULL,
  KEY `studentId` (`studentId`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`studentId`) REFERENCES `payment` (`studentId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for professor
-- ----------------------------
DROP TABLE IF EXISTS `professor`;
CREATE TABLE `professor` (
  `instructorId` varchar(32) NOT NULL,
  `department` varchar(32) NOT NULL,
  `designation` varchar(32) NOT NULL,
  PRIMARY KEY  (`instructorId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for registeredcourse
-- ----------------------------
DROP TABLE IF EXISTS `registeredcourse`;
CREATE TABLE `registeredcourse` (
  `studentId` varchar(32) NOT NULL,
  `courseCode` varchar(32) NOT NULL,
  `grade` varchar(32) NOT NULL,
  `rid` int(32) NOT NULL auto_increment,
  PRIMARY KEY  (`rid`),
  KEY `studentId` (`studentId`),
  KEY `courseCode` (`courseCode`),
  CONSTRAINT `courseCode` FOREIGN KEY (`courseCode`) REFERENCES `course` (`courseCode`),
  CONSTRAINT `studentId` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleType` varchar(32) NOT NULL,
  `userId` varchar(32) NOT NULL,
  KEY `userId` (`userId`),
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentId` varchar(32) NOT NULL,
  `branch` varchar(32) NOT NULL,
  `batch` varchar(32) NOT NULL,
  `isRegistered` varchar(32) NOT NULL,
  `isPaid` varchar(32) NOT NULL,
  `isApproved` varchar(32) default NULL,
  `isReportGenerated` varchar(32) default NULL,
  PRIMARY KEY  (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `name` varchar(32) default NULL,
  `gender` varchar(32) default NULL,
  `address` varchar(59) default NULL,
  `role` varchar(39) default NULL,
  PRIMARY KEY  (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `admin` VALUES ('1');
INSERT INTO `catalog` VALUES ('AWS', 'Amazon', 'Amazon cloud certifcation');
INSERT INTO `catalog` VALUES ('Az-104', 'Azure', 'Microsoft certification');
INSERT INTO `catalog` VALUES ('Az-900', 'Azure', 'Microsoft certification');
INSERT INTO `catalog` VALUES ('C_101', 'Angular', 'Angular Course');
INSERT INTO `catalog` VALUES ('lz-808', 'Java', 'Java certification');
INSERT INTO `catalog` VALUES ('OCJP_1', 'OCJP_1', 'NEw java');
INSERT INTO `catalog` VALUES ('OCJP_101', 'OCJP', 'OCJP COURSE');
INSERT INTO `catalog` VALUES ('Python', 'Python', 'Python certificate');
INSERT INTO `course` VALUES ('1', 'Test Course', '1', '2', '554');
INSERT INTO `course` VALUES ('Az-104', 'Azure', '2', '1', '1000');
INSERT INTO `course` VALUES ('Az-900', 'Azure', '2', '7', '1200');
INSERT INTO `course` VALUES ('Python', 'Python Certification', '2', '4', '1500');
INSERT INTO `professor` VALUES ('1', 'dept1', 'asd');
INSERT INTO `professor` VALUES ('2', 'IT', 'AS');
INSERT INTO `professor` VALUES ('5', 'IT', 'AS');
INSERT INTO `professor` VALUES ('7', 'IT', 'AS');
INSERT INTO `professor` VALUES ('9', 'IT', 'AM');
INSERT INTO `registeredcourse` VALUES ('1', 'Az-104', 'A', '1');
INSERT INTO `registeredcourse` VALUES ('2', 'Python', 'A', '3');
INSERT INTO `registeredcourse` VALUES ('4', 'Python', '-', '11');
INSERT INTO `registeredcourse` VALUES ('9', '1', 'A', '12');
INSERT INTO `registeredcourse` VALUES ('10', '1', 'A', '13');
INSERT INTO `registeredcourse` VALUES ('11', 'Python', 'C', '14');
INSERT INTO `registeredcourse` VALUES ('3', 'Python', '-', '15');
INSERT INTO `registeredcourse` VALUES ('18', 'Python', 'A', '16');
INSERT INTO `registeredcourse` VALUES ('18', 'Az-900', 'B', '17');
INSERT INTO `registeredcourse` VALUES ('19', 'Az-104', 'C', '18');
INSERT INTO `registeredcourse` VALUES ('19', 'Az-900', 'A', '20');
INSERT INTO `registeredcourse` VALUES ('19', '1', '-', '24');
INSERT INTO `registeredcourse` VALUES ('rahul', '1', '-', '29');
INSERT INTO `registeredcourse` VALUES ('rahul', 'Az-900', '-', '30');
INSERT INTO `registeredcourse` VALUES ('rahul', '1', '-', '31');
INSERT INTO `registeredcourse` VALUES ('11', '1', '-', '34');
INSERT INTO `registeredcourse` VALUES ('rahul', 'Python', '-', '35');
INSERT INTO `registeredcourse` VALUES ('E0101', '1', '-', '39');
INSERT INTO `registeredcourse` VALUES ('E0102', '1', '-', '41');
INSERT INTO `role` VALUES ('Admin', '1');
INSERT INTO `student` VALUES ('1', 'b1', 'batch1', '1', '1', '0', '0');
INSERT INTO `student` VALUES ('10', 'b1', 'batch1', '1', '1', '1', '0');
INSERT INTO `student` VALUES ('11', 'b1', 'batch1', '1', '1', '1', '0');
INSERT INTO `student` VALUES ('12', 'b1', 'batch1', '1', '0', '0', '0');
INSERT INTO `student` VALUES ('1232', 'computer', 'batch 1', '1', '0', '0', '0');
INSERT INTO `student` VALUES ('1234', 'Computer', 'batch1', '1', '0', '0', '0');
INSERT INTO `student` VALUES ('13', 'b1', 'batch1', '1', '0', '0', '0');
INSERT INTO `student` VALUES ('14', 'b1', 'batch1', '1', '0', '0', '0');
INSERT INTO `student` VALUES ('15', 'b1', 'batch1', '1', '0', '0', '0');
INSERT INTO `student` VALUES ('16', 'b1', 'batch1', '1', '0', '0', '0');
INSERT INTO `student` VALUES ('17', 'b1', 'batch1', '1', '0', '0', '0');
INSERT INTO `student` VALUES ('18', 'C ', 'batch1', '1', '1', '1', '0');
INSERT INTO `student` VALUES ('19', 'Computer', 'batch1', '1', '1', '0', '0');
INSERT INTO `student` VALUES ('2', 'IT', '2019', '1', '1', '0', '0');
INSERT INTO `student` VALUES ('3', 'Computer', '2019', '1', '1', '0', '0');
INSERT INTO `student` VALUES ('4', 'b1', 'batch1', '1', '1', '0', '0');
INSERT INTO `student` VALUES ('5', 'b1', 'batch1', '1', '0', '0', '0');
INSERT INTO `student` VALUES ('6', 'b1', 'batch1', '1', '0', '0', '0');
INSERT INTO `student` VALUES ('7', 'b1', 'batch1', '1', '0', '1', '0');
INSERT INTO `student` VALUES ('8', 'b1', 'batch1', '1', '0', '1', '0');
INSERT INTO `student` VALUES ('9', 'b1', 'batch1', '1', '1', '1', '0');
INSERT INTO `student` VALUES ('E0101', 'Computer', 'Computer', '1', '1', '1', '0');
INSERT INTO `student` VALUES ('E0102', 'Computer', 'batch 2', '1', '0', '1', '0');
INSERT INTO `student` VALUES ('rahul', 'Computer', 'batch 1', '1', '0', '1', '0');
INSERT INTO `user` VALUES ('1', 'shital', 'shital deshmukh', 'FEMALE', 'nashik', 'ADMIN');
INSERT INTO `user` VALUES ('101', 'mona', 'monali deshmukh', 'FEMALE', 'Nashik', 'STUDENT');
INSERT INTO `user` VALUES ('11', 'ria', 'ria', 'FEMALE', 'Nashik', 'STUDENT');
INSERT INTO `user` VALUES ('12', 'ria1', 'ria1', 'FEMALE', 'Nashik', 'STUDENT');
INSERT INTO `user` VALUES ('1232', 'shital', 'shital', 'FEMALE', 'nashik', 'STUDENT');
INSERT INTO `user` VALUES ('1234', 'vidhi', 'vidhi', 'FEMALE', 'Nashik', 'STUDENT');
INSERT INTO `user` VALUES ('13', 'ria1', 'ria1', 'FEMALE', 'Nashik', 'STUDENT');
INSERT INTO `user` VALUES ('14', 'ria1', 'mmm', 'FEMALE', 'Nashik', 'STUDENT');
INSERT INTO `user` VALUES ('15', 'ria1', 'mmm', 'FEMALE', 'Nashik', 'STUDENT');
INSERT INTO `user` VALUES ('16', 'asdc', 'asd', 'FEMALE', 'Nashik', 'STUDENT');
INSERT INTO `user` VALUES ('17', 'asdc', 'asd', 'FEMALE', 'Nashik', 'STUDENT');
INSERT INTO `user` VALUES ('18', 'abcl@123', 'asd', 'FEMALE', 'Nashik', 'STUDENT');
INSERT INTO `user` VALUES ('19', 'soha@123', 'soha', 'FEMALE', 'Nashik', 'STUDENT');
INSERT INTO `user` VALUES ('2', 'dhara', 'dhara', 'FEMALE', 'Mumbai', 'STUDENT');
INSERT INTO `user` VALUES ('3', 'soham', 'soham', 'MALE', 'Pune', 'STUDENT');
INSERT INTO `user` VALUES ('4', 'neha', 'neha', 'FEMALE', 'Nashik', 'STUDENT');
INSERT INTO `user` VALUES ('5', 'neha1', 'neha1', 'FEMALE', 'Nashik', 'STUDENT');
INSERT INTO `user` VALUES ('6', 'ruhi', 'ruhi', 'FEMALE', 'Nashik', 'STUDENT');
INSERT INTO `user` VALUES ('7', 'ruhi1', 'ruhi1', 'FEMALE', 'Nashik', 'STUDENT');
INSERT INTO `user` VALUES ('8', 'shital', 'neha', 'FEMALE', 'Nashik', 'STUDENT');
INSERT INTO `user` VALUES ('9', 'mona123', 'mona', 'FEMALE', 'Nashik', 'STUDENT');
INSERT INTO `user` VALUES ('E0101', 'neha', 'neha', 'FEMALE', 'nashik', 'STUDENT');
INSERT INTO `user` VALUES ('E0102', 'shoham', 'soham', 'MALE', 'PUNE', 'STUDENT');
INSERT INTO `user` VALUES ('rahul', 'rahul', 'rahul', 'MALE', 'nashik', 'STUDENT');
