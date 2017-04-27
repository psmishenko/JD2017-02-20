-- -----------------------------------------------------
-- Table `akhmelev`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `akhmelev`.`ads` ;
DROP TABLE IF EXISTS `akhmelev`.`users` ;
DROP TABLE IF EXISTS `akhmelev`.`roles` ;

CREATE TABLE IF NOT EXISTS `akhmelev`.`roles` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Role` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akhmelev`.`users`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `akhmelev`.`users` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(45) NULL,
  `Password` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `roles_ID` INT NOT NULL,
  `userscol` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_users_roles_idx` (`roles_ID` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_ID`)
    REFERENCES `akhmelev`.`roles` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akhmelev`.`ads`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `akhmelev`.`ads` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `RoomCount` INT NULL,
  `Flat` INT NULL,
  `Flats` INT NULL,
  `Price` DOUBLE NULL,
  `Area` DOUBLE NULL,
  `Description` VARCHAR(5000) NULL,
  `Address` VARCHAR(200) NULL,
  `FK_users` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_ads_users1_idx` (`FK_users` ASC),
  CONSTRAINT `fk_ads_users1`
    FOREIGN KEY (`FK_users`)
    REFERENCES `akhmelev`.`users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;
