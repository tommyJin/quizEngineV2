-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: db_sort_seat
-- ------------------------------------------------------
-- Server version	5.6.27-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hall`
--

DROP TABLE IF EXISTS `hall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hall` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `content` longtext,
  `filepath` longtext,
  `setting` longtext,
  `creator_id` int(11) NOT NULL,
  `isDeleted` int(11) NOT NULL DEFAULT '0',
  `created` bigint(20) NOT NULL DEFAULT '0',
  `modified` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hall`
--

LOCK TABLES `hall` WRITE;
/*!40000 ALTER TABLE `hall` DISABLE KEYS */;
INSERT INTO `hall` VALUES (1,'hall test1','content of hall1','/pic/abc1','json here1',1,1,1465124095108,1465124325599),(2,'hall test','content of hall','/pic/abc','json here',1,0,1465124354307,1465124354307),(3,'hall test','content of hall','/pic/abc','json here',1,0,1465124443953,1465124443953),(4,'hall test2','content of hall2','/pic/abc2','json here2',1,0,1465124534664,1465124534664),(5,'tea1','49615',NULL,NULL,1,0,1465247718886,1465247718886),(6,'aaa165','1651',NULL,NULL,1,0,1465247799216,1465247799216),(7,'fwafgwag','gawgaw',NULL,NULL,1,0,1465247823545,1465247823545),(8,'test2个企鹅去啊恶搞去啊恶搞11','gwagwaga嘎瓦嘎哈额去去q\'a',NULL,NULL,1,0,1465247860698,1465248057192),(9,'hall test_0','content of hall0','/pic/abc0','json here0',1,0,1465248158222,1465248158222),(10,'hall test_1','content of hall1','/pic/abc1','json here1',1,0,1465248158319,1465248158319),(11,'hall test_2','content of hall2','/pic/abc2','json here2',1,0,1465248158362,1465248158362),(12,'hall test_3','content of hall3','/pic/abc3','json here3',1,0,1465248158406,1465248158406),(13,'hall test_4','content of hall4','/pic/abc4','json here4',1,0,1465248158506,1465248158506),(14,'hall test_5','content of hall5','/pic/abc5','json here5',1,0,1465248158603,1465248158603),(15,'hall test_6','content of hall6','/pic/abc6','json here6',1,0,1465248158649,1465248158649),(16,'hall test_7','content of hall7','/pic/abc7','json here7',1,0,1465248158682,1465248158682),(17,'hall test_8','content of hall8','/pic/abc8','json here8',1,0,1465248158727,1465248158727),(18,'hall test_9','content of hall9','/pic/abc9','json here9',1,0,1465248158839,1465248158839),(19,'hall test_10','content of hall10','/pic/abc10','json here10',1,0,1465248158916,1465248158916),(20,'hall test_11','content of hall11','/pic/abc11','json here11',1,0,1465248158970,1465248158970),(21,'hall test_12','content of hall12','/pic/abc12','json here12',1,0,1465248159038,1465248159038),(22,'hall test_13','content of hall13','/pic/abc13','json here13',1,0,1465248159068,1465248159068),(23,'hall test_14','content of hall14','/pic/abc14','json here14',1,0,1465248159113,1465248159113),(24,'hall test_15','content of hall15','/pic/abc15','json here15',1,0,1465248159159,1465248159159),(25,'hall test_16','content of hall16','/pic/abc16','json here16',1,1,1465248159276,1465248159276),(26,'hall test_17','content of hall17','/pic/abc17','json here17',1,1,1465248159355,1465248159355),(27,'hall test_18','content of hall18','/pic/abc18','json here18',1,1,1465248159447,1465248159447),(28,'hall test_19','content of hall19','/pic/abc19','json here19',1,1,1465248159492,1465248159492);
/*!40000 ALTER TABLE `hall` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meeting`
--

DROP TABLE IF EXISTS `meeting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meeting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `content` longtext,
  `range` varchar(200) DEFAULT NULL,
  `date` varchar(45) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `hall_id` int(11) DEFAULT NULL,
  `setting` longtext,
  `creator_id` int(11) NOT NULL,
  `isDeleted` int(11) NOT NULL DEFAULT '0',
  `created` bigint(20) NOT NULL DEFAULT '0',
  `modified` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meeting`
--

LOCK TABLES `meeting` WRITE;
/*!40000 ALTER TABLE `meeting` DISABLE KEYS */;
INSERT INTO `meeting` VALUES (1,'人大第一次会议','开会了开会了','全体党员','2016-06-18 20:54','省政府',NULL,NULL,1,0,1465249260196,1465251420026),(2,'人大第二次会议1','分哇嘎哇过期过去额邱娥国去1','全体党员1','2016-06-14 19:52','15 Croydon Road1',NULL,NULL,1,0,1465251537061,1465251555596),(3,'福娃覆盖全球1','法网发去1','福娃1','2016-06-29 12:34','去微软去1',23,NULL,1,0,1465472435967,1465472910053);
/*!40000 ALTER TABLE `meeting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `title` varchar(45) NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `creator_id` int(11) NOT NULL,
  `isDeleted` int(11) NOT NULL DEFAULT '0',
  `created` bigint(20) NOT NULL DEFAULT '0',
  `modified` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'赵六23',1,'副党委书记','121',1,0,1465133317856,1465133317856),(2,'王五23',2,'党委书记','119',1,0,1465133317893,1465133317893),(3,'李四23',3,'副省长','120',1,0,1465133317937,1465133317937),(4,'张三23',4,'省长','110',1,0,1465133317982,1465133317982);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rule`
--

DROP TABLE IF EXISTS `rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `content` longtext,
  `creator_id` int(11) NOT NULL,
  `isDeleted` int(11) NOT NULL DEFAULT '0',
  `created` bigint(20) NOT NULL DEFAULT '0',
  `modified` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rule`
--

LOCK TABLES `rule` WRITE;
/*!40000 ALTER TABLE `rule` DISABLE KEYS */;
/*!40000 ALTER TABLE `rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `isDeleted` int(11) NOT NULL DEFAULT '0',
  `created` bigint(20) NOT NULL DEFAULT '0',
  `modified` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin','administrator啊',0,0,1465241378051),(2,'admin1','admin','李四',1,1465237351029,1465248397098),(3,'bbbb','aaaa1','测试1',0,1465241390845,1465248403279);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-09 13:33:02
