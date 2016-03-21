create database productsdb;
use productsdb;

CREATE TABLE `accounts` (
  `username` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `email` varchar(300) NOT NULL,
  `firstName` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `isAdmin` varchar(10) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `category` (
  `cebu` varchar(999) DEFAULT NULL,
  `tenzen` varchar(999) DEFAULT NULL,
  `euro` varchar(999) DEFAULT NULL,
  `homewise` varchar(999) DEFAULT NULL,
  `tile_trim` varchar(999) DEFAULT NULL,
  `door` varchar(999) DEFAULT NULL,
  `grout` varchar(999) DEFAULT NULL,
  `adhesive` varchar(999) DEFAULT NULL,
  `water_closet` varchar(999) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE `Sell` (
  `sell_no` int(11) NOT NULL AUTO_INCREMENT,
  `product_code` varchar(20) NOT NULL,
  `product_name` varchar(999) NOT NULL,
  `unit_price` double NOT NULL,
  `quantity` int(11) NOT NULL,
  `product_description` varchar(999) DEFAULT NULL,
  `discount_sell` double DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `note_quantity` int(11) DEFAULT NULL,
  `note_description` varchar(999) DEFAULT NULL,
  `customer_name` varchar(200) NOT NULL,
  `tin` varchar(200) NOT NULL,
  `address` varchar(200) NOT NULL,
  `date` datetime NOT NULL,
  `mode_of_payment` varchar(45) NOT NULL,
  `check_no` int(11) DEFAULT NULL,
  `size` varchar(999) NOT NULL,
  `delivery_pickup_status` varchar(45) NOT NULL,
  PRIMARY KEY (`sell_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `DeliveryDB` (
  `DeliveryNum` int(11) NOT NULL AUTO_INCREMENT,
  `batch_no` int(11) NOT NULL,
  `Driver` varchar(50) NOT NULL,
  `Helper` varchar(50) NOT NULL,
  `PlateNum` varchar(50) NOT NULL,
  `CodingDay` varchar(50) NOT NULL,
  `DeliveryDate` datetime NOT NULL,
  `sell_no` varchar(45) NOT NULL,
  PRIMARY KEY (`DeliveryNum`),
  CONSTRAINT `sell_no` FOREIGN KEY (`DeliveryNum`) REFERENCES `Sell` (`sell_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `Product` (
  `product_code` varchar(20) NOT NULL,
  `product_name` varchar(999) NOT NULL,
  `supplier` varchar(200) NOT NULL,
  `delivery_date` date NOT NULL,
  `date_received` date NOT NULL,
  `delivery_charge` varchar(45) NOT NULL,
  `DR_SI` int(6) NOT NULL,
  `size` varchar(999) NOT NULL,
  `quantity` int(11) NOT NULL,
  `product_description` varchar(999) DEFAULT NULL,
  `unit_price` double NOT NULL,
  `discount_add` double DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `mode_of_payment` varchar(45) NOT NULL,
  `check_no` int(11) DEFAULT NULL,
  `category` varchar(999) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Product_old` (
  `product_code` varchar(20) NOT NULL,
  `product_name` varchar(999) NOT NULL,
  `supplier` varchar(200) NOT NULL,
  `delivery_date` date NOT NULL,
  `date_received` date NOT NULL,
  `delivery_charge` varchar(45) NOT NULL,
  `DR_SI` int(6) NOT NULL,
  `size` varchar(999) NOT NULL,
  `quantity` int(11) NOT NULL,
  `product_description` varchar(999) DEFAULT NULL,
  `unit_price` double NOT NULL,
  `discount_add` double DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `mode_of_payment` varchar(45) NOT NULL,
  `check_no` int(11) DEFAULT NULL,
  `category` varchar(999) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

