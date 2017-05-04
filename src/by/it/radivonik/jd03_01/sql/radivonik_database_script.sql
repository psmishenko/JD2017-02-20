CREATE DATABASE  IF NOT EXISTS `radivonik` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `radivonik`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: radivonik
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.10-MariaDB

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
-- Table structure for table `avto`
--

DROP TABLE IF EXISTS `avto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numgos` varchar(20) NOT NULL,
  `voditel` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avto`
--

LOCK TABLES `avto` WRITE;
/*!40000 ALTER TABLE `avto` DISABLE KEYS */;
/*!40000 ALTER TABLE `avto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `klient`
--

DROP TABLE IF EXISTS `klient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `klient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `unp` varchar(20) DEFAULT NULL,
  `adres` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `klient`
--

LOCK TABLES `klient` WRITE;
/*!40000 ALTER TABLE `klient` DISABLE KEYS */;
/*!40000 ALTER TABLE `klient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `naklad`
--

DROP TABLE IF EXISTS `naklad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `naklad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `num` varchar(20) NOT NULL,
  `seria` varchar(20) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_type` int(11) NOT NULL,
  `id_klient` int(11) NOT NULL,
  `id_avto` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_naklad_user_idx` (`id_user`),
  KEY `fk_naklad_type_idx` (`id_type`),
  KEY `fk_naklad_klient_idx` (`id_klient`),
  KEY `fk_naklad_avto_idx` (`id_avto`),
  CONSTRAINT `fk_naklad_avto` FOREIGN KEY (`id_avto`) REFERENCES `avto` (`id`),
  CONSTRAINT `fk_naklad_klient` FOREIGN KEY (`id_klient`) REFERENCES `klient` (`id`),
  CONSTRAINT `fk_naklad_typenaklad` FOREIGN KEY (`id_type`) REFERENCES `typenaklad` (`id`),
  CONSTRAINT `fk_naklad_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `naklad`
--

LOCK TABLES `naklad` WRITE;
/*!40000 ALTER TABLE `naklad` DISABLE KEYS */;
/*!40000 ALTER TABLE `naklad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin'),(2,'buh'),(3,'sklad');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sklad`
--

DROP TABLE IF EXISTS `sklad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sklad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_tovar` int(11) NOT NULL,
  `count` decimal(16,3) NOT NULL,
  `cena` decimal(16,2) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sklad_tovar_idx` (`id_tovar`),
  KEY `fk_sklad_user_idx` (`id_user`),
  CONSTRAINT `fk_sklad_tovar` FOREIGN KEY (`id_tovar`) REFERENCES `tovar` (`id`),
  CONSTRAINT `fk_sklad_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sklad`
--

LOCK TABLES `sklad` WRITE;
/*!40000 ALTER TABLE `sklad` DISABLE KEYS */;
/*!40000 ALTER TABLE `sklad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sostavnaklad`
--

DROP TABLE IF EXISTS `sostavnaklad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sostavnaklad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_naklad` int(11) NOT NULL,
  `id_tovar` int(11) NOT NULL,
  `npp` int(11) DEFAULT NULL,
  `count` decimal(16,3) NOT NULL,
  `cena` decimal(16,2) NOT NULL,
  `prnds` decimal(5,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sostavnaklad_naklad_idx` (`id_naklad`),
  KEY `fk_sostavnaklad_tovar_idx` (`id_tovar`),
  CONSTRAINT `fk_sostavnaklad_naklad` FOREIGN KEY (`id_naklad`) REFERENCES `naklad` (`id`),
  CONSTRAINT `fk_sostavnaklad_tovar` FOREIGN KEY (`id_tovar`) REFERENCES `tovar` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sostavnaklad`
--

LOCK TABLES `sostavnaklad` WRITE;
/*!40000 ALTER TABLE `sostavnaklad` DISABLE KEYS */;
/*!40000 ALTER TABLE `sostavnaklad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tovar`
--

DROP TABLE IF EXISTS `tovar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tovar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `edizm` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tovar`
--

LOCK TABLES `tovar` WRITE;
/*!40000 ALTER TABLE `tovar` DISABLE KEYS */;
/*!40000 ALTER TABLE `tovar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typenaklad`
--

DROP TABLE IF EXISTS `typenaklad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `typenaklad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typenaklad`
--

LOCK TABLES `typenaklad` WRITE;
/*!40000 ALTER TABLE `typenaklad` DISABLE KEYS */;
INSERT INTO `typenaklad` VALUES (1,'TN_IN','Входящая товарная накладная'),(2,'TTN_IN','Входящая товарно-транспортная накладная'),(3,'TN_OUT','Исходящая товарная накладная'),(4,'TTN_OUT','Исходяшая товарно-транспортная накладная');
/*!40000 ALTER TABLE `typenaklad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `id_role` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_role_idx` (`id_role`),
  CONSTRAINT `fk_user_role` FOREIGN KEY (`id_role`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'radivonik','admin','admin@tut.by',1);
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

-- Dump completed on 2017-05-05  1:10:40
