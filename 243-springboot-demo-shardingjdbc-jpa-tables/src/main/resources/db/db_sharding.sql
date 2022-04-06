-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: test_db_sharding
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `tb_role_0`
--

DROP TABLE IF EXISTS `tb_role_0`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_role_0` (
  `id` bigint NOT NULL,
  `name` varchar(255) NOT NULL,
  `role_key` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_role_0`
--

LOCK TABLES `tb_role_0` WRITE;
/*!40000 ALTER TABLE `tb_role_0` DISABLE KEYS */;
INSERT INTO `tb_role_0` VALUES (3,'333','333','33','2021-09-08 17:09:15','2021-09-08 17:09:15');
/*!40000 ALTER TABLE `tb_role_0` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_role_1`
--

DROP TABLE IF EXISTS `tb_role_1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_role_1` (
  `id` bigint NOT NULL,
  `name` varchar(255) NOT NULL,
  `role_key` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_role_1`
--

LOCK TABLES `tb_role_1` WRITE;
/*!40000 ALTER TABLE `tb_role_1` DISABLE KEYS */;
INSERT INTO `tb_role_1` VALUES (1,'admin','admin','admin','2021-09-08 17:09:15','2021-09-08 17:09:15'),(2,'11','11','11','2021-09-08 17:09:15','2021-09-08 17:09:15');
/*!40000 ALTER TABLE `tb_role_1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_0`
--

DROP TABLE IF EXISTS `tb_user_0`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_user_0` (
  `id` bigint NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone_number` int DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_0`
--

LOCK TABLES `tb_user_0` WRITE;
/*!40000 ALTER TABLE `tb_user_0` DISABLE KEYS */;
INSERT INTO `tb_user_0` VALUES (718415228786159616,'pdai','dad','pdai@pdai.tech',121212121,'pdai','2022-04-06 20:45:38','2022-04-06 20:45:38');
/*!40000 ALTER TABLE `tb_user_0` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_1`
--

DROP TABLE IF EXISTS `tb_user_1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_user_1` (
  `id` bigint NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone_number` int DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_1`
--

LOCK TABLES `tb_user_1` WRITE;
/*!40000 ALTER TABLE `tb_user_1` DISABLE KEYS */;
INSERT INTO `tb_user_1` VALUES (1,'pdai','dfasdf','suzhou.daipeng@gmail.com',1212121213,'afsdfsaf','2021-09-08 17:09:15','2021-09-08 17:09:15'),(718415481409089537,'pdai2','dad2','pdai2@pdai.tech',1212121212,'pdai2','2022-04-06 20:46:38','2022-04-06 20:46:38');
/*!40000 ALTER TABLE `tb_user_1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_role_0`
--

DROP TABLE IF EXISTS `tb_user_role_0`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_user_role_0` (
  `id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_role_0`
--

LOCK TABLES `tb_user_role_0` WRITE;
/*!40000 ALTER TABLE `tb_user_role_0` DISABLE KEYS */;
INSERT INTO `tb_user_role_0` VALUES (1,1,1);
/*!40000 ALTER TABLE `tb_user_role_0` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_role_1`
--

DROP TABLE IF EXISTS `tb_user_role_1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_user_role_1` (
  `id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_role_1`
--

LOCK TABLES `tb_user_role_1` WRITE;
/*!40000 ALTER TABLE `tb_user_role_1` DISABLE KEYS */;
INSERT INTO `tb_user_role_1` VALUES (11,718415481409089537,3),(13,718415228786159616,2);
/*!40000 ALTER TABLE `tb_user_role_1` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-06 23:06:23
