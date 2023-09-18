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
-- Table structure for table `SupervizorOdobri`
--

DROP TABLE IF EXISTS `SupervizorOdobri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SupervizorOdobri` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) COLLATE latin2_croatian_ci DEFAULT NULL,
  `rec` varchar(45) COLLATE latin2_croatian_ci DEFAULT NULL,
  `odobreno` int(11) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin2 COLLATE=latin2_croatian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SupervizorOdobri`
--

LOCK TABLES `SupervizorOdobri` WRITE;
/*!40000 ALTER TABLE `SupervizorOdobri` DISABLE KEYS */;
INSERT INTO `SupervizorOdobri` VALUES (1,'ana','MUS',0),(2,'mira','MUSLI',0),(3,'jovan','OLOVKA',0),(4,'marko','SVESKA',0),(5,'dakidakic','LETOVANJE',0),(6,'miramira','SET',1),(7,'miramira','METE',1),(8,'miramira','VMC',1),(9,'miramira','KRIZA',1),(10,'miramira','FILE',1),(11,'ana','PITA',1),(12,'anaana','V',2),(16,'anaana','ROBA',1),(18,'anaana','ONA',0),(19,'dakidakic','OBRAZ',1),(20,'dakidakic','VIS',1),(21,'dakidakic','TU',1),(22,'dakidakic','VRT',1);
/*!40000 ALTER TABLE `SupervizorOdobri` ENABLE KEYS */;
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
