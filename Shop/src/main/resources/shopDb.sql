-- # CREATE TABLES # --

CREATE TABLE shop_user(
	id INT PRIMARY KEY AUTO_INCREMENT,
	user_id VARCHAR(10) NOT NULL,
	passwd VARCHAR(10) NOT NULL,
	name VARCHAR(10) NOT NULL,
	address VARCHAR(150) NOT NULL,
	tel VARCHAR(14) NOT NULL,
	email VARCHAR(100) NOT NULL,
	authority INT(1) NOT NULL DEFAULT 1,
	inp_date DATE NOT NULL,
	upd_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP()
);

CREATE TABLE shop_category(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL
);

CREATE TABLE shop_product(
	id INT PRIMARY KEY AUTO_INCREMENT,
	category_id INT NOT NULL,
	name VARCHAR(100) NOT NULL,
	price INT NOT NULL,
	stock_quantity INT NOT NULL,
	image1 VARCHAR(255),
	image2 VARCHAR(255),
	detail TEXT,
	inp_date DATE NOT NULL,
	upd_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
	FOREIGN KEY(category_id) references shop_category(id)
);

CREATE TABLE shop_order(
	id INT PRIMARY KEY AUTO_INCREMENT,
	user_id INT NOT NULL,
	total_price INT NOT NULL,
	order_date DATE NOT NULL,
	inp_date DATE NOT NULL,
	upd_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
	FOREIGN KEY(user_id) references shop_user(id)
);

CREATE TABLE shop_order_detail(
	id INT PRIMARY KEY AUTO_INCREMENT,
	order_id INT NOT NULL,
	product_id INT NOT NULL,
	order_quantity INT NOT NULL,
	inp_date DATE NOT NULL,
	upd_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
	FOREIGN KEY(order_id) references shop_order(id),
	FOREIGN KEY(product_id) references shop_product(id)
);

-- # INSERT DATA # --
-- shop_user
INSERT INTO shop_user VALUES(0, 'admin', 'admin', 'admin', 'EARTH', '07043372692', 'heyawoo@gmail.com', 0, CURDATE(), CURRENT_TIMESTAMP());
INSERT INTO shop_user VALUES(0, 'test', 'test', 'test', 'UNIVERSE', '01040260253', 'test@gmail.com', 1, CURDATE(), CURRENT_TIMESTAMP());
-- shop_category
INSERT INTO shop_category VALUES(0, 'red');
INSERT INTO shop_category VALUES(0, 'green');
INSERT INTO shop_category VALUES(0, 'blue');
INSERT INTO shop_category VALUES(0, 'yellow');
INSERT INTO shop_category VALUES(0, 'orange');
INSERT INTO shop_category VALUES(0, 'black');
INSERT INTO shop_category VALUES(0, 'white');
INSERT INTO shop_category VALUES(0, 'pink');
INSERT INTO shop_category VALUES(0, 'glitter');
INSERT INTO shop_category VALUES(0, 'colorful');
-- shop_product
INSERT INTO shop_product VALUES(0, 1, 'apple', 100, 10, 'apple1', 'apple2', 'explain', CURDATE(), CURRENT_TIMESTAMP());
INSERT INTO shop_product VALUES(0, 2, 'leaves', 5, 10, 'leaves1', 'leaves2', 'explain', CURDATE(), CURRENT_TIMESTAMP());
INSERT INTO shop_product VALUES(0, 10, 'pizza', 1500, 15, 'pizza1', 'pizza2', 'explain', CURDATE(), CURRENT_TIMESTAMP());
INSERT INTO shop_product VALUES(0, 8, 'ballons', 120, 3, 'ballons1', 'ballons2', 'explain', CURDATE(), CURRENT_TIMESTAMP());
INSERT INTO shop_product VALUES(0, 9, 'money', 10000, 3, 'money1', 'money2', 'explain', CURDATE(), CURRENT_TIMESTAMP());
INSERT INTO shop_product VALUES(0, 4, 'wine', 1900, 4, 'wine1', 'wine2', 'explain', CURDATE(), CURRENT_TIMESTAMP());
INSERT INTO shop_product VALUES(0, 10, 'vegetables', 1000, 6, 'vegetables1', 'vegetables2', 'explain', CURDATE(), CURRENT_TIMESTAMP());
INSERT INTO shop_product VALUES(0, 5, 'orange', 150, 9, 'orange1', 'orange2', 'explain', CURDATE(), CURRENT_TIMESTAMP());
INSERT INTO shop_product VALUES(0, 3, 'aqua', 100, 50, 'aqua1', 'aqua2', 'explain', CURDATE(), CURRENT_TIMESTAMP());
INSERT INTO shop_product VALUES(0, 6, 'cola', 500, 8, 'cola1', 'cola2', 'explain', CURDATE(), CURRENT_TIMESTAMP());
INSERT INTO shop_product VALUES(0, 7, 'mac', 100000, 2, 'mac1', 'mac2', 'explain', CURDATE(), CURRENT_TIMESTAMP());

-- shop_order
INSERT INTO shop_order VALUES(0, 1, 10240, CURDATE(), CURDATE(), CURRENT_TIMESTAMP());
-- shop_order_detail
INSERT INTO shop_order_detail VALUES(0, 1, 4, 2, CURDATE(), CURRENT_TIMESTAMP());
INSERT INTO shop_order_detail VALUES(0, 1, 5, 1, CURDATE(), CURRENT_TIMESTAMP());


-- # DROP TABLES # --
DROP TABLE shop_order_detail;
DROP TABLE shop_order;
DROP TABLE shop_product;
DROP TABLE shop_category;
DROP TABLE shop_user;


-- # DELETE DATA # --
DELETE FROM shop_order_detail;
DELETE FROM shop_order;
DELETE FROM shop_product;
DELETE FROM shop_category;
DELETE FROM shop_user;

ALTER TABLE shop_order_detail AUTO_INCREMENT = 1;
ALTER TABLE shop_order AUTO_INCREMENT = 1;
ALTER TABLE shop_product AUTO_INCREMENT = 1;
ALTER TABLE shop_category AUTO_INCREMENT = 1;
ALTER TABLE shop_user AUTO_INCREMENT = 1;




-- main select
SELECT p.*, IFNULL(p.stock_quantity - d.order_quantity, p.stock_quantity) AS extra
FROM shop_product p 
LEFT JOIN shop_order_detail d
ON p.id = d.product_id
ORDER BY p.inp_date, p.id DESC
LIMIT 6;

SELECT p.id, c.name as category, p.name, p.price, IFNULL(p.stock_quantity - d.order_quantity, p.stock_quantity) AS stock_quantity, p.image1, p.image2
FROM shop_product p
LEFT JOIN shop_order_detail d
ON p.id = d.product_id
JOIN shop_category c
On p.category_id = c.id
ORDER BY p.inp_date, p.id DESC
LIMIT 6;

-- list
SELECT p.id as id, p.category_id, c.name as category, p.name as name, p.price as price, IFNULL(p.stock_quantity - d.order_quantity, p.stock_quantity) AS stock_quantity, p.image1 as image1, p.image2 as image2, p.detail as detail
FROM shop_product p
LEFT JOIN shop_order_detail d
ON p.id = d.product_id
JOIN shop_category c
On p.category_id = c.id
WHERE 
p.name LIKE '%a%'
AND p.category_id = 1

-- paging
SELECT COUNT(*) totalcount 
FROM shop_product;


