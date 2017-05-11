-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema prigozhanov
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `prigozhanov` ;

-- -----------------------------------------------------
-- Schema prigozhanov
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `prigozhanov` DEFAULT CHARACTER SET utf8 ;
USE `prigozhanov` ;

-- -----------------------------------------------------
-- Table `prigozhanov`.`cars`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `prigozhanov`.`cars` ;

CREATE TABLE IF NOT EXISTS `prigozhanov`.`cars` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Mark` VARCHAR(100) NOT NULL,
  `Model` VARCHAR(100) NOT NULL,
  `HP` INT(11) NOT NULL,
  `Location` VARCHAR(100) NOT NULL,
  `Luggage_capacity` INT(11) NOT NULL,
  `Price` INT(11) NOT NULL,
  `Seats` INT(11) NOT NULL,
  `Fuel_consumption` INT(11) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `prigozhanov`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `prigozhanov`.`roles` ;

CREATE TABLE IF NOT EXISTS `prigozhanov`.`roles` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Role` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `prigozhanov`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `prigozhanov`.`users` ;

CREATE TABLE IF NOT EXISTS `prigozhanov`.`users` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Passport_data` VARCHAR(100) NOT NULL,
  `Login` VARCHAR(100) NOT NULL,
  `Password` VARCHAR(100) NOT NULL,
  `Email` VARCHAR(100) NOT NULL,
  `FK_Roles` INT(11) NOT NULL DEFAULT '2',
  PRIMARY KEY (`ID`),
  INDEX `fk_users_roles_idx` (`FK_Roles` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`FK_Roles`)
    REFERENCES `prigozhanov`.`roles` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `prigozhanov`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `prigozhanov`.`orders` ;

CREATE TABLE IF NOT EXISTS `prigozhanov`.`orders` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Passport_data` VARCHAR(45) NOT NULL,
  `Card_number` VARCHAR(45) NOT NULL,
  `Order_duration` INT(11) NOT NULL,
  `Telephone` VARCHAR(45) NOT NULL,
  `FK_Users` INT(11) NULL DEFAULT NULL,
  `FK_Cars` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Orders_users1_idx` (`FK_Users` ASC),
  INDEX `fk_Orders_cars1_idx` (`FK_Cars` ASC),
  CONSTRAINT `fk_Orders_cars1`
    FOREIGN KEY (`FK_Cars`)
    REFERENCES `prigozhanov`.`cars` (`ID`),
  CONSTRAINT `fk_Orders_users1`
    FOREIGN KEY (`FK_Users`)
    REFERENCES `prigozhanov`.`users` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
