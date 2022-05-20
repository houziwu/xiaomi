# Host: localhost  (Version: 5.5.53)
# Date: 2022-05-20 10:38:46
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "stu"
#

CREATE TABLE `stu` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `major` varchar(20) NOT NULL DEFAULT '',
  `classes` varchar(20) NOT NULL DEFAULT '',
  `Java` varchar(20) DEFAULT NULL,
  `PHP` varchar(20) DEFAULT NULL,
  `JavaWeb` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=6601 DEFAULT CHARSET=utf8;

#
# Data for table "stu"
#

INSERT INTO `stu` VALUES (4500,'朱棣','计科','3',NULL,NULL,NULL),(6225,'李白','计科','1','89','90','20'),(6226,'杜甫','计科','2','50','50','50'),(6227,'李二凤','计科','2','98','98','98'),(6228,'李世民','计科','3','45','98','67'),(6230,'赵匡胤','计科','2',NULL,NULL,NULL),(6231,'李斯','计科接本','1',NULL,NULL,NULL),(6232,'崔琰','计科接本','2',NULL,NULL,NULL),(6237,'刘邦','计科接本','3','80','90','88'),(6238,'项羽','计科','3','50','46','33'),(6421,'张三','计科接本','3','80','80','80'),(6422,'李四','计科接本','3','70','90','90'),(6423,'王五','计科接本','3','80','76','94'),(6424,'李文','计科','3','20','20','20'),(6425,'李武','计科','3','40','40','40'),(6501,'陈胜','计科接本','2',NULL,NULL,NULL),(6600,'吴广','计科','1','80','78','75');

#
# Structure for table "user"
#

CREATE TABLE `user` (
  `name` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(20) NOT NULL DEFAULT '',
  `type` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES ('admin','admin','admin'),('bilibili','1234','admin'),('caocao','123','guest'),('guest','guest','guest'),('libai','123','guest'),('lidong','123','guest'),('liufeng','123','guest'),('liuyu','123','guest'),('liuzifeng','1234','guest'),('qianqiao','555','guest'),('qitailang','917','guest'),('qq','123','admin'),('xuhuai','123','guest'),('六三','123','guest'),('刘备','123','guest'),('刘邦','123','guest'),('吴广','123','guest'),('崔琰','123','guest'),('张三','1234','guest'),('张银松','123456789','guest'),('朱棣','123','guest'),('李世民','123','guest'),('李二凤','123','guest'),('李四','123','guest'),('李斯','123','guest'),('荀彧','123','guest'),('赵匡胤','1234','guest'),('陈胜','123','guest'),('项羽','1234','guest');
