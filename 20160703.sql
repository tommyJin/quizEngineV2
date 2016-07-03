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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'test1','1+1=<input type=\"button\" id=\"blank_1\" value=\"blank_1\" disabled=\"disabled\" />;2+2=<input type=\"button\" id=\"blank_2\" value=\"blank_2\" disabled=\"disabled\" />;1*0=<input type=\"button\" id=\"blank_3\" value=\"blank_3\" disabled=\"disabled\" />','[{\"id\":\"blank_1\",\"val\":\"2\"},{\"id\":\"blank_2\",\"val\":\"4\"},{\"id\":\"blank_3\",\"val\":\"0\"}]','tag1',1,6,1,3,'this is feed back&nbsp;',0,1464717637293,1464717933124),(2,'test2','<input type=\"button\" id=\"blank_1\" value=\"blank_1\" disabled=\"disabled\" />aaaa','[]','ttt',4,2,3,2,'fff',0,1464787780920,1464787780920),(3,'test e','cccccc<input type=\"button\" id=\"blank_1\" value=\"blank_1\" disabled=\"disabled\" />','[]','ttttt',2,2,2,1,'fffffff',0,1464788032877,1464788032877),(4,'b1test','cccc<input type=\"button\" id=\"blank_1\" value=\"blank_1\" disabled=\"disabled\" /><input type=\"button\" id=\"blank_2\" value=\"blank_2\" disabled=\"disabled\" /><input type=\"button\" id=\"blank_3\" value=\"blank_3\" disabled=\"disabled\" /><input type=\"button\" id=\"blank_4\" value=\"blank_4\" disabled=\"disabled\" />','[{\"id\":\"blank_1\",\"answer\":\"b1\",\"feedback\":\"bbbbbbbbbbbbbb1\"},{\"id\":\"blank_2\",\"answer\":\"b2\",\"feedback\":\"<span style=\\\"white-space:normal;\\\">bbbbbbbbbbbbbb</span>2\"},{\"id\":\"blank_3\",\"answer\":\"b3\",\"feedback\":\"<span style=\\\"white-space:normal;\\\">bbbbbbbbbbbbbb</span>3\"},{\"id\":\"blank_4\",\"answer\":\"b4\",\"feedback\":\"<span style=\\\"white-space:normal;\\\">bbbbbbbbbbbbbb</span>4\"}]','ttt',5,2,4,5,'fffff',0,1464797487839,1464800073910),(5,'cb','ccccc<input type=\"button\" id=\"blank_1\" value=\"blank_1\" disabled=\"disabled\" />','[{\"id\":\"blank_1\",\"answer\":\"bbbb1\"},{\"id\":\"blank_1\",\"answer\":\"fffffff1\"}]','ttt',3,6,2,3,'fffff',0,1464800216653,1464800216653),(6,'cb2','ccccc<input type=\"button\" id=\"blank_1\" value=\"blank_1\" disabled=\"disabled\" /><input type=\"button\" id=\"blank_2\" value=\"blank_2\" disabled=\"disabled\" /><input type=\"button\" id=\"blank_3\" value=\"blank_3\" disabled=\"disabled\" />','[{\"id\":\"blank_1\",\"answer\":\"b1\",\"feedback\":\"f1\"},{\"id\":\"blank_2\",\"answer\":\"b2\",\"feedback\":\"f2\"},{\"id\":\"blank_3\",\"answer\":\"b3\",\"feedback\":\"f3\"}]','tttt',1,6,1,3,'fffff',0,1464800512364,1464800599818),(7,'tf1','ccccc','{\"true_content\":\"this is true\",\"false_content\":\"this is false\",\"right\":\"false\"}','ttt',2,5,3,2,'fffff',0,1464802527837,1464802587370),(8,'tf21','cccccc1','{\"true_content\":\"this is true1\",\"false_content\":\"this is false1\",\"feedback_true\":\"this is true ff1\",\"feedback_false\":\"this is false feedback1\",\"right\":\"false\"}','ttt11',2,5,2,41,'ffffffff1',0,1464802727891,1464803307286),(9,'mc1','ccccccccc','[{\"id\":\"choice_1\",\"choice\":\"c1\",\"feedback\":\"f1\",\"isRight\":true},{\"id\":\"choice_2\",\"choice\":\"c2\",\"feedback\":\"f2\",\"isRight\":false},{\"id\":\"choice_3\",\"choice\":\"c3\",\"feedback\":\"f3\",\"isRight\":false},{\"id\":\"choice_4\",\"choice\":\"c4\",\"feedback\":\"f4\",\"isRight\":false}]','ttt',4,4,3,53,'ffff',0,1464813060034,1464815410380),(10,'mc2','fwafwafwa','[{\"id\":\"choice_1\",\"choice\":\"waerac1\",\"feedback\":\"fwafwaf1\",\"isRight\":false},{\"id\":\"choice_2\",\"choice\":\"fwadfadc2\",\"feedback\":\"fgawgwadf2\",\"isRight\":false},{\"id\":\"choice_3\",\"choice\":\"fwafwagwavc3\",\"feedback\":\"fwagwaedwaf4faf3\",\"isRight\":false}]','gwagaw',1,4,1,11,'fwafwa',0,1464815599732,1464815599732),(11,'mc3','fwafawgwa','[{\"id\":\"choice_1\",\"choice\":\"fwagwac1\",\"feedback\":\"fawgwaf1\",\"isRight\":false},{\"id\":\"choice_2\",\"choice\":\"fwagwavc2\",\"feedback\":\"fawgwafcf2\",\"isRight\":false},{\"id\":\"choice_3\",\"choice\":\"gwagawdc3\",\"feedback\":\"fawgawdaf3\",\"isRight\":false},{\"id\":\"choice_4\",\"choice\":\"fawgawvc4fwagwac4\",\"feedback\":\"gawdafwaff4\",\"isRight\":false},{\"id\":\"choice_5\",\"choice\":\"gagwadac5\",\"feedback\":\"fgawgawdf5\",\"isRight\":false}]','gawgaw',4,4,3,12,'fwafwa',0,1464815731867,1464815731867),(12,'mc6','1','[{\"id\":\"choice_1\",\"choice\":\"12312\",\"feedback\":\"4214\",\"isRight\":true},{\"id\":\"choice_2\",\"choice\":\"4123\",\"feedback\":\"14124\",\"isRight\":false}]','1',5,4,4,5,'1',0,1464816219480,1464816254833),(13,'fill in blank','fwafwa<input type=\"button\" id=\"blank_1\" value=\"blank_1\" disabled=\"disabled\" />4645','[{\"id\":\"blank_1\",\"answer\":\"36\",\"feedback\":\"f1rfwaf\"}]','ttt',5,2,4,3,'fff',0,1464817668578,1464817830226),(14,'mc6','fawfawgwa','[{\"id\":\"choice_1\",\"choice\":\"fwaf\",\"feedback\":\"awfgwag\",\"isRight\":false},{\"id\":\"choice_2\",\"choice\":\"gwada\",\"feedback\":\"awgawga\",\"isRight\":true},{\"id\":\"choice_3\",\"choice\":\"awfawga\",\"feedback\":\"gawgawd\",\"isRight\":true},{\"number\":\"2\"}]','tawtgwa',2,4,1,5,'fawf',0,1464818536892,1464818536892),(15,'mc7','fwaf','\"[[object Object]]\"','gwa',5,4,4,5,'faw',0,1464819135319,1464819135319),(16,'gagdaw','gwagwa','[{\"id\":\"choice_1\",\"choice\":\"wa\",\"feedback\":\"gwa\",\"number\":{\"number\":\"1\"},\"isRight\":false},{\"id\":\"choice_2\",\"choice\":\"wdad\",\"feedback\":\"gwa\",\"number\":{\"number\":\"1\"},\"isRight\":true},{\"id\":\"choice_3\",\"choice\":\"dwa\",\"feedback\":\"gwag\",\"number\":{\"number\":\"1\"},\"isRight\":false}]','gwa',5,4,4,5,'fwadwa',0,1464820373795,1464820373795),(17,'gwa','wfagaw','[{\"id\":\"choice_1\",\"choice\":\"fwaf\",\"feedback\":\"gwa\",\"number\":\"1\",\"isRight\":false},{\"id\":\"choice_2\",\"choice\":\"gawf\",\"feedback\":\"gwasdwa\",\"number\":\"1\",\"isRight\":true},{\"id\":\"choice_3\",\"choice\":\"gwagwa\",\"feedback\":\"gwaga\",\"number\":\"1\",\"isRight\":true}]','gwad',5,4,4,5,'waf',0,1464820445407,1464820558823),(18,'mc9','gwaga','[{\"id\":\"choice_1\",\"choice\":\"fwaga\",\"feedback\":\"wdwagaw\",\"number\":\"1\",\"isRight\":true},{\"id\":\"choice_2\",\"choice\":\"gwa\",\"feedback\":\"dawga\",\"number\":\"1\",\"isRight\":false},{\"id\":\"choice_3\",\"choice\":\"gawd\",\"feedback\":\"gwagaw\",\"number\":\"1\",\"isRight\":false}]','wsdwa',5,4,4,5,'fwaf',0,1464820767915,1464820803199);
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_category`
--

LOCK TABLES `question_category` WRITE;
/*!40000 ALTER TABLE `question_category` DISABLE KEYS */;
INSERT INTO `question_category` VALUES (1,'CSC8487','CSC8487 content',0,1463346149229,1463346149229),(2,'CSC8488','CSC8488 content',0,1463346149400,1463346149400),(3,'CSC8489','CSC8489 content',0,1463346149453,1463346149453),(4,'CSC8490','CSC8490 content1',0,1463346149508,1464051817818),(5,'CSC1234','1d65aw165fw',1,1464051911946,1464052132416),(6,'CSC1234','1d65aw165fw',1,1464051922710,1464052129382),(7,'CSC123456','a1d6w5af6w',1,1464052141191,1464052163488),(8,'CSC123456','a1d6w5af6w1',1,1464052145077,1464052162120),(9,'CSC12345','1f6cwaf165wa',1,1464052184902,1464052549303),(10,'CSC333','a1wdf6wa16f5',1,1464052467593,1464052547858),(11,'CSC222','f16wa5f222',1,1464052517079,1464052546377),(12,'aaa','bbb',1,1464371152894,1464371173215),(13,'aaa','ddd',1,1464371306359,1464371314825),(14,'CSC8499','To be able to demonstrate: - problem solving skills related to the project chosen. - written and oral communication skills appropriate to technical communication and presentation to non-specialists. - personal skills for lifelong learning; ability to exploit professional information resources.',0,1466977060511,1466977060511);
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_choice`
--

LOCK TABLES `question_choice` WRITE;
/*!40000 ALTER TABLE `question_choice` DISABLE KEYS */;
INSERT INTO `question_choice` VALUES (1,1,'[{\"id\":\"blank_1\"},{\"id\":\"blank_2\"},{\"id\":\"blank_3\"}]',0,1464717637372,1464717933157),(2,2,'[]',0,1464787781089,1464787781089),(3,3,'[]',0,1464788032935,1464788032935),(4,4,'[{\"id\":\"blank_1\"},{\"id\":\"blank_2\"},{\"id\":\"blank_3\"},{\"id\":\"blank_4\"}]',0,1464797487918,1464800073964),(5,5,'[{\"id\":\"blank_1\"},{\"id\":\"blank_1\"}]',0,1464800216709,1464800216709),(6,6,'[{\"id\":\"blank_1\"},{\"id\":\"blank_2\"},{\"id\":\"blank_3\"}]',0,1464800512508,1464800599883),(7,7,'{\"true_content\":\"this is true\",\"false_content\":\"this is false\"}',0,1464802527897,1464802587457),(8,8,'{\"true_content\":\"this is true1\",\"false_content\":\"this is false1\"}',0,1464802727954,1464803307341),(9,9,'[{\"id\":\"choice_1\",\"choice\":\"c1\"},{\"id\":\"choice_2\",\"choice\":\"c2\"},{\"id\":\"choice_3\",\"choice\":\"c3\"},{\"id\":\"choice_4\",\"choice\":\"c4\"}]',0,1464813062628,1464815410422),(10,10,'[{\"id\":\"choice_1\",\"choice\":\"waerac1\"},{\"id\":\"choice_2\",\"choice\":\"fwadfadc2\"},{\"id\":\"choice_3\",\"choice\":\"fwafwagwavc3\"}]',0,1464815599782,1464815599782),(11,11,'[{\"id\":\"choice_1\",\"choice\":\"fwagwac1\"},{\"id\":\"choice_2\",\"choice\":\"fwagwavc2\"},{\"id\":\"choice_3\",\"choice\":\"gwagawdc3\"},{\"id\":\"choice_4\",\"choice\":\"fawgawvc4fwagwac4\"},{\"id\":\"choice_5\",\"choice\":\"gagwadac5\"}]',0,1464815731924,1464815731924),(12,12,'[{\"id\":\"choice_1\",\"choice\":\"12312\"},{\"id\":\"choice_2\",\"choice\":\"4123\"}]',0,1464816219520,1464816254869),(13,13,'[{\"id\":\"blank_1\"}]',0,1464817668629,1464817830295),(14,14,'[{\"id\":\"choice_1\",\"choice\":\"fwaf\"},{\"id\":\"choice_2\",\"choice\":\"gwada\"},{\"id\":\"choice_3\",\"choice\":\"awfawga\"},{\"number\":\"2\"}]',0,1464818536930,1464818536930),(15,15,'\"[[object Object]]\"',0,1464819135384,1464819135384),(16,16,'[{\"id\":\"choice_1\",\"choice\":\"wa\",\"number\":{\"number\":\"1\"}},{\"id\":\"choice_2\",\"choice\":\"wdad\",\"number\":{\"number\":\"1\"}},{\"id\":\"choice_3\",\"choice\":\"dwa\",\"number\":{\"number\":\"1\"}}]',0,1464820373863,1464820373863),(17,17,'[{\"id\":\"choice_1\",\"choice\":\"fwaf\",\"number\":\"1\"},{\"id\":\"choice_2\",\"choice\":\"gawf\",\"number\":\"1\"},{\"id\":\"choice_3\",\"choice\":\"gwagwa\",\"number\":\"1\"}]',0,1464820445451,1464820558864),(18,18,'[{\"id\":\"choice_1\",\"choice\":\"fwaga\",\"number\":\"1\"},{\"id\":\"choice_2\",\"choice\":\"gwa\",\"number\":\"1\"},{\"id\":\"choice_3\",\"choice\":\"gawd\",\"number\":\"1\"}]',0,1464820767984,1464820803232);
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
INSERT INTO `question_type` VALUES (1,'Fill in Multiple Blanks','Fill in Multiple Blanks content',0,1463347838573,1463347838573),(2,'Fill in the Blank','Fill in the Blank content',0,1463347838822,1463347838822),(3,'Multiple Answer','Multiple Answer content',0,1463347838884,1463347838884),(4,'Multiple Choice','Multiple Choice content',0,1463347838999,1463347839222),(5,'True Or False','True Or False content',0,1463347839055,1463347839055),(6,'Calculate Numeric','Calculate Numeric content',0,1463347839099,1463347839099);
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
  `answered` int(11) DEFAULT '2',
  `content` longtext,
  `creator_id` int(11) NOT NULL,
  `question_level_id` int(11) DEFAULT NULL,
  `question_category_id` int(11) DEFAULT NULL,
  `mark` int(11) NOT NULL DEFAULT '0',
  `isDeleted` int(11) NOT NULL DEFAULT '0',
  `created` bigint(20) NOT NULL DEFAULT '0',
  `modified` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz`
--

LOCK TABLES `quiz` WRITE;
/*!40000 ALTER TABLE `quiz` DISABLE KEYS */;
INSERT INTO `quiz` VALUES (1,'All Categories Hard',5,2,'Generated by student1222',4,3,NULL,0,0,1466729361910,1466729361910),(2,'CSC8487 All Levels',4,2,'Generated by student1222',4,NULL,1,0,0,1466729722739,1466729722739),(3,'All Categories All Levels',5,2,'Generated by student1222',4,NULL,NULL,0,0,1466730337527,1466730337527),(4,'All Categories All Levels',5,1,'Generated by student1222',4,NULL,NULL,0,0,1466730438487,1466730438487),(5,'All Categories All Levels',5,2,'Generated by student1222',4,NULL,NULL,0,0,1467290564649,1467290564649),(6,'All Categories All Levels',5,1,'Generated by student1222',4,NULL,NULL,0,0,1467461147734,1467461147734),(7,'All Categories All Levels',5,2,'Generated by student1222',4,NULL,NULL,0,0,1467471242068,1467471242068),(8,'All Categories All Levels',15,2,'Generated by student1222',4,NULL,NULL,0,0,1467480321076,1467480321076),(9,'All Categories All Levels',5,2,'Generated by student1222',4,NULL,NULL,0,0,1467540889275,1467540889275),(10,'All Categories All Levels',5,2,'Generated by student1222',4,NULL,NULL,0,0,1467541368692,1467541368692),(11,'All Categories All Levels',5,2,'Generated by student1222',4,NULL,NULL,0,0,1467542324641,1467542324641),(12,'All Categories All Levels',5,2,'Generated by student1222',4,NULL,NULL,0,0,1467545132200,1467545132200),(13,'All Categories All Levels',18,2,'Generated by student1222',4,NULL,NULL,0,0,1467545226749,1467545226749);
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
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz_question`
--

LOCK TABLES `quiz_question` WRITE;
/*!40000 ALTER TABLE `quiz_question` DISABLE KEYS */;
INSERT INTO `quiz_question` VALUES (1,2,1,4,3,0,1466729722830,1466729722830),(2,2,6,4,3,0,1466729722924,1466729722924),(3,2,10,4,11,0,1466729723056,1466729723056),(4,2,14,4,5,0,1466729723132,1466729723132),(5,3,1,4,3,0,1466730337898,1466730337898),(6,3,4,4,5,0,1466730338252,1466730338252),(7,3,15,4,5,0,1466730338448,1466730338448),(8,3,11,4,12,0,1466730339364,1466730339364),(9,3,5,4,3,0,1466730340148,1466730340148),(10,4,8,4,41,0,1466730438837,1466730438837),(11,4,16,4,5,0,1466730438962,1466730438962),(12,4,7,4,2,0,1466730439070,1466730439070),(13,4,13,4,3,0,1466730439167,1466730439167),(14,4,2,4,2,0,1466730439601,1466730439601),(15,4,13,4,3,0,1466961228509,1466961228509),(16,4,17,4,5,0,1466961228606,1466961228606),(17,4,7,4,2,0,1466961228665,1466961228665),(18,4,9,4,53,0,1466961228704,1466961228704),(19,4,2,4,2,0,1466961228766,1466961228766),(20,4,9,4,53,0,1466961364615,1466961364615),(21,4,14,4,5,0,1466961364666,1466961364666),(22,4,17,4,5,0,1466961364713,1466961364713),(23,4,18,4,5,0,1466961364779,1466961364779),(24,4,1,4,3,0,1466961364846,1466961364846),(25,4,13,4,3,0,1466961511935,1466961511935),(26,4,5,4,3,0,1466961511976,1466961511976),(27,4,2,4,2,0,1466961512021,1466961512021),(28,4,1,4,3,0,1466961512089,1466961512089),(29,4,18,4,5,0,1466961512126,1466961512126),(30,4,13,4,3,0,1466961579561,1466961579561),(31,4,2,4,2,0,1466961579610,1466961579610),(32,4,7,4,2,0,1466961579653,1466961579653),(33,4,6,4,3,0,1466961579703,1466961579703),(34,4,5,4,3,0,1466961579743,1466961579743),(35,4,10,4,11,0,1466961649753,1466961649753),(36,4,5,4,3,0,1466961649808,1466961649808),(37,4,4,4,5,0,1466961649874,1466961649874),(38,4,9,4,53,0,1466961649931,1466961649931),(39,4,13,4,3,0,1466961650014,1466961650014),(40,4,15,4,5,0,1466961958835,1466961958835),(41,4,6,4,3,0,1466961958892,1466961958892),(42,4,10,4,11,0,1466961958946,1466961958946),(43,4,16,4,5,0,1466961958991,1466961958991),(44,4,7,4,2,0,1466961959049,1466961959049),(45,4,8,4,41,0,1466963298376,1466963298376),(46,4,15,4,5,0,1466963298456,1466963298456),(47,4,3,4,1,0,1466963298526,1466963298526),(48,4,12,4,5,0,1466963298571,1466963298571),(49,4,11,4,12,0,1466963298612,1466963298612),(50,5,3,4,1,0,1467290564853,1467290564853),(51,5,2,4,2,0,1467290564987,1467290564987),(52,5,4,4,5,0,1467290565041,1467290565041),(53,5,5,4,3,0,1467290565084,1467290565084),(54,5,9,4,53,0,1467290565118,1467290565118),(55,6,7,4,2,0,1467461147932,1467461147932),(56,6,15,4,5,0,1467461148050,1467461148050),(57,6,17,4,5,0,1467461148107,1467461148107),(58,6,4,4,5,0,1467461148220,1467461148220),(59,6,18,4,5,0,1467461148281,1467461148281),(60,7,13,4,3,0,1467471242504,1467471242504),(61,7,2,4,2,0,1467471242957,1467471242957),(62,7,9,4,53,0,1467471243193,1467471243193),(63,7,6,4,3,0,1467471243404,1467471243404),(64,7,14,4,5,0,1467471244732,1467471244732),(65,8,6,4,3,0,1467480321155,1467480321155),(66,8,2,4,2,0,1467480321207,1467480321207),(67,8,10,4,11,0,1467480321269,1467480321269),(68,8,5,4,3,0,1467480321340,1467480321340),(69,8,12,4,5,0,1467480321452,1467480321452),(70,8,8,4,41,0,1467480321485,1467480321485),(71,8,13,4,3,0,1467480321517,1467480321517),(72,8,18,4,5,0,1467480321565,1467480321565),(73,8,3,4,1,0,1467480321628,1467480321628),(74,8,7,4,2,0,1467480321710,1467480321710),(75,8,17,4,5,0,1467480321797,1467480321797),(76,8,15,4,5,0,1467480321929,1467480321929),(77,8,1,4,3,0,1467480322007,1467480322007),(78,8,14,4,5,0,1467480322099,1467480322099),(79,8,4,4,5,0,1467480322163,1467480322163),(80,9,6,4,3,0,1467540889391,1467540889391),(81,9,15,4,5,0,1467540889465,1467540889465),(82,9,11,4,12,0,1467540889495,1467540889495),(83,9,7,4,2,0,1467540889531,1467540889531),(84,9,14,4,5,0,1467540889561,1467540889561),(85,10,15,4,5,0,1467541368842,1467541368842),(86,10,8,4,41,0,1467541368915,1467541368915),(87,10,5,4,3,0,1467541368980,1467541368980),(88,10,17,4,5,0,1467541369025,1467541369025),(89,10,3,4,1,0,1467541369066,1467541369066),(90,11,9,4,53,0,1467542324770,1467542324770),(91,11,18,4,5,0,1467542324840,1467542324840),(92,11,10,4,11,0,1467542324956,1467542324956),(93,11,3,4,1,0,1467542325038,1467542325038),(94,11,2,4,2,0,1467542325088,1467542325088),(95,12,17,4,5,0,1467545132799,1467545132799),(96,12,3,4,1,0,1467545132903,1467545132903),(97,12,11,4,12,0,1467545132971,1467545132971),(98,12,2,4,2,0,1467545133118,1467545133118),(99,12,13,4,3,0,1467545133213,1467545133213),(100,13,15,4,5,0,1467545226947,1467545226947),(101,13,4,4,5,0,1467545227010,1467545227010),(102,13,14,4,5,0,1467545227108,1467545227108),(103,13,8,4,41,0,1467545227165,1467545227165),(104,13,6,4,3,0,1467545227316,1467545227316),(105,13,10,4,11,0,1467545227352,1467545227352),(106,13,16,4,5,0,1467545227420,1467545227420),(107,13,13,4,3,0,1467545227449,1467545227449),(108,13,5,4,3,0,1467545227486,1467545227486),(109,13,2,4,2,0,1467545227518,1467545227518),(110,13,18,4,5,0,1467545227618,1467545227618),(111,13,12,4,5,0,1467545227720,1467545227720),(112,13,7,4,2,0,1467545227760,1467545227760),(113,13,3,4,1,0,1467545227851,1467545227851),(114,13,11,4,12,0,1467545227906,1467545227906),(115,13,1,4,3,0,1467545227994,1467545227994),(116,13,9,4,53,0,1467545228024,1467545228024),(117,13,17,4,5,0,1467545228071,1467545228071);
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
INSERT INTO `quiz_record` VALUES (1,1,1,1,'true',5,0,1463355615059,1463355615059),(2,1,1,2,'Text',5,0,1463355615227,1463355615227),(3,1,1,3,'true',5,0,1463355615286,1463355615286),(4,2,1,4,'Text',5,1,1463355615407,1463355693145),(5,1,1,5,'true',5,0,1463355615495,1463355615495),(6,3,4,1,'123',17,0,1463442304626,1463442304626),(7,3,4,2,'123',0,0,1463442388514,1463442388514),(8,3,4,3,'123',0,0,1463442974808,1463442974808),(9,3,4,4,'123',0,0,1463443339085,1463443339085);
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
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,1,'4c48e80e7d478cf99e4f1c353a95cbb0',1464296016296,1464296016296,1464382416296,0),(2,1,'1ab9a253815da1cfbd43fab52ab096b4',1464296070958,1464296206969,1464382606969,0),(3,1,'4e346349f3e5ad2adada8d6872ed3fd6',1464296100183,1464296100183,1464382500183,0),(4,1,'92b5af5c4590036eda7804322d71296d',1464296144708,1464296144708,1464382544708,0),(5,1,'12e96a75f3446d1688fedd5428d04890',1466270960723,1466270960723,1466357360723,0),(6,1,'b1aec78e08e7bff884971971ba1b4b19',1466270996635,1466270996635,1466357396635,0),(7,1,'9647860a788a49df7a5d74c71c4342c3',1466272097871,1466272097871,1466358497871,0),(8,1,'a1fc5149a6dae1977135f6aa0dc4a954',1466272248153,1466272248153,1466358648153,0),(9,1,'67d008f43116a78c564567d5f105465b',1466272344392,1466272344392,1466358744392,0),(10,1,'c7d667c9a1bcdda11582e155ed9933a1',1466272398581,1466272398581,1466358798581,0),(11,1,'3164f0ae96a44b97a26a1b6a371e7978',1466272533229,1466272533229,1466358933229,0),(12,4,'7f4593cdeec3646619dd42d92671ba29',1466273546019,1466273546019,1466359946019,0),(13,4,'dc603697ddb711434f5d788d5de3394c',1466273659184,1466273659184,1466360059184,0),(14,4,'e0d04bb0f6256a583a4133bac391a46',1466273669333,1466273669333,1466360069333,0),(15,4,'740babf4b296ffd852dd3737fbd18b1d',1466273768710,1466273768710,1466360168710,0),(16,4,'c02a64f25c0c5b4a84f2107757c8de72',1466273832731,1466273832731,1466360232731,0),(17,4,'4efeeab84e9b500d608a21e74828630f',1466279555568,1466279555568,1466365955568,0),(18,4,'224a3da2c245a5b0e85af4331316e43f',1466279750409,1466279750409,1466366150409,0),(19,4,'f0edd10f3e043ca85388e2ea8a87b644',1466279750664,1466279750664,1466366150664,0),(20,4,'5686c8b062005111d141ebd5bf716867',1466279809723,1466279809723,1466366209723,0),(21,4,'4a6d19e4d93a2bcce881258a80f325fb',1466285269228,1466285269228,1466371669228,0),(22,4,'4c4c1cb561925e24359fc0d6cb598600',1466285753163,1466285753163,1466372153163,0),(23,4,'8f65cf0254fa8c09756841010ee60dbe',1466286053859,1466286053859,1466372453859,0),(24,4,'ab61637eab0d534c2f269430bfb1d94c',1466286210845,1466286210845,1466372610845,0),(25,4,'f7c53cccd9afcbe2176e6f920c6d02ee',1466286781860,1466286781860,1466373181860,0),(26,4,'37e192da19fed855c0291edee7a98aeb',1466287040783,1466287040783,1466373440783,0),(27,4,'6960ee4c57f9f469e4433c0d38c1a21f',1466287115529,1466287115529,1466373515529,0),(28,4,'a4ce36a7ee9cea5b0ddc6c6ac97370eb',1466288256521,1466288256521,1466374656521,0),(29,4,'c69d43f896c8e7493936303eca285135',1466288673420,1466288673420,1466375073420,0),(30,4,'7c60327f8836ac2ee1a287752bb6eb19',1466294136290,1466294136290,1466380536290,0),(31,4,'aeff3d1f99a8a5cbf5cdb732ec148727',1466297000646,1466297000646,1466383400646,0),(32,4,'bd5628ef8800ecb14adb57fd6d747b4e',1466297200350,1466297200350,1466383600350,0),(33,4,'a6097a586c367e45d8e73fe7e83babae',1466297920853,1466297920853,1466384320853,0),(34,4,'27b26f278fdbbdb44b5f3de9640029e2',1466298151647,1466298151647,1466384551647,0),(35,4,'e0683dda22065b93803632646ea8036c',1466298270335,1466298270335,1466384670335,0),(36,4,'8b8f957337d6e3e44d95301422b439f6',1466298420721,1466298420721,1466384820721,0),(37,4,'84714b616d76509e5c343f5ffda91989',1466298424512,1466298424512,1466384824512,0),(38,4,'6b24da6ec77c34128d20f10b78fe2d04',1466298636583,1466298636583,1466385036583,0),(39,4,'b13403c5f9dcfa5772d7161401e42bac',1466298837743,1466298837743,1466385237743,0),(40,4,'778b87d9a70173ca0d16228b8f83b764',1466353835026,1466353835026,1466440235026,0),(41,4,'4462a6b385ae22b8f25f0ead5b773728',1466354806897,1466354806897,1466441206897,0),(42,4,'b4fd09a03c55d4552a548afddf931381',1466358512648,1466358512648,1466444912648,0),(43,4,'1e42a7ede45e68e666b5edbcca34ad51',1466359082450,1466359082450,1466445482450,0),(44,4,'e55fd540fea1ba754992464e1cb5e508',1466359342610,1466359342610,1466445742610,0),(45,4,'a074af2a214353eeabe5067ba64c8092',1466359509896,1466359509896,1466445909896,0),(46,4,'82042fc0495a13107f9ee6c674406078',1466359768252,1466359768252,1466446168252,0),(47,4,'58491e2c6745af2a3aa366ec16b472d3',1466360142047,1466360142047,1466446542047,0),(48,4,'f29773002abec201ee2b130f0322cf05',1466363116543,1466363116543,1466449516543,0),(49,4,'5553f9b3f1e6cd0513bf6dfb6ca01296',1466418861765,1466418861765,1466505261765,0),(50,4,'c67c17976c25405e362c6b5df645da4',1466418881885,1466418881885,1466505281885,0),(51,4,'6ebb2aa024eb47d5e9afe1ec72b67cb0',1466698620653,1466698620653,1466785020653,0),(52,4,'9a9e108cc3a3880e3f3455d775402e0d',1466703842890,1466703842890,1466790242890,0),(53,4,'f911652fc9763a8e7accabb1a24838ae',1466720245663,1466720245663,1466806645663,0),(54,4,'bb7f099b513740e6dc3c7a474b9ca7f7',1466724058211,1466724058211,1466810458211,0),(55,4,'c6ddf4b3ad050cf63d0e4ecc056e6603',1466724510491,1466724510491,1466810910491,0),(56,4,'1b4d9edaab5bb790349e4c3adda0f7eb',1466725634683,1466725634683,1466812034683,0),(57,4,'caad4905cbc36debc7c7f579c4445603',1466726005862,1466726005862,1466812405862,0),(58,4,'949b8417165bf5f4434ffdb6bc71be44',1466726245757,1466726245757,1466812645757,0),(59,4,'37a6cdcfc34292d62c534164a316ba99',1466727714319,1466727714319,1466814114319,0),(60,4,'d69d94eb9e7018518d63aa72b87ab829',1466728469497,1466728469497,1466814869497,0),(61,4,'6b3ad1dd90ad5ce3d399c9c2a07fdd4a',1466730870180,1466730870180,1466817270180,0),(62,4,'ff54a954deb0cd6173be84169598de6f',1466951945711,1466951945711,1467038345711,0),(63,4,'ed5824fc9cabba3d42d29510004ebe8f',1466963635976,1466963635976,1467050035976,0),(64,4,'94b7eaeda71af729548b504cd7c8f067',1466978693029,1466978693029,1467065093029,0),(65,4,'25952157b1d89c6874df6866bdaa2bf0',1467105513170,1467105513170,1467191913170,0),(66,4,'bacb900b11d9699d60729c9199622723',1467284281990,1467284281990,1467370681990,0),(67,4,'eea44a3dc54fe1bb8707868984fb59ed',1467289821033,1467289821033,1467376221033,0),(68,4,'d439b44ff71c0b23f1808119f46e8cbd',1467308961031,1467308961031,1467395361031,0),(69,4,'ccb5dc43b0f073469be02f2c5569a0c5',1467308961031,1467308961031,1467395361031,0),(70,4,'2fc2037c3c269b312d79da14bf6d5b03',1467309017117,1467309017117,1467395417117,0),(71,4,'4b785cae8ab624bc1a6bcbca60849af',1467457938442,1467457938442,1467544338442,0),(72,4,'26e67ea9966ad5c613a5c4d949e9a18a',1467458144269,1467458144269,1467544544269,0),(73,4,'46ca51b9025374cd4d70930771c19dd',1467458211725,1467458211725,1467544611725,0),(74,4,'db72bf677dfbdbe5c97481b2783f35af',1467459067557,1467459067557,1467545467557,0),(75,4,'251b7b23815a896267ad39451603f455',1467461012719,1467461012719,1467547412719,0),(76,4,'851810ce89e0402adc983908505828',1467462151034,1467462151034,1467548551034,0),(77,4,'b7e5d50e0a246a10f81de337bffbab7a',1467470963671,1467470963671,1467557363671,0),(78,4,'eb696d0044aae3a9adeb7dff0fe914d2',1467480289785,1467480289785,1467566689785,0),(79,4,'bff5cc479a89d4c1dab779e453b45183',1467482087284,1467482087284,1467568487284,0),(80,4,'70bfc88470da0b59f4e1e7d275774eda',1467540824389,1467540824389,1467627224389,0),(81,4,'cb6553e1c130f9bc5a8e473c382bb46b',1467541316282,1467541316282,1467627716282,0),(82,4,'24d6031609bd0478d0148d0c59374d7e',1467542265587,1467542265587,1467628665587,0),(83,4,'d6fca06c2a86703bf4ea9b1fe6366715',1467543108211,1467543108211,1467629508211,0),(84,4,'8df0e08bea6d9aa6ba5c33d4ffbfc921',1467543493672,1467543493672,1467629893672,0),(85,4,'1bd40dcbdcd8397b98667d604e1915c4',1467544259479,1467544259479,1467630659479,0),(86,4,'8148d6ea91d30b58ea94213a08952bfd',1467544889052,1467544889052,1467631289052,0);
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
INSERT INTO `user` VALUES (1,'admin',NULL,'admin','administrator',1,1462798345400,1462798345400,0),(2,'user',NULL,'user','testuser',2,1462798345405,1462798345405,0),(3,'user1',NULL,'user','testuser',2,1462798525735,1462798525735,0),(4,'student','ww1333@gmail.com','student','student1222',3,1462798525735,1466298883059,0),(5,'user0',NULL,'user0','testuser0',3,1464025496306,1464027379558,0),(6,'user2',NULL,'user2','testuser2',3,1464025496518,1464027497950,0),(7,'user3',NULL,'user3','testuser3',3,1464025496743,1464025496743,0),(8,'user4',NULL,'user4','testuser4',3,1464025496819,1464025496819,0),(9,'user5',NULL,'user5','testuser5',3,1464025497009,1464025497009,0),(10,'user6',NULL,'user6','testuser6',3,1464025497099,1464025497099,0),(11,'user7',NULL,'user7','testuser7',3,1464025497161,1464025497161,0),(12,'user8',NULL,'user8','testuser8',3,1464025497209,1464025497209,0),(13,'user9',NULL,'user9','testuser9',3,1464025497240,1464026902923,0),(14,'user10',NULL,'user10','testuser10',3,1464025497285,1464026879706,0),(15,'user11',NULL,'user11','testuser11',3,1464025497317,1464025497317,0),(16,'user12',NULL,'user12','testuser12',3,1464025497350,1464025497350,0),(17,'user13',NULL,'user13','testuser13',3,1464025497397,1464025497397,0),(18,'user14',NULL,'user14','testuser14',3,1464025497439,1464025497439,0),(19,'user15',NULL,'user15','testuser15',3,1464025497485,1464025497485,0),(20,'user16',NULL,'user16','testuser16',3,1464025497617,1464025497617,0),(21,'user17',NULL,'user17','testuser17',3,1464025497695,1464040674545,1),(22,'user18',NULL,'user18','testuser18',3,1464025497726,1464040551597,1),(23,'user19',NULL,'user19','testuser19',3,1464025497775,1464040505461,1),(24,'teac','tea1@gmail.com','123456','tea1',2,1464043074654,1464043074654,0),(25,'teac1','tea1@gmail.com','123456','tea1',2,1464043139778,1464043139778,0),(26,'tec2','tea2@gmail.com','123456','tea1',1,1464043163244,1464043163244,0),(27,'teacher2','tea1@gmail.com','123456','tea1',1,1464043257637,1464043257637,0),(28,'teac2','tea1@gmail.com','123456','tea1',2,1464043368669,1464043368669,0),(29,'tete','eta@gmai.com','123456','te12',3,1464043634252,1464044056863,0);
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

-- Dump completed on 2016-07-03 18:12:02
