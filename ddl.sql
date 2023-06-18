DROP DATABASE IF EXISTS HikuCraft;
CREATE DATABASE HikuCraft;
USE HikuCraft;

-- Tables

CREATE TABLE PlayerData (
	UUID VARCHAR(36) NOT NULL,
	TimePlayed TIME(1),

	PRIMARY KEY (UUID),
	UNIQUE (UUID),
	
	CONSTRAINT PlayerData_TimePlayed CHECK (TimePlayed >= 0),

);


CREATE TABLE Home (
	UUID VARCHAR(36) NOT NULL,
	Name VARCHAR(16) NOT NULL,
	World VARCHAR(16) NOT NULL,
	X INT NOT NULL,
	Y INT NOT NULL,
	Z INT NOT NULL,

	PRIMARY KEY (UUID, Name),
	UNIQUE (UUID, Name),
	FOREIGN KEY (UUID) REFERENCES PlayerData (UUID) ON DELETE CASCADE ON UPDATE CASCADE,
	
	CONSTRAINT 'Home_World' CHECK (World IN ('world', 'world_nether', 'world_the_end')),

);



-- Users
CREATE USER IF NOT EXISTS 'HikuCraft_admin'@'localhost' IDENTIFIED BY 'HikuCraft_admin_psw';
CREATE USER IF NOT EXISTS 'HikuCraft_user'@'localhost' IDENTIFIED BY 'HikuCraft_user_psw';

GRANT ALL PRIVILEGES ON HikuCraft.* TO 'HikuCraft_admin'@'localhost';
GRANT SELECT ON HikuCraft.* TO 'HikuCraft_user'@'localhost';
GRANT INSERT ON HikuCraft.* TO 'HikuCraft_user'@'localhost';
GRANT UPDATE(TimePlayed) ON HikuCraft.PlayerData TO 'HikuCraft_user'@'localhost';
GRANT DELETE ON HikuCraft.Home TO 'HikuCraft_user'@'localhost';
