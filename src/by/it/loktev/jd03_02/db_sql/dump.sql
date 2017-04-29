-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               10.1.10-MariaDB - mariadb.org binary distribution
-- ОС Сервера:                   Win32
-- HeidiSQL Версия:              9.2.0.4947
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных loktevalexey
DROP DATABASE IF EXISTS `loktevalexey`;
CREATE DATABASE IF NOT EXISTS `loktevalexey` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `loktevalexey`;


-- Дамп структуры для таблица loktevalexey.ad
DROP TABLE IF EXISTS `ad`;
CREATE TABLE IF NOT EXISTS `ad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `floor` int(11) NOT NULL DEFAULT '0',
  `floors` int(11) NOT NULL DEFAULT '0',
  `rooms` int(11) NOT NULL DEFAULT '0',
  `address` varchar(200) NOT NULL DEFAULT '0',
  `desc` varchar(2000) DEFAULT NULL,
  `userid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_ad_user` (`userid`),
  CONSTRAINT `FK_ad_user` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы loktevalexey.ad: ~0 rows (приблизительно)
DELETE FROM `ad`;
/*!40000 ALTER TABLE `ad` DISABLE KEYS */;
/*!40000 ALTER TABLE `ad` ENABLE KEYS */;


-- Дамп структуры для таблица loktevalexey.roles
DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы loktevalexey.roles: ~6 rows (приблизительно)
DELETE FROM `roles`;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `name`) VALUES
	(1, 'Администратор2'),
	(2, 'Пользователь2'),
	(3, 'Администратор'),
	(4, 'Администратор'),
	(5, 'Администратор'),
	(6, 'Администратор2');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;


-- Дамп структуры для таблица loktevalexey.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_roles` (`roleid`),
  CONSTRAINT `FK_user_roles` FOREIGN KEY (`roleid`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы loktevalexey.user: ~3 rows (приблизительно)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `login`, `password`, `email`, `roleid`) VALUES
	(1, 'log', 'pass', 'admin@tut.by', 1),
	(4, 'log3', 'pass3', 'admin3@tut.by', 1),
	(7, 'log2', 'pass2', 'admin2@tut.by', 1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
