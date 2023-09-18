-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: let1
-- ------------------------------------------------------
-- Server version	5.7.26-0ubuntu0.16.04.1

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
-- Table structure for table `OdigranaIgraDana`
--

DROP TABLE IF EXISTS `OdigranaIgraDana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `OdigranaIgraDana` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `odigrano` int(11) DEFAULT '0',
  `datum` date DEFAULT NULL,
  `bodovi` int(11) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=288 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OdigranaIgraDana`
--

LOCK TABLES `OdigranaIgraDana` WRITE;
/*!40000 ALTER TABLE `OdigranaIgraDana` DISABLE KEYS */;
INSERT INTO `OdigranaIgraDana` VALUES (1,'ilijaperic',1,'2019-07-10',64),(2,'igorigic',1,'2019-07-10',33),(3,'mikimikic',1,'2019-07-10',55),(4,'nikinikic',1,'2019-07-10',21),(5,'dakidakic',1,'2019-07-10',24),(6,'cakicakic',1,'2019-07-10',57),(7,'makimakic',1,'2019-07-10',60),(8,'dekidekic',1,'2019-07-10',80),(9,'anaana',1,'2019-07-10',30),(10,'miramira',1,'2019-07-10',40),(11,'miramira',1,'2019-07-09',15),(13,'dekidekic',0,'2019-07-09',33),(224,'miramira',1,'2019-07-08',6),(229,'ana',1,'2019-07-09',47),(230,'ana',0,'2019-07-09',NULL),(231,'ana',0,'2019-07-09',NULL),(232,'ana',0,'2019-07-09',NULL),(233,'mira',1,'2019-07-09',35),(234,'marko',1,'2019-07-09',38),(235,'marko',0,'2019-07-09',NULL),(236,'dakidakic',0,'2019-07-09',0),(266,'anaana',1,'2019-07-09',50),(267,'anaana',0,'2019-07-09',NULL),(268,'anaana',0,'2019-07-09',NULL),(269,'anaana',0,'2019-07-09',NULL),(270,'anaana',0,'2019-07-09',NULL),(271,'anaana',0,'2019-07-09',NULL),(272,'miramira',0,'2019-07-09',NULL),(273,'dekidekic',0,'2019-07-09',NULL),(274,'dakidakic',0,'2019-07-09',NULL),(275,'dakidakic',0,'2019-07-09',NULL),(276,'dakidakic',0,'2019-07-09',NULL),(277,'dakidakic',0,'2019-07-09',NULL),(278,'dakidakic',0,'2019-07-09',NULL),(279,'dakidakic',0,'2019-07-09',NULL),(280,'dakidakic',0,'2019-07-09',NULL),(281,'dakidakic',0,'2019-07-09',NULL),(282,'dakidakic',0,'2019-07-09',NULL),(283,'dakidakic',0,'2019-07-09',NULL),(284,'dakidakic',0,'2019-07-09',NULL),(285,'dakidakic',0,'2019-07-09',NULL),(286,'dakidakic',0,'2019-07-09',NULL),(287,'dakidakic',0,'2019-07-09',NULL);
/*!40000 ALTER TABLE `OdigranaIgraDana` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-09 16:08:14
