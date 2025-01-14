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
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area` (
  `pincode` int NOT NULL,
  `area_name` varchar(30) NOT NULL,
  PRIMARY KEY (`pincode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (380001,'Dariapur'),(380002,'N C Nagar'),(380004,'Shahibag'),(380005,'Kabir chowk'),(380006,'Ambawadi'),(380007,'Anandnagar'),(380008,'Maninagar'),(380009,'Navarangpura'),(380013,'Naranpura'),(380015,'I I M'),(380016,'Meghaninagar'),(380018,'Saraspur'),(380019,'D Cabin'),(380021,'Gomtipur'),(380022,'Gitamandir'),(380023,'Rakhial'),(380024,'Bapunagar'),(380026,'Amraiwadi'),(380028,'Bhairavnath Road'),(380050,'Ghodasar'),(380051,'Jivraj Park'),(380052,'Memnagar'),(380054,'Thaltej'),(380055,'Juhapura'),(380058,'Bopal'),(380059,'Vastrapur'),(380061,'Ghatlodia'),(380063,'Sola H B C'),(382330,'Naroda'),(382340,'Kubernagar'),(382345,'saijpur Bogha'),(382350,'Nikol'),(382405,'Saijpur'),(382415,'Odhav'),(382418,'Vastral'),(382424,'Chandkheda'),(382425,'Pirana'),(382427,'Aslali'),(382440,'Vatva'),(382443,'Isanpur'),(382475,'Sardarnagar'),(382480,'Ranip');
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-09 15:11:28
