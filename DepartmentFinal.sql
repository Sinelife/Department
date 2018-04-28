-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: department_final
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



DROP DATABASE IF EXISTS `department_final`;
CREATE DATABASE `department_final`;
USE `department_final`;



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
  `cathedra_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`scientist_id`,`cathedra_id`),
  KEY `fk_Aspirant_Scientist1_idx` (`scientist_id`),
  KEY `fk_Aspirant_lecturer1_idx` (`teacher_scientist_id`),
  KEY `fk_Aspirant_Department1_idx` (`cathedra_id`),
  CONSTRAINT `fk_Aspirant_Department1` FOREIGN KEY (`cathedra_id`) REFERENCES `cathedra` (`cathedra_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aspirant_Scientist1` FOREIGN KEY (`scientist_id`) REFERENCES `scientist` (`scientist_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aspirant_lecturer1` FOREIGN KEY (`teacher_scientist_id`) REFERENCES `teacher` (`scientist_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aspirant`
--

LOCK TABLES `aspirant` WRITE;
/*!40000 ALTER TABLE `aspirant` DISABLE KEYS */;
INSERT INTO `aspirant` VALUES ('Тема аспіранта 1','2012-09-01','2015-06-22','2015-06-20',9,20,1),('Тема аспіранта 2','2017-09-01',NULL,NULL,10,20,1),('Тема аспіранта 3','2016-09-01',NULL,NULL,11,21,2),('Тема аспіранта 4','2016-09-01',NULL,NULL,12,21,2),('Тема аспіранта 5','2016-09-01',NULL,NULL,13,22,3),('Тема аспіранта 6','2017-09-01',NULL,NULL,14,23,3),('Тема аспіранта 7','2014-09-01','2017-06-22','2017-06-20',15,24,4),('Тема аспіранта 8','2014-09-01','2017-06-22','2017-06-20',16,24,4),('Тема аспіранта 9','2012-09-01','2015-06-22','2015-06-20',17,25,4);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cathedra`
--

LOCK TABLES `cathedra` WRITE;
/*!40000 ALTER TABLE `cathedra` DISABLE KEYS */;
INSERT INTO `cathedra` VALUES (1,'Кафедра інформатики','123-45-67'),(2,'Кафедра математики','987-65-43'),(3,'Кафедра мультимедійних технологій','123-99-99'),(4,'Кафедра мережних технологій','987-11-11');
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
INSERT INTO `magister` VALUES ('2014-09-01','2016-06-22','Тема магістра 1','випустився',1,NULL,1),('2014-09-01','2016-06-22','Тема магістра 2','випустився',2,NULL,1),('2015-09-01','2017-06-22','Тема магістра 3','випустився',3,NULL,2),('2015-09-01','2017-06-22','Тема магістра 4','випустився',4,NULL,2),('2017-09-01',NULL,'Тема магістра 5',NULL,5,NULL,3),('2015-09-01','2017-06-22','Тема магістра 6','випустився',6,NULL,3),('2017-09-01',NULL,'Тема магістра 7',NULL,7,NULL,4),('2013-09-01','2015-06-22','Тема магістра 8','випустився',8,NULL,4);
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
  `title` varchar(100) NOT NULL,
  `customer` varchar(45) NOT NULL,
  `start` date NOT NULL,
  `end` date DEFAULT NULL,
  `cathedra_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`scientific_theme_id`),
  KEY `fk_ScientificTheme_Department1_idx` (`cathedra_id`),
  CONSTRAINT `fk_ScientificTheme_Department1` FOREIGN KEY (`cathedra_id`) REFERENCES `cathedra` (`cathedra_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scientifictheme`
--

LOCK TABLES `scientifictheme` WRITE;
/*!40000 ALTER TABLE `scientifictheme` DISABLE KEYS */;
INSERT INTO `scientifictheme` VALUES (1,'Анімація алгоритмів на графах','Компанія \"Start\"','2017-01-01','2018-04-07',1),(2,'Навчальна прогрма з вивчення мови програмування Delphi','Кафедра інформатики','2017-01-20',NULL,1),(3,'Пошук даних, моделі пошуку даних','Компаныя \"Start\"','2018-01-01',NULL,4),(4,'Загальні алгоритми пошуку інформації в Internet','Компанія \"1000\"','2017-01-02',NULL,4),(5,'Розробка зручного інтерфейсу для графів великого обсягу','Кафедра інформатики','2017-02-02',NULL,2),(6,'Алгоритми склеювання змінних в системі предикатного програмування','Компанія \"ABC\"','2017-01-12','2018-04-07',2),(7,'Порівняння мультимедійних систем Toyota Touch 2 і Toyota Touch 2 with Go Plus','Компанія \"ABC\"','2017-06-06','2018-04-07',3),(8,'Порівняння 3d max і cinema 4d','Фірма \"Graphics\"','2018-02-02',NULL,3),(9,'Покращення алгоритмів сортування даних','Компанія \"DataBase\"','2017-04-05',NULL,1),(10,'Створення курсу програмування на Java','Факультет інформатики','2017-05-05',NULL,1);
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
  `year` int(10) NOT NULL,
  PRIMARY KEY (`scientific_work_id`,`scientist_id`),
  KEY `fk_ScientificWork_Scientist1_idx` (`scientist_id`),
  CONSTRAINT `fk_ScientificWork_Scientist1` FOREIGN KEY (`scientist_id`) REFERENCES `scientist` (`scientist_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scientificwork`
--

LOCK TABLES `scientificwork` WRITE;
/*!40000 ALTER TABLE `scientificwork` DISABLE KEYS */;
INSERT INTO `scientificwork` VALUES (1,'Порівняння С і С++','стаття',9,2017),(2,'Порівння Java і C#','стаття',10,2017),(3,'Використання OpenMP','стаття',11,2016),(4,'Розумне написання SQL запитів','підручник',12,2017),(5,'Вивчення алгоритмів на графах','підручник',14,2016),(6,'Protege і Бази Знань','доповідь',15,2017),(7,'Нормалізація баз данних','доповідь',15,2018),(8,'Порівняння С++ і Java','стаття',9,2017),(9,'Транзакційна пам\'ять','доповідь',9,2018),(10,'Порівняння Javascript i Python','стаття',10,2017),(11,'Бібліотека SignalR на C#','стаття',10,2017);
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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scientist`
--

LOCK TABLES `scientist` WRITE;
/*!40000 ALTER TABLE `scientist` DISABLE KEYS */;
INSERT INTO `scientist` VALUES (1,'Римарчук',1,'111-11-11'),(2,'Пилипенко',0,'222-22-22'),(3,'Максименко',1,'333-33-33'),(4,'Бондарчук',0,'444-44-44'),(5,'Кириленко',1,'555-55-55'),(6,'Потапенко',0,'666-66-66'),(7,'Дмитрієв',1,'777-77-77'),(8,'Богун',0,'888-88-88'),(9,'Андрійчук',1,'123-11-11'),(10,'Федотов',1,'123-11-12'),(11,'Щербань',1,'123-11-13'),(12,'Черненко',1,'123-11-14'),(13,'Біленко',0,'123-11-15'),(14,'Сіренко',0,'123-11-16'),(15,'Щербенко',0,'123-11-17'),(16,'Хоменко',0,'123-11-18'),(17,'Ярмоленко',0,'123-11-19'),(18,'Антонович',1,'999-99-11'),(19,'Якименко',0,'999-99-12'),(20,'Довженко',1,'999-99-13'),(21,'Вольцман',0,'999-99-14'),(22,'Корольов',1,'999-99-15'),(23,'Дем\'яненко',0,'999-99-16'),(24,'Рибін',1,'999-99-17'),(25,'Гордон',0,'999-99-18'),(26,'Грицаєнко',1,'999-99-19');
/*!40000 ALTER TABLE `scientist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supervision`
--

DROP TABLE IF EXISTS `supervision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supervision` (
  `supervisor_id` int(11) NOT NULL,
  `start` date NOT NULL,
  `end` date DEFAULT NULL,
  `teacher_scientist_id` int(10) unsigned NOT NULL,
  `scientific_theme_id` int(11) NOT NULL,
  `ruler` tinyint(4) NOT NULL,
  PRIMARY KEY (`teacher_scientist_id`,`scientific_theme_id`,`supervisor_id`),
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
INSERT INTO `supervision` VALUES (1,'2017-01-01','2017-03-01',18,1,0),(3,'2017-04-19','2018-04-07',18,1,1),(4,'2017-01-20','2017-06-22',18,2,0),(18,'2017-04-05',NULL,18,9,1),(2,'2017-03-01','2017-04-19',19,1,0),(5,'2017-06-22',NULL,19,2,1),(19,'2017-05-05',NULL,19,10,1),(9,'2017-02-02','2017-06-06',20,5,0),(11,'2017-09-09',NULL,20,5,1),(13,'2017-06-07','2018-04-07',20,6,1),(10,'2017-06-06','2017-09-09',21,5,0),(12,'2017-01-12','2017-06-07',21,6,0),(15,'2017-10-10','2018-01-01',22,7,0),(17,'2018-02-02',NULL,22,8,1),(14,'2017-06-06','2017-10-10',23,7,0),(16,'2018-01-01','2018-04-07',23,7,1),(7,'2017-01-02','2017-05-23',24,4,0),(6,'2018-01-01',NULL,25,3,1),(8,'2017-05-23',NULL,25,4,1);
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
INSERT INTO `teacher` VALUES ('старший викладач','практик','2016-01-01',9,4),('лектор','старший викладач','2016-01-01',17,1),('лектор','профсеор','1995-12-12',18,1),('лектор','професор','2000-12-12',19,1),('лектор','старший викладач','2001-12-12',20,2),('лектор','професор','1993-12-12',21,2),('практик','старший викладач','2005-12-12',22,3),('практик','старший викладач','2002-12-12',23,3),('практик','старший викладач','2001-12-12',24,4),('практик','старший викладач','2001-12-12',25,4),('лектор','професор','1990-12-12',26,4);
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
INSERT INTO `working` VALUES ('Вичення алгоритмів (Частина - 3)','2017-01-02','2017-04-04',1,4),('Вивчення алгоритму','2017-01-12','2017-08-12',1,6),('вивчення cinema4d','2018-02-02',NULL,1,8),('Вивчення видів сортувань(Частина -1)','2017-06-06',NULL,1,9),('Створення 5 частини курсу','2017-08-08',NULL,1,10),('Аналіз алгоритмів','2017-01-01','2017-04-01',2,1),('Вичення алгоритмів (Частина - 2)','2017-01-02',NULL,2,4),('FrontEnd(Частина-1)','2017-02-02',NULL,2,5),('Вивчення видів сортувань(Частина -5)','2017-07-13',NULL,2,9),('Створення 2 частини курсу','2017-07-07',NULL,2,10),('Вивчення моделей пошуку','2018-01-01',NULL,3,3),('Вивчення 3d max','2018-02-02',NULL,3,8),('Аналіз мови Delphi (частина - 1)','2017-01-20','2017-05-25',4,2),('вивчення Toyota Touch 2','2017-06-06','2018-04-07',4,7),('Аналіз мови Delphi (частина - 2)','2017-04-20',NULL,5,2),('Аналіз переваг','2017-08-08','2018-04-07',5,7),('Аналіз (Частина 2)','2018-02-02',NULL,6,3),('Тестування','2017-01-12','2018-04-07',6,6),('BackEnd (частина -2)','2017-05-09','2018-04-07',8,1),('BackEnd(Частина-1)','2017-02-02','2017-05-05',8,5),('Написання коду(Частина - 2)','2017-04-04','2018-04-07',8,6),('Порівняння','2018-01-01','2018-04-07',8,7),('Test','2018-01-01',NULL,9,2),('Порівняння','2018-02-23',NULL,9,8),('Вивчення видів сортувань(Частина -6)','2017-08-08',NULL,9,9),('Створення 6 частини курсу','2017-09-01',NULL,9,10),('Створення 1 частини курсу','2017-07-07','2017-08-08',10,10),('Вивчення особливостей Delphi','2017-01-20','2017-06-06',11,2),('Розробка навчальної програми','2017-01-20','2017-07-01',12,2),('Аналіз(Частина - 1)','2018-01-01','2018-02-02',12,3),('FrontEnd(Частина-2)','2017-02-02',NULL,12,5),('Вивчення видів сортувань(Частина -3)','2017-07-01','2017-10-10',12,9),('FrontEnd','2017-01-09','2017-08-08',13,1),('Вичення алгоритмів (Частина - 1)','2017-01-02',NULL,13,4),('Написання коду(Частина - 1)','2017-01-12','2017-09-01',13,6),('вивчення Toyota Touch 2 with Go Plus','2017-06-06','2018-04-07',13,7),('Огляд алгоритмів пошуку данних','2018-01-01',NULL,14,3),('Вивчення видів сортувань(Частина -2)','2017-06-09',NULL,14,9),('BackEnd (частина -1)','2017-02-01','2017-05-09',15,1),('Аналіз недоліків','2017-08-08','2018-04-07',16,7),('BackEnd(Частина-2)','2017-04-03',NULL,17,5),('Порівняння(частина - 2)','2018-03-03',NULL,17,8),('Вичення алгоритмів (Частина - 5)','2017-05-05',NULL,18,4),('FrontEnd(Частина-3)','2017-03-03',NULL,18,5),('Аналіз(Частина - 3)','2018-02-01',NULL,19,3),('FrontEnd(Частина-4)','2017-04-04',NULL,19,5),('Створення 3 частини курсу','2017-07-20',NULL,20,10),('Вичення алгоритмів (Частина - 4)','2017-01-02',NULL,21,4),('Створення 4 частини курсу','2017-08-09',NULL,21,10),('Корегування багів','2017-06-06','2018-04-07',22,6),('Тестування','2017-03-03','2018-04-07',24,1),('Вивчення видів сортувань(Частина -4)','2017-06-10',NULL,24,9),('Аналіз','2017-02-02',NULL,25,5),('Спостереження','2017-07-07',NULL,26,2);
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

-- Dump completed on 2018-04-09 21:39:19
