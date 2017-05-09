-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema korzun
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `korzun` ;

-- -----------------------------------------------------
-- Schema korzun
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `korzun` DEFAULT CHARACTER SET utf8 ;
USE `korzun` ;

-- -----------------------------------------------------
-- Table `korzun`.`Specializations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `korzun`.`Specializations` ;

CREATE TABLE IF NOT EXISTS `korzun`.`Specializations` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Specialization` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `Specialization_UNIQUE` (`Specialization` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korzun`.`Staff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `korzun`.`Staff` ;

CREATE TABLE IF NOT EXISTS `korzun`.`Staff` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `FK_Specialization` INT NOT NULL,
  `Login` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `FK_Specialization_idx` (`FK_Specialization` ASC),
  CONSTRAINT `FK_Specialization`
    FOREIGN KEY (`FK_Specialization`)
    REFERENCES `korzun`.`Specializations` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korzun`.`Brigades`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `korzun`.`Brigades` ;

CREATE TABLE IF NOT EXISTS `korzun`.`Brigades` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `FirstPilotID` INT NOT NULL,
  `SecondPilotID` INT NOT NULL,
  `NavigatorID` INT NOT NULL,
  `Radio_operatorID` INT NOT NULL,
  `StewardessID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `FirstPilotID_UNIQUE` (`FirstPilotID` ASC),
  UNIQUE INDEX `SecondPilotID_UNIQUE` (`SecondPilotID` ASC),
  INDEX `N_idx` (`NavigatorID` ASC),
  INDEX `RO_idx` (`Radio_operatorID` ASC),
  INDEX `S_idx` (`StewardessID` ASC),
  CONSTRAINT `FP`
    FOREIGN KEY (`FirstPilotID`)
    REFERENCES `korzun`.`Staff` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `SP`
    FOREIGN KEY (`SecondPilotID`)
    REFERENCES `korzun`.`Staff` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `N`
    FOREIGN KEY (`NavigatorID`)
    REFERENCES `korzun`.`Staff` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `RO`
    FOREIGN KEY (`Radio_operatorID`)
    REFERENCES `korzun`.`Staff` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `S`
    FOREIGN KEY (`StewardessID`)
    REFERENCES `korzun`.`Staff` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `korzun`.`Flights`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `korzun`.`Flights` ;

CREATE TABLE IF NOT EXISTS `korzun`.`Flights` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Destination` VARCHAR(45) NOT NULL,
  `Brigades_ID` INT NOT NULL,
  PRIMARY KEY (`ID`, `Destination`),
  INDEX `fk_Flights_Brigades1_idx` (`Brigades_ID` ASC),
  CONSTRAINT `fk_Flights_Brigades1`
    FOREIGN KEY (`Brigades_ID`)
    REFERENCES `korzun`.`Brigades` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
