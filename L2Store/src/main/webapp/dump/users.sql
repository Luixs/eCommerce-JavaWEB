#-------- CRIAÇÃO DOS USUÁRIOS

CREATE TABLE users (
	id serial not null PRIMARY KEY,
	name varchar(30) not null,
	lastName varchar(30),
	birthday varchar(25),
	gender varchar(2),
	mail varchar(59),
	pass varchar(32)
);

SELECT * FROM users;
#SENHA -- 123456

DROP TABLE users;
DROP TABLE ordersBuy;
#------ CRIAÇÃO DAS ORDENS DE COMPRA

CREATE TABLE ordersBuy(
	id serial not null PRIMARY KEY,
	id_products varchar(30) not null,
	value varchar(10) not null,
	name varchar(30),
	mail varchar(59) not null
);


SELECT * FROM users;
SELECT * FROM ordersBuy;