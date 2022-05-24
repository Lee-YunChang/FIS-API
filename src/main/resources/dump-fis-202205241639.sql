-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: fis
-- ------------------------------------------------------
-- Server version	5.5.5-10.5.9-MariaDB

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
-- Table structure for table `contract_information`
--

DROP TABLE IF EXISTS `contract_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract_information` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `channel_name` varchar(255) DEFAULT NULL,
  `rate` int(11) DEFAULT NULL,
  `create_dtime` date DEFAULT NULL,
  `youtube_channel_id` bigint(20) DEFAULT NULL,
  `creator_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `contract_information_FK` (`creator_id`),
  KEY `contract_information_FK_1` (`youtube_channel_id`),
  CONSTRAINT `contract_information_FK` FOREIGN KEY (`creator_id`) REFERENCES `creator` (`id`),
  CONSTRAINT `contract_information_FK_1` FOREIGN KEY (`youtube_channel_id`) REFERENCES `youtube_channel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_information`
--

LOCK TABLES `contract_information` WRITE;
/*!40000 ALTER TABLE `contract_information` DISABLE KEYS */;
/*!40000 ALTER TABLE `contract_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creator`
--

DROP TABLE IF EXISTS `creator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `creator` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `create_dtime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creator`
--

LOCK TABLES `creator` WRITE;
/*!40000 ALTER TABLE `creator` DISABLE KEYS */;
/*!40000 ALTER TABLE `creator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `settlement_detail`
--

DROP TABLE IF EXISTS `settlement_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `settlement_detail` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `settlement_amt` int(11) DEFAULT NULL,
  `create_dtime` date DEFAULT NULL,
  `contract_information_id` bigint(20) DEFAULT NULL,
  `youtube_channel_profit_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `settlement_detail_FK` (`youtube_channel_profit_id`),
  KEY `settlement_detail_FK_1` (`contract_information_id`),
  CONSTRAINT `settlement_detail_FK` FOREIGN KEY (`youtube_channel_profit_id`) REFERENCES `youtue_channel_profit` (`id`),
  CONSTRAINT `settlement_detail_FK_1` FOREIGN KEY (`contract_information_id`) REFERENCES `contract_information` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settlement_detail`
--

LOCK TABLES `settlement_detail` WRITE;
/*!40000 ALTER TABLE `settlement_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `settlement_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `youtube_channel`
--

DROP TABLE IF EXISTS `youtube_channel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `youtube_channel` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `channel_name` varchar(255) DEFAULT NULL,
  `company_rs` int(11) DEFAULT NULL,
  `create_dtime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `youtube_channel`
--

LOCK TABLES `youtube_channel` WRITE;
/*!40000 ALTER TABLE `youtube_channel` DISABLE KEYS */;
/*!40000 ALTER TABLE `youtube_channel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `youtue_channel_profit`
--

DROP TABLE IF EXISTS `youtue_channel_profit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `youtue_channel_profit` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `company_rs_amt` int(11) DEFAULT NULL,
  `creator_rs_amt` int(11) DEFAULT NULL,
  `profit_amt` int(11) DEFAULT NULL,
  `profit_dtime` date DEFAULT NULL,
  `youtube_channel_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `youtue_channel_profit_FK` (`youtube_channel_id`),
  CONSTRAINT `youtue_channel_profit_FK` FOREIGN KEY (`youtube_channel_id`) REFERENCES `youtube_channel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `youtue_channel_profit`
--

LOCK TABLES `youtue_channel_profit` WRITE;
/*!40000 ALTER TABLE `youtue_channel_profit` DISABLE KEYS */;
/*!40000 ALTER TABLE `youtue_channel_profit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'fis'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-24 16:39:53
