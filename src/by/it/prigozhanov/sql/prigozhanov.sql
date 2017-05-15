-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1:2016
-- Время создания: Май 15 2017 г., 19:46
-- Версия сервера: 10.1.10-MariaDB
-- Версия PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `prigozhanov`
--
CREATE DATABASE IF NOT EXISTS `prigozhanov` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `prigozhanov`;

-- --------------------------------------------------------

--
-- Структура таблицы `cars`
--

CREATE TABLE `cars` (
  `ID` int(11) NOT NULL,
  `Mark` varchar(100) NOT NULL,
  `Model` varchar(100) NOT NULL,
  `HP` int(11) NOT NULL,
  `Location` varchar(100) NOT NULL,
  `Luggage_capacity` int(11) NOT NULL,
  `Price` int(11) NOT NULL,
  `Seats` int(11) NOT NULL,
  `Fuel_consumption` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `cars`
--

INSERT INTO `cars` (`ID`, `Mark`, `Model`, `HP`, `Location`, `Luggage_capacity`, `Price`, `Seats`, `Fuel_consumption`) VALUES
(1, 'Porsche', 'Panamera', 600, 'Minsk', 2, 1950, 4, 15),
(2, 'BMW', 'M3', 550, 'Minsk', 3, 1200, 4, 16),
(3, 'Bentley', 'Bentayga', 750, 'Minsk', 3, 2500, 4, 13),
(4, 'Honda', 'Accord', 320, 'Minsk', 3, 400, 4, 10),
(5, 'Porsche', 'CaymanS', 730, 'Minsk', 1, 2400, 2, 17),
(6, 'Honda', 'Civic', 300, 'Moscow', 4, 450, 5, 14),
(7, 'Honda', 'Accord', 350, 'Moscow', 5, 550, 5, 16),
(8, 'Honda', 'CR-Z', 250, 'Moscow', 4, 430, 4, 17);

-- --------------------------------------------------------

--
-- Структура таблицы `orders`
--

CREATE TABLE `orders` (
  `ID` int(11) NOT NULL,
  `Passport_data` varchar(45) NOT NULL,
  `Card_number` varchar(45) NOT NULL,
  `Order_duration` int(11) NOT NULL,
  `Telephone` varchar(45) NOT NULL,
  `FK_Users` int(11) DEFAULT NULL,
  `FK_Cars` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `orders`
--

INSERT INTO `orders` (`ID`, `Passport_data`, `Card_number`, `Order_duration`, `Telephone`, `FK_Users`, `FK_Cars`) VALUES
(8, 'MP77777777', 'TEST-TEST-TEST-TEST', 6, '+375333538090', 7, 2),
(9, 'MP7777777', 'TEST-TEST-TEST-TEST', 3, '+375333538090', 5, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `roles`
--

CREATE TABLE `roles` (
  `ID` int(11) NOT NULL,
  `Role` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `roles`
--

INSERT INTO `roles` (`ID`, `Role`) VALUES
(1, 'Administrator'),
(2, 'User');

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `Passport_data` varchar(100) NOT NULL,
  `Login` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `FK_Roles` int(11) NOT NULL DEFAULT '2'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`ID`, `Passport_data`, `Login`, `Password`, `Email`, `FK_Roles`) VALUES
(5, 'MP7777777', 'Administrator', 'Administrator', 'Administrator@mail.com', 1),
(6, 'MP884727263', 'Ivanov', 'Ivanov123', 'Ivanov1@gmail.com', 2),
(7, 'MP77777777', 'TestUser', 'TestUser', 'TestUser@mail.ru', 2),
(10, 'MP2683134', 'Prigozhanov', '12345678', 'prigozhanov@gmail.com', 1),
(11, 'MP2394563', 'Petrov1994', '2939132KWleex', 'petrov1994@gmail.com', 2),
(12, 'MP7777777', 'TestAdministrator', 'Administrator', 'Administrator@mail.com', 2);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_Orders_users1_idx` (`FK_Users`),
  ADD KEY `fk_Orders_cars1_idx` (`FK_Cars`);

--
-- Индексы таблицы `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_users_roles_idx` (`FK_Roles`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `cars`
--
ALTER TABLE `cars`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT для таблицы `orders`
--
ALTER TABLE `orders`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT для таблицы `roles`
--
ALTER TABLE `roles`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `fk_Orders_cars1` FOREIGN KEY (`FK_Cars`) REFERENCES `cars` (`ID`),
  ADD CONSTRAINT `fk_Orders_users1` FOREIGN KEY (`FK_Users`) REFERENCES `users` (`ID`);

--
-- Ограничения внешнего ключа таблицы `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_users_roles` FOREIGN KEY (`FK_Roles`) REFERENCES `roles` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
