CREATE DATABASE  IF NOT EXISTS `kardex` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `kardex`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: kardex
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `CPF` varchar(14) DEFAULT NULL,
  `Nome` varchar(45) NOT NULL,
  `Celular` varchar(20) DEFAULT NULL,
  `Email` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`Codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'4815698756','Vinicius Batista','11952956487','vinni.batista@java.com'),(2,'48154798547','Marcelo Moura','1195248575','marcelo.moura@sql.com'),(3,'8054258415','Warren Buffet','119521458745','warren.buffet@invest.com'),(4,'485414854785','Steve Jobs','1195254871254','s.jobs@apple.com'),(5,'58475874125','William Henry Gates ','11952548124','bill.gates@microsoft.com');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrada`
--

DROP TABLE IF EXISTS `entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrada` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `Data` datetime NOT NULL,
  `Qtde` int(11) DEFAULT '0',
  `Valor` decimal(8,2) DEFAULT '0.00',
  `Fornecedor` int(11) NOT NULL,
  `Produto` int(11) NOT NULL,
  PRIMARY KEY (`Codigo`),
  KEY `fk_Entrada_Fornecedor_idx` (`Fornecedor`),
  KEY `fk_Entrada_Produto1_idx` (`Produto`),
  CONSTRAINT `fk_Entrada_Fornecedor` FOREIGN KEY (`Fornecedor`) REFERENCES `fornecedor` (`Codigo`),
  CONSTRAINT `fk_Entrada_Produto1` FOREIGN KEY (`Produto`) REFERENCES `produto` (`Codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrada`
--

LOCK TABLES `entrada` WRITE;
/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
INSERT INTO `entrada` VALUES (1,'2020-11-02 00:00:00',1,19.99,4,4),(2,'2020-11-01 00:00:00',2,0.99,6,7);
/*!40000 ALTER TABLE `entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornecedor` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `CNPJ` varchar(18) DEFAULT NULL,
  `Nome` varchar(45) NOT NULL,
  `Telefone` varchar(20) DEFAULT NULL,
  `Email` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`Codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` VALUES (1,'77652571000135','Acme Corps','38518285','acmecorps@looneytunes.com'),(2,'47826827000112','Sirius Cybernetics Corp','38964125','siriuscybernetics@mochileirogalaxya.com'),(3,'63851179000100','Monty Python','369841265','monty.p@python.com'),(4,'866167870001658','Wayne Tech','3854796254','waynetech@dc.com'),(5,'14325789000165','Stark Industries','36542015','industriasstark@marvel.com'),(6,'866874215485','Industrias Oscorp','95643851','industriasoscorp@spiderman.com');
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `Descricao` varchar(45) NOT NULL,
  `Qtde` int(11) DEFAULT '0',
  `CustoMedio` decimal(8,2) DEFAULT '0.00',
  PRIMARY KEY (`Codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Mouse',10,12.99),(2,'Monitor',5,59.79),(3,'Teclado',90,40.00),(4,'Notebook',14,999.99),(5,'SmartPhone',30,999.99),(6,'Cadeira',59,299.99),(7,'Cabo USB',100,0.99),(8,'Mesa Para Escritorio',85,499.99);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saida`
--

DROP TABLE IF EXISTS `saida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saida` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `Data` datetime NOT NULL,
  `Produto` int(11) NOT NULL,
  `Cliente` int(11) NOT NULL,
  `Qtde` int(11) DEFAULT '0',
  `Valor` decimal(8,2) DEFAULT '0.00',
  PRIMARY KEY (`Codigo`),
  KEY `fk_Saida_Produto_idx` (`Produto`),
  KEY `fk_Saida_Cliente_idx` (`Cliente`),
  CONSTRAINT `fk_Saida_Cliente` FOREIGN KEY (`Cliente`) REFERENCES `cliente` (`Codigo`),
  CONSTRAINT `fk_Saida_Produto` FOREIGN KEY (`Produto`) REFERENCES `produto` (`Codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saida`
--

LOCK TABLES `saida` WRITE;
/*!40000 ALTER TABLE `saida` DISABLE KEYS */;
INSERT INTO `saida` VALUES (1,'2020-11-01 00:00:00',1,1,1,10.50),(2,'2020-11-09 00:00:00',1,1,1,10.50),(3,'2020-11-06 00:00:00',7,2,2,0.99),(4,'2020-11-01 00:00:00',6,4,8,299.99);
/*!40000 ALTER TABLE `saida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'kardex'
--

--
-- Dumping routines for database 'kardex'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-02 23:48:34
