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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_fname` varchar(20) NOT NULL,
  `user_lname` varchar(20) NOT NULL,
  `email` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL,
  `contactno` varchar(10) NOT NULL,
  `address` varchar(200) NOT NULL,
  `role` varchar(30) NOT NULL,
  `pincode` int NOT NULL,
  `status` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_id`),
  KEY `pincode fk_idx` (`pincode`),
  CONSTRAINT `pincode fk` FOREIGN KEY (`pincode`) REFERENCES `area` (`pincode`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'Tej','Panchal','tejpanchal1999@gmail.com','cr/dywXiiGit9iPtSlXJOg==','9484463630','41,krishnapark sociery, sardar chowk, krishnanagar , ahmedabad','User',380006,1),(5,'Nikhar','Panchal','panchalnikhar4920@gmail.com','SzFdJp0UvqQcz1RzMemexQ==','9099227669','40,Krishnapark Sardar chowk krishnanagar','Admin',380023,1),(7,'Dhruv','Babariya','dhruvbabariya912001@gmail.com','ed3/YsV9W3rTsXa01bcc4w==','9484848484','26, Navlakhha Bungloow, Bapunagar, Ahmedabad','User',380004,1),(10,'Laxminarayan','Vyas','laxminarayanvyas077@gmail.com','ufY8Q4ipkCvTsXa01bcc4w==','9625813305','b-204,Smita appartment , radio mirchi road vejalpur ahmedabad','User',380016,1),(36,'KAJAL','PANCHAL','kajalpanchal962@gmail.com','bFBFXKeot5EwvwvS0hBTLA==','8866507827','40, krishnapark, opp maniba school, sardar chowk, krishnanagar, ahmedabad','User',382330,1),(37,'Naiya','Panchal','naiyapanchal007@gmail.com','kmNzEaOQ+k/TsXa01bcc4w==','6354062691','40, krishnapark society, Opp.Maniba school, sardar chowk, krishnanagar ,ahmedabad  ,gujarat','User',382330,1),(38,'Ravi123','Brahmbhatt','skbrkb611@gmail.com','YbxpFgZ1ADGJJSpQl9fUJg==','8545784585','jabjadjad','User',380016,1),(39,'abc','jaa','mariyamdoi97@gmail.com','xzw1FnReywmt9iPtSlXJOg==','8474747474','aknad','User',380023,0),(42,'Divyesh','Akbari','divyeshakabari01@gmail.com','LM1B1CeegVpe6rq3sWv8OA==','6354789455','1, Ramnagar Sociery, Nikol, Ahmedabad','Gardener',382350,1),(43,'Prince','Panchani','princepanchani890@gmail.com','OwEh+86YnWmcBUblDIuFtw==','8160840949','C-46 , Harikrupa Society , Nikol ','Gardener',382350,1),(44,'Harsh','Panchal','nikharp2000@gmail.com','SzFdJp0UvqQcz1RzMemexQ==','8849028614','40, Krishnapark Society, Sardar Chowk , Krishnanagar','User',380016,1),(45,'Maulik','Savaliya','savaliyamaulik786@gmail.com','04hpMQsG5JqcBUblDIuFtw==','8974561234','12/B Shaym Darshan , Nikol','Gardener',380006,1),(49,'Nikhar','Nikhar','nikhar.panchal123@gmail.com','SzFdJp0UvqQcz1RzMemexQ==','9099227767','40,Krishnapark Society','User',382350,1);
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

-- Dump completed on 2023-07-09 15:11:27
