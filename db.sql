DROP DATABASE IF EXISTS centreformation;
CREATE DATABASE centreformation;
USE centreformation;

CREATE TABLE SOCIETE (CodeSociete INTEGER NOT NULL AUTO_INCREMENT, NomSociete VARCHAR(255), PRIMARY KEY (CodeSociete));
CREATE TABLE COMMANDE (NumeroCommande INTEGER NOT NULL AUTO_INCREMENT, DateCommande DATE, NbrPlacesCommande INTEGER, SocieteCode INTEGER,SessionNumero INTEGER,  PRIMARY KEY (NumeroCommande));
CREATE TABLE SESSION (NumeroSession INTEGER NOT NULL AUTO_INCREMENT, DateSession DATE, HeureDebut TIME, HeureFin TIME,SeminaireCode INTEGER,PRIMARY KEY (NumeroSession));
CREATE TABLE FACTURE (NumeroFacture INTEGER NOT NULL AUTO_INCREMENT, DateFacture DATE, MontantFacture INTEGER, NbrPlacesFacturees INTEGER, CommandeNumero INTEGER,PRIMARY KEY (NumeroFacture));
CREATE TABLE SEMINAIRE (CodeSeminaire INTEGER NOT NULL AUTO_INCREMENT, PrixSeminaire INTEGER, DureeSeminaire INTEGER, NiveauSeminaire INTEGER,NbrPlacesSeminaire INTEGER, PRIMARY KEY (CodeSeminaire));

ALTER TABLE COMMANDE ADD CONSTRAINT fk_COMMANDE_SOCIETE_PasserCommande FOREIGN KEY (SocieteCode) REFERENCES SOCIETE (CodeSociete);
ALTER TABLE COMMANDE ADD CONSTRAINT fk_COMMANDE_SESSION_Demande_Satifaite FOREIGN KEY (SessionNumero) REFERENCES SESSION (NumeroSession);
ALTER TABLE FACTURE ADD CONSTRAINT fk_FACTURE_COMMANDE_Generer FOREIGN KEY (CommandeNumero) REFERENCES  COMMANDE (NumeroCommande);
ALTER TABLE SESSION ADD CONSTRAINT fk_SESSION_SEMINAIRE_Concerner FOREIGN KEY (SeminaireCode) REFERENCES SEMINAIRE (CodeSeminaire);

INSERT INTO SEMINAIRE (PrixSeminaire, DureeSeminaire, NiveauSeminaire,NbrPlacesSeminaire) VALUES 
(200, 5,2,15),(250, 6,3,10),(900, 4,5,12);

INSERT INTO SOCIETE (NomSociete) VALUES ('STI'),('GHI'),('Societe M'),('Treeptik'),('Video store');

INSERT INTO SESSION (DateSession, HeureDebut, HeureFin,SeminaireCode) VALUES 
('2013-07-22','09:00:00', '16:00:00', 2),('2013-07-31','09:00:00', '15:00:00', 1),
('2013-08-05','08:00:00', '12:00:00', 3);

INSERT INTO COMMANDE ( DateCommande, NbrPlacesCommande, SocieteCode,SessionNumero) VALUES 
('2013-07-22',3,1,3),('2013-07-25',2,2,3),('2013-07-20',5,3,3),('2013-07-19',1,4,3),
('2013-07-22',2,1,2),('2013-07-23',4,5,2),('2013-07-25',3,2,2),('2013-07-27',2,3,2),
('2013-07-20',2,1,1),('2013-07-21',2,2,1),('2013-07-15',2,4,1),('2013-07-10',2,5,1);

INSERT INTO FACTURE (DateFacture, MontantFacture, NbrPlacesFacturees,CommandeNumero) VALUES 
('2013-07-22', 500, 2,9),('2013-07-22', 500, 2,10),('2013-07-22', 500, 2,11),('2013-07-22', 500, 2,12),
('2013-07-31', 400, 2,5),('2013-07-28', 800, 4,6),('2013-07-30', 600, 3,7),('2013-07-31', 200, 2,8),
('2013-08-05', 900, 3,1),('2013-08-05', 600, 2,2),('2013-08-05', 1500, 5,3),('2013-08-05', 300, 1,4);