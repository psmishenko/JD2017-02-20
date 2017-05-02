CREATE TABLE `valuts` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`namesokr` VARCHAR(3) NOT NULL,
	`namefull` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`id`)
)
COMMENT='Справочник валют'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `countrys` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`id`)
)
COMMENT='Справочник стран'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `groupsbanks` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`id`)
)
COMMENT='Группы банков'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `roles` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `opertypes` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`)
)
COMMENT='Типы операций'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `users` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`login` VARCHAR(50) NOT NULL,
	`password` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`)
)
COMMENT='Пользователи'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `usersroles` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`iduser` INT(11) NOT NULL,
	`idrole` INT(11) NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_usersroles_users` (`iduser`),
	INDEX `FK_usersroles_roles` (`idrole`),
	CONSTRAINT `FK_usersroles_roles` FOREIGN KEY (`idrole`) REFERENCES `roles` (`id`) ON DELETE CASCADE,
	CONSTRAINT `FK_usersroles_users` FOREIGN KEY (`iduser`) REFERENCES `users` (`id`) ON DELETE CASCADE
)
COMMENT='Роли пользавателей'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `sysopers` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`iduser` INT(11) NOT NULL,
	`datetime` DATETIME NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_sysopers_users` (`iduser`),
	CONSTRAINT `FK_sysopers_users` FOREIGN KEY (`iduser`) REFERENCES `users` (`id`) ON DELETE CASCADE
)
COMMENT='Журнал операций пользователей'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `banks` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(150) NOT NULL,
	`idcountry` INT(11) NULL DEFAULT NULL,
	`bic` VARCHAR(10) NULL DEFAULT NULL,
	`idgroupbank` INT(11) NULL DEFAULT NULL,
	`idsysoper` INT(11) NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_banks_sysopers` (`idsysoper`),
	INDEX `FK_banks_countrys` (`idcountry`),
	INDEX `FK_banks_groupsbanks` (`idgroupbank`),
	CONSTRAINT `FK_banks_countrys` FOREIGN KEY (`idcountry`) REFERENCES `countrys` (`id`) ON UPDATE SET NULL ON DELETE SET NULL,
	CONSTRAINT `FK_banks_groupsbanks` FOREIGN KEY (`idgroupbank`) REFERENCES `groupsbanks` (`id`) ON UPDATE SET NULL ON DELETE SET NULL,
	CONSTRAINT `FK_banks_sysopers` FOREIGN KEY (`idsysoper`) REFERENCES `sysopers` (`id`)
)
COMMENT='Справочник банков'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `sdels` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`idbank` INT(11) NOT NULL,
	`summa` DOUBLE NOT NULL,
	`idvalut` INT(11) NOT NULL,
	`idopertype` INT(11) NOT NULL,
	`fromdate` DATE NOT NULL,
	`todate` DATE NOT NULL,
	`idsysoper` INT(11) NOT NULL,
	`idsysoperedit` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_sdels_banks` (`idbank`),
	INDEX `FK_sdels_valuts` (`idvalut`),
	INDEX `FK_sdels_opertypes` (`idopertype`),
	INDEX `FK_sdels_sysopers` (`idsysoper`),
	INDEX `FK_sdels_sysopers_edit` (`idsysoperedit`),
	CONSTRAINT `FK_sdels_banks` FOREIGN KEY (`idbank`) REFERENCES `banks` (`id`) ON DELETE CASCADE,
	CONSTRAINT `FK_sdels_opertypes` FOREIGN KEY (`idopertype`) REFERENCES `opertypes` (`id`) ON DELETE CASCADE,
	CONSTRAINT `FK_sdels_sysopers` FOREIGN KEY (`idsysoper`) REFERENCES `sysopers` (`id`),
	CONSTRAINT `FK_sdels_sysopers_edit` FOREIGN KEY (`idsysoperedit`) REFERENCES `sysopers` (`id`),
	CONSTRAINT `FK_sdels_valuts` FOREIGN KEY (`idvalut`) REFERENCES `valuts` (`id`) ON DELETE CASCADE
)
COMMENT='Журнал сделок'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `kursvaluts` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`datekurs` DATE NOT NULL,
	`za` DOUBLE NOT NULL,
	`idzavalut` INT(11) NOT NULL,
	`dat` DOUBLE NOT NULL,
	`iddatvalut` INT(11) NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_kursvaluts_valuts_za` (`idzavalut`),
	INDEX `FK_kursvaluts_valuts_dat` (`iddatvalut`),
	CONSTRAINT `FK_kursvaluts_valuts_dat` FOREIGN KEY (`iddatvalut`) REFERENCES `valuts` (`id`) ON DELETE CASCADE,
	CONSTRAINT `FK_kursvaluts_valuts_za` FOREIGN KEY (`idzavalut`) REFERENCES `valuts` (`id`) ON DELETE CASCADE
)
COMMENT='Курсы валют'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `limits` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`idgroupbank` INT(11) NOT NULL,
	`fromdate` DATETIME NOT NULL,
	`idopertype` INT(11) NOT NULL,
	`summa` DOUBLE NOT NULL,
	`idvalut` INT(11) NOT NULL,
	`idsysoper` INT(11) NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_limits_groupsbanks` (`idgroupbank`),
	INDEX `FK_limits_opertypes` (`idopertype`),
	INDEX `FK_limits_valuts` (`idvalut`),
	INDEX `FK_limits_sysopers` (`idsysoper`),
	CONSTRAINT `FK_limits_groupsbanks` FOREIGN KEY (`idgroupbank`) REFERENCES `groupsbanks` (`id`) ON DELETE CASCADE,
	CONSTRAINT `FK_limits_opertypes` FOREIGN KEY (`idopertype`) REFERENCES `opertypes` (`id`) ON DELETE CASCADE,
	CONSTRAINT `FK_limits_sysopers` FOREIGN KEY (`idsysoper`) REFERENCES `sysopers` (`id`),
	CONSTRAINT `FK_limits_valuts` FOREIGN KEY (`idvalut`) REFERENCES `valuts` (`id`) ON DELETE CASCADE
)
COMMENT='Лимиты'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;