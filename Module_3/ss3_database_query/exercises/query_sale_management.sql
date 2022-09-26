use sale_management;
create table customer (
    customer_id int primary key AUTO_INCREMENT,
    customer_name varchar(20) not null,
    customer_age int
);
create table `order` (
    order_id int primary key AUTO_INCREMENT,
    customer_id int not null,
    foreign key (customer_id) references customer(customer_id),
    order_date Date not null,
    order_total_price double
);
create table product (
    product_id int primary key AUTO_INCREMENT,
    product_name varchar(30) not null,
    product_price double not null
);
create table order_detaile (
    order_id int not null,
    product_id int not null,
    primary key(order_id, product_id),
    foreign key (order_id) references `order` (order_id),
    foreign key (product_id) references product (product_id),
    order_quantity double not null
);

INSERT INTO
    customer (customer_name, customer_age)
VALUES
    ('Minh Quan', 10),
    ('Ngoc Oanh', 20),
    ('Hong Ha', 50);
    
INSERT INTO
    `order` (customer_id, order_date, order_total_price)
VALUES
    (1, '2006/03/21', NULL),
    (2, '2006/03/23', NULL),
    (1, '2006/03/16', NULL);
    
INSERT INTO
    product (product_name, product_price)
VALUES
    ('May Giat', 3),
    ('Tu Lanh', 5),
    ('Dieu Hoa', 7),
    ('Quat', 1),
    ('Bep Dien', 2);
    
INSERT INTO
    order_detaile
VALUES
    (1, 1, 3),
    (1, 3, 7),
    (1, 4, 2),
    (2, 1, 1),
    (3, 1, 8),
    (2, 5, 4),
    (2, 2, 3);
    
SELECT
    order_id,
    order_date,
    order_total_price
FROM
    `order`;
SELECT
    C.customer_name,
    OD.product_id
FROM
    customer C
    JOIN `order` O on O.customer_id = C.customer_id
    JOIN order_detaile OD on OD.order_id = O.order_id;
    
SELECT
    C.customer_name
FROM
    customer C
WHERE
    C.customer_id not in (
        SELECT
            O.customer_id
        FROM
            `order` O
    );
    
SELECT
    OD.order_id,
    sum(OD.product_id * OD.order_quantity) as 'Total value'
FROM
    order_detaile OD
GROUP by
    OD.order_id;