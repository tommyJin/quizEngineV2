-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: quiz_engine
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
-- Table structure for table `category_user`
--

DROP TABLE IF EXISTS `category_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `created` bigint(20) NOT NULL DEFAULT '0',
  `modified` bigint(20) NOT NULL DEFAULT '0',
  `isDeleted` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_user`
--

LOCK TABLES `category_user` WRITE;
/*!40000 ALTER TABLE `category_user` DISABLE KEYS */;
INSERT INTO `category_user` VALUES (1,1,0,1469032220130,1469033200332,1),(2,1,1,1469032220510,1469032220510,0),(3,1,2,1469032220694,1469032220694,0),(4,1,3,1469032221252,1469032221252,0),(5,1,4,1469032221362,1469032221362,0),(6,30,15,1469048583092,1469048583092,0),(7,30,4,1469048583167,1469048583167,0),(8,30,2,1469048583237,1469048583237,0),(9,27,14,1469051275079,1469051283596,1),(10,27,4,1469051275116,1469051275116,0),(11,27,2,1469051298977,1469051298977,0),(12,29,15,1469055999326,1469055999326,0),(13,29,14,1469055999351,1469055999351,0),(14,29,4,1469055999379,1469055999379,0),(15,29,2,1469055999434,1469055999434,0),(16,28,3,1469056008613,1469056008613,0),(17,28,2,1469056008667,1469056008667,0),(18,25,14,1469056015366,1469056015366,0),(19,25,4,1469056015410,1469056015410,0),(20,25,3,1469056015464,1469056015464,0),(21,24,4,1469056020369,1469056020369,0),(22,24,3,1469056020405,1469056020405,0),(23,3,14,1469056031649,1469056031649,0),(24,2,3,1469056040914,1469531436941,1),(25,20,14,1469056110378,1469056110378,0),(26,20,4,1469056110421,1469056110421,0),(27,20,3,1469056110459,1469056110459,0),(28,19,15,1469056119100,1469056119100,0),(29,18,14,1469056126264,1469056126264,0),(30,18,2,1469056126310,1469056126310,0),(31,17,4,1469056132267,1469056132267,0),(32,17,3,1469056132305,1469056132305,0),(33,16,15,1469056139940,1469056139940,0),(34,16,2,1469056139990,1469056139990,0),(35,15,14,1469056147417,1469056147417,0),(36,15,4,1469056147471,1469056147471,0),(37,15,3,1469056147517,1469056147517,0),(38,31,14,1469057840414,1469057981083,1),(39,31,4,1469057840459,1469057840459,0),(40,31,3,1469057840530,1469057840530,0),(41,31,15,1469057981149,1469057981149,0),(42,32,15,1469530661632,1469530661632,0),(43,32,14,1469530661719,1469530661719,0),(44,32,2,1469530661746,1469530661746,0),(45,32,4,1469530674087,1469530674087,0),(46,32,3,1469530674134,1469530674134,0),(47,2,15,1469531437057,1469531437057,0),(48,2,14,1469531437141,1469531437141,0),(49,2,4,1469531437263,1469531437263,0),(50,4,15,1469539234286,1469539234286,0),(51,4,4,1469539234390,1469539234390,0),(52,4,3,1469539234480,1469539234480,0);
/*!40000 ALTER TABLE `category_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `content` longtext,
  `answer` longtext NOT NULL,
  `question_topic_id` varchar(225) DEFAULT NULL,
  `question_level_id` int(11) NOT NULL,
  `question_type_id` int(11) NOT NULL,
  `question_category_id` int(11) NOT NULL,
  `mark` int(11) NOT NULL,
  `feedback` longtext,
  `isDeleted` int(11) NOT NULL DEFAULT '0',
  `created` bigint(20) NOT NULL DEFAULT '0',
  `modified` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'test1','1+1=<input type=\"button\" id=\"blank_1\" value=\"blank_1\" disabled=\"disabled\" />;2+2=<input type=\"button\" id=\"blank_2\" value=\"blank_2\" disabled=\"disabled\" />;1*0=<input type=\"button\" id=\"blank_3\" value=\"blank_3\" disabled=\"disabled\" />','[{\"id\":\"blank_1\",\"answer\":\"2\",\"feedback\":\"blank_1 feedback\"},{\"id\":\"blank_2\",\"answer\":\"4\",\"feedback\":\"<span style=\\\"white-space:normal;\\\">blank_2 feedback</span>\"},{\"id\":\"blank_3\",\"answer\":\"0\",\"feedback\":\"<span style=\\\"white-space:normal;\\\">blank_3 feedback</span>\"}]','tag1',1,1,1,3,'this is feed back&nbsp;',0,1464717637293,1468233582047),(2,'test2','JAVA is a OO language or not :(YES or NO)<input type=\"button\" id=\"blank_1\" value=\"blank_1\" disabled=\"disabled\" />','[]','ttt',4,1,3,2,'fff',1,1464787780920,1468246764205),(3,'test e','chaochao:<input type=\"button\" id=\"blank_1\" value=\"blank_1\" disabled=\"disabled\" />','[{\"id\":\"blank_1\",\"answer\":\"like\",\"feedback\":\"like chaochao\"}]','ttttt',2,6,2,1,'fffffff',0,1464788032877,1468234696139),(4,'b1test','b1:<input type=\"button\" id=\"blank_1\" value=\"blank_1\" disabled=\"disabled\" />&nbsp;b2:<input type=\"button\" id=\"blank_2\" value=\"blank_2\" disabled=\"disabled\" />&nbsp;b3:<input type=\"button\" id=\"blank_3\" value=\"blank_3\" disabled=\"disabled\" />&nbsp;b4:<input type=\"button\" id=\"blank_4\" value=\"blank_4\" disabled=\"disabled\" />','[{\"id\":\"blank_1\",\"answer\":\"b1\",\"feedback\":\"bbbbbbbbbbbbbb1\"},{\"id\":\"blank_2\",\"answer\":\"b2\",\"feedback\":\"<span style=\\\"white-space:normal;\\\">bbbbbbbbbbbbbb</span>2\"},{\"id\":\"blank_3\",\"answer\":\"b3\",\"feedback\":\"<span style=\\\"white-space:normal;\\\">bbbbbbbbbbbbbb</span>3\"},{\"id\":\"blank_4\",\"answer\":\"b4\",\"feedback\":\"<span style=\\\"white-space:normal;\\\">bbbbbbbbbbbbbb</span>4\"}]','10,4',5,1,4,5,'fffff',0,1464797487839,1469807516227),(5,'cb','ccccc<input type=\"button\" id=\"blank_1\" value=\"blank_1\" disabled=\"disabled\" />','[{\"id\":\"blank_1\",\"answer\":\"bbbb1\"},{\"id\":\"blank_1\",\"answer\":\"fffffff1\"}]','ttt',3,6,2,3,'fffff',1,1464800216653,1464800216653),(6,'cb2','ccccc<input type=\"button\" id=\"blank_1\" value=\"blank_1\" disabled=\"disabled\" /><input type=\"button\" id=\"blank_2\" value=\"blank_2\" disabled=\"disabled\" /><input type=\"button\" id=\"blank_3\" value=\"blank_3\" disabled=\"disabled\" />','[{\"id\":\"blank_1\",\"answer\":\"b1\",\"feedback\":\"f1\"},{\"id\":\"blank_2\",\"answer\":\"b2\",\"feedback\":\"f2\"},{\"id\":\"blank_3\",\"answer\":\"b3\",\"feedback\":\"f3\"}]','tttt',1,6,1,3,'fffff',0,1464800512364,1464800599818),(7,'tf1','are you man or woman','{\"true_content\":\"man\",\"false_content\":\"woman\",\"feedback_true\":\"yoooo&nbsp;&nbsp;&nbsp;&nbsp;\",\"feedback_false\":\"whyyyyy\",\"right\":\"true\"}','ttt',2,5,3,2,'fffff',0,1464802527837,1468234151640),(8,'tf21','cccccc1','{\"true_content\":\"this is true1\",\"false_content\":\"this is false1\",\"feedback_true\":\"this is true ff1\",\"feedback_false\":\"this is false feedback1\",\"right\":\"false\"}','ttt11',2,5,2,41,'ffffffff1',0,1464802727891,1464803307286),(9,'mc1','ccccccccc','[{\"id\":\"choice_1\",\"choice\":\"c1\",\"feedback\":\"f1\",\"number\":\"1\",\"isRight\":true},{\"id\":\"choice_2\",\"choice\":\"c2\",\"feedback\":\"f2\",\"number\":\"1\",\"isRight\":false},{\"id\":\"choice_3\",\"choice\":\"c3\",\"feedback\":\"f3\",\"number\":\"1\",\"isRight\":false},{\"id\":\"choice_4\",\"choice\":\"c4\",\"feedback\":\"f4\",\"number\":\"1\",\"isRight\":false}]','ttt',4,4,3,53,'ffff',0,1464813060034,1468234207269),(10,'mc2','fwafwafwa','[{\"id\":\"choice_1\",\"choice\":\"waerac1\",\"feedback\":\"fwafwaf1\",\"number\":\"2\",\"isRight\":true},{\"id\":\"choice_2\",\"choice\":\"fwadfadc2\",\"feedback\":\"fgawgwadf2\",\"number\":\"2\",\"isRight\":false},{\"id\":\"choice_3\",\"choice\":\"fwafwagwavc3\",\"feedback\":\"fwagwaedwaf4faf3\",\"number\":\"2\",\"isRight\":true}]','gwagaw',1,4,1,11,'fwafwa',0,1464815599732,1468234225824),(11,'mc3','fwafawgwa','[{\"id\":\"choice_1\",\"choice\":\"fwagwac1\",\"feedback\":\"fawgwaf1\",\"number\":\"1\",\"isRight\":false},{\"id\":\"choice_2\",\"choice\":\"fwagwavc2\",\"feedback\":\"fawgwafcf2\",\"number\":\"1\",\"isRight\":true},{\"id\":\"choice_3\",\"choice\":\"gwagawdc3\",\"feedback\":\"fawgawdaf3\",\"number\":\"1\",\"isRight\":false},{\"id\":\"choice_4\",\"choice\":\"fawgawvc4fwagwac4\",\"feedback\":\"gawdafwaff4\",\"number\":\"1\",\"isRight\":false},{\"id\":\"choice_5\",\"choice\":\"gagwadac5\",\"feedback\":\"fgawgawdf5\",\"number\":\"1\",\"isRight\":false}]','gawgaw',4,4,3,12,'fwafwa',0,1464815731867,1468234240877),(12,'mc6','1','[{\"id\":\"choice_1\",\"choice\":\"c1\",\"feedback\":\"f1\",\"number\":\"1\",\"isRight\":true},{\"id\":\"choice_2\",\"choice\":\"c2\",\"feedback\":\"f2\",\"number\":\"1\",\"isRight\":false}]','1',5,4,4,5,'1',0,1464816219480,1468234267661),(13,'fill in blank','6*6=<input type=\"button\" id=\"blank_1\" value=\"blank_1\" disabled=\"disabled\" />.','[{\"id\":\"blank_1\",\"answer\":\"36\",\"feedback\":\"fffff\"}]','6',5,6,15,3,'fff',0,1464817668578,1469807507401),(14,'mc6','mt choice','[{\"id\":\"choice_1\",\"choice\":\"fwaf\",\"feedback\":\"awfgwag\",\"isRight\":false},{\"id\":\"choice_2\",\"choice\":\"gwada\",\"feedback\":\"awgawga\",\"isRight\":true},{\"id\":\"choice_3\",\"choice\":\"awfawga\",\"feedback\":\"gawgawd\",\"isRight\":true},{\"number\":\"2\"}]','tawtgwa',2,4,1,5,'fawf',1,1464818536892,1464818536892),(15,'mc7','mt choice','[{\"id\":\"choice_1\",\"choice\":\"c1\",\"feedback\":\"f1\",\"number\":\"1\",\"isRight\":true},{\"id\":\"choice_2\",\"choice\":\"c2\",\"feedback\":\"f2\",\"number\":\"1\",\"isRight\":false}]','3',5,4,15,5,'faw',0,1464819135319,1469807497292),(16,'gagdaw','mt choice','[{\"id\":\"choice_1\",\"choice\":\"c1\",\"feedback\":\"f1\",\"number\":\"2\",\"isRight\":false},{\"id\":\"choice_2\",\"choice\":\"c2\",\"feedback\":\"f2\",\"number\":\"2\",\"isRight\":true},{\"id\":\"choice_3\",\"choice\":\"c3\",\"feedback\":\"f3\",\"number\":\"2\",\"isRight\":true}]','4,2',5,4,4,5,'fwadwa',0,1464820373795,1469807464624),(17,'gwa','mt choice','[{\"id\":\"choice_1\",\"choice\":\"fwaf\",\"feedback\":\"gwa\",\"number\":\"1\",\"isRight\":false},{\"id\":\"choice_2\",\"choice\":\"gawf\",\"feedback\":\"gwasdwa\",\"number\":\"1\",\"isRight\":true},{\"id\":\"choice_3\",\"choice\":\"gwagwa\",\"feedback\":\"gwaga\",\"number\":\"1\",\"isRight\":true}]','gwad',5,4,4,5,'waf',1,1464820445407,1464820558823),(18,'mc9','mt choice','[{\"id\":\"choice_1\",\"choice\":\"fwaga\",\"feedback\":\"wdwagaw\",\"number\":\"1\",\"isRight\":true},{\"id\":\"choice_2\",\"choice\":\"gwa\",\"feedback\":\"dawga\",\"number\":\"1\",\"isRight\":false},{\"id\":\"choice_3\",\"choice\":\"gawd\",\"feedback\":\"gwagaw\",\"number\":\"1\",\"isRight\":false}]','10,4',5,4,4,5,'fwaf',0,1464820767915,1469807454854),(19,'fwawd','gawgaw','{\"true_content\":\"aaaa\",\"false_content\":\"bbbb\",\"feedback_true\":\"gwagwa\",\"feedback_false\":\"afwgag\",\"right\":\"false\"}','14',5,5,4,5,'dwafwa',0,1469615297250,1469807441443);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_category`
--

DROP TABLE IF EXISTS `question_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `content` longtext,
  `isDeleted` int(11) NOT NULL DEFAULT '0',
  `created` bigint(20) NOT NULL DEFAULT '0',
  `modified` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_category`
--

LOCK TABLES `question_category` WRITE;
/*!40000 ALTER TABLE `question_category` DISABLE KEYS */;
INSERT INTO `question_category` VALUES (1,'CSC8487','CSC8487 content',1,1463346149229,1469037833365),(2,'CSC8488','CSC8488 content',0,1463346149400,1463346149400),(3,'CSC8489','CSC8489 content',0,1463346149453,1463346149453),(4,'CSC8490','CSC8490 content1',0,1463346149508,1464051817818),(5,'CSC1234','1d65aw165fw',1,1464051911946,1464052132416),(6,'CSC1234','1d65aw165fw',1,1464051922710,1464052129382),(7,'CSC123456','a1d6w5af6w',1,1464052141191,1464052163488),(8,'CSC123456','a1d6w5af6w1',1,1464052145077,1464052162120),(9,'CSC12345','1f6cwaf165wa',1,1464052184902,1464052549303),(10,'CSC333','a1wdf6wa16f5',1,1464052467593,1464052547858),(11,'CSC222','f16wa5f222',1,1464052517079,1464052546377),(12,'aaa','bbb',1,1464371152894,1464371173215),(13,'aaa','ddd',1,1464371306359,1464371314825),(14,'CSC8499','To be able to demonstrate: - problem solving skills related to the project chosen. - written and oral communication skills appropriate to technical communication and presentation to non-specialists. - personal skills for lifelong learning; ability to exploit professional information resources.',0,1466977060511,1466977060511),(15,'CSC8143','this is 81441111',0,1469037823849,1469038127858);
/*!40000 ALTER TABLE `question_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_choice`
--

DROP TABLE IF EXISTS `question_choice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_choice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) NOT NULL,
  `content` longtext,
  `isDeleted` int(11) NOT NULL DEFAULT '0',
  `created` bigint(20) NOT NULL DEFAULT '0',
  `modified` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `question_id_UNIQUE` (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_choice`
--

LOCK TABLES `question_choice` WRITE;
/*!40000 ALTER TABLE `question_choice` DISABLE KEYS */;
INSERT INTO `question_choice` VALUES (1,1,'[{\"id\":\"blank_1\"},{\"id\":\"blank_2\"},{\"id\":\"blank_3\"}]',0,1464717637372,1468233582118),(2,2,'[]',0,1464787781089,1468246764376),(3,3,'[{\"id\":\"blank_1\"}]',0,1464788032935,1468234696202),(4,4,'[{\"id\":\"blank_1\"},{\"id\":\"blank_2\"},{\"id\":\"blank_3\"},{\"id\":\"blank_4\"}]',0,1464797487918,1469807516285),(5,5,'[{\"id\":\"blank_1\"},{\"id\":\"blank_1\"}]',0,1464800216709,1464800216709),(6,6,'[{\"id\":\"blank_1\"},{\"id\":\"blank_2\"},{\"id\":\"blank_3\"}]',0,1464800512508,1464800599883),(7,7,'{\"true_content\":\"man\",\"false_content\":\"woman\"}',0,1464802527897,1468234151684),(8,8,'{\"true_content\":\"this is true1\",\"false_content\":\"this is false1\"}',0,1464802727954,1464803307341),(9,9,'[{\"id\":\"choice_1\",\"choice\":\"c1\",\"number\":\"1\"},{\"id\":\"choice_2\",\"choice\":\"c2\",\"number\":\"1\"},{\"id\":\"choice_3\",\"choice\":\"c3\",\"number\":\"1\"},{\"id\":\"choice_4\",\"choice\":\"c4\",\"number\":\"1\"}]',0,1464813062628,1468234207380),(10,10,'[{\"id\":\"choice_1\",\"choice\":\"waerac1\",\"number\":\"2\"},{\"id\":\"choice_2\",\"choice\":\"fwadfadc2\",\"number\":\"2\"},{\"id\":\"choice_3\",\"choice\":\"fwafwagwavc3\",\"number\":\"2\"}]',0,1464815599782,1468234225936),(11,11,'[{\"id\":\"choice_1\",\"choice\":\"fwagwac1\",\"number\":\"1\"},{\"id\":\"choice_2\",\"choice\":\"fwagwavc2\",\"number\":\"1\"},{\"id\":\"choice_3\",\"choice\":\"gwagawdc3\",\"number\":\"1\"},{\"id\":\"choice_4\",\"choice\":\"fawgawvc4fwagwac4\",\"number\":\"1\"},{\"id\":\"choice_5\",\"choice\":\"gagwadac5\",\"number\":\"1\"}]',0,1464815731924,1468234241000),(12,12,'[{\"id\":\"choice_1\",\"choice\":\"c1\",\"number\":\"1\"},{\"id\":\"choice_2\",\"choice\":\"c2\",\"number\":\"1\"}]',0,1464816219520,1468234267730),(13,13,'[{\"id\":\"blank_1\"}]',0,1464817668629,1469807507462),(14,14,'[{\"id\":\"choice_1\",\"choice\":\"fwaf\"},{\"id\":\"choice_2\",\"choice\":\"gwada\"},{\"id\":\"choice_3\",\"choice\":\"awfawga\"},{\"number\":\"2\"}]',0,1464818536930,1464818536930),(15,15,'[{\"id\":\"choice_1\",\"choice\":\"c1\",\"number\":\"1\"},{\"id\":\"choice_2\",\"choice\":\"c2\",\"number\":\"1\"}]',0,1464819135384,1469807497355),(16,16,'[{\"id\":\"choice_1\",\"choice\":\"c1\",\"number\":\"2\"},{\"id\":\"choice_2\",\"choice\":\"c2\",\"number\":\"2\"},{\"id\":\"choice_3\",\"choice\":\"c3\",\"number\":\"2\"}]',0,1464820373863,1469807464689),(17,17,'[{\"id\":\"choice_1\",\"choice\":\"fwaf\",\"number\":\"1\"},{\"id\":\"choice_2\",\"choice\":\"gawf\",\"number\":\"1\"},{\"id\":\"choice_3\",\"choice\":\"gwagwa\",\"number\":\"1\"}]',0,1464820445451,1464820558864),(18,18,'[{\"id\":\"choice_1\",\"choice\":\"fwaga\",\"number\":\"1\"},{\"id\":\"choice_2\",\"choice\":\"gwa\",\"number\":\"1\"},{\"id\":\"choice_3\",\"choice\":\"gawd\",\"number\":\"1\"}]',0,1464820767984,1469807454927),(19,19,'{\"true_content\":\"aaaa\",\"false_content\":\"bbbb\"}',0,1469615297500,1469807441560);
/*!40000 ALTER TABLE `question_choice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_level`
--

DROP TABLE IF EXISTS `question_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `content` longtext,
  `isDeleted` int(11) NOT NULL DEFAULT '0',
  `created` bigint(20) NOT NULL DEFAULT '0',
  `modified` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_level`
--

LOCK TABLES `question_level` WRITE;
/*!40000 ALTER TABLE `question_level` DISABLE KEYS */;
INSERT INTO `question_level` VALUES (1,'Easy','Easy content',0,1463346100115,1463346100115),(2,'Normal','Normal content',0,1463346100273,1463346100273),(3,'Hard','Hard content',0,1463346100313,1463346100313),(4,'Survivor','Survivor content',0,1463346100358,1463346100358),(5,'Tag test','111112',0,1464074245691,1464074282139);
/*!40000 ALTER TABLE `question_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_topic`
--

DROP TABLE IF EXISTS `question_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `content` longtext,
  `isDeleted` int(11) NOT NULL DEFAULT '0',
  `created` bigint(20) NOT NULL DEFAULT '0',
  `modified` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_topic`
--

LOCK TABLES `question_topic` WRITE;
/*!40000 ALTER TABLE `question_topic` DISABLE KEYS */;
INSERT INTO `question_topic` VALUES (1,14,'Cloud computing','Cloud computing content',0,1463346263792,1469537435646),(2,4,'Java','Java content',0,1463346263953,1469537430264),(3,15,'Spark','Spark content',0,1463346264005,1469537423722),(4,4,'Kafka','Kafka content',0,1463346264105,1469537416676),(5,14,'Big data','Big data content',0,1463346264159,1469537410123),(6,15,'SPIN','SPIN content1',0,1463346264204,1469537401594),(7,1,'NodeJs','node js',0,1464053092662,1464053102885),(8,1,'Tag test','jfaowijgioaw1',0,1464074131727,1464074266715),(9,1,'Tag test','tawtwa',0,1464074182026,1464074264864),(10,4,'first topic','aaaaa',0,1469530868472,1469537395492),(11,14,'sectopi','fjaiow',0,1469531145966,1469537388312),(12,15,'thir1','fjaowi1',0,0,1469537380760),(13,14,'123','3241',0,1469531946694,1469537374357),(14,4,'first topifwafwa','gwagwag',0,1469531991036,1469537367767);
/*!40000 ALTER TABLE `question_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_type`
--

DROP TABLE IF EXISTS `question_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `content` longtext,
  `isDeleted` int(11) NOT NULL DEFAULT '0',
  `created` bigint(20) NOT NULL DEFAULT '0',
  `modified` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_type`
--

LOCK TABLES `question_type` WRITE;
/*!40000 ALTER TABLE `question_type` DISABLE KEYS */;
INSERT INTO `question_type` VALUES (1,'Fill in Multiple Blanks','Fill in Multiple Blanks content',0,1463347838573,1463347838573),(2,'Fill in the Blank','Fill in the Blank content',1,1463347838822,1463347838822),(3,'Multiple Answer','Multiple Answer content',0,1463347838884,1463347838884),(4,'Multiple Choice','Multiple Choice content',0,1463347838999,1463347839222),(5,'True Or False','True Or False content',0,1463347839055,1463347839055),(6,'Calculate Numeric','Calculate Numeric content',0,1463347839099,1463347839099);
/*!40000 ALTER TABLE `question_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quiz`
--

DROP TABLE IF EXISTS `quiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quiz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `number` int(11) NOT NULL,
  `showanswer` int(11) DEFAULT '3',
  `answered` int(11) DEFAULT '2',
  `content` longtext,
  `creator_id` int(11) NOT NULL,
  `question_category_id` int(11) DEFAULT NULL,
  `question_topic_id` varchar(45) DEFAULT NULL,
  `question_level_id` int(11) DEFAULT NULL,
  `total_mark` int(11) DEFAULT NULL,
  `mark` int(11) DEFAULT NULL,
  `isDeleted` int(11) NOT NULL DEFAULT '0',
  `created` bigint(20) NOT NULL DEFAULT '0',
  `modified` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz`
--

LOCK TABLES `quiz` WRITE;
/*!40000 ALTER TABLE `quiz` DISABLE KEYS */;
INSERT INTO `quiz` VALUES (1,'CSC8490 All Levels',3,2,2,'Generated by student1222',4,4,NULL,NULL,15,0,0,1469977879740,1469977897607),(2,'CSC8490 Tag test',4,1,2,'Generated by student1222',4,4,NULL,5,20,5,0,1469977962649,1469979273905),(3,'CSC8490 Tag test',2,1,2,'Generated by student1222',4,4,NULL,5,15,5,0,1469979594215,1470085447469),(4,'CSC8490 All Levels',3,1,2,'Generated by student1222',4,4,NULL,NULL,15,0,0,1470085528279,1470085535896),(5,'CSC8490 All Levels',3,2,2,'Generated by student1222',4,4,NULL,NULL,15,5,0,1470092356856,1470097944068),(6,'CSC8490 All Levels',4,3,2,'Generated by student1222',4,4,NULL,NULL,20,NULL,0,1470141842387,1470141843195),(7,'CSC8490 All Levels',3,3,2,'Generated by student1222',4,4,NULL,NULL,15,NULL,0,1470143827841,1470143828264),(8,'CSC8490 All Levels',3,3,2,'Generated by student1222',4,4,NULL,NULL,15,NULL,0,1470143833042,1470143833297),(9,'CSC8490 All Levels',3,3,2,'Generated by student1222',4,4,NULL,NULL,15,NULL,0,1470143835251,1470143835547),(10,'CSC8490 All Levels',4,3,2,'Generated by student1222',4,4,NULL,NULL,20,NULL,0,1470143845663,1470143845929),(11,'CSC8490 Tag test',4,3,2,'Generated by student1222',4,4,NULL,5,20,NULL,0,1470143850041,1470143850396),(12,'CSC8490 Tag test',4,1,2,'Generated by student1222',4,4,NULL,5,20,NULL,0,1470143855392,1470143855670),(13,'CSC8490 Tag test',4,1,2,'Generated by student1222',4,4,NULL,5,20,NULL,0,1470143858058,1470143858341),(14,'CSC8490 All Levels',3,2,2,'Generated by student1222',4,4,NULL,NULL,15,NULL,0,1470143890611,1470143890974),(15,'CSC8490 All Levels',3,2,2,'Generated by student1222',4,4,NULL,NULL,15,NULL,0,1470143893529,1470143894040),(16,'CSC8490 Tag test',3,2,2,'Generated by student1222',4,4,NULL,5,15,NULL,0,1470143897408,1470143897881),(17,'CSC8490 Tag test',4,3,2,'Generated by student1222',4,4,NULL,5,20,NULL,0,1470143904579,1470143905254),(18,'CSC8490 Tag test',4,1,2,'Generated by student1222',4,4,NULL,5,20,NULL,0,1470143907539,1470143908021),(19,'CSC8490 Tag test',4,1,2,'Generated by student1222',4,4,NULL,5,20,NULL,0,1470143910249,1470143910538),(20,'CSC8490 Tag test',4,1,2,'Generated by student1222',4,4,NULL,5,20,10,0,1470143923775,1470181074124),(21,'CSC8490 Tag test',4,1,2,'Generated by student1222',4,4,NULL,5,20,NULL,0,1470143926376,1470143927174),(22,'CSC8490 Tag test',3,1,2,'Generated by student1222',4,4,NULL,5,15,0,0,1470181112342,1470181350679);
/*!40000 ALTER TABLE `quiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quiz_question`
--

DROP TABLE IF EXISTS `quiz_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quiz_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quiz_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `mark` int(11) NOT NULL DEFAULT '0',
  `isDeleted` int(11) NOT NULL DEFAULT '0',
  `created` bigint(20) NOT NULL DEFAULT '0',
  `modified` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz_question`
--

LOCK TABLES `quiz_question` WRITE;
/*!40000 ALTER TABLE `quiz_question` DISABLE KEYS */;
INSERT INTO `quiz_question` VALUES (1,1,16,4,5,0,1469977879861,1469977879861),(2,1,18,4,5,0,1469977879938,1469977879938),(3,1,4,4,5,0,1469977879977,1469977879977),(4,2,19,4,5,0,1469977962746,1469977962746),(5,2,4,4,5,0,1469977962929,1469977962929),(6,2,12,4,5,0,1469977962976,1469977962976),(7,2,16,4,5,0,1469977963042,1469977963042),(8,3,12,4,5,0,1469979594309,1469979594309),(9,3,16,4,5,0,1469979594512,1469979594512),(10,3,4,4,5,0,1469979594551,1469979594551),(11,4,4,4,5,0,1470085528692,1470085528692),(12,4,18,4,5,0,1470085528806,1470085528806),(13,4,16,4,5,0,1470085528936,1470085528936),(14,5,19,4,5,0,1470092357144,1470092357144),(15,5,12,4,5,0,1470092357280,1470092357280),(16,5,4,4,5,0,1470092357342,1470092357342),(17,6,12,4,5,0,1470141842600,1470141842600),(18,6,19,4,5,0,1470141842828,1470141842828),(19,6,16,4,5,0,1470141842951,1470141842951),(20,6,4,4,5,0,1470141843018,1470141843018),(21,7,4,4,5,0,1470143828042,1470143828042),(22,7,16,4,5,0,1470143828127,1470143828127),(23,7,12,4,5,0,1470143828208,1470143828208),(24,8,16,4,5,0,1470143833127,1470143833127),(25,8,4,4,5,0,1470143833192,1470143833192),(26,8,19,4,5,0,1470143833234,1470143833234),(27,9,19,4,5,0,1470143835359,1470143835359),(28,9,12,4,5,0,1470143835414,1470143835414),(29,9,16,4,5,0,1470143835472,1470143835472),(30,10,12,4,5,0,1470143845719,1470143845719),(31,10,4,4,5,0,1470143845787,1470143845787),(32,10,19,4,5,0,1470143845841,1470143845841),(33,10,16,4,5,0,1470143845899,1470143845899),(34,11,16,4,5,0,1470143850090,1470143850090),(35,11,4,4,5,0,1470143850182,1470143850182),(36,11,18,4,5,0,1470143850260,1470143850260),(37,11,12,4,5,0,1470143850315,1470143850315),(38,12,12,4,5,0,1470143855463,1470143855463),(39,12,19,4,5,0,1470143855527,1470143855527),(40,12,4,4,5,0,1470143855575,1470143855575),(41,12,18,4,5,0,1470143855638,1470143855638),(42,13,19,4,5,0,1470143858127,1470143858127),(43,13,16,4,5,0,1470143858174,1470143858174),(44,13,12,4,5,0,1470143858212,1470143858212),(45,13,4,4,5,0,1470143858291,1470143858291),(46,14,4,4,5,0,1470143890792,1470143890792),(47,14,16,4,5,0,1470143890842,1470143890842),(48,14,19,4,5,0,1470143890918,1470143890918),(49,15,16,4,5,0,1470143893648,1470143893648),(50,15,18,4,5,0,1470143893846,1470143893846),(51,15,12,4,5,0,1470143893974,1470143893974),(52,16,16,4,5,0,1470143897499,1470143897499),(53,16,4,4,5,0,1470143897561,1470143897561),(54,16,12,4,5,0,1470143897826,1470143897826),(55,17,16,4,5,0,1470143904737,1470143904737),(56,17,12,4,5,0,1470143904891,1470143904891),(57,17,19,4,5,0,1470143905089,1470143905089),(58,17,18,4,5,0,1470143905188,1470143905188),(59,18,12,4,5,0,1470143907615,1470143907615),(60,18,4,4,5,0,1470143907668,1470143907668),(61,18,16,4,5,0,1470143907851,1470143907851),(62,18,18,4,5,0,1470143907907,1470143907907),(63,19,16,4,5,0,1470143910298,1470143910298),(64,19,4,4,5,0,1470143910355,1470143910355),(65,19,19,4,5,0,1470143910389,1470143910389),(66,19,18,4,5,0,1470143910448,1470143910448),(67,20,4,4,5,0,1470143923863,1470143923863),(68,20,18,4,5,0,1470143923920,1470143923920),(69,20,19,4,5,0,1470143924173,1470143924173),(70,20,16,4,5,0,1470143924204,1470143924204),(71,21,12,4,5,0,1470143926580,1470143926580),(72,21,16,4,5,0,1470143926803,1470143926803),(73,21,18,4,5,0,1470143926951,1470143926951),(74,21,4,4,5,0,1470143927018,1470143927018),(75,22,18,4,5,0,1470181112600,1470181112600),(76,22,4,4,5,0,1470181112721,1470181112721),(77,22,12,4,5,0,1470181112812,1470181112812);
/*!40000 ALTER TABLE `quiz_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quiz_record`
--

DROP TABLE IF EXISTS `quiz_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quiz_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quiz_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `quiz_question_id` int(11) DEFAULT NULL,
  `answer` longtext NOT NULL,
  `mark` int(11) NOT NULL,
  `isDeleted` int(11) NOT NULL DEFAULT '0',
  `created` bigint(20) NOT NULL DEFAULT '0',
  `modified` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz_record`
--

LOCK TABLES `quiz_record` WRITE;
/*!40000 ALTER TABLE `quiz_record` DISABLE KEYS */;
INSERT INTO `quiz_record` VALUES (1,20,4,67,'[{\"id\":\"blank_2\",\"answer\":\"ss\"},{\"id\":\"blank_3\",\"answer\":\"ff\"},{\"id\":\"blank_1\",\"answer\":\"gg\"},{\"id\":\"blank_4\",\"answer\":\"aa\"}]',0,0,1470178546730,1470180713567),(2,20,4,68,'[{\"id\":\"choice_1\",\"checked\":true}]',5,0,1470178785203,1470180888294),(3,20,4,69,'false',5,0,1470178788203,1470180698169),(4,20,4,70,'[{\"id\":\"choice_1\",\"checked\":true},{\"id\":\"choice_2\",\"checked\":true},{\"id\":\"choice_3\",\"checked\":true}]',0,0,1470178792869,1470180896327),(5,22,4,77,'[{\"id\":\"choice_2\",\"checked\":true}]',0,0,1470181119006,1470181346535),(6,22,4,76,'[{\"id\":\"blank_1\",\"answer\":\"ss\"},{\"id\":\"blank_2\",\"answer\":\"ff\"},{\"id\":\"blank_3\",\"answer\":\"sds\"},{\"id\":\"blank_4\",\"answer\":\"awd\"}]',0,0,1470181126664,1470181336300),(7,22,4,75,'[{\"id\":\"choice_3\",\"checked\":true}]',0,0,1470181130349,1470181326999);
/*!40000 ALTER TABLE `quiz_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) NOT NULL,
  `token` varchar(45) NOT NULL,
  `created` bigint(20) NOT NULL DEFAULT '0',
  `modified` bigint(20) NOT NULL DEFAULT '0',
  `expire` bigint(20) NOT NULL DEFAULT '0',
  `isDeleted` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `token_UNIQUE` (`token`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,1,'4c48e80e7d478cf99e4f1c353a95cbb0',1464296016296,1464296016296,1464382416296,0),(2,1,'1ab9a253815da1cfbd43fab52ab096b4',1464296070958,1464296206969,1464382606969,0),(3,1,'4e346349f3e5ad2adada8d6872ed3fd6',1464296100183,1464296100183,1464382500183,0),(4,1,'92b5af5c4590036eda7804322d71296d',1464296144708,1464296144708,1464382544708,0),(5,1,'12e96a75f3446d1688fedd5428d04890',1466270960723,1466270960723,1466357360723,0),(6,1,'b1aec78e08e7bff884971971ba1b4b19',1466270996635,1466270996635,1466357396635,0),(7,1,'9647860a788a49df7a5d74c71c4342c3',1466272097871,1466272097871,1466358497871,0),(8,1,'a1fc5149a6dae1977135f6aa0dc4a954',1466272248153,1466272248153,1466358648153,0),(9,1,'67d008f43116a78c564567d5f105465b',1466272344392,1466272344392,1466358744392,0),(10,1,'c7d667c9a1bcdda11582e155ed9933a1',1466272398581,1466272398581,1466358798581,0),(11,1,'3164f0ae96a44b97a26a1b6a371e7978',1466272533229,1466272533229,1466358933229,0),(12,4,'7f4593cdeec3646619dd42d92671ba29',1466273546019,1466273546019,1466359946019,0),(13,4,'dc603697ddb711434f5d788d5de3394c',1466273659184,1466273659184,1466360059184,0),(14,4,'e0d04bb0f6256a583a4133bac391a46',1466273669333,1466273669333,1466360069333,0),(15,4,'740babf4b296ffd852dd3737fbd18b1d',1466273768710,1466273768710,1466360168710,0),(16,4,'c02a64f25c0c5b4a84f2107757c8de72',1466273832731,1466273832731,1466360232731,0),(17,4,'4efeeab84e9b500d608a21e74828630f',1466279555568,1466279555568,1466365955568,0),(18,4,'224a3da2c245a5b0e85af4331316e43f',1466279750409,1466279750409,1466366150409,0),(19,4,'f0edd10f3e043ca85388e2ea8a87b644',1466279750664,1466279750664,1466366150664,0),(20,4,'5686c8b062005111d141ebd5bf716867',1466279809723,1466279809723,1466366209723,0),(21,4,'4a6d19e4d93a2bcce881258a80f325fb',1466285269228,1466285269228,1466371669228,0),(22,4,'4c4c1cb561925e24359fc0d6cb598600',1466285753163,1466285753163,1466372153163,0),(23,4,'8f65cf0254fa8c09756841010ee60dbe',1466286053859,1466286053859,1466372453859,0),(24,4,'ab61637eab0d534c2f269430bfb1d94c',1466286210845,1466286210845,1466372610845,0),(25,4,'f7c53cccd9afcbe2176e6f920c6d02ee',1466286781860,1466286781860,1466373181860,0),(26,4,'37e192da19fed855c0291edee7a98aeb',1466287040783,1466287040783,1466373440783,0),(27,4,'6960ee4c57f9f469e4433c0d38c1a21f',1466287115529,1466287115529,1466373515529,0),(28,4,'a4ce36a7ee9cea5b0ddc6c6ac97370eb',1466288256521,1466288256521,1466374656521,0),(29,4,'c69d43f896c8e7493936303eca285135',1466288673420,1466288673420,1466375073420,0),(30,4,'7c60327f8836ac2ee1a287752bb6eb19',1466294136290,1466294136290,1466380536290,0),(31,4,'aeff3d1f99a8a5cbf5cdb732ec148727',1466297000646,1466297000646,1466383400646,0),(32,4,'bd5628ef8800ecb14adb57fd6d747b4e',1466297200350,1466297200350,1466383600350,0),(33,4,'a6097a586c367e45d8e73fe7e83babae',1466297920853,1466297920853,1466384320853,0),(34,4,'27b26f278fdbbdb44b5f3de9640029e2',1466298151647,1466298151647,1466384551647,0),(35,4,'e0683dda22065b93803632646ea8036c',1466298270335,1466298270335,1466384670335,0),(36,4,'8b8f957337d6e3e44d95301422b439f6',1466298420721,1466298420721,1466384820721,0),(37,4,'84714b616d76509e5c343f5ffda91989',1466298424512,1466298424512,1466384824512,0),(38,4,'6b24da6ec77c34128d20f10b78fe2d04',1466298636583,1466298636583,1466385036583,0),(39,4,'b13403c5f9dcfa5772d7161401e42bac',1466298837743,1466298837743,1466385237743,0),(40,4,'778b87d9a70173ca0d16228b8f83b764',1466353835026,1466353835026,1466440235026,0),(41,4,'4462a6b385ae22b8f25f0ead5b773728',1466354806897,1466354806897,1466441206897,0),(42,4,'b4fd09a03c55d4552a548afddf931381',1466358512648,1466358512648,1466444912648,0),(43,4,'1e42a7ede45e68e666b5edbcca34ad51',1466359082450,1466359082450,1466445482450,0),(44,4,'e55fd540fea1ba754992464e1cb5e508',1466359342610,1466359342610,1466445742610,0),(45,4,'a074af2a214353eeabe5067ba64c8092',1466359509896,1466359509896,1466445909896,0),(46,4,'82042fc0495a13107f9ee6c674406078',1466359768252,1466359768252,1466446168252,0),(47,4,'58491e2c6745af2a3aa366ec16b472d3',1466360142047,1466360142047,1466446542047,0),(48,4,'f29773002abec201ee2b130f0322cf05',1466363116543,1466363116543,1466449516543,0),(49,4,'5553f9b3f1e6cd0513bf6dfb6ca01296',1466418861765,1466418861765,1466505261765,0),(50,4,'c67c17976c25405e362c6b5df645da4',1466418881885,1466418881885,1466505281885,0),(51,4,'6ebb2aa024eb47d5e9afe1ec72b67cb0',1466698620653,1466698620653,1466785020653,0),(52,4,'9a9e108cc3a3880e3f3455d775402e0d',1466703842890,1466703842890,1466790242890,0),(53,4,'f911652fc9763a8e7accabb1a24838ae',1466720245663,1466720245663,1466806645663,0),(54,4,'bb7f099b513740e6dc3c7a474b9ca7f7',1466724058211,1466724058211,1466810458211,0),(55,4,'c6ddf4b3ad050cf63d0e4ecc056e6603',1466724510491,1466724510491,1466810910491,0),(56,4,'1b4d9edaab5bb790349e4c3adda0f7eb',1466725634683,1466725634683,1466812034683,0),(57,4,'caad4905cbc36debc7c7f579c4445603',1466726005862,1466726005862,1466812405862,0),(58,4,'949b8417165bf5f4434ffdb6bc71be44',1466726245757,1466726245757,1466812645757,0),(59,4,'37a6cdcfc34292d62c534164a316ba99',1466727714319,1466727714319,1466814114319,0),(60,4,'d69d94eb9e7018518d63aa72b87ab829',1466728469497,1466728469497,1466814869497,0),(61,4,'6b3ad1dd90ad5ce3d399c9c2a07fdd4a',1466730870180,1466730870180,1466817270180,0),(62,4,'ff54a954deb0cd6173be84169598de6f',1466951945711,1466951945711,1467038345711,0),(63,4,'ed5824fc9cabba3d42d29510004ebe8f',1466963635976,1466963635976,1467050035976,0),(64,4,'94b7eaeda71af729548b504cd7c8f067',1466978693029,1466978693029,1467065093029,0),(65,4,'25952157b1d89c6874df6866bdaa2bf0',1467105513170,1467105513170,1467191913170,0),(66,4,'bacb900b11d9699d60729c9199622723',1467284281990,1467284281990,1467370681990,0),(67,4,'eea44a3dc54fe1bb8707868984fb59ed',1467289821033,1467289821033,1467376221033,0),(68,4,'d439b44ff71c0b23f1808119f46e8cbd',1467308961031,1467308961031,1467395361031,0),(69,4,'ccb5dc43b0f073469be02f2c5569a0c5',1467308961031,1467308961031,1467395361031,0),(70,4,'2fc2037c3c269b312d79da14bf6d5b03',1467309017117,1467309017117,1467395417117,0),(71,4,'4b785cae8ab624bc1a6bcbca60849af',1467457938442,1467457938442,1467544338442,0),(72,4,'26e67ea9966ad5c613a5c4d949e9a18a',1467458144269,1467458144269,1467544544269,0),(73,4,'46ca51b9025374cd4d70930771c19dd',1467458211725,1467458211725,1467544611725,0),(74,4,'db72bf677dfbdbe5c97481b2783f35af',1467459067557,1467459067557,1467545467557,0),(75,4,'251b7b23815a896267ad39451603f455',1467461012719,1467461012719,1467547412719,0),(76,4,'851810ce89e0402adc983908505828',1467462151034,1467462151034,1467548551034,0),(77,4,'b7e5d50e0a246a10f81de337bffbab7a',1467470963671,1467470963671,1467557363671,0),(78,4,'eb696d0044aae3a9adeb7dff0fe914d2',1467480289785,1467480289785,1467566689785,0),(79,4,'bff5cc479a89d4c1dab779e453b45183',1467482087284,1467482087284,1467568487284,0),(80,4,'70bfc88470da0b59f4e1e7d275774eda',1467540824389,1467540824389,1467627224389,0),(81,4,'cb6553e1c130f9bc5a8e473c382bb46b',1467541316282,1467541316282,1467627716282,0),(82,4,'24d6031609bd0478d0148d0c59374d7e',1467542265587,1467542265587,1467628665587,0),(83,4,'d6fca06c2a86703bf4ea9b1fe6366715',1467543108211,1467543108211,1467629508211,0),(84,4,'8df0e08bea6d9aa6ba5c33d4ffbfc921',1467543493672,1467543493672,1467629893672,0),(85,4,'1bd40dcbdcd8397b98667d604e1915c4',1467544259479,1467544259479,1467630659479,0),(86,4,'8148d6ea91d30b58ea94213a08952bfd',1467544889052,1467544889052,1467631289052,0),(87,4,'a88371afa7fd0d3cf802c2f248923e4',1467566937957,1467566937957,1467653337957,0),(88,4,'26740177598dc32985584ca793f5c94f',1467567088359,1467567088359,1467653488359,0),(89,4,'93592c1b91b0747c2a43f7ed3ff64ea2',1467567481426,1467567481426,1467653881426,0),(90,4,'427a305ea40c9d1d52c2426b2d646dd1',1467567529932,1467567529932,1467653929932,0),(91,4,'76752ab0324ff17783e84b4241e8fcc9',1467567602074,1467567602074,1467654002074,0),(92,4,'ea168743206a8ae0cd910e891e982360',1467572094604,1467572094604,1467658494604,0),(93,4,'faeda6191f4ad2a5b81d0bad98d3393a',1467901323396,1467901323396,1467987723396,0),(94,4,'e8f03a8caf47083b7ca375c2b2886aa6',1467936320404,1467936320404,1468022720404,0),(95,4,'d2e2b1e36aead3b0266a43d7a4dd5152',1467940498046,1467940498046,1468026898046,0),(96,4,'112ce9e66e61955e539b1cf650161457',1468232651956,1468232651956,1468319051956,0),(97,4,'a44fd7cbde48ba926ad46288d94fbd72',1468239234471,1468239234471,1468325634471,0),(98,4,'6b70835f8b3de622203a6fd35cb9c42f',1469023149510,1469023149510,1469109549510,0),(99,4,'2c8e5c07d014e947bf6c9fa9e15b738d',1469537827001,1469537827001,1469624227001,0),(100,4,'9a4375f0e13b2ff1f0c99819d84a290e',1469538953872,1469538953872,1469625353872,0),(101,4,'e208893d0c484fbf9796bd32ebdb1a58',1469539185617,1469539185617,1469625585617,0),(102,4,'c99b9504c20d3dba14727ebb8a77cd7c',1469630274083,1469630274083,1469716674083,0),(103,4,'a323a52109fc2b34bc6d942714af5695',1469632296564,1469632296564,1469718696564,0),(104,4,'a2704ec09ca83fb5b4ca22ea847c91df',1469648598080,1469648598080,1469734998080,0),(105,4,'bf82cbf008cf800ded97aacaaca5658d',1469649271947,1469649271947,1469735671947,0),(106,4,'276f03f671953966891b2cdf1a8bd6cf',1469704531647,1469704531647,1469790931647,0),(107,4,'8fb000fbe73a4c1db6f74ce7354b3e26',1469800669899,1469800669899,1469887069899,0),(108,4,'960dedabcbfeaf41536546e3a5e25f5',1469802139148,1469802139148,1469888539148,0),(109,4,'56afcc848a1c48bc2fe1bd7f7c96e263',1469809707005,1469809707005,1469896107005,0),(110,4,'862ecb945f1104002cff929d3c42c115',1469825697535,1469825697535,1469912097535,0),(111,4,'5895c023aa4876b8966c300e46f3afb0',1469826301063,1469826301063,1469912701063,0),(112,4,'a5771e105ed6b4046c80a19dfec561c2',1469828989243,1469828989243,1469915389243,0),(113,4,'4d2dc5baca52b2e3b7e9a6abc40a9ab',1469829813114,1469829813114,1469916213114,0),(114,4,'7ac270e940f6d2b6d1404128a9b6d0fe',1469968778507,1469968778507,1470055178507,0),(115,4,'afca4f73ab4ce799b93ce369a53ff300',1469977230493,1469977230493,1470063630493,0),(116,4,'3f409693c946cdc8cd1691b2404247e8',1469977654183,1469977654183,1470064054183,0),(117,4,'ee0cad07f9f496f717ed71e39ec1b170',1470058365858,1470058365858,1470144765858,0),(118,4,'23cf21e6facb9e6d0d8a2eb8701a4c75',1470139055476,1470139055476,1470225455476,0),(119,4,'f648fd4cefb33ae114bdf645b8a579ee',1470146627402,1470146627402,1470233027402,0),(120,4,'84c96d1c3ab675c399187a74f8d92e8f',1470167334038,1470167334038,1470253734038,0),(121,4,'54a6ffea7863798f5ec7e5e6680aaaeb',1470167834056,1470167834056,1470254234056,0);
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
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
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `type` int(11) NOT NULL DEFAULT '2',
  `created` bigint(20) NOT NULL DEFAULT '0',
  `modified` bigint(20) NOT NULL DEFAULT '0',
  `isDeleted` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin',NULL,'admin','administrator',1,1462798345400,1462798345400,0),(2,'user','tommyjing0620@gmail.com','user','testuser',2,1462798345405,1469531436804,0),(3,'user1','tommyjing0620@gmail.com','user','testuser',2,1462798525735,1469056031590,0),(4,'student','ww1333@gmail.com','student','student1222',3,1462798525735,1469539234074,0),(5,'user0',NULL,'user0','testuser0',3,1464025496306,1464027379558,0),(6,'user2',NULL,'user2','testuser2',3,1464025496518,1464027497950,0),(7,'user3',NULL,'user3','testuser3',3,1464025496743,1464025496743,0),(8,'user4',NULL,'user4','testuser4',3,1464025496819,1464025496819,0),(9,'user5',NULL,'user5','testuser5',3,1464025497009,1464025497009,0),(10,'user6',NULL,'user6','testuser6',3,1464025497099,1464025497099,0),(11,'user7',NULL,'user7','testuser7',3,1464025497161,1464025497161,0),(12,'user8',NULL,'user8','testuser8',3,1464025497209,1464025497209,0),(13,'user9',NULL,'user9','testuser9',3,1464025497240,1464026902923,0),(14,'user10',NULL,'user10','testuser10',3,1464025497285,1464026879706,0),(15,'user11','tommyjing0620@gmail.com','user11','testuser11',3,1464025497317,1469056147365,0),(16,'user12','tommyjing0620@gmail.com','user12','testuser12',3,1464025497350,1469056139906,0),(17,'user13','tommyjing0620@gmail.com','user13','testuser13',3,1464025497397,1469056132243,0),(18,'user14','tommyjing0620@gmail.com','user14','testuser14',3,1464025497439,1469056126209,0),(19,'user15','aw@gmail.com','user15','testuser15',3,1464025497485,1469056119047,0),(20,'user16','tommyjing0620@gmail.com','user16','testuser16',3,1464025497617,1469056110317,0),(21,'user17',NULL,'user17','testuser17',3,1464025497695,1464040674545,1),(22,'user18',NULL,'user18','testuser18',3,1464025497726,1464040551597,1),(23,'user19',NULL,'user19','testuser19',3,1464025497775,1464040505461,1),(24,'teac','tea1@gmail.com','123456','tea1',2,1464043074654,1469056020305,0),(25,'teac1','tea1@gmail.com','123456','tea1',2,1464043139778,1469056015294,0),(26,'tec2','tea2@gmail.com','123456','tea1',1,1464043163244,1464043163244,0),(27,'teacher2','tea1@gmail.com','123456','tea1',1,1464043257637,1469051298922,0),(28,'teac2','tea1@gmail.com','123456','tea1',2,1464043368669,1469056008560,0),(29,'tete','eta@gmai.com','123456','te12',3,1464043634252,1469055999270,0),(30,'teajiof','fga@gmai.com','fjaeo','goae',2,1469048582628,1469048582628,0),(31,'ceshio','fjaoi1w@fgja1o.com','fjawio1','fjoaiw1',3,1469057840144,1469057981047,0),(32,'sb123','asb@gmail.com','sb12','sb',3,1469530661491,1469530673758,0);
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

-- Dump completed on 2016-08-03  1:02:46
