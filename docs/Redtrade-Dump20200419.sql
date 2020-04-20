-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: redtrade
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `action` varchar(10) DEFAULT NULL,
  `symbol` char(7) DEFAULT NULL,
  `shares` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `history_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES (1,'2020-03-14','BUY','AAPL',5,170,5);
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `holding`
--

DROP TABLE IF EXISTS `holding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `holding` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shares` varchar(45) DEFAULT NULL,
  `symbol` char(7) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `user_id_idx` (`user_id`),
  KEY `symbol_idx` (`symbol`),
  CONSTRAINT `symbol` FOREIGN KEY (`symbol`) REFERENCES `stock` (`symbol`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `holding`
--

LOCK TABLES `holding` WRITE;
/*!40000 ALTER TABLE `holding` DISABLE KEYS */;
INSERT INTO `holding` VALUES (1,'10','AAPL',5),(2,'5','GOOG',6);
/*!40000 ALTER TABLE `holding` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock` (
  `symbol` char(7) NOT NULL,
  `company` varchar(45) DEFAULT NULL,
  `link` varchar(45) DEFAULT NULL,
  `current_price` float DEFAULT NULL,
  PRIMARY KEY (`symbol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES ('AAPL','apple.com','https://www.apple.com/',280),('FB','facebook.com','https://www.facebook.com/',180),('GOOG','google.com','https://www.goole.com/',1500);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idUser_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (5,'tsmith','abc123','tony','smith','tsmith@redtrade.com'),(6,'mjohns','abc123','mike','johns','mjohns@redtrade.com'),(7,'hshin','abc123','hyunsook','shin','hshin@redtrade.com'),(8,'username33','pass2','first2','last2','email@redtrade.com2'),(9,'username','pass','first','last','email@redtrade.com');
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

-- Dump completed on 2020-04-19 20:56:37
