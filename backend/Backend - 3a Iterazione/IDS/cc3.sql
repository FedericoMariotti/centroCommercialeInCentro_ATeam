-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Dic 17, 2020 alle 10:55
-- Versione del server: 10.4.17-MariaDB
-- Versione PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cc3`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `customer`
--

CREATE TABLE `customer` (
  `idCustomer` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `surname` varchar(20) NOT NULL,
  `address` varchar(50) NOT NULL,
  `cellNumber` int(10) NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `deliver`
--

CREATE TABLE `deliver` (
  `idDeliver` int(11) NOT NULL,
  `name` int(20) NOT NULL,
  `cellnumber` int(10) NOT NULL,
  `address` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `locker`
--

CREATE TABLE `locker` (
  `idLocker` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `address` varchar(50) NOT NULL,
  `cellnumber` int(10) NOT NULL,
  `openTime` time DEFAULT NULL,
  `closeTime` time DEFAULT NULL,
  `idDeliver` int(11) DEFAULT NULL  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `market`
--

CREATE TABLE `market` (
  `idMarket` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL CHECK (`type` in ('abbigliamento','arredamento','bottegacalzature','edilizia','elettronica','farmacia','ipermercato','profumeria')),
  `cellNumber` int(10) DEFAULT NULL,
  `idSeller` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `order`
--

CREATE TABLE `order` (
  `idOrder` int(11) NOT NULL,
  `status` varchar(15) DEFAULT NULL CHECK (`status` in ('recieved','preparing','shipped','inDelivery','delivered','deliveredInLocker','pickedInLocker','cancelled')),
  `idProduct` int(11) DEFAULT NULL,
  `idCustomer` int(11) DEFAULT NULL,
  `idDeliver` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `product`
--

CREATE TABLE `product` (
  `idProduct` int(11) NOT NULL,
  `name` int(11) NOT NULL,
  `price` float NOT NULL,
  `brand` int(11) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `idMarket` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `seller`
--

CREATE TABLE `seller` (
  `idSeller` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `surname` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`idCustomer`);

--
-- Indici per le tabelle `deliver`
--
ALTER TABLE `deliver`
  ADD PRIMARY KEY (`idDeliver`);

--
-- Indici per le tabelle `locker`
--
ALTER TABLE `locker`
  ADD PRIMARY KEY (`idLocker`),
  ADD KEY `idDeliver` (`idDeliver`);

--
-- Indici per le tabelle `market`
--
ALTER TABLE `market`
  ADD PRIMARY KEY (`idMarket`),
  ADD KEY `idSeller` (`idSeller`);

--
-- Indici per le tabelle `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`idOrder`),
  ADD KEY `idProduct` (`idProduct`),
  ADD KEY `idCustomer` (`idCustomer`),
  ADD KEY `idDeliver` (`idDeliver`);

--
-- Indici per le tabelle `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`idProduct`),
  ADD KEY `idMarket` (`idMarket`);

--
-- Indici per le tabelle `seller`
--
ALTER TABLE `seller`
  ADD PRIMARY KEY (`idSeller`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `customer`
--
ALTER TABLE `customer`
  MODIFY `idCustomer` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `deliver`
--
ALTER TABLE `deliver`
  MODIFY `idDeliver` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `locker`
--
ALTER TABLE `locker`
  MODIFY `idLocker` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `market`
--
ALTER TABLE `market`
  MODIFY `idMarket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `order`
--
ALTER TABLE `order`
  MODIFY `idOrder` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `product`
--
ALTER TABLE `product`
  MODIFY `idProduct` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `seller`
--
ALTER TABLE `seller`
  MODIFY `idSeller` int(11) NOT NULL AUTO_INCREMENT;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `locker`
--
ALTER TABLE `locker`
  ADD CONSTRAINT `locker_ibfk_1` FOREIGN KEY (`idDeliver`) REFERENCES `deliver` (`idDeliver`);

--
-- Limiti per la tabella `market`
--
ALTER TABLE `market`
  ADD CONSTRAINT `market_ibfk_1` FOREIGN KEY (`idSeller`) REFERENCES `seller` (`idSeller`);

--
-- Limiti per la tabella `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `order_ibfk_1` FOREIGN KEY (`idProduct`) REFERENCES `product` (`idProduct`),
  ADD CONSTRAINT `order_ibfk_2` FOREIGN KEY (`idCustomer`) REFERENCES `customer` (`idCustomer`),
  ADD CONSTRAINT `order_ibfk_3` FOREIGN KEY (`idDeliver`) REFERENCES `deliver` (`idDeliver`);

--
-- Limiti per la tabella `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`idMarket`) REFERENCES `market` (`idMarket`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
