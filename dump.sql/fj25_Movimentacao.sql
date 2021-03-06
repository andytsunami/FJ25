CREATE DATABASE  IF NOT EXISTS `fj25` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `fj25`;
-- MySQL dump 10.13  Distrib 5.5.22, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: fj25
-- ------------------------------------------------------
-- Server version	5.5.22-0ubuntu1

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
-- Table structure for table `Movimentacao`
--

DROP TABLE IF EXISTS `Movimentacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Movimentacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `tipoMovimentacao` varchar(255) DEFAULT NULL,
  `valor` decimal(19,2) DEFAULT NULL,
  `conta_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK257EB923C547677D` (`conta_id`),
  CONSTRAINT `FK257EB923C547677D` FOREIGN KEY (`conta_id`) REFERENCES `Conta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Movimentacao`
--

LOCK TABLES `Movimentacao` WRITE;
/*!40000 ALTER TABLE `Movimentacao` DISABLE KEYS */;
INSERT INTO `Movimentacao` VALUES (5,'2013-01-09 19:25:08','Lalala','ENTRADA',10.50,2),(8,'2013-01-09 20:02:01','Conta de luz  - abril 2012','SAIDA',100.00,4),(9,'2013-01-09 20:02:39','Conta de luz  - abril 2012','SAIDA',100.00,5),(10,'2013-01-09 20:07:12','Conta de luz  - abril 2012','SAIDA',100.00,6),(11,'2013-01-09 20:18:19','Conta de luz  - abril 2012','SAIDA',100.00,7),(14,'2013-01-09 00:00:00','Michel JSF','ENTRADA',10.20,2),(15,'2013-01-09 00:00:00','mariazinha','SAIDA',21.00,5),(17,'2013-01-09 00:00:00','Seraaaaa','ENTRADA',2.00,4),(18,'2013-01-14 00:00:00','Teste das tags','ENTRADA',1000.00,2),(19,'2013-01-14 00:00:00','Mais tag',NULL,11.00,3),(20,'2013-01-14 00:00:00','3','ENTRADA',21.00,2),(21,'2013-01-14 00:00:00','Agora com filter','ENTRADA',666.00,5),(29,'2013-01-20 22:30:34',NULL,'SAIDA',114.00,9),(30,'2013-01-16 22:30:34',NULL,'SAIDA',891.00,9),(31,'2013-01-21 22:30:34',NULL,'SAIDA',276.00,9),(32,'2013-01-26 22:30:34',NULL,'SAIDA',746.00,9),(33,'2013-01-19 22:30:34',NULL,'SAIDA',894.00,9),(34,'2013-01-24 22:30:34',NULL,'SAIDA',758.00,9),(35,'2013-01-22 22:30:34',NULL,'SAIDA',615.00,9),(36,'2013-01-25 22:30:34',NULL,'SAIDA',192.00,9),(37,'2013-01-23 22:30:34',NULL,'SAIDA',957.00,9),(38,'2013-01-24 22:30:34',NULL,'SAIDA',228.00,9),(39,'2013-01-23 22:30:34',NULL,'SAIDA',582.00,9),(40,'2013-01-23 22:30:34',NULL,'SAIDA',157.00,9),(41,'2013-01-25 22:30:34',NULL,'SAIDA',736.00,9),(42,'2013-01-21 22:30:34',NULL,'SAIDA',500.00,9),(43,'2013-01-20 22:30:34',NULL,'SAIDA',846.00,9),(44,'2013-01-21 22:30:34',NULL,'SAIDA',614.00,9),(45,'2013-01-18 22:30:34',NULL,'SAIDA',625.00,9),(46,'2013-01-16 22:30:34',NULL,'SAIDA',452.00,9),(47,'2013-01-21 22:30:34',NULL,'SAIDA',220.00,9),(48,'2013-01-27 22:30:34',NULL,'SAIDA',481.00,9),(49,'2013-01-27 22:30:34',NULL,'SAIDA',153.00,9),(50,'2013-01-25 22:30:34',NULL,'SAIDA',330.00,9),(51,'2013-01-25 22:30:34',NULL,'SAIDA',334.00,9),(52,'2013-01-17 22:30:34',NULL,'SAIDA',114.00,9),(53,'2013-01-28 22:30:34',NULL,'SAIDA',368.00,9),(54,'2013-01-16 22:30:34',NULL,'SAIDA',755.00,9),(55,'2013-01-24 22:30:34',NULL,'SAIDA',17.00,9),(56,'2013-01-17 22:30:34',NULL,'SAIDA',850.00,9),(57,'2013-01-24 22:30:34',NULL,'SAIDA',363.00,9),(58,'2013-01-23 22:30:34',NULL,'SAIDA',705.00,9),(59,'2013-01-18 22:30:34',NULL,'SAIDA',625.00,9),(60,'2013-01-22 22:30:34',NULL,'SAIDA',993.00,9),(61,'2013-01-30 22:30:34',NULL,'SAIDA',25.00,9),(62,'2013-01-26 22:30:34',NULL,'SAIDA',304.00,9),(63,'2013-01-21 22:30:34',NULL,'SAIDA',102.00,9),(64,'2013-01-29 22:30:34',NULL,'SAIDA',137.00,9),(65,'2013-01-23 22:30:34',NULL,'SAIDA',255.00,9),(66,'2013-01-21 22:30:34',NULL,'SAIDA',396.00,9),(67,'2013-01-23 22:30:34',NULL,'SAIDA',996.00,9),(68,'2013-01-19 22:30:34',NULL,'SAIDA',275.00,9),(69,'2013-01-22 22:30:34',NULL,'SAIDA',928.00,9),(70,'2013-01-23 22:30:34',NULL,'SAIDA',484.00,9),(71,'2013-01-20 22:30:34',NULL,'SAIDA',705.00,9),(72,'2013-01-25 22:30:34',NULL,'SAIDA',479.00,9),(73,'2013-01-17 22:30:34',NULL,'SAIDA',934.00,9),(74,'2013-01-29 22:30:34',NULL,'SAIDA',35.00,9),(75,'2013-01-16 22:30:34',NULL,'SAIDA',107.00,9),(76,'2013-01-23 22:30:34',NULL,'SAIDA',72.00,9),(77,'2013-01-22 22:30:34',NULL,'SAIDA',765.00,9),(78,'2013-01-27 22:30:34',NULL,'SAIDA',435.00,9);
/*!40000 ALTER TABLE `Movimentacao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-01-17 23:09:40
