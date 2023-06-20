DROP DATABASE IF EXISTS HikuCraft;
CREATE DATABASE HikuCraft;
USE HikuCraft;

-- Tables

CREATE TABLE PlayerDatas (

	UUID VARCHAR(36) NOT NULL,
	TimeSpent UNSIGNED INT NOT NULL DEFAULT 0,

	PRIMARY KEY (UUID),
	UNIQUE (UUID)
	
);


CREATE TABLE Homes (

	UUID VARCHAR(36) NOT NULL,
	Name VARCHAR(16) NOT NULL,
	World VARCHAR(16) NOT NULL,
	X INT NOT NULL,
	Y INT NOT NULL,
	Z INT NOT NULL,

	PRIMARY KEY (UUID, Name),
	UNIQUE (UUID, Name),
	FOREIGN KEY (UUID) REFERENCES PlayerData (UUID) ON DELETE CASCADE ON UPDATE CASCADE,
	
	CONSTRAINT Home_World CHECK (World IN ('world', 'world_nether', 'world_the_end'))

);



-- Users
CREATE USER IF NOT EXISTS 'HikuCraft_admin'@'localhost' IDENTIFIED BY 'HikuCraft_admin_psw';
CREATE USER IF NOT EXISTS 'HikuCraft_user'@'localhost' IDENTIFIED BY 'HikuCraft_user_psw';

GRANT ALL PRIVILEGES ON HikuCraft.* TO 'HikuCraft_admin'@'localhost';
GRANT SELECT ON HikuCraft.* TO 'HikuCraft_user'@'localhost';
GRANT INSERT ON HikuCraft.* TO 'HikuCraft_user'@'localhost';
GRANT UPDATE(TimeSpent) ON HikuCraft.PlayerData TO 'HikuCraft_user'@'localhost';
GRANT DELETE ON HikuCraft.Home TO 'HikuCraft_user'@'localhost';
