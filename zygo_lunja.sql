-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 01 août 2022 à 20:38
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 7.4.29
USE heroku_b23fce149c4259a;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données : `zygo_lunja`
--
CREATE DATABASE IF NOT EXISTS `zygo_lunja` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `zygo_lunja`;

-- --------------------------------------------------------

--
-- Structure de la table `exercice`
--

DROP TABLE IF EXISTS `exercice`;
CREATE TABLE IF NOT EXISTS `exercice` (
  `ide` bigint(20) NOT NULL,
  `namee` varchar(255) DEFAULT NULL,
  `user_username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ide`),
  KEY `FK85ryx3k61t9nie4e6jc2uafll` (`user_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `role` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `serie`
--

DROP TABLE IF EXISTS `serie`;
CREATE TABLE IF NOT EXISTS `serie` (
  `ids` bigint(20) NOT NULL,
  `poidslv1` double DEFAULT NULL,
  `poidslv2` double DEFAULT NULL,
  `poidslv3` double DEFAULT NULL,
  `rep1` int(11) DEFAULT NULL,
  `rep2` int(11) DEFAULT NULL,
  `rep3` int(11) DEFAULT NULL,
  `exercie_ide` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ids`),
  KEY `FK7cjsorai99q4kr48upgbya23g` (`exercie_ide`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `series_exercices`
--

DROP TABLE IF EXISTS `series_exercices`;
CREATE TABLE IF NOT EXISTS `series_exercices` (
  `exercice_ide` bigint(20) NOT NULL,
  `series_ids` bigint(20) NOT NULL,
  UNIQUE KEY `UK_fl60jheh852dyau6f4p6wrlds` (`series_ids`),
  KEY `FKfkhux119poixqnyxvrjn048ir` (`exercice_ide`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `users_exercices`
--

DROP TABLE IF EXISTS `users_exercices`;
CREATE TABLE IF NOT EXISTS `users_exercices` (
  `user_username` varchar(255) NOT NULL,
  `exercices_ide` bigint(20) NOT NULL,
  UNIQUE KEY `UK_lvso34gi5nregg2f5ew5d3fq6` (`exercices_ide`),
  KEY `FKj00vafgav83c4q93klksd8n8h` (`user_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE IF NOT EXISTS `users_roles` (
  `user_username` varchar(255) NOT NULL,
  `roles_role` varchar(255) NOT NULL,
  KEY `FK9bxfby7rpenikksf47nelxdbt` (`roles_role`),
  KEY `FK1y8kc6nr793297gijoc5t5qmx` (`user_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `exercice`
--
ALTER TABLE `exercice`
  ADD CONSTRAINT `FK85ryx3k61t9nie4e6jc2uafll` FOREIGN KEY (`user_username`) REFERENCES `users` (`username`);

--
-- Contraintes pour la table `serie`
--
ALTER TABLE `serie`
  ADD CONSTRAINT `FK7cjsorai99q4kr48upgbya23g` FOREIGN KEY (`exercie_ide`) REFERENCES `exercice` (`ide`);

--
-- Contraintes pour la table `series_exercices`
--
ALTER TABLE `series_exercices`
  ADD CONSTRAINT `FKfkhux119poixqnyxvrjn048ir` FOREIGN KEY (`exercice_ide`) REFERENCES `exercice` (`ide`),
  ADD CONSTRAINT `FKns0ahup805xbx9k1bdv2boqq9` FOREIGN KEY (`series_ids`) REFERENCES `serie` (`ids`);

--
-- Contraintes pour la table `users_exercices`
--
ALTER TABLE `users_exercices`
  ADD CONSTRAINT `FKhh0v4f5kmlcpv5o5pnbdxv8xk` FOREIGN KEY (`exercices_ide`) REFERENCES `exercice` (`ide`),
  ADD CONSTRAINT `FKj00vafgav83c4q93klksd8n8h` FOREIGN KEY (`user_username`) REFERENCES `users` (`username`);

--
-- Contraintes pour la table `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `FK1y8kc6nr793297gijoc5t5qmx` FOREIGN KEY (`user_username`) REFERENCES `users` (`username`),
  ADD CONSTRAINT `FK9bxfby7rpenikksf47nelxdbt` FOREIGN KEY (`roles_role`) REFERENCES `role` (`role`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
