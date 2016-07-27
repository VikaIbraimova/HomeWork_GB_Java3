CREATE TABLE followers (
	user_from 	TEXT 	NOT NULL,
	user_to 	TEXT 	NOT NULL
);

CREATE TABLE tweets (
	id 	INTEGER PRIMARY KEY 	AUTOINCREMENT 	NOT NULL,
	login 	TEXT 					NOT NULL,
	message TEXT 					NOT NULL,
	date 	TEXT
);

CREATE TABLE users (
	login 		TEXT 	PRIMARY KEY 	NOT NULL,
	username 	TEXT 			NOT NULL
);
	


