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
-- Table structure for table `Partija`
--

DROP TABLE IF EXISTS `Partija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Partija` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `plaviUsername` varchar(35) DEFAULT NULL,
  `plaviPoeni` int(11) DEFAULT NULL,
  `crveniUsername` varchar(35) DEFAULT NULL,
  `crveniPoeni` int(11) unsigned DEFAULT NULL,
  `Ishod` varchar(35) DEFAULT NULL,
  `datumIganja` date DEFAULT NULL,
  `potvrdioCrveni` int(11) DEFAULT '0',
  `potvrdionPlavi` int(11) DEFAULT '0',
  `aktivnaIgra` int(11) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Partija`
--

LOCK TABLES `Partija` WRITE;
/*!40000 ALTER TABLE `Partija` DISABLE KEYS */;
INSERT INTO `Partija` VALUES (1,'ana',25,'ivanperic',34,'ivanperic','2019-07-01',1,1,1),(2,'ana',13,'ivanperic',24,'ivanperic','2019-07-02',1,1,1),(3,'ana',45,'ivanperic',41,'ana','2019-07-03',1,1,1),(4,'ana',32,'mira',14,'ana','2019-07-04',1,1,1),(5,'ana',15,'jovan',55,'jovan','2019-07-04',1,1,1),(6,'ana',17,'marko',22,'marko','2019-07-05',1,1,1),(7,'ana',22,'anitaperic',33,'anitaperic','2019-07-07',1,1,1),(8,'ilijaperic',44,'igorigic',55,'igorigic','2019-07-04',1,1,1),(9,'igorigic',40,'mikimikic',55,'mikimikic','2019-07-08',1,1,1),(10,'nikinikic',50,'dakidakic',60,'dakidakic','2019-07-09',1,1,1),(11,'dakidakic',60,'cakicakic',70,'cakicakic','2019-07-02',1,1,1),(12,'cakicakic',10,'makimakic',20,'makimakic','2019-07-04',1,1,1),(13,'makimakic',10,'dekidekic',10,'nereseno','2019-07-05',1,1,1),(14,'anaana',20,'miramira',20,'nereseno','2019-07-05',1,1,1),(15,'ana',45,'igorigic',41,'ana','2019-07-04',1,1,1),(16,'ana',32,'ilijaperic',14,'ana','2019-07-05',1,1,1),(17,'makimakic',15,'jovan',55,'jovan','2019-07-06',1,1,1),(18,'makimakic',17,'marko',22,'marko','2019-07-07',1,1,1),(19,'igorigic',22,'anitaperic',33,'anitaperic','2019-07-08',1,1,1),(20,'nikinikic',44,'igorigic',55,'igorigic','2019-07-09',1,1,1),(21,'cakicakic',40,'mikimikic',55,'mikimikic','2019-07-10',1,1,1),(22,'dakidakic',50,'makimakic',60,'makimakic','2019-07-10',1,1,1),(23,'dakidakic',60,'anaana',70,'anaana','2019-07-10',1,1,1),(24,'anaana',10,'makimakic',20,'makimakic','2019-07-10',1,1,1),(25,'anaana',10,'dekidekic',10,'nereseno','2019-07-09',1,1,1),(26,'anaana',20,'miramira',20,'nereseno','2019-07-09',1,1,1);
/*!40000 ALTER TABLE `Partija` ENABLE KEYS */;
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
