use classicmodels;
DELIMITER //
CREATE PROCEDURE find_all_customers()
BEGIN
SELECT * FROM customers;
end //
DELIMITER ;
CALL find_all_customers;

DROP PROCEDURE find_all_customers;

DELIMITER $$
CREATE PROCEDURE find_customer_175()
BEGIN
SELECT * FROM customers WHERE customerNumber = 175;
end $$
delimiter ;

DROP PROCEDURE find_customer_175;