/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.28 : Database - mybook
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shuma` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shuma`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `shuma`;

CREATE TABLE `shuma` (
  `bookId` INT(11)  AUTO_INCREMENT COMMENT '编号',
  `bookName` VARCHAR(50) NOT NULL COMMENT '名称',
  `price` INT(11) DEFAULT NULL COMMENT '价格',
  `content` VARCHAR(50) DEFAULT NULL COMMENT '描述',
  `img` VARCHAR(50) DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`bookId`)
) ENGINE=INNODB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

 

INSERT  INTO `shuma`(`bookName`,`price`,`content`,`img`) VALUES 
('魅族S1',1001,'4GB运行32内存','img/xt1.jpg'),
('魅族S2',1311,'6GB运行64内存','img/xt2.png'),
('魅族S3',1411,'4GB运行128内存','img/xt3.png'),
('魅族note5',1511,'4GB运行64内存','img/xt4.png'),
('魅族note6',1611,'4GB运行128内存','img/xt5.png'),
('魅族note',1111,'4GB运行32内存','img/xt6.png');

/*Table structure for table `cartinfo` */



/*Table structure for table `vipuser` */

DROP TABLE IF EXISTS `vipuser`;

CREATE TABLE `vipuser` (
  `id` INT(11)  AUTO_INCREMENT,
  `uName` VARCHAR(50) NOT NULL,
  `uPwd` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `vipuser` */

INSERT  INTO `vipuser`(`uName`,`uPwd`) VALUES ('zhangsan','123456');

create table admin(
	aId int auto_increment primary key,
	adminName varchar(50) not null,
	adminPwd varchar(20) not null
);

insert into admin(adminName,adminPwd) values('admin','admin');






/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
