-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1:2016
-- Время создания: Апр 30 2017 г., 17:21
-- Версия сервера: 10.1.10-MariaDB
-- Версия PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `korzun`
--

-- --------------------------------------------------------

--
-- Структура таблицы `brigades`
--

CREATE TABLE `brigades` (
  `ID` int(11) NOT NULL,
  `FirstPilotID` int(11) NOT NULL,
  `SecondPilotID` int(11) NOT NULL,
  `NavigatorID` int(11) NOT NULL,
  `Radio_operatorID` int(11) NOT NULL,
  `StewardessID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `brigades`
--

INSERT INTO `brigades` (`ID`, `FirstPilotID`, `SecondPilotID`, `NavigatorID`, `Radio_operatorID`, `StewardessID`) VALUES
(1, 2, 3, 4, 5, 6),
(2, 8, 10, 7, 9, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `flights`
--

CREATE TABLE `flights` (
  `ID` int(11) NOT NULL,
  `Destination` varchar(20) NOT NULL,
  `Brigades_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `flights`
--

INSERT INTO `flights` (`ID`, `Destination`, `Brigades_ID`) VALUES
(1, 'Minsk', 1),
(2, 'Amsterdam', 2);

-- --------------------------------------------------------

--
-- Структура таблицы `specializations`
--

CREATE TABLE `specializations` (
  `ID` int(11) NOT NULL,
  `Specialization` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `specializations`
--

INSERT INTO `specializations` (`ID`, `Specialization`) VALUES
(1, 'Pilot'),
(2, 'Navigator'),
(3, 'Radio_operator'),
(4, 'Stewardess');

-- --------------------------------------------------------

--
-- Структура таблицы `staff`
--

CREATE TABLE `staff` (
  `ID` int(11) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `FK_Specialization` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `staff`
--

INSERT INTO `staff` (`ID`, `Name`, `FK_Specialization`) VALUES
(1, 'Mikhal Potapich', 4),
(2, 'Pasha', 1),
(3, 'Max', 1),
(4, 'Nastya', 2),
(5, 'Vasya', 3),
(6, 'Masha', 4),
(7, 'Walter', 2),
(8, 'Back', 1),
(9, 'Baker', 3),
(10, 'Alla', 1);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `brigades`
--
ALTER TABLE `brigades`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `flights`
--
ALTER TABLE `flights`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `specializations`
--
ALTER TABLE `specializations`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `brigades`
--
ALTER TABLE `brigades`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблицы `flights`
--
ALTER TABLE `flights`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблицы `specializations`
--
ALTER TABLE `specializations`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT для таблицы `staff`
--
ALTER TABLE `staff`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
