-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: localhost    Database: japdp_cfgs_dam_tf
-- ------------------------------------------------------
-- Server version	8.0.36-0ubuntu0.22.04.1

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
-- Table structure for table `t_category`
--

DROP TABLE IF EXISTS `t_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_category`
--

LOCK TABLES `t_category` WRITE;
/*!40000 ALTER TABLE `t_category` DISABLE KEYS */;
INSERT INTO `t_category` VALUES (1,'Bebidas para hidratarse o para ofrecer un sabor refrescante.','Agua y refrescos'),(2,'Aperitivos para comer en cualquier momento','Aperitivos'),(3,'Bebidas para tomar en el desayuno o merienda','Cacao, café e infusiones'),(4,'Para almuerzos y cenas','Carne'),(5,'Aperitivos para comer en cualquier momento','Galletas'),(6,'Bebidas para tomar en el desayuno o merienda','Charcutería y quesos');
/*!40000 ALTER TABLE `t_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_customer`
--

DROP TABLE IF EXISTS `t_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_customer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_customer`
--

LOCK TABLES `t_customer` WRITE;
/*!40000 ALTER TABLE `t_customer` DISABLE KEYS */;
INSERT INTO `t_customer` VALUES (1,'Sevilla','Carlos','Invierno'),(2,'Málaga','Felipe','Primavera'),(3,'España','Juan','Otoño');
/*!40000 ALTER TABLE `t_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order`
--

DROP TABLE IF EXISTS `t_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order` (
  `customer_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` varchar(255) DEFAULT NULL,
  `ship_address` varchar(255) DEFAULT NULL,
  `status` enum('PENDING','SHIPPED','DELIVERED') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKesy3n2gc3fa0s3trrk3tvyv9a` (`customer_id`),
  CONSTRAINT `FKesy3n2gc3fa0s3trrk3tvyv9a` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order`
--

LOCK TABLES `t_order` WRITE;
/*!40000 ALTER TABLE `t_order` DISABLE KEYS */;
INSERT INTO `t_order` VALUES (1,1,'2024-12-23','Almería','PENDING'),(1,2,'2024-01-11','Cordoba','PENDING'),(2,3,'2024-01-07','Cádiz','PENDING'),(2,4,'2024-02-11','Huelva','PENDING'),(3,5,'2024-05-15','Madrid','PENDING');
/*!40000 ALTER TABLE `t_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_orderdetail`
--

DROP TABLE IF EXISTS `t_orderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_orderdetail` (
  `quantity` int NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_id` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnjshvjicfnhhppqn7cta1jgbu` (`order_id`),
  KEY `FK2x36oaauph7p60nt1xgdg0tpy` (`product_id`),
  CONSTRAINT `FK2x36oaauph7p60nt1xgdg0tpy` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`),
  CONSTRAINT `FKnjshvjicfnhhppqn7cta1jgbu` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_orderdetail`
--

LOCK TABLES `t_orderdetail` WRITE;
/*!40000 ALTER TABLE `t_orderdetail` DISABLE KEYS */;
INSERT INTO `t_orderdetail` VALUES (4,1,1,1),(6,2,1,3),(4,3,1,10),(6,4,2,11),(6,5,2,20),(6,6,2,23),(6,7,3,30);
/*!40000 ALTER TABLE `t_orderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product`
--

DROP TABLE IF EXISTS `t_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_product` (
  `price` double NOT NULL,
  `quantity` int NOT NULL,
  `category_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp17nkwpqnnxh5iax87dc58sp3` (`category_id`),
  CONSTRAINT `FKp17nkwpqnnxh5iax87dc58sp3` FOREIGN KEY (`category_id`) REFERENCES `t_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product`
--

LOCK TABLES `t_product` WRITE;
/*!40000 ALTER TABLE `t_product` DISABLE KEYS */;
INSERT INTO `t_product` VALUES (2.4000000953674316,50,1,1,'6 botellas x 1 L','Lote agua mineral mediana'),(1.5,50,1,2,'6 botellas x 1,5 L','Lote agua mineral grande'),(0.4000000059604645,200,1,3,'Botella 1 L','Botella agua mineral mediana'),(0.25,200,1,4,'Bottela 1,5 L','Botella agua mineral grande'),(1.9900000095367432,200,1,5,'Bottela 2 L','Refresco Coca-Cola grande'),(1.4900000095367432,200,1,6,'Bottela 1,25 L','Refresco Coca-Cola mediano'),(1.4500000476837158,200,1,7,'Bottela 1.5 L','Refresco Coca-Cola pequeño'),(0.8899999856948853,400,1,8,'Lata 330 mL','Refresco Coca-Cola lata'),(0.8899999856948853,200,1,9,'12 latas x 330 mL','Lote Coca-Cola lata'),(1.9900000095367432,150,2,10,'Bolsa 160 g','Patatas fritas Lay\'s grande'),(1.9900000095367432,200,2,11,'Bolsa 160 g','Patatas fritas Lays sabor jamón grande'),(2.3499999046325684,300,2,12,'Paquete 130 g','Pistachos'),(3.0999999046325684,200,2,13,'Paquete 100 g','Almendras sin piel al punto de sal'),(2.700000047683716,200,2,14,'Paquete 150 g','Almendras con piel al punto de sal'),(3.0999999046325684,200,2,15,'Paquete 200 g','Avellanas'),(3.700000047683716,150,3,16,'Bote 383 g','Bote ColaCao mediano'),(5.099999904632568,130,3,17,'Bote 760 g','Bote ColaCao grande'),(4.889999866485596,160,3,18,'Caja 16 cápsulas','Lote café en cápsula Dolce Gusto'),(1,100,3,19,'Caja 20 bolsitas','Té verde'),(1.100000023841858,120,3,20,'Caja 30 bolsitas','Té negro'),(1.2999999523162842,80,3,21,'Caja 40 bolsitas','Té Chai'),(15,40,4,22,'Paquete 500 g','Filete de Res'),(7.5,40,4,23,'Paquete 1 kilo','Pechuga de Pollo'),(12,40,4,24,'Paquete 2 kilos','Costillas de Cerdo'),(3.5,100,5,25,'Paquete 250 g','Galletas de Chocolate'),(2.799999952316284,100,5,26,'Paquete 300 g','Galletas de Avena'),(8.5,80,6,27,'Paquete 250 g','Jamón Serrano'),(5.75,60,6,28,'Paquete 300 g','Salami'),(6.199999809265137,90,6,29,'Paquete 200 g','Queso Cheddar'),(7.300000190734863,70,6,30,'Paquete 150 g','Queso Brie');
/*!40000 ALTER TABLE `t_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `creation_date` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `role` enum('ADMIN','USER') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_i6qjjoe560mee5ajdg7v1o6mi` (`email`),
  UNIQUE KEY `UK_jhib4legehrm4yscx9t3lirqi` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'2024-02-02','Jose descrito','jose@example.es','$2a$10$Cfoeh1proMX0IyMTDS3xVeDijYSsufiERFdH14p7ITaKl4ZyZNtJW','jose','USER');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-09 18:41:25
