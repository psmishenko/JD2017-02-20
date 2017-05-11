-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema tereshko
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `tereshko` ;

-- -----------------------------------------------------
-- Schema tereshko
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tereshko` DEFAULT CHARACTER SET utf8 ;
USE `tereshko` ;

-- -----------------------------------------------------
-- Table `tereshko`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tereshko`.`roles` ;

CREATE TABLE IF NOT EXISTS `tereshko`.`roles` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Role` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tereshko`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tereshko`.`users` ;

CREATE TABLE IF NOT EXISTS `tereshko`.`users` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(100) NOT NULL,
  `Password` VARCHAR(100) NOT NULL,
  `Email` VARCHAR(100) NOT NULL,
  `FK_roles` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_users_roles_idx` (`FK_roles` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`FK_roles`)
    REFERENCES `tereshko`.`roles` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tereshko`.`ads`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tereshko`.`ads` ;

CREATE TABLE IF NOT EXISTS `tereshko`.`ads` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Floor` INT(11) NOT NULL,
  `Floors` INT(11) NOT NULL,
  `Price` DOUBLE NOT NULL,
  `Area` DOUBLE NOT NULL,
  `Rooms` INT(11) NOT NULL,
  `Address` VARCHAR(200) NOT NULL,
  `Description` VARCHAR(2000) NOT NULL,
  `FK_users` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_ads_users_idx` (`FK_users` ASC),
  CONSTRAINT `fk_ads_users`
    FOREIGN KEY (`FK_users`)
    REFERENCES `tereshko`.`users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
