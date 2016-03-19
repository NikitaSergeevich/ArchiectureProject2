CREATE DATABASE  IF NOT EXISTS `orderinfo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `orderinfo`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: orderinfo
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `order1458219619055`
--

DROP TABLE IF EXISTS `order1458219619055`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order1458219619055` (
  `item_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_id` varchar(20) DEFAULT NULL,
  `description` varchar(80) DEFAULT NULL,
  `item_price` float(7,2) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order1458219619055`
--

LOCK TABLES `order1458219619055` WRITE;
/*!40000 ALTER TABLE `order1458219619055` DISABLE KEYS */;
INSERT INTO `order1458219619055` VALUES (1,'SH001','Saaz Hops',6.00);
/*!40000 ALTER TABLE `order1458219619055` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order1458289401165`
--

DROP TABLE IF EXISTS `order1458289401165`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order1458289401165` (
  `item_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_id` varchar(20) DEFAULT NULL,
  `description` varchar(80) DEFAULT NULL,
  `item_price` float(7,2) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order1458289401165`
--

LOCK TABLES `order1458289401165` WRITE;
/*!40000 ALTER TABLE `order1458289401165` DISABLE KEYS */;
INSERT INTO `order1458289401165` VALUES (1,'LC001','Lemon Cypress',67.00);
/*!40000 ALTER TABLE `order1458289401165` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order1458291108505`
--

DROP TABLE IF EXISTS `order1458291108505`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order1458291108505` (
  `item_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_id` varchar(20) DEFAULT NULL,
  `description` varchar(80) DEFAULT NULL,
  `item_price` float(7,2) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order1458291108505`
--

LOCK TABLES `order1458291108505` WRITE;
/*!40000 ALTER TABLE `order1458291108505` DISABLE KEYS */;
INSERT INTO `order1458291108505` VALUES (1,'LC001','Lemon Cypress',67.00);
/*!40000 ALTER TABLE `order1458291108505` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `order_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_date` varchar(30) DEFAULT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `address` varchar(80) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `total_cost` float(10,2) DEFAULT NULL,
  `shipped` tinyint(1) DEFAULT NULL,
  `ordertable` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (25,'2/5/2016 16:0:19','Nikita','Nikita','street','111',6.00,1,'order1458219619055'),(26,'2/6/2016 11:23:21','Nikita','Nikita','Street','8999152',67.00,1,'order1458289401165'),(27,'2/6/2016 11:51:48','d','d','d','d',67.00,0,'order1458291108505');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordersleaftech`
--

DROP TABLE IF EXISTS `ordersleaftech`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordersleaftech` (
  `order_id` int(10) DEFAULT NULL,
  `order_date` varchar(30) DEFAULT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `address` varchar(80) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `total_cost` float(10,2) DEFAULT NULL,
  `shipped` tinyint(1) DEFAULT NULL,
  `ordertable` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordersleaftech`
--

LOCK TABLES `ordersleaftech` WRITE;
/*!40000 ALTER TABLE `ordersleaftech` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordersleaftech` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-19 16:00:30
