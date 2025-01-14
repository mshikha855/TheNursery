-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: nurseryschema
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `order_table`
--

DROP TABLE IF EXISTS `order_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_table` (
  `order_id` varchar(50) NOT NULL DEFAULT 'abc',
  `order_date` varchar(50) DEFAULT NULL,
  `order_status` tinyint NOT NULL DEFAULT '0',
  `tot_amount` float DEFAULT NULL,
  `payment_status` tinyint NOT NULL DEFAULT '0',
  `delivery_status` varchar(40) DEFAULT 'Not Deliver',
  `user_id` int NOT NULL,
  `delivery_address` varchar(450) NOT NULL,
  `delivery_area` varchar(45) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_table`
--

LOCK TABLES `order_table` WRITE;
/*!40000 ALTER TABLE `order_table` DISABLE KEYS */;
INSERT INTO `order_table` VALUES ('ORDS_135463','27/05/2021 12:45:58',0,875,1,'Not Deliver',49,'40,Krishnapark ','Anandnagar'),('ORDS_274775','27/05/2021 09:38:29',0,575,1,'Not Deliver',44,'12/B Rupal Appartment ','Ranip'),('ORDS_434715','27/05/2021 09:41:01',0,525,1,'Not Deliver',2,'55, Nilkanth Appartment ','Gomtipur'),('ORDS_675627','27/05/2021 12:47:14',0,464,0,'Not Deliver',49,'12/B Rupal Apaartment','Amraiwadi'),('ORDS_960028','27/05/2021 09:43:32',0,100,0,'Deliver',2,'19 Maruti Park , Krishnanagar','Naroda'),('ORDS_976380','13/06/2022 17:09:51',0,625,1,'Not Deliver',44,'dbjsbfjsbf','Gomtipur');
/*!40000 ALTER TABLE `order_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-09 15:11:27
