-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.10-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.2.0.4947
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for loktevalexey
DROP DATABASE IF EXISTS `loktevalexey`;
CREATE DATABASE IF NOT EXISTS `loktevalexey` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `loktevalexey`;


-- Dumping structure for table loktevalexey.roles
DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table loktevalexey.roles: ~2 rows (approximately)
DELETE FROM `roles`;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `name`) VALUES
	(1, 'Администратор'),
	(2, 'Пользователь');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;


-- Dumping structure for table loktevalexey.statuses
DROP TABLE IF EXISTS `statuses`;
CREATE TABLE IF NOT EXISTS `statuses` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table loktevalexey.statuses: ~3 rows (approximately)
DELETE FROM `statuses`;
/*!40000 ALTER TABLE `statuses` DISABLE KEYS */;
INSERT INTO `statuses` (`id`, `name`) VALUES
	(1, 'новая'),
	(2, 'в работе'),
	(3, 'исполнена');
/*!40000 ALTER TABLE `statuses` ENABLE KEYS */;


-- Dumping structure for table loktevalexey.tasks
DROP TABLE IF EXISTS `tasks`;
CREATE TABLE IF NOT EXISTS `tasks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '',
  `enddate` date DEFAULT NULL,
  `price` double NOT NULL DEFAULT '0',
  `statusid` smallint(6) NOT NULL DEFAULT '1',
  `execuserid` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `FK_tasks_statuses` (`statusid`),
  KEY `FK_tasks_users` (`execuserid`),
  CONSTRAINT `FK_tasks_statuses` FOREIGN KEY (`statusid`) REFERENCES `statuses` (`id`),
  CONSTRAINT `FK_tasks_users` FOREIGN KEY (`execuserid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Dumping data for table loktevalexey.tasks: ~6 rows (approximately)
DELETE FROM `tasks`;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` (`id`, `name`, `enddate`, `price`, `statusid`, `execuserid`) VALUES
	(1, 'aaa', NULL, 111, 1, 1),
	(4, 'привет пока 444', '2222-12-22', 111.22000122070312, 2, 5),
	(6, 'test task', '1111-01-20', 111.22000122070312, 2, 1),
	(7, 'test test', '2012-01-20', 333, 2, 1),
	(8, 'ertwetgwrtewrt', '2022-07-20', 222, 3, 2),
	(10, 'привет пока 333 aaa', '2017-05-22', 333.1099853515625, 3, 1);
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;


-- Dumping structure for table loktevalexey.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) DEFAULT NULL,
  `passhash` varchar(32) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `roleid` int(11) DEFAULT '2',
  PRIMARY KEY (`id`),
  KEY `FK_user_roles` (`roleid`),
  CONSTRAINT `FK_user_roles` FOREIGN KEY (`roleid`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table loktevalexey.users: ~4 rows (approximately)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `login`, `passhash`, `email`, `roleid`) VALUES
	(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'email22@gmail.com', 1),
	(2, 'user11', 'ee11cbb19052e40b07aac0ca060c23ee', 'email11@gmail.com', 1),
	(5, 'user3', 'ee11cbb19052e40b07aac0ca060c23ee', 'loktev@tut.by', 2);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
