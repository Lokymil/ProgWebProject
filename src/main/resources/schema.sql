create table users (
	id long NOT NULL AUTO_INCREMENT,
	lastName varchar(256),
	firstName varchar(256),
	userName varchar(256) NOT NULL,
	email varchar(256) NOT NULL,
	level varchar(50) NOT NULL
);

create table articles (
	id long NOT NULL AUTO_INCREMENT,
	authorId long NOT NULL,
	title varchar(256) NOT NULL,
	content varchar(5000) NOT NULL,
	creationDate date NOT NULL,
	lastModified date
);

create table coments (
	id long NOT NULL AUTO_INCREMENT,
	authorId long NOT NULL,
	articleId long NOT NULL,
	content varchar(5000),
	creationDate date NOT NULL
);

create table credentials (
	id long NOT NULL AUTO_INCREMENT,
	userId long NOT NULL,
	login varchar(256) NOT NULL,
	password varchar(256),
	authorisation varchar(256),
	lastUse datetime
);