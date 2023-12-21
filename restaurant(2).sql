-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 18 déc. 2023 à 20:34
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `restaurant`
--

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `idCom` int(11) NOT NULL,
  `dateCom` date NOT NULL,
  `idT` int(11) NOT NULL,
  `etatCom` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`idCom`, `dateCom`, `idT`, `etatCom`) VALUES
(1, '2023-07-31', 1, 1),
(2, '2023-07-31', 1, 1),
(3, '2023-07-31', 2, 0),
(4, '2023-07-31', 5, 0),
(5, '2023-11-15', 3, 0);

-- --------------------------------------------------------

--
-- Structure de la table `details_commande`
--

CREATE TABLE `details_commande` (
  `id` int(11) NOT NULL,
  `idCom` int(11) NOT NULL,
  `idPro` int(11) NOT NULL,
  `qt` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `details_commande`
--

INSERT INTO `details_commande` (`id`, `idCom`, `idPro`, `qt`) VALUES
(1, 1, 9, 1),
(2, 2, 1, 1),
(3, 3, 3, 1),
(4, 3, 1, 1),
(5, 3, 9, 1),
(6, 3, 10, 1),
(7, 3, 15, 10),
(8, 3, 12, 3),
(9, 3, 11, 1),
(10, 4, 1, 1),
(11, 5, 11, 2),
(12, 5, 15, 1);

-- --------------------------------------------------------

--
-- Structure de la table `produits`
--

CREATE TABLE `produits` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `descr` varchar(200) NOT NULL,
  `price` int(11) NOT NULL,
  `catg` varchar(100) NOT NULL,
  `available` tinyint(1) NOT NULL,
  `image` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `produits`
--

INSERT INTO `produits` (`id`, `name`, `descr`, `price`, `catg`, `available`, `image`) VALUES
(1, 'Poulet grillé', 'Poulet laqué avec du miel\nPour 4  maximum personne', 20000, 'Specialité', 1, '.\\src\\Assets\\Images\\56194691-f36d-44d9-b991-e063703c214c.jpg'),
(3, 'Sushi', 'Plat qui vient de japon\nPour une personne', 7000, 'Entrée', 1, '.\\src\\Assets\\Images\\344bf82e-7dcd-431d-aeb8-5d74bc09625a.jpg'),
(8, 'Plat Spécial', 'Plat spécial du jours ', 4000, 'petit déjeuner', 1, '.\\src\\Assets\\Images\\7f0b11a8-9d29-4238-9bfa-14773c620c4f.jpg'),
(9, 'Cuisse de poulet', 'cuisse laquet au gigembre', 2000, 'Repas', 1, '.\\src\\Assets\\Images\\66c30f10-0c22-4f6d-af03-3a9e83d38bd9.jpg'),
(10, 'Salade de fruit de Mer', 'Contient plusieur type te fruit de mer tels que\n(poisson,languste,...)', 15000, 'Entrée', 1, '.\\src\\Assets\\Images\\32786ebe-f38f-4b42-87a7-1cccb29eb6df.jpg'),
(11, 'Plat de spaguet', 'Plat de spagetti ', 10000, 'Specialité', 1, '.\\src\\Assets\\Images\\1b6faf2a-ee1d-49d4-801e-654940327372.jpg'),
(12, 'Barbecues', 'Barbecue de boeuf', 80000, 'Specialité', 1, '.\\src\\Assets\\Images\\4f7a6810-18f9-4592-b4a1-bfdc60c9a562.jpg'),
(15, 'saucisse', '15cm', 11000, 'Repas', 1, '.\\src\\Assets\\Images\\f5e31dae-cd7f-4f87-90ec-69b99dd92de5.jpg'),
(17, 'Vin(1990)', 'Vin de 1990 ', 30000, 'Boisson', 1, '.\\src\\Assets\\Images\\Vin(1990).jpg');

-- --------------------------------------------------------

--
-- Structure de la table `table_r`
--

CREATE TABLE `table_r` (
  `id` int(11) NOT NULL,
  `tables` varchar(150) NOT NULL,
  `Available` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `table_r`
--

INSERT INTO `table_r` (`id`, `tables`, `Available`) VALUES
(1, 'Table1', 1),
(2, 'Table2', 0),
(3, 'Table3', 0),
(4, 'Table4', 1),
(5, 'Table5', 0),
(6, 'Table6', 1),
(7, 'Table7', 1),
(8, 'Table8', 1),
(9, 'Table9', 1);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `login` varchar(200) NOT NULL,
  `mdp` varchar(200) NOT NULL,
  `admin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `login`, `mdp`, `admin`) VALUES
(1, 'Admin', 'admin', 1),
(2, 'UT1', 'Saive', 0),
(3, 'UT3', 'eddy', 0),
(4, 'Eddy', 'Eddy', 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`idCom`),
  ADD KEY `fk_table` (`idT`);

--
-- Index pour la table `details_commande`
--
ALTER TABLE `details_commande`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_produit` (`idPro`),
  ADD KEY `fk_commandes` (`idCom`);

--
-- Index pour la table `produits`
--
ALTER TABLE `produits`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `table_r`
--
ALTER TABLE `table_r`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `idCom` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `details_commande`
--
ALTER TABLE `details_commande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `produits`
--
ALTER TABLE `produits`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT pour la table `table_r`
--
ALTER TABLE `table_r`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `fk_table` FOREIGN KEY (`idT`) REFERENCES `table_r` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `details_commande`
--
ALTER TABLE `details_commande`
  ADD CONSTRAINT `fk_commandes` FOREIGN KEY (`idCom`) REFERENCES `commande` (`idCom`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_produit` FOREIGN KEY (`idPro`) REFERENCES `produits` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
