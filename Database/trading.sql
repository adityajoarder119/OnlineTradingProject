-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: trading
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `stockordered`
--

DROP TABLE IF EXISTS `stockordered`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stockordered` (
  `orderId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `stockId` int NOT NULL,
  `quantityOrdered` int NOT NULL,
  `orderDate` varchar(45) NOT NULL,
  `totalPrice` double NOT NULL,
  PRIMARY KEY (`orderId`),
  KEY `userId_idx` (`userId`),
  KEY `stockId_idx` (`stockId`),
  CONSTRAINT `stockId` FOREIGN KEY (`stockId`) REFERENCES `stocks` (`stockId`),
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockordered`
--

LOCK TABLES `stockordered` WRITE;
/*!40000 ALTER TABLE `stockordered` DISABLE KEYS */;
INSERT INTO `stockordered` VALUES (6,4,4,10,'01/02/22',8500);
/*!40000 ALTER TABLE `stockordered` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stocks`
--

DROP TABLE IF EXISTS `stocks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stocks` (
  `stockId` int NOT NULL AUTO_INCREMENT,
  `stockName` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `availability` int NOT NULL,
  PRIMARY KEY (`stockId`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stocks`
--

LOCK TABLES `stocks` WRITE;
/*!40000 ALTER TABLE `stocks` DISABLE KEYS */;
INSERT INTO `stocks` VALUES (1,'Exavalu',100,30),(2,'CloudKaptan',500,60),(3,'TCS',1000,90),(4,'Wipro',850,200),(5,'Elijah',66853.92,100),(6,'Phillip',84421.95,250),(7,'Kenzie',69914.63,180),(8,'Regina',59682.39,1000),(9,'Irene',51795.67,300),(10,'Lucy',49056.65,200),(11,'Lily',57882.21,345),(12,'Noah',17978.68,878),(13,'Cedrick',98680.42,8799),(14,'Fred',26522.86,134),(15,'Elijah',66853.92,100),(16,'Phillip',84421.95,250),(17,'Kenzie',69914.63,180),(18,'Regina',59682.39,1000),(19,'Irene',51795.67,300),(20,'Lucy',49056.65,200),(21,'Lily',57882.21,345),(22,'Noah',17978.68,878),(23,'Cedrick',98680.42,8799),(24,'Fred',26522.86,134);
/*!40000 ALTER TABLE `stocks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `emailId` varchar(45) NOT NULL,
  `phoneNumber` varchar(10) NOT NULL,
  `dob` varchar(10) NOT NULL,
  `password` varchar(45) NOT NULL,
  `address` varchar(200) NOT NULL,
  `status` int NOT NULL DEFAULT '0',
  `otp` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `emailId_UNIQUE` (`emailId`),
  UNIQUE KEY `phoneNumber_UNIQUE` (`phoneNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Abhineet','abh@gmail.com','1234567890','0','kuchbhi','spj',0,NULL),(2,'Aditys Joarder','adityajoarder119@gmail.com','8972041619','2022-01-05','1234','asdasd',1,'8010'),(3,'adi j','sdg@asd.com','4569871235','2022-01-05','123','bvcfgdfg',0,NULL),(4,'ritu','rituparnabhattacharya0@gmail.com','1234568975','1998-10-31','12345','Purnia',0,'1498'),(6,'Aditys Joar','adityajoarder01@gmail.com','8972041614','2022-01-05','4568','asdasd',0,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wishlist`
--

DROP TABLE IF EXISTS `wishlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wishlist` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` varchar(45) NOT NULL,
  `stockId` int NOT NULL,
  `quantity` int NOT NULL,
  `availability` int NOT NULL,
  `totalPrice` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlist`
--

LOCK TABLES `wishlist` WRITE;
/*!40000 ALTER TABLE `wishlist` DISABLE KEYS */;
INSERT INTO `wishlist` VALUES (8,'4',2,10,70,5000);
/*!40000 ALTER TABLE `wishlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'trading'
--

--
-- Dumping routines for database 'trading'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-02  1:04:42
