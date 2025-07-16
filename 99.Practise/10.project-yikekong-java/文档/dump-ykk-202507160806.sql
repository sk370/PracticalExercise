-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 192.168.171.128    Database: ykk
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_admin`
--

DROP TABLE IF EXISTS `tb_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `login_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '登录名',
  `password` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `type` tinyint DEFAULT NULL COMMENT '类型 1超级管理员 0普通用户',
  `board` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '看板',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_admin`
--

LOCK TABLES `tb_admin` WRITE;
/*!40000 ALTER TABLE `tb_admin` DISABLE KEYS */;
INSERT INTO `tb_admin` VALUES (1,'admin','$2a$10$1yahOIjcP1TtZCx3GG5uEOPj/Foz2YpSKEQvWq4WzEHVmbQ6DsL62',NULL,NULL);
/*!40000 ALTER TABLE `tb_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_alarm`
--

DROP TABLE IF EXISTS `tb_alarm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_alarm` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '报警名称',
  `quota_id` int DEFAULT NULL COMMENT '指标id',
  `operator` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运算符',
  `threshold` int DEFAULT NULL COMMENT '报警阈值',
  `level` int DEFAULT NULL COMMENT '报警级别  1一般 2严重',
  `cycle` int DEFAULT NULL COMMENT '沉默周期（分钟）',
  `webhook` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'web钩子',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tb_alarm_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_alarm`
--

LOCK TABLES `tb_alarm` WRITE;
/*!40000 ALTER TABLE `tb_alarm` DISABLE KEYS */;
INSERT INTO `tb_alarm` VALUES (1,'温度过高',1,'>',10,2,10,' '),(2,'湿度过高',2,'>',10,1,10,' ');
/*!40000 ALTER TABLE `tb_alarm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_board`
--

DROP TABLE IF EXISTS `tb_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_board` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `admin_id` int DEFAULT '1' COMMENT '管理员id',
  `name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '看板名称',
  `quota` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '指标(趋势时设置)',
  `device` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备(累计)',
  `system` tinyint DEFAULT '0' COMMENT '是否是系统看板',
  `disable` tinyint DEFAULT '0' COMMENT '是否不显示',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tb_board_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_board`
--

LOCK TABLES `tb_board` WRITE;
/*!40000 ALTER TABLE `tb_board` DISABLE KEYS */;
INSERT INTO `tb_board` VALUES (1,1,NULL,'0',NULL,1,0),(2,1,NULL,'0',NULL,1,0),(3,1,NULL,'0',NULL,1,0),(4,1,NULL,'0',NULL,1,0);
/*!40000 ALTER TABLE `tb_board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_gps`
--

DROP TABLE IF EXISTS `tb_gps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_gps` (
  `id` bigint NOT NULL COMMENT 'id',
  `subject` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '主题',
  `sn_key` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备识别码字段',
  `single_field` tinyint DEFAULT NULL COMMENT '类型（单字段、双字段）',
  `value_key` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '经纬度字段',
  `separation` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '经纬度分隔符',
  `longitude` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '经度字段',
  `latitude` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '维度字段',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tb_gps_subject_uindex` (`subject`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_gps`
--

LOCK TABLES `tb_gps` WRITE;
/*!40000 ALTER TABLE `tb_gps` DISABLE KEYS */;
INSERT INTO `tb_gps` VALUES (1,'gps','sn',1,'gps',',','lon','lat');
/*!40000 ALTER TABLE `tb_gps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_quota`
--

DROP TABLE IF EXISTS `tb_quota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_quota` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '指标名称',
  `unit` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '指标单位',
  `subject` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '报文主题',
  `value_key` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '指标值字段',
  `sn_key` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '设备识别码字段',
  `webhook` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'web钩子',
  `value_type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '指标字段类型，Double、Inteter、Boolean',
  `reference_value` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '参考值',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tb_quota_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_quota`
--

LOCK TABLES `tb_quota` WRITE;
/*!40000 ALTER TABLE `tb_quota` DISABLE KEYS */;
INSERT INTO `tb_quota` VALUES (1,'温度','℃','temperature','temp','sn',' ','Double','1-5'),(2,'湿度','%','humidity','h','sn',' ','Double','10-20');
/*!40000 ALTER TABLE `tb_quota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'ykk'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-16  8:06:30
