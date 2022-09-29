use classicmodels;
CREATE VIEW customers_view as
SELECT
    customerNumber,
    customerName,
    phone
FROM
    customers;
SELECT
    *
FROM
    customers_view;
CREATE
    or REPLACE VIEW customers_view as
SELECT
    customerNumber,
    customerName,
    contactFirstName,
    contactLastName,
    phone
FROM
    customers
WHERE
    city = 'Nantes';
SELECT
    *
FROM
    customers_view;
DROP VIEW customer_view;