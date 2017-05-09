-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ikavalenka
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ikavalenka` ;

-- -----------------------------------------------------
-- Schema ikavalenka
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ikavalenka` DEFAULT CHARACTER SET latin1 ;
-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
USE `ikavalenka` ;

-- -----------------------------------------------------
-- Table `ikavalenka`.`administrator`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ikavalenka`.`administrator` ;

CREATE TABLE IF NOT EXISTS `ikavalenka`.`administrator` (
  `Adm_id` INT(11) NOT NULL AUTO_INCREMENT,
  `Login` INT(11) NOT NULL,
  `Password` INT(11) NOT NULL,
  `Catalog` TEXT NOT NULL,
  `FullOrder_id` INT(11) NOT NULL,
  `BlackList_id_fk` INT(11) NOT NULL,
  PRIMARY KEY (`Adm_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ikavalenka`.`blacklist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ikavalenka`.`blacklist` ;

CREATE TABLE IF NOT EXISTS `ikavalenka`.`blacklist` (
  `Black_list_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Client_id_fk` INT(11) NOT NULL,
  PRIMARY KEY (`Black_list_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ikavalenka`.`client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ikavalenka`.`client` ;

CREATE TABLE IF NOT EXISTS `ikavalenka`.`client` (
  `Client_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Login` INT(11) NOT NULL,
  `Password` INT(11) NOT NULL,
  `order_ID` INT(11) NOT NULL,
  `cost_order` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`Client_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ikavalenka`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ikavalenka`.`roles` ;

CREATE TABLE IF NOT EXISTS `ikavalenka`.`roles` (
  `id` INT(5) NULL DEFAULT NULL,
  `name` VARCHAR(30) NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
