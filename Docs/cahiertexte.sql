SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE DATABASE IF NOT EXISTS `cahiertexte`;
USE `cahiertexte`;

CREATE TABLE Filiere(
   codeFiliere VARCHAR(50),
   nom VARCHAR(50) NOT NULL,
   DESCRIPTION VARCHAR(50) NOT NULL,
   PRIMARY KEY(codeFiliere)
);

CREATE TABLE Niveau(
   codeNiveau VARCHAR(50),
   nom VARCHAR(50) NOT NULL,
   codeFiliere VARCHAR(50) NOT NULL,
   PRIMARY KEY(codeNiveau),
   FOREIGN KEY(codeFiliere) REFERENCES Filiere(codeFiliere) ON DELETE CASCADE
);

CREATE TABLE Utilisateur(
   userId INT AUTO_INCREMENT,
   username VARCHAR(50) NOT NULL,
   PASSWORD VARCHAR(50) NOT NULL,
   email VARCHAR(50) NOT NULL,
   nom VARCHAR(50) NOT NULL,
   prenom VARCHAR(50) NOT NULL,
   PRIMARY KEY(userId)
);

CREATE TABLE ROLE(
   idRole INT AUTO_INCREMENT,
   nom VARCHAR(50) NOT NULL,
   DESCRIPTION VARCHAR(250) NOT NULL,
   PRIMARY KEY(idRole)
);

CREATE TABLE Ue(
   codeUe VARCHAR(50),
   nom VARCHAR(50) NOT NULL,
   nombreHeures INT NOT NULL,
   codeNiveau VARCHAR(50) NOT NULL,
   PRIMARY KEY(codeUe),
   FOREIGN KEY(codeNiveau) REFERENCES Niveau(codeNiveau) ON DELETE CASCADE
);

CREATE TABLE Notification(
   idNotification INT AUTO_INCREMENT,
   message VARCHAR(500) NOT NULL,
   estLue BOOLEAN NOT NULL,
   TYPE VARCHAR(50) NOT NULL,
   dateLecture DATETIME NOT NULL,
   dateEnvoi DATETIME NOT NULL,
   userId INT NOT NULL,
   PRIMARY KEY(idNotification),
   FOREIGN KEY(userId) REFERENCES Utilisateur(userId) ON DELETE CASCADE
);

CREATE TABLE Seance(
   idSeance INT AUTO_INCREMENT,
   dateCours DATETIME NOT NULL,
   heureFin TIME NOT NULL,
   duree INT NOT NULL,
   titreLecon VARCHAR(50) NOT NULL,
   heureDebut TIME NOT NULL,
   contenue VARCHAR(250) NOT NULL,
   codeUe VARCHAR(50) NOT NULL,
   userId INT NOT NULL,
   PRIMARY KEY(idSeance),
   FOREIGN KEY(codeUe) REFERENCES Ue(codeUe) ON DELETE CASCADE ,
   FOREIGN KEY(userId) REFERENCES Utilisateur(userId) ON DELETE CASCADE
);

CREATE TABLE Signature(
   idSignature INT AUTO_INCREMENT,
   professeurSignature BOOLEAN NOT NULL,
   dateSignatureProf DATE NOT NULL,
   idSeance INT NOT NULL,
   PRIMARY KEY(idSignature),
   UNIQUE(idSeance),
   FOREIGN KEY(idSeance) REFERENCES Seance(idSeance) ON DELETE CASCADE
);

CREATE TABLE roleUtilisateur(
   userId INT ,
   idRole INT,
   PRIMARY KEY(userId, idRole),
   FOREIGN KEY(userId) REFERENCES Utilisateur(userId) ON DELETE CASCADE,
   FOREIGN KEY(idRole) REFERENCES ROLE(idRole) ON DELETE CASCADE
);
