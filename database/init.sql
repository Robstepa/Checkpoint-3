PRAGMA foreign_keys = ON;
BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `TypeBooks` (
	`type_id`	TEXT NOT NULL UNIQUE,
	`type`	TEXT NOT NULL,
	PRIMARY KEY(`type_id`)
);

CREATE TABLE IF NOT EXISTS `Publishers` (
	`publisher_id`	TEXT NOT NULL UNIQUE,
	`name`	TEXT NOT NULL,
	`city`	TEXT NOT NULL,
	`country`	TEXT NOT NULL,
	PRIMARY KEY(`publisher_id`)
);

CREATE TABLE IF NOT EXISTS `Authors` (
	`author_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`name`	TEXT NOT NULL,
	`surname`	TEXT NOT NULL,
	`birth_year`	TEXT NOT NULL,
	`city`	TEXT NOT NULL,
	`country`	TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS `Books` (
	`ISBN`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`author` TEXT NOT NULL,
	`title`	TEXT NOT NULL,
	`publisher`	TEXT NOT NULL,
	`publication_year`	TEXT NOT NULL,
	`price`	TEXT NOT NULL,
	`type`	TEXT NOT NULL,
	FOREIGN KEY (`author`) REFERENCES `Authors`(`author_id`),
	FOREIGN KEY (`publisher`) REFERENCES `Publishers`(`publisher_id`),
	FOREIGN KEY (`type`) REFERENCES `TypeBook`(`type_id`)
);

COMMIT;
