use classicmodels;
ALTER TABLE customers ADD INDEX i_customer_name(customerName);
EXPLAIN SELECT * FROM customers WHERE customerName = 'Land of Toys Inc.';
ALTER TABLE customers DROP INDEX i_customer_name;
ALTER TABLE customers add INDEX i_name(contactLastName,contactFirstName);
EXPLAIN SELECT * FROM customers WHERE contactFirstName = 'Jean' or contactFirstName = 'King';
ALTER TABLE customers DROP INDEX i_name;