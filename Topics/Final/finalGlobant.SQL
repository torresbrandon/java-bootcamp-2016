use shoppingcart;
DROP TABLE IF EXISTS credit
;
DROP TABLE IF EXISTS sale_item
;
DROP TABLE IF EXISTS sale
;
DROP TABLE IF EXISTS cart
;
DROP TABLE IF EXISTS item
;
DROP TABLE IF EXISTS category
;
DROP TABLE IF EXISTS client
;

CREATE TABLE credit
(
	cardType VARCHAR(20) NOT NULL,
	numberCard NUMERIC(10) NOT NULL,
	rateNumber SMALLINT NOT NULL,
	idClient INTEGER NOT NULL,
	fk_sale MEDIUMINT UNSIGNED NOT NULL,
	PRIMARY KEY (fk_sale)
	
) 
;


CREATE TABLE sale_item
(
	fk_Sale MEDIUMINT UNSIGNED NOT NULL,
	fk_Item MEDIUMINT UNSIGNED NOT NULL,
	units SMALLINT UNSIGNED NOT NULL,
	PRIMARY KEY (fk_Sale, fk_Item)
	
) 
;


CREATE TABLE sale
(
	idSale MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT,
	purchaseDate DATE NOT NULL,
	payment VARCHAR(30),
	total NUMERIC(10,2),
	fk_client INTEGER UNSIGNED NOT NULL,
	PRIMARY KEY (idSale)
	
) 
;


CREATE TABLE cart
(
	fk_emailClient VARCHAR(30) NOT NULL,
	fk_Item MEDIUMINT UNSIGNED NOT NULL,
	units SMALLINT UNSIGNED NOT NULL,
	PRIMARY KEY (fk_emailClient, fk_Item),
	
	
) 
;


CREATE TABLE item
(
	idItem MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT,
	nameItem VARCHAR(30) NOT NULL,
	price NUMERIC(10,2) NOT NULL,
	description VARCHAR(50),
	color VARCHAR(20) NOT NULL,
	unitsAvailable SMALLINT UNSIGNED,
	fk_category SMALLINT UNSIGNED NOT NULL,
	PRIMARY KEY (idItem)
	
) 
;


CREATE TABLE category
(
	idCategory SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
	nameCategory VARCHAR(20) NOT NULL,
	PRIMARY KEY (idCategory)
) 
;


CREATE TABLE client
(
	idClient INTEGER UNSIGNED NOT NULL,
	nameClient VARCHAR(30) NOT NULL,
	lastNameClient VARCHAR(50) NOT NULL,
	city VARCHAR(20) NOT NULL,
	neighborhood VARCHAR(30) NOT NULL,
	address VARCHAR(30),
	phone NUMERIC(10) UNSIGNED,
	email VARCHAR(30),
	password VARCHAR(10),
	PRIMARY KEY (idClient),
	UNIQUE UQ_client_email(email)
) 
;





ALTER TABLE credit ADD CONSTRAINT FK_credit_sale 
	FOREIGN KEY (fk_sale) REFERENCES sale (idSale)
;

ALTER TABLE sale_item ADD CONSTRAINT FK_sale_item_item 
	FOREIGN KEY (fk_Item) REFERENCES item (idItem)
;

ALTER TABLE sale ADD CONSTRAINT FK_sale_client 
	FOREIGN KEY (fk_client) REFERENCES client (idClient)
;

ALTER TABLE cart ADD CONSTRAINT FK_cart_client 
	FOREIGN KEY (fk_emailClient) REFERENCES client (email)
;

ALTER TABLE cart ADD CONSTRAINT FK_cart_item 
	FOREIGN KEY (fk_Item) REFERENCES item (idItem)
;

ALTER TABLE item ADD CONSTRAINT FK_item_category 
	FOREIGN KEY (fk_category) REFERENCES category (idCategory)
;



insert into client 
values(12345678, 'brandon','torres', 'bogota', 'costa rica', 'calle falsa 123', 12345678, 'brandon@gmail.com', 'brandon', '123123');


insert into category (nameCategory) values('Home');
insert into category (nameCategory) values('Tecnology');


insert into item (nameItem, price, description, color, unitsAvailable, fk_category)
 values('TV', 1200000,'smartv color', 'gray', 20, 1 );

insert into item (nameItem, price, description, color, unitsAvailable, fk_category)
 values('PC', 1600000,'core i7', 'gray', 20, 2 );

SELECT idItem, nameItem, price, description, color, nameCategory FROM item, category where idItem=1 and fk_category=idCategory;
