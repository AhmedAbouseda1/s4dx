CREATE DATABASE  IF NOT EXISTS `s4dx_db`; /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `s4dx_db`;
-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Database: s4dx_db
-- ------------------------------------------------------
-- Server version	5.5.11

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
-- Table structure for table `xdevices`
--

DROP TABLE IF EXISTS `xdevices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xdevices` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `manufacturer_id` varchar(45) NOT NULL,
  `hcp_id` int(11) DEFAULT NULL,
  `hardware_state` varchar(45) DEFAULT NULL,
  UNIQUE KEY `manufacturer_id_UNIQUE` (`manufacturer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xdevices`
--

LOCK TABLES `xdevices` WRITE;
/*!40000 ALTER TABLE `xdevices` DISABLE KEYS */;
INSERT INTO `xdevices` VALUES (1,'X1',NULL,'UNASSIGNED'),(2,'X2',NULL,'UNASSIGNED'),(3,'X3',NULL,'UNASSIGNED'),(4,'X4',NULL,'UNASSIGNED'),(5,'X5',NULL,'UNASSIGNED'),(6,'X6',NULL,'UNASSIGNED');
/*!40000 ALTER TABLE `xdevices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hcps`
--

DROP TABLE IF EXISTS `hcps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hcps` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `hcpid` varchar(45) DEFAULT NULL,
  `street` varchar(145) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `city_code` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hcps`
--

LOCK TABLES `hcps` WRITE;
/*!40000 ALTER TABLE `hcps` DISABLE KEYS */;
INSERT INTO `hcps` VALUES (18,'SchÃ¤fer','Sredzkistr. 67','Berlin','10405','SchÃ¤fer'),(19,'Buschhaus','Prenzlauer Allee 217','Berlin','10405','Buschhaus'),(20,'Falsafi Amin','Kolmarer Str. 1','Berlin','10405','Falsafi Amin'),(21,'Fink','Marienburger Str. 3-4','Berlin','10405','Fink'),(22,'Fischer','Jablonskistr. 16','Berlin','10405','Fischer'),(23,'Glaunsinger','Danziger Str. 78 b','Berlin','10405','Glaunsinger'),(24,'JÃ¼rgens','Prenzlauer Allee 19','Berlin','10405','JÃ¼rgens'),(25,'Knobloch','Winsstr. 45','Berlin','10405','Knobloch'),(26,'KrÃ¼ger','Kollwitzstr. 14','Berlin','10405','KrÃ¼ger'),(27,'Kubo','Sredzkistr. 47','Berlin','10405','Kubo'),(28,'Lammerschmidt','Winsstr. 40','Berlin','10405','Lammerschmidt'),(29,'Pomrenke','Greifswalder Str. 5','Berlin','10405','Pomrenke'),(30,'Schafranka','Immanuelkirchstr. 30','Berlin','10405','Schafranka'),(31,'Scholz','Chodowieckistr. 15','Berlin','10405','Scholz'),(32,'Schreen','Winsstr. 56','Berlin','10405','Schreen'),(33,'Wagner','Greifswalder Str. 23','Berlin','10405','Wagner'),(34,'Wullkopf','Prenzlauer Allee 187','Berlin','10405','Wullkopf'),(35,'1','street','Berlin','10405','1');
/*!40000 ALTER TABLE `hcps` ENABLE KEYS */;
UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-29 12:19:21
