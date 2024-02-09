-- Création de la base de données pour la boutique en ligne
CREATE DATABASE IF NOT EXISTS reservationAteliers;
USE reservationAteliers;
-- Drop database reservationAteliers;
-- Création de la table des ateliers

-- Création de la table des clients
CREATE TABLE clients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- Ajout d'enregistrements dans la table clients
INSERT INTO reservationAteliers.clients (nom, email) VALUES
('Client 1', 'client1@example.com'),
('Client 2', 'client2@example.com'),
('Client 3', 'client3@example.com'),
('Client 4', 'client4@example.com');

select * from clients;

-- Création de la table des artisans
CREATE TABLE artisans (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- Ajout d'enregistrements dans la table artisans
INSERT INTO reservationAteliers.artisans (nom, email) VALUES
('Artisan 1', 'artisan1@example.com'),
('Artisan 2', 'artisan2@example.com'),
('Artisan 3', 'artisan3@example.com'),
('Artisan 4', 'artisan4@example.com');

select * from artisans;

CREATE TABLE ateliers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    description TEXT,
    artisan_id INT,
    CONSTRAINT fk_artisan FOREIGN KEY (artisan_id) REFERENCES artisans(id)
);

-- Ajout d'enregistrements dans la table ateliers
INSERT INTO reservationAteliers.ateliers (nom, description, artisan_id) VALUES
('Atelier 1', 'Description de l\'atelier 1', 1),
('Atelier 2', 'Description de l\'atelier 2', 2),
('Atelier 3', 'Description de l\'atelier 3', 3),
('Atelier 4', 'Description de l\'atelier 4', 4);

select * from ateliers;


-- Création de la table des réservations
CREATE TABLE reservations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date_reservation TIMESTAMP NOT NULL,
    client_id INT,
    atelier_id INT,
    CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES clients(id),
    CONSTRAINT fk_atelier FOREIGN KEY (atelier_id) REFERENCES ateliers(id)
);

-- Ajout d'enregistrements dans la table reservations
INSERT INTO reservationAteliers.reservations (date_reservation, client_id, atelier_id) VALUES
('2024-01-29 10:00:00', 1, 1),
('2024-01-30 14:30:00', 2, 2),
('2024-02-01 09:45:00', 3, 3),
('2024-02-02 16:00:00', 4, 4);

select * from reservations;


select version();


