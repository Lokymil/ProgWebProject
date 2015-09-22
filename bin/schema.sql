create table users (
	id long NOT NULL AUTO_INCREMENT,
	lastName varchar(256),
	firstName varchar(256),
	userName varchar(256) NOT NULL,
	email varchar(256) NOT NULL,
	level varchar(50) NOT NULL
);