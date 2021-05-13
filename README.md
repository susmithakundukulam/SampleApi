
#sampleApi

CREATE DATABASE IF NOT EXISTS `sampleApi`; 
USE `sampleApi`; 

CREATE TABLE `sampleapi`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(100) NOT NULL,
  `password` VARCHAR(150) NOT NULL,
  `status` INT(11) NOT NULL,
  PRIMARY KEY (`id`));
