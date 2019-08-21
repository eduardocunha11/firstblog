/*
SQLyog Ultimate v8.55 
MySQL - 8.0.14 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE garagem;
USE garagem;

/*Table structure for table `car_brands` */

DROP TABLE IF EXISTS `car_brands`;

CREATE TABLE `car_brands` (
  `brand_id` int(11) NOT NULL,
  `brand` varchar(50) NOT NULL,
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `car_brands` */

insert  into `car_brands`(`brand_id`,`brand`) values (1,'FORD'),(2,'FIAT'),(3,'HONDA'),(4,'TOYOTA'),(5,'VOLKSWAGEN');

/*Table structure for table `car_models` */

DROP TABLE IF EXISTS `car_models`;

CREATE TABLE `car_models` (
  `model_id` int(11) NOT NULL,
  `model` varchar(50) NOT NULL,
  `brand_id` int(50) NOT NULL,
  `model_description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`model_id`),
  KEY `FK_car_models` (`brand_id`),
  CONSTRAINT `FK_car_models` FOREIGN KEY (`brand_id`) REFERENCES `car_brands` (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `car_models` */

insert  into `car_models`(`model_id`,`model`,`brand_id`,`model_description`) values (1,'KA',1,'FORD KA 1.0'),(2,'FOCUS',1,'FORD FOCUS 2.0'),(3,'FUSION',1,'FORD FUSION 2.0'),(4,'UNO',2,'FIAT UNO VIVACE 1.0'),(5,'ARGO',2,'FIAT ARGO 1.0'),(6,'TORO',2,'FIAT TORO 2.5'),(7,'CITY',3,'HONDA CITY 2.5'),(8,'CIVIC',3,'HONDA CIVIC 2.0'),(9,'HRV',3,'HONDA HRV 2.0'),(10,'COROLLA',4,'TOYOTA COROLLA 2.0'),(11,'HILUX',4,'TOYOTA HILUX 3.0'),(12,'RAV4',4,'TOYOTA RAV4 3.0'),(13,'GOL',5,'VOLKSWAGEN GOL G6 1.0'),(14,'POLO',5,'VOLKSWAGEN POLO 2.0'),(15,'AMAROK',5,'VOLKSWAGEN AMAROK 3.0');

/*Table structure for table `sales` */

DROP TABLE IF EXISTS `sales`;

CREATE TABLE `sales` (
  `sale_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_name` varchar(100) NOT NULL,
  `brand_id` int(11) NOT NULL,
  `model_id` int(11) NOT NULL,
  `date_time` timestamp NOT NULL,
  `sale_value` double NOT NULL,
  PRIMARY KEY (`sale_id`),
  KEY `FK_sales` (`brand_id`),
  KEY `FK_sales_model` (`model_id`),
  CONSTRAINT `FK_sales_model` FOREIGN KEY (`model_id`) REFERENCES `car_models` (`model_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `sales` */

insert  into `sales`(`sale_id`,`client_name`,`brand_id`,`model_id`,`date_time`,`sale_value`) values (5,'Eduardo Campos',1,2,'2019-04-01 00:00:00',43000),(6,'Marcio Ribeiro',4,11,'2019-04-01 00:00:00',120000),(7,'Joao Roberto',2,5,'2019-04-02 00:00:00',34500),(8,'Joao Mauricio Batista',3,7,'2019-04-02 00:00:00',45600);

/*Table structure for table `user_login` */

DROP TABLE IF EXISTS `user_login`;

CREATE TABLE `user_login` (
  `login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `user` varchar(100) NOT NULL,
  PRIMARY KEY (`login`,`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user_login` */

insert  into `user_login`(`login`,`password`,`user`) values ('eduardo','pds2','Eduardo Cunha Campos'),('joao','123456','Joao Machado Batista'),('maria','abacaxi','Maria Imaculada Maciel Reis');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
