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
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Surname` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Pol` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `BirthDay` date DEFAULT NULL,
  `Username` varchar(250) CHARACTER SET utf8 NOT NULL,
  `Password` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Email` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `PrihvacenZahtev` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `TipKorisnika` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Job` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Username_UNIQUE` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (12,'jana','jovic','zenski','1990-12-10','admin','c702c01472345ec0be3af8873cd09a392922f557','user1@gmail.com','true','admin','pekar'),(80,'ana','peric','zenski','2002-02-02','ana','0d55286a8808b072eded6147e10e10e7e5eb7cfb','anaperic@gmail.com','true','ucesnik','lekar'),(81,'ivan','peric','muski','2003-02-01','ivanperic','fe13bf0eb2f4dfc09b9f6eee409b571c39ab7cc8','ivan@gmail.com','true','ucesnik','pekar'),(82,'mira','lazic','zenski','2003-03-03','mira','547a30d42c0846d05f3551021029c18d190989fb','miral@gmail.com','true','ucesnik','pevacica'),(83,'jovan','mikic','muski','1992-03-21','jovan','b673365fd1cc8eb4d7b7addc6cfead4d5ecc5bd9','jovan@gmail.com','true','ucesnik','vozac'),(84,'marko','markovic','muski','1994-02-13','marko','3d835f6b25aa4a4f7c43f29cfd6434644c181310','marko@gmail.com','true','ucesnik','pekar'),(86,'lara','peric','zenski','1992-03-12','lara','cb0ef376ac56bea9fd216c9ec669aaa8b5d65b10','lara@gmail.com','true','supervizor','pilot'),(87,'olja','jovic','zenski','1991-06-22','olja','f459a1049d59b9d90408b3fce75ea0567bfb5169','olja@gmail.com','true','supervizor','doktor'),(88,'mirko','nedic','muski','1993-02-11','mirko','3709d63a07e2fbbb0fb5abfc0f5c794209c71b11','mirko@gmail.com','true','supervizor','student'),(89,'klara','nedic','zenski','1994-01-23','klara','b00563dc22db31f3ee314557fb4c30b053bc5736','klara@gmail.com','true','supervizor','student'),(90,'ceca','jovic','zenski','2009-01-01','ceca','6d91345aee81a24fec1b96c9280e404436f37486','ceca@gmail.com','true','admin','lekar'),(91,'ranka','ralic','zenski','2003-01-13','ranka','fc82663529c53c0e224c792707a99863824fac99','ranka@gmail.com','false','ucesnik','prodavac'),(92,'duki','dulic','muski','1997-01-23','duki','c0c9c19fcbda07f0a0a6efba21e255a963d6ebf1','duki@gmail.com','false','ucesnik','student'),(93,'miki','miric','muski','1991-06-16','miki','bdd805db8a3a3222d9c679100417ac8dd207e456','miki@gmail.com','false','ucesnik','vozac'),(94,'rale','miric','muski','1991-02-02','rale','d21479fd6ed37417b0f9f3f32e9c43f0307400e0','rale@gmail.com','false','ucesnik','prodavac'),(96,'bora','boric','muski','1993-04-04','bora','8f17edc7c017cb7f81d730074473b45fdb6ed1eb','bora@gmail.com','false','ucesnik','nastavnik'),(97,'neda','neric','zenski','2003-02-01','neda','a7d9b6d1e23ba8896ac88fc835253ebbab9d3867','neda@gmail.com','false','ucesnik','student'),(98,'dara','neric','muski','1994-01-12','dara','db66641b5e5a48b1da21768331b1b062cbbc02cb','dara@gmail.com','false','ucesnik','pevac'),(99,'anita','peric','zenski','2000-01-01','anitaperic','e62d130d959191524e3b4927d9a199fb3ba78268','anita@gmail.com','true','ucesnik','advokat'),(100,'ilija','jovic','muski','2002-02-02','ilijaperic','4b8d628f6f75469650d8a6cd0c189dcd60e5f4e5','ilija@gmail.com','true','ucesnik','pekar'),(101,'igor','igic','muski','1997-09-28','igorigic','a331b60b4247865e962b90580b1422e9f8754a81','igor@gmail.com','true','ucesnik','veterinar'),(102,'miki','mikic','muski','1991-01-01','mikimikic','8fa4f0ee55c6d357cb4ab846400bc901fe1c2481','miki@gmail.com','true','ucesnik','glumac'),(103,'niki','nikic','zenski','2000-01-23','nikinikic','71ee0ddaf7d4f3b5e482237db5b5096a9b4bfab4','niki@gmail.com','true','ucesnik','stolar'),(104,'daki','dakic','muski','1996-01-12','dakidakic','29826cf67f225d2b1ecf10725d2ec03013d79788','daki@gmail.com','true','ucesnik','student'),(105,'caki','cakic','zenski','1998-01-12','cakicakic','d417cb3cd13c440ab964b3bd9f0e86d6c277a834','caki@gmail.com','true','ucesnik','student'),(106,'maki','makic','zenski','1991-01-01','makimakic','feba435992cf0bc8adffeeb7675baf25f9d15c0a','maki@gmail.com','true','ucesnik','student'),(107,'deki','dekic','muski','1994-02-13','dekidekic','89c4e87a2f3bc10cd92d2fd0ecd53c3cb92da859','deki@gmail.com','true','ucesnik','student'),(108,'ana','dekic','zenski','2003-02-01','anaana','b3d1578723864327f6c1893a1417a53ee370bd05','anaana@gmail.com','true','ucesnik','student'),(109,'mira','dekic','zenski','2003-03-03','miramira','763789efe6531230166cc0b4182ab1f2ac22b035','mira@gmail.com','true','ucesnik','student');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
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
