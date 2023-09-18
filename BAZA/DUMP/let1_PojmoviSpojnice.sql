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
-- Table structure for table `PojmoviSpojnice`
--

DROP TABLE IF EXISTS `PojmoviSpojnice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PojmoviSpojnice` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `polje11` varchar(45) DEFAULT NULL COMMENT ' ',
  `polje12` varchar(45) DEFAULT NULL,
  `polje21` varchar(45) DEFAULT NULL,
  `polje22` varchar(45) DEFAULT NULL,
  `polje31` varchar(45) DEFAULT NULL,
  `polje32` varchar(45) DEFAULT NULL,
  `polje41` varchar(45) DEFAULT NULL,
  `polje42` varchar(45) DEFAULT NULL,
  `polje51` varchar(45) DEFAULT NULL,
  `polje52` varchar(45) DEFAULT NULL,
  `polje61` varchar(45) DEFAULT NULL,
  `polje62` varchar(45) DEFAULT NULL,
  `polje71` varchar(45) DEFAULT NULL,
  `polje72` varchar(45) DEFAULT NULL,
  `polje81` varchar(45) DEFAULT NULL,
  `polje82` varchar(45) DEFAULT NULL,
  `polje91` varchar(45) DEFAULT NULL,
  `polje92` varchar(45) DEFAULT NULL,
  `polje101` varchar(45) DEFAULT NULL,
  `polje102` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PojmoviSpojnice`
--

LOCK TABLES `PojmoviSpojnice` WRITE;
/*!40000 ALTER TABLE `PojmoviSpojnice` DISABLE KEYS */;
INSERT INTO `PojmoviSpojnice` VALUES (1,'1','1','2','2','3','3','4','4','5','5','6','6','7','7','8','8','9','9','10','10'),(2,'ime','ana','prezime','peric','godine','21','kosa','plava','visina','163','nacionalnost','srpska','vozac','da','zanimanje','pevac','mesto','Beograd','suprug','Pera'),(3,'Ivo Andric','Aska i vuk','Dis','Medju svojima','Jovan Ducic','Podne','Ana Frank','Dnevnik','Oskar Davico','Srbija','Bora Stankovic','Uvela ruza','Eva Kiri','Marija Kiri','E. Hemingvej','Starac i more','D. Kovacevic','Ko to tamo peva','R. Petrovic','Afrika'),(7,'Crna Gora','Budva','Hrvatska','Dubrovnik','Srbija','Kragujevac','Slovenija','Maribor','Makedonija','Skoplje','Italija','Milano','Francuska','Pariz','Spanija','Madrid','Rumunija','Bukurest','Nemacka','Berlin'),(8,'Partizan','Beograd','Juventus','Torino','Arsenal','London','Bajern','Minhen','Ajax','Amsterdam','Hajduk','Split','Atletiko','Madrid','Borusija','Dortmund','Crvena Zvezda','Beograd','Sloboda','Uzice'),(9,'A','Austrija','AUS','Australija','GR','Grcka','D','Nemacka','GE','Gruzija','IRL','Irska','IR','Iran','I','Italija','B','Belgija','BZ','Belize'),(10,'CDN','Kanada','DK','Danska','EC','Ekvador','F','Francuska','GH','Gana','H','Madjarska','J','Japan','JOR','Jordan','KWT','Kuvajt','LAO','Laos'),(11,'Alber Kami','Stranac','Balzak','Cica Gorio','B. Stankovic','Necista krv','Viktor Igo','Jadnici','Ivo Andric','Travnicka hronika','B. Stankovic','Kostana','M. Selimovic','Tvrdjava','M. Crnjanski','Seobe','Aleksa Santic','Hasanaginica','Dz. Dzojs','Dablinci'),(12,'+34','Spanija','+7','Rusija','+44','Engleska','+32','Belgija','+46','Svedska','+359','Bugarska','+381','Srbija','+39','Italija','+420','Ceska','+385','Hrvatska'),(13,'169','13','64','8','625','25','25','5','289','17','121','11','441','21','81','9','361','19','9','3'),(14,'Aladin','Filip Pulman','Bambi','Feliks Salten','Ruzno pace','H. K. Andersen','Pepeljuga','Sarl Pero','Lepotica i zver','Linda Vulverton','Petar Pan','Dzejms Bari','Snezana','Braca Grim','Alisa','Luis Kerol','Zlatokosa','Braca Grim','Knjiga o dzungli','R. Kipling');
/*!40000 ALTER TABLE `PojmoviSpojnice` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-09 16:08:15
