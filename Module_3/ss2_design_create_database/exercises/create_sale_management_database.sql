create database if not exists sale_management;
use sale_management;
create table customer (
customer_id int primary key,
customer_name varchar(20) not null,
customer_age int
);
create table `order` (
order_id int primary key,
customer_id int not null unique,
foreign key (customer_id) references customer(customer_id),
order_date Date not null,
order_total_price double not null
);
create table product (
product_id int primary key,
product_name varchar(30) not null,
product_price double not null
);
create table order_detaile (
order_id int not null,
product_id int not null,
primary key(order_id,product_id),
foreign key (order_id) references `order` (order_id),
foreign key (product_id) references product (product_id),
order_quantity double not null);