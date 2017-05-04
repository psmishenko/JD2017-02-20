-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               10.1.10-MariaDB - mariadb.org binary distribution
-- Операционная система:         Win32
-- HeidiSQL Версия:              9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных smirnov
DROP DATABASE IF EXISTS `smirnov`;
CREATE DATABASE IF NOT EXISTS `smirnov` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `smirnov`;

-- Дамп структуры для таблица smirnov.banks
DROP TABLE IF EXISTS `banks`;
CREATE TABLE IF NOT EXISTS `banks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `idcountry` int(11) DEFAULT NULL,
  `bic` varchar(10) DEFAULT NULL,
  `idgroupbank` int(11) DEFAULT NULL,
  `idsysoper` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_banks_sysopers` (`idsysoper`),
  KEY `FK_banks_countrys` (`idcountry`),
  KEY `FK_banks_groupsbanks` (`idgroupbank`),
  CONSTRAINT `FK_banks_countrys` FOREIGN KEY (`idcountry`) REFERENCES `countrys` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_banks_groupsbanks` FOREIGN KEY (`idgroupbank`) REFERENCES `groupsbanks` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_banks_sysopers` FOREIGN KEY (`idsysoper`) REFERENCES `sysopers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='Справочник банков';

-- Дамп данных таблицы smirnov.banks: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `banks` DISABLE KEYS */;
INSERT INTO `banks` (`id`, `name`, `idcountry`, `bic`, `idgroupbank`, `idsysoper`) VALUES
	(1, 'БПС-Сбербанк', 1, '11-22-33', 1, 1),
	(2, 'Альфа-Банк', 2, '11-22-44', 2, 1),
	(3, 'ПАО Сбербанк', 2, '99-88-77', 1, 1);
/*!40000 ALTER TABLE `banks` ENABLE KEYS */;

-- Дамп структуры для таблица smirnov.countrys
DROP TABLE IF EXISTS `countrys`;
CREATE TABLE IF NOT EXISTS `countrys` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Справочник стран';

-- Дамп данных таблицы smirnov.countrys: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `countrys` DISABLE KEYS */;
INSERT INTO `countrys` (`id`, `name`) VALUES
	(1, 'Беларусь'),
	(2, 'Росиия');
/*!40000 ALTER TABLE `countrys` ENABLE KEYS */;

-- Дамп структуры для таблица smirnov.groupsbanks
DROP TABLE IF EXISTS `groupsbanks`;
CREATE TABLE IF NOT EXISTS `groupsbanks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Группы банков';

-- Дамп данных таблицы smirnov.groupsbanks: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `groupsbanks` DISABLE KEYS */;
INSERT INTO `groupsbanks` (`id`, `name`) VALUES
	(1, 'Группа Сбербанк'),
	(2, 'Группа Альфа-Банк');
/*!40000 ALTER TABLE `groupsbanks` ENABLE KEYS */;

-- Дамп структуры для таблица smirnov.kursvaluts
DROP TABLE IF EXISTS `kursvaluts`;
CREATE TABLE IF NOT EXISTS `kursvaluts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datekurs` date NOT NULL,
  `za` double NOT NULL,
  `idzavalut` int(11) NOT NULL,
  `dat` double NOT NULL,
  `iddatvalut` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_kursvaluts_valuts_za` (`idzavalut`),
  KEY `FK_kursvaluts_valuts_dat` (`iddatvalut`),
  CONSTRAINT `FK_kursvaluts_valuts_dat` FOREIGN KEY (`iddatvalut`) REFERENCES `valuts` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_kursvaluts_valuts_za` FOREIGN KEY (`idzavalut`) REFERENCES `valuts` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Курсы валют';

-- Дамп данных таблицы smirnov.kursvaluts: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `kursvaluts` DISABLE KEYS */;
/*!40000 ALTER TABLE `kursvaluts` ENABLE KEYS */;

-- Дамп структуры для таблица smirnov.limits
DROP TABLE IF EXISTS `limits`;
CREATE TABLE IF NOT EXISTS `limits` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idgroupbank` int(11) NOT NULL,
  `fromdate` datetime NOT NULL,
  `idopertype` int(11) NOT NULL,
  `summa` double NOT NULL,
  `idvalut` int(11) NOT NULL,
  `idsysoper` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_limits_groupsbanks` (`idgroupbank`),
  KEY `FK_limits_opertypes` (`idopertype`),
  KEY `FK_limits_valuts` (`idvalut`),
  KEY `FK_limits_sysopers` (`idsysoper`),
  CONSTRAINT `FK_limits_groupsbanks` FOREIGN KEY (`idgroupbank`) REFERENCES `groupsbanks` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_limits_opertypes` FOREIGN KEY (`idopertype`) REFERENCES `opertypes` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_limits_sysopers` FOREIGN KEY (`idsysoper`) REFERENCES `sysopers` (`id`),
  CONSTRAINT `FK_limits_valuts` FOREIGN KEY (`idvalut`) REFERENCES `valuts` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Лимиты';

-- Дамп данных таблицы smirnov.limits: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `limits` DISABLE KEYS */;
/*!40000 ALTER TABLE `limits` ENABLE KEYS */;

-- Дамп структуры для таблица smirnov.opertypes
DROP TABLE IF EXISTS `opertypes`;
CREATE TABLE IF NOT EXISTS `opertypes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Типы операций';

-- Дамп данных таблицы smirnov.opertypes: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `opertypes` DISABLE KEYS */;
/*!40000 ALTER TABLE `opertypes` ENABLE KEYS */;

-- Дамп структуры для таблица smirnov.roles
DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы smirnov.roles: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `name`) VALUES
	(1, 'Администратор'),
	(2, 'Пользователь'),
	(3, 'Гость'),
	(4, 'Аудитор');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Дамп структуры для таблица smirnov.sdels
DROP TABLE IF EXISTS `sdels`;
CREATE TABLE IF NOT EXISTS `sdels` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idbank` int(11) NOT NULL,
  `summa` double NOT NULL,
  `idvalut` int(11) NOT NULL,
  `idopertype` int(11) NOT NULL,
  `fromdate` date NOT NULL,
  `todate` date NOT NULL,
  `idsysoper` int(11) NOT NULL,
  `idsysoperedit` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_sdels_banks` (`idbank`),
  KEY `FK_sdels_valuts` (`idvalut`),
  KEY `FK_sdels_opertypes` (`idopertype`),
  KEY `FK_sdels_sysopers` (`idsysoper`),
  KEY `FK_sdels_sysopers_edit` (`idsysoperedit`),
  CONSTRAINT `FK_sdels_banks` FOREIGN KEY (`idbank`) REFERENCES `banks` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_sdels_opertypes` FOREIGN KEY (`idopertype`) REFERENCES `opertypes` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_sdels_sysopers` FOREIGN KEY (`idsysoper`) REFERENCES `sysopers` (`id`),
  CONSTRAINT `FK_sdels_sysopers_edit` FOREIGN KEY (`idsysoperedit`) REFERENCES `sysopers` (`id`),
  CONSTRAINT `FK_sdels_valuts` FOREIGN KEY (`idvalut`) REFERENCES `valuts` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Журнал сделок';

-- Дамп данных таблицы smirnov.sdels: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `sdels` DISABLE KEYS */;
/*!40000 ALTER TABLE `sdels` ENABLE KEYS */;

-- Дамп структуры для таблица smirnov.sysopers
DROP TABLE IF EXISTS `sysopers`;
CREATE TABLE IF NOT EXISTS `sysopers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) NOT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_sysopers_users` (`iduser`),
  CONSTRAINT `FK_sysopers_users` FOREIGN KEY (`iduser`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Журнал операций пользователей';

-- Дамп данных таблицы smirnov.sysopers: ~1 rows (приблизительно)
/*!40000 ALTER TABLE `sysopers` DISABLE KEYS */;
INSERT INTO `sysopers` (`id`, `iduser`, `datetime`) VALUES
	(1, 1, '2017-04-29 16:32:48');
/*!40000 ALTER TABLE `sysopers` ENABLE KEYS */;

-- Дамп структуры для таблица smirnov.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Пользователи';

-- Дамп данных таблицы smirnov.users: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `name`, `login`, `password`) VALUES
	(1, 'Смирнов А.В.', 'smirnov_a', 'smirn'),
	(2, 'Дяго А.А.', 'smirnovа_a', 'anna');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Дамп структуры для таблица smirnov.usersroles
DROP TABLE IF EXISTS `usersroles`;
CREATE TABLE IF NOT EXISTS `usersroles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) NOT NULL,
  `idrole` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_usersroles_users` (`iduser`),
  KEY `FK_usersroles_roles` (`idrole`),
  CONSTRAINT `FK_usersroles_roles` FOREIGN KEY (`idrole`) REFERENCES `roles` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_usersroles_users` FOREIGN KEY (`iduser`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='Роли пользавателей';

-- Дамп данных таблицы smirnov.usersroles: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `usersroles` DISABLE KEYS */;
INSERT INTO `usersroles` (`id`, `iduser`, `idrole`) VALUES
	(1, 1, 1),
	(2, 1, 4),
	(3, 2, 1),
	(4, 2, 3);
/*!40000 ALTER TABLE `usersroles` ENABLE KEYS */;

-- Дамп структуры для таблица smirnov.valuts
DROP TABLE IF EXISTS `valuts`;
CREATE TABLE IF NOT EXISTS `valuts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `namesokr` varchar(3) NOT NULL,
  `namefull` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Справочник валют';

-- Дамп данных таблицы smirnov.valuts: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `valuts` DISABLE KEYS */;
/*!40000 ALTER TABLE `valuts` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
