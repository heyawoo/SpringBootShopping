-- # CREATE TABLES # --

CREATE TABLE shop_user(
	id INT PRIMARY KEY AUTO_INCREMENT,
	user_id VARCHAR(10) NOT NULL,
	passwd VARCHAR(10) NOT NULL,
	name VARCHAR(10) NOT NULL,
	address VARCHAR(150) NOT NULL,
	tel VARCHAR(14) NOT NULL,
	email VARCHAR(100) NOT NULL,
	authority INT(1) DEFAULT 1,
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
INSERT INTO shop_category VALUES(0, 'gliter');
INSERT INTO shop_category VALUES(0, 'colorful');
-- shop_product
INSERT INTO shop_product VALUES(0, 1, 'rose', 100, 1, 'rose_img1', 'rose_img2', CURDATE(), CURRENT_TIMESTAMP());
INSERT INTO shop_product VALUES(0, 2, 'leaf', 5, 10, 'leaf_img1', 'leaf_img2', CURDATE(), CURRENT_TIMESTAMP());
INSERT INTO shop_product VALUES(0, 10, 'earth', 100000000, 1, 'earth_img1', 'earth_img2', CURDATE(), CURRENT_TIMESTAMP());
INSERT INTO shop_product VALUES(0, 8, 'rolly pop', 120, 15, 'rollypop_img1', 'rollypop_img2', CURDATE(), CURRENT_TIMESTAMP());
INSERT INTO shop_product VALUES(0, 9, 'gold bar', 10000, 3, 'goldbar_img1', 'goldbar_img2', CURDATE(), CURRENT_TIMESTAMP());
INSERT INTO shop_product VALUES(0, 4, 'lemon', 30, 14, 'lemon_img1', 'lemon_img2', CURDATE(), CURRENT_TIMESTAMP());
INSERT INTO shop_product VALUES(0, 10, 'umbrella', 1000, 6, 'umbrella_img1', 'umbrella_img2', CURDATE(), CURRENT_TIMESTAMP());
INSERT INTO shop_product VALUES(0, 5, 'orange', 150, 4, 'orange_img1', 'orange_img2', CURDATE(), CURRENT_TIMESTAMP());
INSERT INTO shop_product VALUES(0, 3, 'cup of water', 100, 50, 'water_img1', 'water_img2', CURDATE(), CURRENT_TIMESTAMP());
INSERT INTO shop_product VALUES(0, 6, 'chocolate', 500, 3, 'chocolate_img1', 'chocolate_img2', CURDATE(), CURRENT_TIMESTAMP());

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
ORDER BY p.inp_date, p.id DESC;





