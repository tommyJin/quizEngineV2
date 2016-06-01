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
  `question_tag` varchar(225) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'test1','1+1=<input type=\"button\" id=\"blank_1\" value=\"blank_1\" disabled=\"disabled\" />;2+2=<input type=\"button\" id=\"blank_2\" value=\"blank_2\" disabled=\"disabled\" />;1*0=<input type=\"button\" id=\"blank_3\" value=\"blank_3\" disabled=\"disabled\" />','[{\"id\":\"blank_1\",\"val\":\"2\"},{\"id\":\"blank_2\",\"val\":\"4\"},{\"id\":\"blank_3\",\"val\":\"0\"}]','tag1',1,6,1,3,'this is feed back&nbsp;',0,1464717637293,1464717933124),(2,'test2','<input type=\"button\" id=\"blank_1\" value=\"blank_1\" disabled=\"disabled\" />aaaa','[]','ttt',4,2,3,2,'fff',0,1464787780920,1464787780920),(3,'test e','cccccc<input type=\"button\" id=\"blank_1\" value=\"blank_1\" disabled=\"disabled\" />','[]','ttttt',2,2,2,1,'fffffff',0,1464788032877,1464788032877),(4,'b1test','cccc<input type=\"button\" id=\"blank_1\" value=\"blank_1\" disabled=\"disabled\" /><input type=\"button\" id=\"blank_2\" value=\"blank_2\" disabled=\"disabled\" /><input type=\"button\" id=\"blank_3\" value=\"blank_3\" disabled=\"disabled\" /><input type=\"button\" id=\"blank_4\" value=\"blank_4\" disabled=\"disabled\" />','[{\"id\":\"blank_1\",\"answer\":\"b1\",\"feedback\":\"bbbbbbbbbbbbbb1\"},{\"id\":\"blank_2\",\"answer\":\"b2\",\"feedback\":\"<span style=\\\"white-space:normal;\\\">bbbbbbbbbbbbbb</span>2\"},{\"id\":\"blank_3\",\"answer\":\"b3\",\"feedback\":\"<span style=\\\"white-space:normal;\\\">bbbbbbbbbbbbbb</span>3\"},{\"id\":\"blank_4\",\"answer\":\"b4\",\"feedback\":\"<span style=\\\"white-space:normal;\\\">bbbbbbbbbbbbbb</span>4\"}]','ttt',5,2,4,5,'fffff',0,1464797487839,1464800073910),(5,'cb','ccccc<input type=\"button\" id=\"blank_1\" value=\"blank_1\" disabled=\"disabled\" />','[{\"id\":\"blank_1\",\"answer\":\"bbbb1\"},{\"id\":\"blank_1\",\"answer\":\"fffffff1\"}]','ttt',3,6,2,3,'fffff',0,1464800216653,1464800216653),(6,'cb2','ccccc<input type=\"button\" id=\"blank_1\" value=\"blank_1\" disabled=\"disabled\" /><input type=\"button\" id=\"blank_2\" value=\"blank_2\" disabled=\"disabled\" /><input type=\"button\" id=\"blank_3\" value=\"blank_3\" disabled=\"disabled\" />','[{\"id\":\"blank_1\",\"answer\":\"b1\",\"feedback\":\"f1\"},{\"id\":\"blank_2\",\"answer\":\"b2\",\"feedback\":\"f2\"},{\"id\":\"blank_3\",\"answer\":\"b3\",\"feedback\":\"f3\"}]','tttt',1,6,1,3,'fffff',0,1464800512364,1464800599818),(7,'tf1','ccccc','{\"true_content\":\"this is true\",\"false_content\":\"this is false\",\"right\":\"false\"}','ttt',2,5,3,2,'fffff',0,1464802527837,1464802587370),(8,'tf21','cccccc1','{\"true_content\":\"this is true1\",\"false_content\":\"this is false1\",\"feedback_true\":\"this is true ff1\",\"feedback_false\":\"this is false feedback1\",\"right\":\"false\"}','ttt11',2,5,2,41,'ffffffff1',0,1464802727891,1464803307286);
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_category`
--

LOCK TABLES `question_category` WRITE;
/*!40000 ALTER TABLE `question_category` DISABLE KEYS */;
INSERT INTO `question_category` VALUES (1,'CSC8487','CSC8487 content',0,1463346149229,1463346149229),(2,'CSC8488','CSC8488 content',0,1463346149400,1463346149400),(3,'CSC8489','CSC8489 content',0,1463346149453,1463346149453),(4,'CSC8490','CSC8490 content1',0,1463346149508,1464051817818),(5,'CSC1234','1d65aw165fw',1,1464051911946,1464052132416),(6,'CSC1234','1d65aw165fw',1,1464051922710,1464052129382),(7,'CSC123456','a1d6w5af6w',1,1464052141191,1464052163488),(8,'CSC123456','a1d6w5af6w1',1,1464052145077,1464052162120),(9,'CSC12345','1f6cwaf165wa',1,1464052184902,1464052549303),(10,'CSC333','a1wdf6wa16f5',1,1464052467593,1464052547858),(11,'CSC222','f16wa5f222',1,1464052517079,1464052546377),(12,'aaa','bbb',1,1464371152894,1464371173215),(13,'aaa','ddd',1,1464371306359,1464371314825);
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_choice`
--

LOCK TABLES `question_choice` WRITE;
/*!40000 ALTER TABLE `question_choice` DISABLE KEYS */;
INSERT INTO `question_choice` VALUES (1,1,'[{\"id\":\"blank_1\"},{\"id\":\"blank_2\"},{\"id\":\"blank_3\"}]',0,1464717637372,1464717933157),(2,2,'[]',0,1464787781089,1464787781089),(3,3,'[]',0,1464788032935,1464788032935),(4,4,'[{\"id\":\"blank_1\"},{\"id\":\"blank_2\"},{\"id\":\"blank_3\"},{\"id\":\"blank_4\"}]',0,1464797487918,1464800073964),(5,5,'[{\"id\":\"blank_1\"},{\"id\":\"blank_1\"}]',0,1464800216709,1464800216709),(6,6,'[{\"id\":\"blank_1\"},{\"id\":\"blank_2\"},{\"id\":\"blank_3\"}]',0,1464800512508,1464800599883),(7,7,'{\"true_content\":\"this is true\",\"false_content\":\"this is false\"}',0,1464802527897,1464802587457),(8,8,'{\"true_content\":\"this is true1\",\"false_content\":\"this is false1\"}',0,1464802727954,1464803307341);
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
-- Table structure for table `question_tag`
--

DROP TABLE IF EXISTS `question_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `content` longtext,
  `isDeleted` int(11) NOT NULL DEFAULT '0',
  `created` bigint(20) NOT NULL DEFAULT '0',
  `modified` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_tag`
--

LOCK TABLES `question_tag` WRITE;
/*!40000 ALTER TABLE `question_tag` DISABLE KEYS */;
INSERT INTO `question_tag` VALUES (1,'Cloud computing','Cloud computing content',0,1463346263792,1463346263792),(2,'Java','Java content',0,1463346263953,1463346263953),(3,'Spark','Spark content',0,1463346264005,1463346264005),(4,'Kafka','Kafka content',0,1463346264105,1463346264105),(5,'Big data','Big data content',0,1463346264159,1463346264159),(6,'SPIN','SPIN content1',0,1463346264204,1464053065446),(7,'NodeJs','node js',1,1464053092662,1464053102885),(8,'Tag test','jfaowijgioaw1',1,1464074131727,1464074266715),(9,'Tag test','tawtwa',1,1464074182026,1464074264864);
/*!40000 ALTER TABLE `question_tag` ENABLE KEYS */;
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
INSERT INTO `question_type` VALUES (1,'Fill in Multiple Blanks','Fill in Multiple Blanks content',0,1463347838573,1463347838573),(2,'Fill in the Blank','Fill in the Blank content',0,1463347838822,1463347838822),(3,'Multiple Answer','Multiple Answer content',0,1463347838884,1463347838884),(4,'Multiple Choice','Multiple Choice content',1,1463347838999,1463347839222),(5,'True Or False','True Or False content',0,1463347839055,1463347839055),(6,'Calculate Numeric','Calculate Numeric content',0,1463347839099,1463347839099);
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
  `content` longtext,
  `creator_id` int(11) NOT NULL,
  `question_level_id` int(11) NOT NULL,
  `question_category_id` int(11) DEFAULT NULL,
  `mark` int(11) NOT NULL DEFAULT '0',
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
INSERT INTO `quiz` VALUES (1,'quiz 1','quiz 1 content',1,3,NULL,5,0,1463353536273,1463353536273),(2,'quiz 2','quiz 2 content',1,2,NULL,5,0,1463353536439,1463353536439),(3,'quiz 3','quiz 3 content',2,3,NULL,5,0,1463353536631,1463353536631),(4,'quiz 4.1','quiz 4 content1',1,4,NULL,5,1,1463353536858,1463353852316),(5,'quiz 5','quiz 5 content',1,4,NULL,5,0,1463353536910,1463353536910),(6,'CSC8488 Normal student1 ','self generated',4,2,2,100,0,1463419872497,1463419872497),(7,'CSC8487 Hard student1 ','self generated',4,3,1,100,0,1463420318192,1463420318192),(8,'CSC8487 Hard student1 ','self generated',4,3,1,50,0,1463420436116,1463420436116),(9,'CSC8487 Hard student1','Generated by student1',4,3,1,0,0,1463421413887,1463421413887),(10,NULL,NULL,2,2,2,0,0,1463436225140,1463436225140),(11,'CSC8488 Hard testuser','Generated by testuser',2,3,2,0,0,1463436326499,1463436326499),(12,'CSC8487 Hard testuser','Generated by testuser',2,3,1,0,0,1463436775784,1463436775784),(13,'CSC8487 Hard testuser','Generated by testuser',2,3,1,0,0,1463437016650,1463437016650),(14,'CSC8487 Hard student1','Generated by student1',4,3,1,0,0,1463437609477,1463437609477),(15,'CSC8487 Hard student1','Generated by student1',4,3,1,0,0,1463439449246,1463439449246),(16,'CSC8487 Hard testuser','Generated by testuser',2,3,1,0,0,1463439599437,1463439599437),(17,'wawwa','wagawg',2,2,1,0,0,1464079273298,1464079273298),(18,'test2','aaa2',2,3,3,0,0,1464079434568,1464079603344),(19,'test3','aaaa3',2,1,2,0,0,1464079636770,1464079636770),(20,'test4','aaaa4',2,1,2,0,0,1464079805243,1464079805243),(21,'test5','aaaaa5',2,1,2,0,0,1464079852575,1464079852575),(22,'aaa','aaaaa<img src=\"/pic/user/20160527200859_876.jpg\" alt=\"\" />',2,4,4,0,0,1464374812866,1464376143296);
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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz_question`
--

LOCK TABLES `quiz_question` WRITE;
/*!40000 ALTER TABLE `quiz_question` DISABLE KEYS */;
INSERT INTO `quiz_question` VALUES (1,15,30,4,13,0,1463439495400,1463439495400),(2,15,74,4,15,0,1463439495488,1463439495488),(3,15,14,4,51,0,1463439495524,1463443339028),(4,15,5,4,14,0,1463439495631,1463439495631),(5,15,70,4,4,0,1463439495669,1463439495669),(6,16,5,2,14,0,1463439617403,1463439617403),(7,16,74,2,15,0,1463439617460,1463439617460),(8,16,50,2,4,0,1463439617544,1463439617544),(9,16,70,2,4,0,1463439617625,1463439617625),(10,16,66,2,1,0,1463439617699,1463439617699),(11,16,43,2,17,0,1463439617747,1463439617747),(12,19,75,2,2,0,1464079637719,1464079637719),(13,19,35,2,0,0,1464079637795,1464079637795),(14,19,13,2,12,0,1464079637841,1464079637841),(15,20,75,2,2,0,1464079806347,1464079806347),(16,20,45,2,8,0,1464079806412,1464079806412),(17,20,35,2,0,0,1464079806457,1464079806457),(18,20,25,2,13,0,1464079806501,1464079806501),(19,21,35,2,0,0,1464079853884,1464079853884),(20,21,45,2,8,0,1464079853936,1464079853936),(21,21,25,2,13,0,1464079853992,1464079853992),(22,21,9,2,6,0,1464079854024,1464079854024);
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz_record`
--

LOCK TABLES `quiz_record` WRITE;
/*!40000 ALTER TABLE `quiz_record` DISABLE KEYS */;
INSERT INTO `quiz_record` VALUES (1,1,1,1,'true',5,0,1463355615059,1463355615059),(2,1,1,2,'Text',5,0,1463355615227,1463355615227),(3,1,1,3,'true',5,0,1463355615286,1463355615286),(4,2,1,4,'Text',5,1,1463355615407,1463355693145),(5,1,1,5,'true',5,0,1463355615495,1463355615495),(6,15,4,3,'123',17,0,1463442304626,1463442304626),(7,15,4,3,'123',0,0,1463442388514,1463442388514),(8,15,4,3,'123',0,0,1463442974808,1463442974808),(9,15,4,3,'123',0,0,1463443339085,1463443339085);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,1,'4c48e80e7d478cf99e4f1c353a95cbb0',1464296016296,1464296016296,1464382416296,0),(2,1,'1ab9a253815da1cfbd43fab52ab096b4',1464296070958,1464296206969,1464382606969,0),(3,1,'4e346349f3e5ad2adada8d6872ed3fd6',1464296100183,1464296100183,1464382500183,0),(4,1,'92b5af5c4590036eda7804322d71296d',1464296144708,1464296144708,1464382544708,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin',NULL,'admin','administrator',1,1462798345400,1462798345400,0),(2,'user',NULL,'user','testuser',2,1462798345405,1462798345405,0),(3,'user1',NULL,'user','testuser',2,1462798525735,1462798525735,0),(4,'student',NULL,'student','student1',3,1462798525735,1464027523714,1),(5,'user0',NULL,'user0','testuser0',3,1464025496306,1464027379558,1),(6,'user2',NULL,'user2','testuser2',3,1464025496518,1464027497950,1),(7,'user3',NULL,'user3','testuser3',3,1464025496743,1464025496743,0),(8,'user4',NULL,'user4','testuser4',3,1464025496819,1464025496819,0),(9,'user5',NULL,'user5','testuser5',3,1464025497009,1464025497009,0),(10,'user6',NULL,'user6','testuser6',3,1464025497099,1464025497099,0),(11,'user7',NULL,'user7','testuser7',3,1464025497161,1464025497161,0),(12,'user8',NULL,'user8','testuser8',3,1464025497209,1464025497209,0),(13,'user9',NULL,'user9','testuser9',3,1464025497240,1464026902923,0),(14,'user10',NULL,'user10','testuser10',3,1464025497285,1464026879706,0),(15,'user11',NULL,'user11','testuser11',3,1464025497317,1464025497317,0),(16,'user12',NULL,'user12','testuser12',3,1464025497350,1464025497350,0),(17,'user13',NULL,'user13','testuser13',3,1464025497397,1464025497397,0),(18,'user14',NULL,'user14','testuser14',3,1464025497439,1464025497439,0),(19,'user15',NULL,'user15','testuser15',3,1464025497485,1464025497485,0),(20,'user16',NULL,'user16','testuser16',3,1464025497617,1464025497617,0),(21,'user17',NULL,'user17','testuser17',3,1464025497695,1464040674545,1),(22,'user18',NULL,'user18','testuser18',3,1464025497726,1464040551597,1),(23,'user19',NULL,'user19','testuser19',3,1464025497775,1464040505461,1),(24,'teac','tea1@gmail.com','123456','tea1',2,1464043074654,1464043074654,0),(25,'teac1','tea1@gmail.com','123456','tea1',2,1464043139778,1464043139778,0),(26,'tec2','tea2@gmail.com','123456','tea1',1,1464043163244,1464043163244,0),(27,'teacher2','tea1@gmail.com','123456','tea1',1,1464043257637,1464043257637,0),(28,'teac2','tea1@gmail.com','123456','tea1',2,1464043368669,1464043368669,0),(29,'tete','eta@gmai.com','123456','te12',3,1464043634252,1464044056863,0);
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

-- Dump completed on 2016-06-01 20:17:28
