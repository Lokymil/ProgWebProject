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
	creatorId long NOT NULL,
	title varchar(256) NOT NULL,
	content varchar(5000) NOT NULL,
	creationDate date NOT NULL,
	lastModified date,
	note long
);

create table coments (
	id long NOT NULL AUTO_INCREMENT,
	creatorId long NOT NULL,
	articleId long NOT NULL,
	content varchar(5000),
	creationDate date NOT NULL
);