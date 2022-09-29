use classicmodels;
DELIMITER //
CREATE PROCEDURE get_customer_by_id 
(IN id INT)
BEGIN
SELECT * from customers WHERE customerNumber = id;
end //
DELIMITER;
CALL get_customer_by_id(175);

DELIMITER //
CREATE PROCEDURE get_number_customers_by_city
(IN city_name VARCHAR(45),
OUT total INT)
BEGIN
SELECT COUNT(customerNumber)
    INTO total
    FROM customers
    WHERE city = city_name;
end //
DELIMITER;
CALL get_number_customers_by_city ('london',@total);
SELECT @total;

DELIMITER //
CREATE PROCEDURE SetCounter(
    INOUT counter INT,
    IN inc INT
)
BEGIN
    SET counter = counter + inc;
END//
DELIMITER ;