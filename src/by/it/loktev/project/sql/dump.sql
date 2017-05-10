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


-- Дамп структуры базы данных loktevalexey
CREATE DATABASE IF NOT EXISTS `loktevalexey` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `loktevalexey`;

-- Дамп структуры для таблица loktevalexey.ads
CREATE TABLE IF NOT EXISTS `ads` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `floor` int(11) NOT NULL DEFAULT '0',
  `floors` int(11) NOT NULL DEFAULT '0',
  `rooms` int(11) NOT NULL DEFAULT '0',
  `address` varchar(200) NOT NULL DEFAULT '0',
  `desc` varchar(2000) DEFAULT NULL,
  `userid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_ad_user` (`userid`),
  CONSTRAINT `FK_ad_user` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы loktevalexey.ads: ~3 rows (приблизительно)
DELETE FROM `ads`;
/*!40000 ALTER TABLE `ads` DISABLE KEYS */;
INSERT INTO `ads` (`id`, `floor`, `floors`, `rooms`, `address`, `desc`, `userid`) VALUES
	(7, 1, 5, 2, 'Мулявина 6', 'ЦА', 2),
	(8, 1, 5, 2, 'Мулявина 7', 'СервисДеск', 3),
	(9, 1, 5, 2, 'Мулявина 8', 'ШББ', 2);
/*!40000 ALTER TABLE `ads` ENABLE KEYS */;

-- Дамп структуры для таблица loktevalexey.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы loktevalexey.roles: ~2 rows (приблизительно)
DELETE FROM `roles`;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `name`) VALUES
	(1, 'Администратор'),
	(2, 'Пользователь');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Дамп структуры для таблица loktevalexey.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `roleid` int(11) DEFAULT '2',
  PRIMARY KEY (`id`),
  KEY `FK_user_roles` (`roleid`),
  CONSTRAINT `FK_user_roles` FOREIGN KEY (`roleid`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы loktevalexey.users: ~6 rows (приблизительно)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `login`, `password`, `email`, `roleid`) VALUES
	(1, 'admin1', 'pass1', 'email1@gmail.com', 1),
	(2, 'user2', 'pass2', 'email2@gmail.com', 2),
	(3, 'user3', 'pass3', 'email3@gmail.com', 2);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
