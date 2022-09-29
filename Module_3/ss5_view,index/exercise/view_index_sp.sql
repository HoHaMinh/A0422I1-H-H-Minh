CREATE DATABASE demo;
use demo;
CREATE TABLE products(
    id INT PRIMARY KEY,
    product_code int,
    product_name VARCHAR(30),
    product_price DOUBLE,
    product_amount DOUBLE,
    product_description VARCHAR(50),
    product_status BIT
);

INSERT INTO
    products
VALUES
    (1, 1, 'a', 1, 1, 'a', 1),
    (2, 2, 'b', 2, 2, 'b', 0),
    (3, 3, 'c', 3, 3, 'c', 1);
    
ALTER TABLE
    products
ADD
    INDEX i_product_code(product_code);
    
ALTER TABLE
    products
ADD
    INDEX i_product_name_price(product_name, product_price);
    
EXPLAIN
SELECT
    *
FROM
    products
WHERE
    product_code = 1;
    
CREATE VIEW products_view as
SELECT
    product_code,
    product_name,
    product_price,
    product_status
FROM
    products;
    
SELECT
    *
FROM
    products_view;
    
CREATE
    or REPLACE view products_view as
SELECT
    product_code,
    product_name
FROM
    products;
    
DROP VIEW products_view;

DELIMITER / / CREATE PROCEDURE display_products () BEGIN
SELECT
    *
FROM
    products;
end / / DELIMITER;

CALL display_products;

DELIMITER / / CREATE PROCEDURE add_new_product (
    in id INT,
    in product_code int,
    in product_name VARCHAR(30),
    in product_price DOUBLE,
    in product_amount DOUBLE,
    in product_description VARCHAR(50),
    in product_status BIT
) BEGIN
INSERT INTO
    products
VALUES
    (
        id,
        product_code,
        product_name,
        product_price,
        product_amount,
        product_description,
        product_status
    );
end / / DELIMITER;

CALL add_new_product (4, 4, 'd', 4, 4, 'd', 0);

DELIMITER / / CREATE PROCEDURE edit_product_by_id (
    in input_id INT,
    in product_code int,
    in product_name VARCHAR(30),
    in product_price DOUBLE,
    in product_amount DOUBLE,
    in product_description VARCHAR(50),
    in product_status BIT
) BEGIN
UPDATE
    products
set
    product_code = product_code,
    product_name = product_name,
    product_price = product_price,
    product_amount = product_amount,
    product_description = product_description,
    product_status = product_status
WHERE
    id = input_id;
end / / DELIMITER;

CALL edit_product_by_id (4, 5, 'e', 5, 5, 'e', 1);

DELIMITER / / CREATE PROCEDURE delete_product_by_id (in input_id INT) BEGIN
DELETE from
    products
WHERE
    id = input_id;
end / / DELIMITER;

CALL delete_product_by_id(4);