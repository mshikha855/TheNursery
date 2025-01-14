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
-- Table structure for table `service_booking`
--

DROP TABLE IF EXISTS `service_booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_booking` (
  `booking_id` varchar(15) NOT NULL,
  `booking_status` tinyint NOT NULL DEFAULT '0',
  `payment_status` tinyint NOT NULL DEFAULT '0',
  `booking_date` varchar(20) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `amount` varchar(5) NOT NULL,
  `gardener_id` int NOT NULL,
  `user_id` int NOT NULL,
  `service_area` varchar(200) NOT NULL,
  `service_address` varchar(200) NOT NULL,
  `service_id` varchar(50) NOT NULL,
  PRIMARY KEY (`booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_booking`
--

LOCK TABLES `service_booking` WRITE;
/*!40000 ALTER TABLE `service_booking` DISABLE KEYS */;
INSERT INTO `service_booking` VALUES ('SERVICE_106126',0,1,'09/04/2021 11:41:37',NULL,'540',0,7,'Kabir chowk','09/ Ramnanagr Society , Uttamnagar','3'),('SERVICE_152257',0,1,'10/04/2021 13:41:10',NULL,'1000',0,44,'Kabir chowk','40, Krishnapark Society , Sardar Chowk','4'),('SERVICE_422932',1,0,'29/03/2021 14:32:16',NULL,'200',42,2,'Bapunagar','khfsl','2'),('SERVICE_57685',0,0,'27/05/2021 12:48:53',NULL,'1000',0,49,'Amraiwadi','abc','4'),('SERVICE_697048',0,1,'10/04/2021 22:31:12',NULL,'1000',45,44,'Anandnagar','40, Krishnapark Society, Sardar chowk ','4'),('SERVICE_853856',1,1,'29/03/2021 14:33:53',NULL,'1000',42,2,'Saraspur','nabcgaey','4'),('SERVICE_878945',0,0,'08/05/2021 11:58:33',NULL,'1500',43,44,'Gitamandir','6/B Rupal Appartment , Ranip','5'),('SERVICE_987099',1,1,'08/05/2021 11:54:35',NULL,'1000',42,44,'Meghaninagar','09/B Vijay Park Society','4');
/*!40000 ALTER TABLE `service_booking` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-09 15:11:29
