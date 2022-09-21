create database if not exists erd_to_relational_database;
use erd_to_relational_database;
create table suppliers (
supplier_id int primary key,
supplier_name varchar(45) not null,
supplier_address varchar(45),
supplier_phoneNo varchar(15)
);
create table order_confirmation (
order_no int primary key,
supplier_id int unique not null,
order_date date not null,
foreign key (supplier_id) references suppliers (supplier_id)
);
create table products (
product_id int primary key,
product_name varchar(45) not null
);
create table order_detailed (
order_no int not null,
product_id int not null,
primary key (order_no, product_id),
foreign key (order_no) references order_confirmation (order_no),
foreign key (product_id) references products (product_id)
);
create table warehouse_receipt (
receipt_id int primary key,
receipt_date date not null
);
create table warehouse_receipt_detailed (
product_id int not null,
receipt_id int not null,
primary key (product_id, receipt_id),
foreign key (product_id) references products (product_id),
foreign key (receipt_id) references warehouse_receipt (receipt_id),
quantity double not null CHECK (quantity>0),
unit_price double not null CHECK (unit_price>0)
);
create table delivery_receipt (
receipt_id int primary key,
receipt_date date not null
);
create table delivery_receipt_detailed (
product_id int not null,
receipt_id int not null,
primary key (product_id, receipt_id),
foreign key (product_id) references products (product_id),
foreign key (receipt_id) references delivery_receipt (receipt_id),
quantity double not null CHECK (quantity>0),
unit_price double not null CHECK (unit_price>0)
);