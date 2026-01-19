-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Tempo de geração: 19/01/2026 às 18:55
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `tonersdb`
--
CREATE DATABASE IF NOT EXISTS `tonersdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `tonersdb`;

-- --------------------------------------------------------

--
-- Estrutura para tabela `printers`
--

CREATE TABLE `printers` (
  `id` bigint(20) NOT NULL,
  `model` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `printers`
--

INSERT INTO `printers` (`id`, `model`) VALUES
(1, 'HP LaserJet 107'),
(2, 'HP LaserJet MFP135'),
(3, 'HP LaserJet M102W'),
(4, 'LaserJet M130FW'),
(5, 'HP LaserJet Hp1102w'),
(6, 'HP LaserJet M1132'),
(7, 'HP LaserJet P2055'),
(9, 'Multifuncional HP LaserJet M180'),
(10, 'HP LaserJet 432'),
(11, 'Pantum Multifuncional M6550'),
(12, 'Brother Laser DCP 1510'),
(13, 'Brother Laser 1000/35/40/70/75'),
(14, 'Epson L3250'),
(15, 'HP LaserJet 3050');

-- --------------------------------------------------------

--
-- Estrutura para tabela `toners`
--

CREATE TABLE `toners` (
  `id` bigint(20) NOT NULL,
  `model` varchar(255) DEFAULT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `toners`
--

INSERT INTO `toners` (`id`, `model`, `quantity`) VALUES
(2, '105A', 8),
(3, '217A', 11),
(4, '285A', 0),
(5, '505', 0),
(6, '510A BK', 5),
(7, '511 C', 7),
(8, '512 Y', 7),
(9, '513 M', 7),
(10, 'PB 211', 3),
(11, 'TN-1060', 19),
(12, 'DR-1060', 16),
(13, 'D203U', 6),
(14, 'Tinta Preta', 3),
(15, 'Tinta Magenta', 10),
(16, 'Tinta Amarela', 10),
(17, 'Tinta Ciano', 11);

-- --------------------------------------------------------

--
-- Estrutura para tabela `toner_printer`
--

CREATE TABLE `toner_printer` (
  `toner_id` bigint(20) NOT NULL,
  `printer_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `toner_printer`
--

INSERT INTO `toner_printer` (`toner_id`, `printer_id`) VALUES
(2, 1),
(2, 2),
(3, 3),
(3, 4),
(4, 5),
(4, 6),
(5, 7),
(6, 9),
(7, 9),
(8, 9),
(9, 9),
(10, 11),
(11, 12),
(11, 13),
(12, 12),
(12, 13),
(13, 10),
(14, 14),
(15, 14),
(16, 14),
(17, 14);

-- --------------------------------------------------------

--
-- Estrutura para tabela `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `users`
--

INSERT INTO `users` (`id`, `name`, `password`) VALUES
(1, 'admin', '123');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `printers`
--
ALTER TABLE `printers`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `toners`
--
ALTER TABLE `toners`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `toner_printer`
--
ALTER TABLE `toner_printer`
  ADD KEY `FKlj27t3u10l4t33mef1pr5ar8j` (`printer_id`),
  ADD KEY `FKkp618vspkr23fmfn81votbw2h` (`toner_id`);

--
-- Índices de tabela `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `printers`
--
ALTER TABLE `printers`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de tabela `toners`
--
ALTER TABLE `toners`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de tabela `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `toner_printer`
--
ALTER TABLE `toner_printer`
  ADD CONSTRAINT `FKkp618vspkr23fmfn81votbw2h` FOREIGN KEY (`toner_id`) REFERENCES `toners` (`id`),
  ADD CONSTRAINT `FKlj27t3u10l4t33mef1pr5ar8j` FOREIGN KEY (`printer_id`) REFERENCES `printers` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
