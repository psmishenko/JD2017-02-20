-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema psmishenko
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `psmishenko` ;

-- -----------------------------------------------------
-- Schema psmishenko
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `psmishenko` DEFAULT CHARACTER SET utf8 ;
USE `psmishenko` ;

-- -----------------------------------------------------
-- Table `psmishenko`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `psmishenko`.`roles` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Role` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `psmishenko`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `psmishenko`.`users` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(100) NOT NULL,
  `Password` VARCHAR(100) NOT NULL,
  `Email` VARCHAR(100) NOT NULL,
  `FK_roles` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_users_roles_idx` (`FK_roles` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`FK_roles`)
    REFERENCES `psmishenko`.`roles` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `psmishenko`.`books`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `psmishenko`.`books` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Author` VARCHAR(100) NOT NULL,
  `Title` VARCHAR(100) NOT NULL,
  `Year` INT(100) NOT NULL,
  `ISBN` INT(100) NOT NULL,
  `LID` INT(100) NOT NULL,
  `FK_users` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_books_users1_idx` (`FK_users` ASC),
  CONSTRAINT `fk_books_users1`
    FOREIGN KEY (`FK_users`)
    REFERENCES `psmishenko`.`users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
