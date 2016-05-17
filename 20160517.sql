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
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'q1','q1 content','','SPIN;Fill in Multiple Blanks',2,3,3,10,'i am q1 feedback',0,1463353502208,1463353502208),(2,'q2','q2 content','','Big data;SPIN',1,3,1,11,'i am q2 feedback',0,1463353502553,1463353502553),(3,'q3','q3 content','','Fill in Multiple Blanks;Big data',1,4,4,18,'i am q3 feedback',0,1463353502590,1463353502590),(4,'q4','q4 content','','Fill in Multiple Blanks;Kafka',4,2,3,6,'i am q4 feedback',0,1463353502636,1463353502636),(5,'q5','q5 content','','Fill in the Blank;SPIN',3,2,1,14,'i am q5 feedback',0,1463353502733,1463353502733),(6,'q6','q6 content','','Kafka;Spark',1,3,4,11,'i am q6 feedback',0,1463353502861,1463353502861),(7,'q7','q7 content','','Spark;SPIN',4,6,4,1,'i am q7 feedback',0,1463353502914,1463353502914),(8,'q8','q8 content','','Spark;Kafka',3,3,4,2,'i am q8 feedback',0,1463353502945,1463353502945),(9,'q9','q9 content','','Big data;Kafka',1,5,2,6,'i am q9 feedback',0,1463353503002,1463353503002),(10,'q10','q10 content','','Kafka;Spark',1,6,4,19,'i am q10 feedback',0,1463353503033,1463353503033),(11,'q11','q11 content','','Fill in Multiple Blanks;SPIN',3,2,3,14,'i am q11 feedback',0,1463407223867,1463407223867),(12,'q12','q12 content','','Fill in the Blank;Fill in the Blank',4,2,2,12,'i am q12 feedback',0,1463407224026,1463407224026),(13,'q13','q13 content','','Fill in Multiple Blanks;Fill in the Blank',1,1,2,12,'i am q13 feedback',0,1463407224076,1463407224076),(14,'q14','q14 content','123','Kafka;Spark',3,1,1,17,'i am q14 feedback',0,1463407224131,1463407224131),(15,'q15','q15 content','','Big data;Fill in the Blank',2,6,1,2,'i am q15 feedback',0,1463407224176,1463407224176),(16,'q16','q16 content','','Spark;Kafka',2,5,4,10,'i am q16 feedback',0,1463407224220,1463407224220),(17,'q17','q17 content','','Spark;Big data',2,3,2,13,'i am q17 feedback',0,1463407224295,1463407224295),(18,'q18','q18 content','','Kafka;Fill in Multiple Blanks',3,5,2,6,'i am q18 feedback',0,1463407224349,1463407224349),(19,'q19','q19 content','','Spark;SPIN',2,3,3,5,'i am q19 feedback',0,1463407224431,1463407224431),(20,'q20','q20 content','','SPIN;Spark',2,5,3,11,'i am q20 feedback',0,1463407224461,1463407224461),(21,'q21','q21 content','','Kafka;Fill in the Blank',4,5,1,2,'i am q21 feedback',0,1463407224502,1463407224502),(22,'q22','q22 content','','Kafka;Spark',2,4,3,17,'i am q22 feedback',0,1463407224541,1463407224541),(23,'q23','q23 content','','Kafka;Big data',2,6,1,5,'i am q23 feedback',0,1463407224587,1463407224587),(24,'q24','q24 content','','SPIN;Fill in Multiple Blanks',1,6,4,13,'i am q24 feedback',0,1463407224629,1463407224629),(25,'q25','q25 content','','Spark;Fill in Multiple Blanks',1,4,2,13,'i am q25 feedback',0,1463407224695,1463407224695),(26,'q26','q26 content','','SPIN;Big data',3,5,4,18,'i am q26 feedback',0,1463407224730,1463407224730),(27,'q27','q27 content','','Big data;Kafka',2,6,2,10,'i am q27 feedback',0,1463407224759,1463407224759),(28,'q28','q28 content','','Spark;Fill in Multiple Blanks',2,2,2,8,'i am q28 feedback',0,1463407224804,1463407224804),(29,'q29','q29 content','','Fill in the Blank;Kafka',2,4,2,5,'i am q29 feedback',0,1463407224842,1463407224842),(30,'q30','q30 content','','Fill in the Blank;SPIN',3,3,1,13,'i am q30 feedback',0,1463407224884,1463407224884),(31,'q31','q31 content','','Fill in the Blank;Spark',2,5,1,1,'i am q31 feedback',0,1463420053790,1463420053790),(32,'q32','q32 content','','Spark;SPIN',4,6,2,3,'i am q32 feedback',0,1463420053909,1463420053909),(33,'q33','q33 content','','Fill in the Blank;Fill in the Blank',3,6,4,16,'i am q33 feedback',0,1463420053988,1463420053988),(34,'q34','q34 content','','SPIN;Fill in Multiple Blanks',1,2,3,15,'i am q34 feedback',0,1463420054045,1463420054045),(35,'q35','q35 content','','Fill in the Blank;SPIN',1,5,2,0,'i am q35 feedback',0,1463420054093,1463420054093),(36,'q36','q36 content','','Fill in Multiple Blanks;Fill in the Blank',4,1,1,8,'i am q36 feedback',0,1463420054155,1463420054155),(37,'q37','q37 content','','Big data;Spark',2,5,1,5,'i am q37 feedback',0,1463420054234,1463420054234),(38,'q38','q38 content','','SPIN;Fill in the Blank',4,4,1,1,'i am q38 feedback',0,1463420054272,1463420054272),(39,'q39','q39 content','','Fill in the Blank;SPIN',2,6,3,14,'i am q39 feedback',0,1463420054315,1463420054315),(40,'q40','q40 content','','Fill in the Blank;Spark',4,5,4,5,'i am q40 feedback',0,1463420054345,1463420054345),(41,'q41','q41 content','','Kafka;Spark',4,4,1,11,'i am q41 feedback',0,1463420054381,1463420054381),(42,'q42','q42 content','','Big data;SPIN',3,6,2,12,'i am q42 feedback',0,1463420054412,1463420054412),(43,'q43','q43 content','','Fill in the Blank;Fill in the Blank',3,3,1,17,'i am q43 feedback',0,1463420054458,1463420054458),(44,'q44','q44 content','','SPIN;SPIN',3,4,1,0,'i am q44 feedback',0,1463420054490,1463420054490),(45,'q45','q45 content','','Spark;Spark',1,4,2,8,'i am q45 feedback',0,1463420054529,1463420054529),(46,'q46','q46 content','','Big data;Kafka',3,2,1,5,'i am q46 feedback',0,1463420054574,1463420054574),(47,'q47','q47 content','','Big data;Fill in the Blank',1,2,4,17,'i am q47 feedback',0,1463420054613,1463420054613),(48,'q48','q48 content','','Kafka;Spark',4,1,4,2,'i am q48 feedback',0,1463420054656,1463420054656),(49,'q49','q49 content','','Big data;Fill in the Blank',1,3,4,9,'i am q49 feedback',0,1463420054691,1463420054691),(50,'q50','q50 content','','Spark;Big data',3,4,1,4,'i am q50 feedback',0,1463420054723,1463420054723),(51,'q51','q51 content','','Spark;Fill in the Blank',2,1,1,2,'i am q51 feedback',0,1463420135345,1463420135345),(52,'q52','q52 content','','Kafka;Fill in the Blank',2,3,2,15,'i am q52 feedback',0,1463420135451,1463420135451),(53,'q53','q53 content','','Spark;Fill in Multiple Blanks',3,4,3,4,'i am q53 feedback',0,1463420135488,1463420135488),(54,'q54','q54 content','','Spark;Spark',3,5,2,4,'i am q54 feedback',0,1463420135546,1463420135546),(55,'q55','q55 content','','Kafka;Spark',4,2,1,10,'i am q55 feedback',0,1463420135577,1463420135577),(56,'q56','q56 content','','SPIN;Kafka',1,1,1,5,'i am q56 feedback',0,1463420135635,1463420135635),(57,'q57','q57 content','','Big data;Fill in the Blank',2,3,1,9,'i am q57 feedback',0,1463420135690,1463420135690),(58,'q58','q58 content','','Big data;Big data',1,3,3,7,'i am q58 feedback',0,1463420135721,1463420135721),(59,'q59','q59 content','','Big data;Fill in Multiple Blanks',1,6,3,1,'i am q59 feedback',0,1463420135753,1463420135753),(60,'q60','q60 content','','SPIN;Fill in Multiple Blanks',4,2,1,8,'i am q60 feedback',0,1463420135806,1463420135806),(61,'q61','q61 content','','Fill in Multiple Blanks;SPIN',2,5,1,11,'i am q61 feedback',0,1463420135886,1463420135886),(62,'q62','q62 content','','Spark;Fill in Multiple Blanks',4,1,2,17,'i am q62 feedback',0,1463420135967,1463420135967),(63,'q63','q63 content','','Fill in the Blank;Big data',1,2,2,1,'i am q63 feedback',0,1463420136022,1463420136022),(64,'q64','q64 content','','Kafka;Fill in the Blank',3,1,3,0,'i am q64 feedback',0,1463420136073,1463420136073),(65,'q65','q65 content','','Fill in the Blank;Kafka',1,6,1,1,'i am q65 feedback',0,1463420136110,1463420136110),(66,'q66','q66 content','','Kafka;Spark',3,3,1,1,'i am q66 feedback',0,1463420136157,1463420136157),(67,'q67','q67 content','','SPIN;Big data',4,4,2,15,'i am q67 feedback',0,1463420136198,1463420136198),(68,'q68','q68 content','','Kafka;Big data',1,4,1,12,'i am q68 feedback',0,1463420136228,1463420136228),(69,'q69','q69 content','','Fill in Multiple Blanks;Fill in the Blank',4,6,4,3,'i am q69 feedback',0,1463420136282,1463420136282),(70,'q70','q70 content','','SPIN;SPIN',3,1,1,4,'i am q70 feedback',0,1463420136317,1463420136317),(71,'q71','q71 content','','SPIN;Kafka',2,2,3,1,'i am q71 feedback',0,1463420136352,1463420136352),(72,'q72','q72 content','','Kafka;Fill in Multiple Blanks',4,2,2,10,'i am q72 feedback',0,1463420136383,1463420136383),(73,'q73','q73 content','','Fill in the Blank;Big data',2,2,4,5,'i am q73 feedback',0,1463420136420,1463420136420),(74,'q74','q74 content','','Fill in Multiple Blanks;Big data',3,6,1,15,'i am q74 feedback',0,1463420136486,1463420136486),(75,'q75','q75 content','','SPIN;SPIN',1,4,2,2,'i am q75 feedback',0,1463420136532,1463420136532),(76,'q76','q76 content','','Spark;SPIN',2,2,3,17,'i am q76 feedback',0,1463420136563,1463420136563),(77,'q77','q77 content','','Spark;SPIN',2,4,4,6,'i am q77 feedback',0,1463420136618,1463420136618),(78,'q78','q78 content','','Fill in Multiple Blanks;Kafka',1,3,1,18,'i am q78 feedback',0,1463420136679,1463420136679),(79,'q79','q79 content','','SPIN;Big data',4,4,3,3,'i am q79 feedback',0,1463420136730,1463420136730),(80,'q80','q80 content','','Kafka;Big data',1,3,3,12,'i am q80 feedback',0,1463420136785,1463420136785);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_category`
--

LOCK TABLES `question_category` WRITE;
/*!40000 ALTER TABLE `question_category` DISABLE KEYS */;
INSERT INTO `question_category` VALUES (1,'CSC8487','CSC8487 content',0,1463346149229,1463346149229),(2,'CSC8488','CSC8488 content',0,1463346149400,1463346149400),(3,'CSC8489','CSC8489 content',0,1463346149453,1463346149453),(4,'CSC8490','CSC8490 content',0,1463346149508,1463346149508);
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
  `answer` varchar(100) NOT NULL,
  `content` longtext,
  `isDeleted` int(11) NOT NULL DEFAULT '0',
  `created` bigint(20) NOT NULL DEFAULT '0',
  `modified` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `question_id_UNIQUE` (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_choice`
--

LOCK TABLES `question_choice` WRITE;
/*!40000 ALTER TABLE `question_choice` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_level`
--

LOCK TABLES `question_level` WRITE;
/*!40000 ALTER TABLE `question_level` DISABLE KEYS */;
INSERT INTO `question_level` VALUES (1,'Easy','Easy content',0,1463346100115,1463346100115),(2,'Normal','Normal content',0,1463346100273,1463346100273),(3,'Hard','Hard content',0,1463346100313,1463346100313),(4,'Survivor','Survivor content',0,1463346100358,1463346100358);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_tag`
--

LOCK TABLES `question_tag` WRITE;
/*!40000 ALTER TABLE `question_tag` DISABLE KEYS */;
INSERT INTO `question_tag` VALUES (1,'Cloud computing','Cloud computing content',0,1463346263792,1463346263792),(2,'Java','Java content',0,1463346263953,1463346263953),(3,'Spark','Spark content',0,1463346264005,1463346264005),(4,'Kafka','Kafka content',0,1463346264105,1463346264105),(5,'Big data','Big data content',0,1463346264159,1463346264159),(6,'SPIN','SPIN content',0,1463346264204,1463346264204);
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz`
--

LOCK TABLES `quiz` WRITE;
/*!40000 ALTER TABLE `quiz` DISABLE KEYS */;
INSERT INTO `quiz` VALUES (1,'quiz 1','quiz 1 content',1,3,NULL,5,0,1463353536273,1463353536273),(2,'quiz 2','quiz 2 content',1,2,NULL,5,0,1463353536439,1463353536439),(3,'quiz 3','quiz 3 content',2,3,NULL,5,0,1463353536631,1463353536631),(4,'quiz 4.1','quiz 4 content1',1,4,NULL,5,1,1463353536858,1463353852316),(5,'quiz 5','quiz 5 content',1,4,NULL,5,0,1463353536910,1463353536910),(6,'CSC8488 Normal student1 ','self generated',4,2,2,100,0,1463419872497,1463419872497),(7,'CSC8487 Hard student1 ','self generated',4,3,1,100,0,1463420318192,1463420318192),(8,'CSC8487 Hard student1 ','self generated',4,3,1,50,0,1463420436116,1463420436116),(9,'CSC8487 Hard student1','Generated by student1',4,3,1,0,0,1463421413887,1463421413887),(10,NULL,NULL,2,2,2,0,0,1463436225140,1463436225140),(11,'CSC8488 Hard testuser','Generated by testuser',2,3,2,0,0,1463436326499,1463436326499),(12,'CSC8487 Hard testuser','Generated by testuser',2,3,1,0,0,1463436775784,1463436775784),(13,'CSC8487 Hard testuser','Generated by testuser',2,3,1,0,0,1463437016650,1463437016650),(14,'CSC8487 Hard student1','Generated by student1',4,3,1,0,0,1463437609477,1463437609477),(15,'CSC8487 Hard student1','Generated by student1',4,3,1,0,0,1463439449246,1463439449246),(16,'CSC8487 Hard testuser','Generated by testuser',2,3,1,0,0,1463439599437,1463439599437);
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz_question`
--

LOCK TABLES `quiz_question` WRITE;
/*!40000 ALTER TABLE `quiz_question` DISABLE KEYS */;
INSERT INTO `quiz_question` VALUES (1,15,30,4,13,0,1463439495400,1463439495400),(2,15,74,4,15,0,1463439495488,1463439495488),(3,15,14,4,51,0,1463439495524,1463443339028),(4,15,5,4,14,0,1463439495631,1463439495631),(5,15,70,4,4,0,1463439495669,1463439495669),(6,16,5,2,14,0,1463439617403,1463439617403),(7,16,74,2,15,0,1463439617460,1463439617460),(8,16,50,2,4,0,1463439617544,1463439617544),(9,16,70,2,4,0,1463439617625,1463439617625),(10,16,66,2,1,0,1463439617699,1463439617699),(11,16,43,2,17,0,1463439617747,1463439617747);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin',NULL,'admin','administrator',1,1462798345400,1462798345400,0),(2,'user',NULL,'user','testuser',2,1462798345405,1462798345405,0),(3,'user1',NULL,'user','testuser',2,1462798525735,1462798525735,0),(4,'student',NULL,'student','student1',3,1462798525735,1462798525735,0);
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

-- Dump completed on 2016-05-17  1:16:30
