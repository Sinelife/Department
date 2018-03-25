-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: department1
-- ------------------------------------------------------
-- Server version	5.7.20-log

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


DROP DATABASE IF EXISTS `department_db`;
CREATE DATABASE `department_db`;
USE `department_db`;


--
-- Table structure for table `aspirant`
--

DROP TABLE IF EXISTS `aspirant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aspirant` (
  `theme_aspirant` varchar(45) DEFAULT NULL,
  `start` date NOT NULL,
  `end` date DEFAULT NULL,
  `protection_date` date DEFAULT NULL,
  `scientist_id` int(10) unsigned NOT NULL,
  `teacher_scientist_id` int(10) unsigned DEFAULT NULL,
  `cathdera_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`scientist_id`,`cathdera_id`),
  KEY `fk_Aspirant_Scientist1_idx` (`scientist_id`),
  KEY `fk_Aspirant_lecturer1_idx` (`teacher_scientist_id`),
  KEY `fk_Aspirant_Department1_idx` (`cathdera_id`),
  CONSTRAINT `fk_Aspirant_Department1` FOREIGN KEY (`cathdera_id`) REFERENCES `cathedra` (`cathedra_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aspirant_Scientist1` FOREIGN KEY (`scientist_id`) REFERENCES `scientist` (`scientist_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aspirant_lecturer1` FOREIGN KEY (`teacher_scientist_id`) REFERENCES `teacher` (`scientist_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aspirant`
--

LOCK TABLES `aspirant` WRITE;
/*!40000 ALTER TABLE `aspirant` DISABLE KEYS */;
INSERT INTO `aspirant` VALUES ('тема аспіранта 1','2017-12-12',NULL,NULL,3,1,1),('тема аспіранта 2','2015-12-12','2017-12-12','2017-12-12',9,4,1),('тема аспіранта 3','2017-10-10',NULL,NULL,11,4,2);
/*!40000 ALTER TABLE `aspirant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cathedra`
--

DROP TABLE IF EXISTS `cathedra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cathedra` (
  `cathedra_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  PRIMARY KEY (`cathedra_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cathedra`
--

LOCK TABLES `cathedra` WRITE;
/*!40000 ALTER TABLE `cathedra` DISABLE KEYS */;
INSERT INTO `cathedra` VALUES (1,'Cathedra1','1234534'),(2,'Cathedra2','34535553');
/*!40000 ALTER TABLE `cathedra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `magister`
--

DROP TABLE IF EXISTS `magister`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `magister` (
  `start` date NOT NULL,
  `end` date DEFAULT NULL,
  `theme_magister` varchar(45) DEFAULT NULL,
  `reason` varchar(45) DEFAULT NULL,
  `scientist_id` int(10) unsigned NOT NULL,
  `teacher_scientist_id` int(10) unsigned DEFAULT NULL,
  `cathedra_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`scientist_id`,`cathedra_id`),
  KEY `fk_Master_Scientist1_idx` (`scientist_id`),
  KEY `fk_Master_lecturer1_idx` (`teacher_scientist_id`),
  KEY `fk_Master_Department1_idx` (`cathedra_id`),
  CONSTRAINT `fk_Master_Department1` FOREIGN KEY (`cathedra_id`) REFERENCES `cathedra` (`cathedra_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Master_Scientist1` FOREIGN KEY (`scientist_id`) REFERENCES `scientist` (`scientist_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Master_lecturer1` FOREIGN KEY (`teacher_scientist_id`) REFERENCES `teacher` (`scientist_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `magister`
--

LOCK TABLES `magister` WRITE;
/*!40000 ALTER TABLE `magister` DISABLE KEYS */;
INSERT INTO `magister` VALUES ('2015-10-10',NULL,'тема магістра 1',NULL,2,1,1),('2014-09-09','2016-10-10','тема магістра 2','випустився',8,1,2),('2016-10-10',NULL,'тема магістра 3',NULL,10,4,2);
/*!40000 ALTER TABLE `magister` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scientifictheme`
--

DROP TABLE IF EXISTS `scientifictheme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scientifictheme` (
  `scientific_theme_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `customer` varchar(45) NOT NULL,
  `start` date NOT NULL,
  `end` date DEFAULT NULL,
  `cathedra_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`scientific_theme_id`),
  KEY `fk_ScientificTheme_Department1_idx` (`cathedra_id`),
  CONSTRAINT `fk_ScientificTheme_Department1` FOREIGN KEY (`cathedra_id`) REFERENCES `cathedra` (`cathedra_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scientifictheme`
--

LOCK TABLES `scientifictheme` WRITE;
/*!40000 ALTER TABLE `scientifictheme` DISABLE KEYS */;
INSERT INTO `scientifictheme` VALUES (1,'Аналіз існуючих інформаційно-пошукових систем','Company1000','2015-11-10',NULL,1),(2,'Анімація алгоритмів на графах','COMPANY','2016-11-11',NULL,2),(3,'Розпаралелення функціональних програм','Company100000','2017-01-01',NULL,1);
/*!40000 ALTER TABLE `scientifictheme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scientificwork`
--

DROP TABLE IF EXISTS `scientificwork`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scientificwork` (
  `scientific_work_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `scientist_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`scientific_work_id`,`scientist_id`),
  KEY `fk_ScientificWork_Scientist1_idx` (`scientist_id`),
  CONSTRAINT `fk_ScientificWork_Scientist1` FOREIGN KEY (`scientist_id`) REFERENCES `scientist` (`scientist_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scientificwork`
--

LOCK TABLES `scientificwork` WRITE;
/*!40000 ALTER TABLE `scientificwork` DISABLE KEYS */;
/*!40000 ALTER TABLE `scientificwork` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scientist`
--

DROP TABLE IF EXISTS `scientist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scientist` (
  `scientist_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `surname` varchar(45) NOT NULL,
  `sex` tinyint(1) unsigned NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`scientist_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scientist`
--

LOCK TABLES `scientist` WRITE;
/*!40000 ALTER TABLE `scientist` DISABLE KEYS */;
INSERT INTO `scientist` VALUES (1,'teacher1',1,'4343437'),(2,'magister1',1,'7433234'),(3,'aspirant1',1,'64534534'),(4,'teacher2',1,'2121221'),(5,'teacher3',1,'44444444'),(6,'teacher4',1,'333333333'),(7,'teacher5',1,'12132443'),(8,'magister2',1,'232323232'),(9,'aspirant2',1,'4545464646'),(10,'magister3',1,'33424434343'),(11,'aspirant3',1,'445898700');
/*!40000 ALTER TABLE `scientist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supervision`
--

DROP TABLE IF EXISTS `supervision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supervision` (
  `start` date NOT NULL,
  `end` date DEFAULT NULL,
  `teacher_scientist_id` int(10) unsigned NOT NULL,
  `scientific_theme_id` int(11) NOT NULL,
  PRIMARY KEY (`teacher_scientist_id`,`scientific_theme_id`),
  KEY `fk_Management_ScientificTheme1_idx` (`scientific_theme_id`),
  CONSTRAINT `fk_Management_ScientificTheme1` FOREIGN KEY (`scientific_theme_id`) REFERENCES `scientifictheme` (`scientific_theme_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_Management_lecturer1` FOREIGN KEY (`teacher_scientist_id`) REFERENCES `teacher` (`scientist_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supervision`
--

LOCK TABLES `supervision` WRITE;
/*!40000 ALTER TABLE `supervision` DISABLE KEYS */;
INSERT INTO `supervision` VALUES ('2016-01-02',NULL,1,1),('2017-01-01',NULL,4,3),('2016-02-02',NULL,6,2);
/*!40000 ALTER TABLE `supervision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `position` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `start_date` date NOT NULL,
  `scientist_id` int(10) unsigned NOT NULL,
  `cathedra_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`scientist_id`,`cathedra_id`),
  KEY `fk_lecturer_Scientist1_idx` (`scientist_id`),
  KEY `fk_lecturer_Department1_idx` (`cathedra_id`),
  CONSTRAINT `fk_lecturer_Department1` FOREIGN KEY (`cathedra_id`) REFERENCES `cathedra` (`cathedra_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lecturer_Scientist1` FOREIGN KEY (`scientist_id`) REFERENCES `scientist` (`scientist_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES ('lector','proffesor','2010-10-10',1,1),('practic','dekan','2009-11-11',4,1),('lector','proffesor','2009-01-01',5,2),('lector','highteacher','2013-01-10',6,2),('practic','proffesor','2013-12-12',7,2);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theme_work`
--

DROP TABLE IF EXISTS `theme_work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `theme_work` (
  `scientific_work_id` int(11) NOT NULL,
  `scientific_theme_id` int(11) NOT NULL,
  PRIMARY KEY (`scientific_work_id`,`scientific_theme_id`),
  KEY `fk_ThemeWork_ScientificTheme1_idx` (`scientific_theme_id`),
  CONSTRAINT `fk_ThemeWork_ScientificTheme1` FOREIGN KEY (`scientific_theme_id`) REFERENCES `scientifictheme` (`scientific_theme_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ThemeWork_ScientificWork1` FOREIGN KEY (`scientific_work_id`) REFERENCES `scientificwork` (`scientific_work_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theme_work`
--

LOCK TABLES `theme_work` WRITE;
/*!40000 ALTER TABLE `theme_work` DISABLE KEYS */;
/*!40000 ALTER TABLE `theme_work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `working`
--

DROP TABLE IF EXISTS `working`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `working` (
  `title` varchar(45) NOT NULL,
  `start` date NOT NULL,
  `end` date DEFAULT NULL,
  `scientist_id` int(10) unsigned NOT NULL,
  `scientific_theme_id` int(11) NOT NULL,
  PRIMARY KEY (`scientist_id`,`scientific_theme_id`),
  KEY `fk_Working_ScientificTheme1_idx` (`scientific_theme_id`),
  CONSTRAINT `fk_Working_ScientificTheme1` FOREIGN KEY (`scientific_theme_id`) REFERENCES `scientifictheme` (`scientific_theme_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_Working_Scientist1` FOREIGN KEY (`scientist_id`) REFERENCES `scientist` (`scientist_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `working`
--

LOCK TABLES `working` WRITE;
/*!40000 ALTER TABLE `working` DISABLE KEYS */;
INSERT INTO `working` VALUES ('FrontEnd Частина-2','2016-04-04','2017-01-01',1,2),('Частина Аналізу - 1','2016-01-10','2016-05-10',2,1),('Аналіз Частина-1','2017-02-02',NULL,2,3),('Частина Аналізу-3','2017-03-03','2017-06-08',6,3),('Основна робота','2016-01-01',NULL,7,1),('Аналіз Частина-3','2016-01-14',NULL,8,1),('FrontEnd Частина-1','2016-04-04',NULL,8,2),('BackEnd Частина-2','2016-03-03','2016-09-09',9,2),('BackEnd Частина-1','2016-02-03',NULL,10,2),('Частина Аналізу-2','2017-01-23',NULL,10,3),('Аналіз Частина-2','2016-01-13',NULL,11,1);
/*!40000 ALTER TABLE `working` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-26 23:38:32
