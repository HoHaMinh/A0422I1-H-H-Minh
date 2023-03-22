CREATE database case_study;
use case_study;

CREATE TABLE position (
position_id INT PRIMARY KEY auto_increment,
position_name VARCHAR(45)
);

CREATE TABLE education_degree (
education_degree_id INT PRIMARY KEY auto_increment,
education_degree_name VARCHAR(45)
);

CREATE TABLE division (
division_id INT PRIMARY KEY auto_increment,
division_name VARCHAR(45)
);

CREATE TABLE role (
role_id INT PRIMARY KEY auto_increment,
role_name VARCHAR(255)
);

CREATE TABLE `user` (
username VARCHAR(255) PRIMARY KEY,
password VARCHAR(255)
);

CREATE TABLE user_role (
role_id INT,
foreign key (role_id) references role (role_id),
username VARCHAR(255),
FOREIGN KEY (username) REFERENCES user (username)
);

CREATE TABLE service_type (
service_type_id INT PRIMARY KEY auto_increment,
service_type_name VARCHAR(45)
);

CREATE TABLE rent_type (
rent_type_id INT PRIMARY KEY,
rent_type_name VARCHAR(45),
rent_type_cost DOUBLE
);

create table service (
service_id int PRIMARY KEY auto_increment,
service_name VARCHAR(45) not null,
service_area INT,
service_cost double NOT NULL,
service_max_people int,
rent_type_id int,
foreign key (rent_type_id) references rent_type (rent_type_id),
service_type_id int,
foreign key (service_type_id) references service_type (service_type_id),
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area DOUBLE,
number_of_floors int
);

create table attach_service (
attach_service_id int PRIMARY KEY auto_increment,
attach_service_name VARCHAR(45) not null,
attach_service_cost double,
attach_service_unit VARCHAR(45),
attach_service_status varchar(45)
);

create table employee (
employee_id int PRIMARY KEY auto_increment,
employee_name VARCHAR(45) not null,
employee_birthday date not null,
employee_id_card varchar(45) not null,
employee_salary double not null,
employee_phone varchar(45) not null,
employee_email varchar(45),
employee_address varchar(45),
position_id int,
foreign key (position_id) references position (position_id),
education_degree_id int,
foreign key (education_degree_id) references education_degree (education_degree_id),
division_id int,
foreign key (division_id) references division (division_id),
username VARCHAR(255),
foreign key (username) references user (username)
);

create table customer_type (
customer_type_id int PRIMARY KEY auto_increment,
customer_type_name VARCHAR(45)
);

create table customer (
customer_id int PRIMARY KEY auto_increment,
customer_type_id int,
foreign key (customer_type_id) references customer_type (customer_type_id),
customer_name VARCHAR(45) not null,
customer_birthday date not null,
customer_gender bit not null,
customer_id_card varchar(45) not null,
customer_phone varchar(45) not null,
customer_email varchar(45),
customer_address varchar(45)
);

create table contract (
contract_id int PRIMARY KEY auto_increment,
contract_start_day datetime,
contract_end_day datetime,
contract_deposit double,
contract_total_money DOUBLE,
employee_id int,
foreign key (employee_id) references employee (employee_id),
customer_id int,
foreign key (customer_id) references customer (customer_id),
service_id int,
foreign key (service_id) references service (service_id)
);

create table contract_detail (
contract_detail_id int PRIMARY KEY auto_increment,
contract_id int,
foreign key (contract_id) references contract (contract_id),
attach_service_id int,
foreign key (attach_service_id) references attach_service (attach_service_id),
quantity int
);

-- division
insert into division (division_id, division_name) values (1, 'Marketing');
insert into division (division_id, division_name) values (2, 'Legal');
insert into division (division_id, division_name) values (3, 'Human Resources');
insert into division (division_id, division_name) values (4, 'Legal');
insert into division (division_id, division_name) values (5, 'Sales');
insert into division (division_id, division_name) values (6, 'Training');

-- education_degree
insert into education_degree (education_degree_id, education_degree_name) values (1, 'Intermediate');
insert into education_degree (education_degree_id, education_degree_name) values (2, 'College');
insert into education_degree (education_degree_id, education_degree_name) values (3, 'Bacherlor');
insert into education_degree (education_degree_id, education_degree_name) values (4, 'Master');


-- position
insert into position (position_id, position_name) values (1, 'Reception');
insert into position (position_id, position_name) values (2, 'Attendant');
insert into position (position_id, position_name) values (3, 'Specialist');
insert into position (position_id, position_name) values (4, 'Supervisor');
insert into position (position_id, position_name) values (5, 'Manager');
insert into position (position_id, position_name) values (6, 'Director');

-- customer type
INSERT INTO customer_type (customer_type_name) value('Diamond'),('Planium'),('Gold'),('Silver'),('Member');

-- rent type
insert into rent_type (rent_type_id, rent_type_name) values (1, 'Day');
insert into rent_type (rent_type_id, rent_type_name) values (2, 'Month');
insert into rent_type (rent_type_id, rent_type_name) values (3, 'Year');
insert into rent_type (rent_type_id, rent_type_name) values (4, 'Hour');

-- attach service
INSERT INTO attach_service(attach_service_name, attach_service_cost, attach_service_unit, attach_service_status) value ('laundry', 3, 'kg', 'new');
INSERT INTO attach_service(attach_service_name, attach_service_cost, attach_service_unit, attach_service_status) value ('ciname', 2, 'ticket', 'on');
INSERT INTO attach_service(attach_service_name, attach_service_cost, attach_service_unit, attach_service_status) value ('taxi', 1, 'km', 'off');
INSERT INTO attach_service(attach_service_name, attach_service_cost, attach_service_unit, attach_service_status) value ('gym', 2, 'hour', 'on');
INSERT INTO attach_service(attach_service_name, attach_service_cost, attach_service_unit, attach_service_status) value ('massage', 8, 'ticket', 'on');
INSERT INTO attach_service(attach_service_name, attach_service_cost, attach_service_unit, attach_service_status) value ('karaoke', 12, 'hour', 'on');

-- customer
insert into customer (customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer_type_id) values ('Winston Van der Son', '1973-01-25', 1, '51625-002', '150-638-9355', 'wvang@merriam-webster.com', 'Quang Nam', 1);
insert into customer (customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer_type_id) values ('Chevy Stanaway', '1981-07-14', 0, '51625-002', '172-626-0746', 'cstanawayh@multiply.com', '9 Meadow Ridge Parkway', 1);
insert into customer (customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer_type_id) values ('Nolan Pflieger', '1994-10-23', 1, '51625-002','316-568-2767', 'npfliegeri@artisteer.com', '8 Straubel Alley', 5);
insert into customer (customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer_type_id) values ('Blanche Bonnyson', '1997-10-05', 1, '51625-002','312-274-1325', 'bbonnysonj@harvard.edu', '9 Longview Crossing', 3);
insert into customer (customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer_type_id) values ('Scott Penburton', '1997-07-30', 0, '51625-002','646-810-1655', 'spenburtonk@imageshack.us', '02056 Spaight Way', 1);
insert into customer (customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer_type_id) values ('Vinson Hunting', '2005-08-08', 1, '51625-002','457-893-9840', 'vhuntingl@123-reg.co.uk', '27 Twin Pines Way', 2);
insert into customer (customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer_type_id) values ('Gabriellia Lepick', '1980-03-18', 0, '51625-002','493-593-5681', 'glepickm@microsoft.com', '28429 Independence Parkway',2);
insert into customer (customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer_type_id) values ('Vaughn Olivey', '1959-01-25', 1, '971-529-2866', '493-593-5681','voliveyn@walmart.com', '72 Doe Crossing Crossing', 3);
insert into customer (customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer_type_id) values ('Elaine Oxton', '1960-03-25', 1, '143-972-2973', '493-593-5681','eoxtono@nymag.com', '3 Hagan Hill', 5);
insert into customer (customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer_type_id) values ('Stephanus Gibbieson', '1962-03-25', 1, '51625-002', '456-807-4184', 'sgibbiesonp@mlb.com', '02676 Drewry Lane', 5);
insert into customer (customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer_type_id) values ('Hendrika Peare', '1989-04-14', 1, '51625-002','408-404-2547', 'hpeareq@dagondesign.com', 'vinh', 4);
insert into customer (customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer_type_id) values ('Torin Sellors', '2000-08-18', 0, '51625-002','504-394-9756', 'tsellorsr@symantec.com', 'Quang Nam', 3);
insert into customer (customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer_type_id) values ('Gisella Legan', '1965-07-20', 0, '51625-002','103-386-8874', 'glegans@feedburner.com', 'Quang Ngai', 1);

-- user
INSERT INTO `user` (username,`password`) VALUES ('spashan0@bandcamp.com',123);
INSERT INTO `user` (username,`password`) VALUES ('pkennerley1@sourceforge.net',123);
INSERT INTO `user` (username,`password`) VALUES ('mbigland2@harvard.edu',123);
INSERT INTO `user` (username,`password`) VALUES ('qrewcastle3@unc.edu',123);
INSERT INTO `user` (username,`password`) VALUES ('jskilbeck4@ox.ac.uk',123);
INSERT INTO `user` (username,`password`) VALUES ('egrayshan5@reuters.com',123);
INSERT INTO `user` (username,`password`) VALUES ('mmattiuzzi6@acquirethisname.com',123);
INSERT INTO `user` (username,`password`) VALUES ('vjaze7@ftc.gov',123);
INSERT INTO `user` (username,`password`) VALUES ('apitherick8@ed.gov',123);
INSERT INTO `user` (username,`password`) VALUES ('rfreshwater9@biglobe.ne.jp',123);
INSERT INTO `user` (username,`password`) VALUES ('tcotona@scribd.com',123);
INSERT INTO `user` (username,`password`) VALUES ('weckersallb@4shared.com',123);
INSERT INTO `user` (username,`password`) VALUES ('gtidmanc@goo.gl',123);
INSERT INTO `user` (username,`password`) VALUES ('ctreadwayd@webs.com',123);
INSERT INTO `user` (username,`password`) VALUES ('alinfitte@tumblr.com',123);
INSERT INTO `user` (username,`password`) VALUES ('lhalwardf@miibeian.gov.cn',123);

-- employee
insert into
    employee (
        employee_id,
        employee_name,
        employee_birthday,
        employee_id_card,
        employee_salary,
        employee_phone,
        employee_email,
        employee_address,
        position_id,
        education_degree_id,
        division_id,
        username
    )
values
    (
        1,
        'Sandy Pashan',
        '1961-01-15',
        '37000-727',
        1163.08,
        '663-959-9605',
        'spashan0@bandcamp.com',
        '5 Roth Road',
        6,
        4,
        4,
        'spashan0@bandcamp.com'
    );
insert into
    employee (
        employee_id,
        employee_name,
        employee_birthday,
        employee_id_card,
        employee_salary,
        employee_phone,
        employee_email,
        employee_address,
        position_id,
        education_degree_id,
        division_id,
        username
    )
values
    (
        2,
        'Philipa Kennerley',
        '1954-11-14',
        '48951-1178',
        1313.71,
        '587-113-9816',
        'pkennerley1@sourceforge.net',
        '5 Union Pass',
        5,
        1,
        3,
        'pkennerley1@sourceforge.net'
    );
insert into
    employee (
        employee_id,
        employee_name,
        employee_birthday,
        employee_id_card,
        employee_salary,
        employee_phone,
        employee_email,
        employee_address,
        position_id,
        education_degree_id,
        division_id,
        username
    )
values
    (
        3,
        'Mahalia Bigland',
        '1961-04-03',
        '0406-9959',
        2347.75,
        '369-457-9519',
        'mbigland2@harvard.edu',
        '922 Gateway Alley',
        6,
        4,
        4,
        'mbigland2@harvard.edu'
    );
insert into
    employee (
        employee_id,
        employee_name,
        employee_birthday,
        employee_id_card,
        employee_salary,
        employee_phone,
        employee_email,
        employee_address,
        position_id,
        education_degree_id,
        division_id,
        username
    )
values
    (
        4,
        'Quillan Rewcastle',
        '1988-08-18',
        '53157-300',
        3124.24,
        '941-396-9009',
        'qrewcastle3@unc.edu',
        '734 John Wall Terrace',
        5,
        3,
        3,
        'qrewcastle3@unc.edu'
    );
insert into
    employee (
        employee_id,
        employee_name,
        employee_birthday,
        employee_id_card,
        employee_salary,
        employee_phone,
        employee_email,
        employee_address,
        position_id,
        education_degree_id,
        division_id,
        username
    )
values
    (
        5,
        'Joella Skilbeck',
        '1968-09-15',
        '61314-225',
        1061.98,
        '847-249-3629',
        'jskilbeck4@ox.ac.uk',
        '577 Everett Park',
        2,
        2,
        1,
        'jskilbeck4@ox.ac.uk'
    );
insert into
    employee (
        employee_id,
        employee_name,
        employee_birthday,
        employee_id_card,
        employee_salary,
        employee_phone,
        employee_email,
        employee_address,
        position_id,
        education_degree_id,
        division_id,
        username
    )
values
    (
        6,
        'Evangelin Grayshan',
        '1984-05-31',
        '51334-882',
        2107.3,
        '253-637-2071',
        'egrayshan5@reuters.com',
        '2 Union Place',
        4,
        1,
        3,
        'egrayshan5@reuters.com'
    );
insert into
    employee (
        employee_id,
        employee_name,
        employee_birthday,
        employee_id_card,
        employee_salary,
        employee_phone,
        employee_email,
        employee_address,
        position_id,
        education_degree_id,
        division_id,
        username
    )
values
    (
        7,
        'Mavis Mattiuzzi',
        '1995-06-03',
        '54868-0520',
        2948.05,
        '851-771-0858',
        'mmattiuzzi6@acquirethisname.com',
        '77 Kensington Trail',
        5,
        2,
        2,
        'mmattiuzzi6@acquirethisname.com'
    );
insert into
    employee (
        employee_id,
        employee_name,
        employee_birthday,
        employee_id_card,
        employee_salary,
        employee_phone,
        employee_email,
        employee_address,
        position_id,
        education_degree_id,
        division_id,
        username
    )
values
    (
        8,
        'Virgilio Jaze',
        '1979-12-15',
        '64764-253',
        3895.07,
        '597-347-4065',
        'vjaze7@ftc.gov',
        '22 4th Point',
        6,
        3,
        2,
        'vjaze7@ftc.gov'
    );
insert into
    employee (
        employee_id,
        employee_name,
        employee_birthday,
        employee_id_card,
        employee_salary,
        employee_phone,
        employee_email,
        employee_address,
        position_id,
        education_degree_id,
        division_id,
        username
    )
values
    (
        9,
        'Annabela Pitherick',
        '1950-12-01',
        '36987-1190',
        2880.58,
        '528-905-6627',
        'apitherick8@ed.gov',
        '0 Lighthouse Bay Junction',
        3,
        2,
        2,
        'apitherick8@ed.gov'
    );
insert into
    employee (
        employee_id,
        employee_name,
        employee_birthday,
        employee_id_card,
        employee_salary,
        employee_phone,
        employee_email,
        employee_address,
        position_id,
        education_degree_id,
        division_id,
        username
    )
values
    (
        10,
        'Rickert Freshwater',
        '1992-06-16',
        '36987-2899',
        2300.7,
        '271-319-5402',
        'rfreshwater9@biglobe.ne.jp',
        '73 Clemons Avenue',
        3,
        2,
        2,
        'rfreshwater9@biglobe.ne.jp'
    );
insert into
    employee (
        employee_id,
        employee_name,
        employee_birthday,
        employee_id_card,
        employee_salary,
        employee_phone,
        employee_email,
        employee_address,
        position_id,
        education_degree_id,
        division_id,
        username
    )
values
    (
        11,
        'Trisha Coton',
        '1968-11-15',
        '16853-1305',
        2971.4,
        '914-126-8308',
        'tcotona@scribd.com',
        '04 Del Mar Circle',
        4,
        3,
        3,
        'tcotona@scribd.com'
    );
insert into
    employee (
        employee_id,
        employee_name,
        employee_birthday,
        employee_id_card,
        employee_salary,
        employee_phone,
        employee_email,
        employee_address,
        position_id,
        education_degree_id,
        division_id,
        username
    )
values
    (
        12,
        'Wat Eckersall',
        '1980-06-02',
        '0268-0153',
        1313.17,
        '713-338-8129',
        'weckersallb@4shared.com',
        '302 Manitowish Avenue',
        6,
        1,
        2,
        'weckersallb@4shared.com'
    );
insert into
    employee (
        employee_id,
        employee_name,
        employee_birthday,
        employee_id_card,
        employee_salary,
        employee_phone,
        employee_email,
        employee_address,
        position_id,
        education_degree_id,
        division_id,
        username
    )
values
    (
        13,
        'Gabi Tidman',
        '1994-05-13',
        '0615-2525',
        3253.19,
        '324-999-3543',
        'gtidmanc@goo.gl',
        '85165 Eagan Hill',
        4,
        1,
        3,
        'gtidmanc@goo.gl'
    );
insert into
    employee (
        employee_id,
        employee_name,
        employee_birthday,
        employee_id_card,
        employee_salary,
        employee_phone,
        employee_email,
        employee_address,
        position_id,
        education_degree_id,
        division_id,
        username
    )
values
    (
        14,
        'Constantin Treadway',
        '1952-01-22',
        '43857-0101',
        2344.88,
        '586-507-1116',
        'ctreadwayd@webs.com',
        '5448 Graedel Hill',
        3,
        4,
        1,
        'ctreadwayd@webs.com'
    );
insert into
    employee (
        employee_id,
        employee_name,
        employee_birthday,
        employee_id_card,
        employee_salary,
        employee_phone,
        employee_email,
        employee_address,
        position_id,
        education_degree_id,
        division_id,
        username
    )
values
    (
        15,
        'Amalie Linfitt',
        '1964-12-26',
        '10237-629',
        2191.54,
        '640-545-4045',
        'alinfitte@tumblr.com',
        '6400 Mifflin Parkway',
        5,
        1,
        3,
        'alinfitte@tumblr.com'
    );
insert into
    employee (
        employee_id,
        employee_name,
        employee_birthday,
        employee_id_card,
        employee_salary,
        employee_phone,
        employee_email,
        employee_address,
        position_id,
        education_degree_id,
        division_id,
        username
    )
values
    (
        16,
        'Leola Halward',
        '1987-03-08',
        '49999-895',
        2572.72,
        '410-710-1004',
        'lhalwardf@miibeian.gov.cn',
        '681 Dexter Parkway',
        6,
        4,
        1,
        'lhalwardf@miibeian.gov.cn'
    );

-- service type
INSERT INTO service_type(service_type_name) VALUES ('Villa'),('House'),('Room');

-- service
INSERT INTO service (service_name, service_area, service_cost, service_max_people, standard_room, description_other_convenience, pool_area, number_of_floors, service_type_id, rent_type_id) VALUES 
('Villa Sweet', 23, 120, 10, 'other', 'no comment', 12, 5, 1,1),
('Villa Couple', 2, 120, 10, 'other', 'no comment', 12, 5, 1,2),
('Villa Family', 6, 120, 10, 'other', 'no comment', 12, 5, 1,3),
('Villa Standard', 8, 120, 10, 'other', 'no comment', 12, 5, 1,4),
('House Sweet', 23, 120, 10, 'other', 'no comment', 12, 5, 2,1),
('House Couple', 23, 120, 10, 'other', 'no comment', 12, 5, 2,2),
('House Family', 23, 120, 10, 'other', 'no comment', 12, 5, 2,3),
('House Standard', 23, 120, 10, 'other', 'no comment', 12, 5, 2,4),
('Room Sweet', 23, 120, 10, 'other', 'no comment', NULL, 5, 3,1),
('Room Couple', 23, 120, 10, 'other', 'no comment', NULL, 5, 3,2),
('Room Family', 23, 120, 10, 'other', 'no comment', NULL, 5, 3,3),
('Room Standard', 23, 120, 10, 'other', 'no comment', NULL, 5, 3,4);

-- contract
insert into contract (contract_start_day, contract_end_day, contract_deposit, contract_total_money, employee_id, customer_id, service_id) values 
('2021-07-30', '2021-04-20', 599, 3000, 5, 5, 6),
('2021-01-15', '2021-01-28', 29, 400, 1, 8, 6),
('2020-12-11', '2020-12-14', 974, 3000, 1, 3, 3),
('2021-04-10', '2021-04-16', 590, 3600, 7, 5, 4),
('2021-12-28', '2022-01-17', 254, 5000, 13, 10, 7),
('2021-04-14', '2021-05-03', 901, 18000, 4, 2, 6),
('2020-01-17', '2021-03-17', 96, 9000, 6, 1, 12),
('2021-10-28', '2021-11-05', 667, 4900, 3, 8, 5),
('2020-06-09', '2020-06-14', 740, 3500, 5, 12, 5),
('2021-01-24', '2021-02-23', 834, 26000, 12, 1, 6),
('2020-02-01', '2021-02-17', 688, 10000, 4, 11, 9),
('2021-03-16', '2021-03-29', 921, 14000, 3, 10, 7),
('2020-12-22', '2021-01-09', 67, 14000, 14, 4, 6),
('2021-10-25', '2021-11-25', 604, 18000, 13, 10, 12),
('2021-01-28', '2021-01-30', 893, 1800, 11, 8, 9),
('2020-12-04', '2021-12-09', 979, 5000, 8, 10, 12),
('2021-07-25', '2021-07-28', 367, 1000, 3, 6, 12),
('2020-11-09', '2021-09-15', 577, 3600, 4, 1, 8),
('2021-06-04', '2021-06-09', 660, 3300, 6, 12, 8),
('2021-02-01', '2021-07-01', 413, 20000, 5, 9, 3),
('2021-03-16', '2021-03-24', 474, 5000, 8, 13, 11),
('2021-06-07', '2021-06-21', 856, 13000, 11, 5, 8),
('2021-03-30', '2021-04-08', 954, 8100, 14, 2, 10),
('2021-01-28', '2021-01-30', 333, 666, 14, 10, 12),
('2020-10-17', '2021-10-17', 885, 11000, 4, 1, 5),
('2021-08-31', '2021-09-04', 190, 800, 6, 9, 9),
('2020-11-10', '2021-04-10', 991, 5000, 7, 7, 8),
('2019-12-31', '2021-01-01', 960, 12000, 9, 5, 5),
('2020-11-30', '2021-06-01', 700, 4200, 4, 11, 4);

-- contract detail
insert into contract_detail (quantity, contract_id, attach_service_id) values (87, 8, 5);
insert into contract_detail (quantity, contract_id, attach_service_id) values (90, 8, 5);
insert into contract_detail (quantity, contract_id, attach_service_id) values (4, 27, 3);
insert into contract_detail (quantity, contract_id, attach_service_id) values (91, 13, 3);
insert into contract_detail (quantity, contract_id, attach_service_id) values (41, 2, 1);
insert into contract_detail (quantity, contract_id, attach_service_id) values (18, 10, 3);
insert into contract_detail (quantity, contract_id, attach_service_id) values (12, 2, 3);
insert into contract_detail (quantity, contract_id, attach_service_id) values (69, 3, 1);
insert into contract_detail (quantity, contract_id, attach_service_id) values (97, 4, 1);
insert into contract_detail (quantity, contract_id, attach_service_id) values (52, 2, 5);
insert into contract_detail (quantity, contract_id, attach_service_id) values (28, 26, 5);
insert into contract_detail (quantity, contract_id, attach_service_id) values (68, 14, 2);
insert into contract_detail (quantity, contract_id, attach_service_id) values (46, 23, 3);
insert into contract_detail (quantity, contract_id, attach_service_id) values (36, 4, 1);
insert into contract_detail (quantity, contract_id, attach_service_id) values (10, 27, 4);
insert into contract_detail (quantity, contract_id, attach_service_id) values (96, 18, 2);
insert into contract_detail (quantity, contract_id, attach_service_id) values (43, 27, 1);
insert into contract_detail (quantity, contract_id, attach_service_id) values (95, 8, 4);
insert into contract_detail (quantity, contract_id, attach_service_id) values (39, 5, 1);
insert into contract_detail (quantity, contract_id, attach_service_id) values (87, 17, 3);
insert into contract_detail (quantity, contract_id, attach_service_id) values (51, 11, 1);
insert into contract_detail (quantity, contract_id, attach_service_id) values (78, 8, 3);
insert into contract_detail (quantity, contract_id, attach_service_id) values (92, 2, 4);
insert into contract_detail (quantity, contract_id, attach_service_id) values (92, 7, 1);
insert into contract_detail (quantity, contract_id, attach_service_id) values (38, 11, 5);
insert into contract_detail (quantity, contract_id, attach_service_id) values (73, 20, 3);
insert into contract_detail (quantity, contract_id, attach_service_id) values (99, 20, 4);
insert into contract_detail (quantity, contract_id, attach_service_id) values (23, 21, 4);
insert into contract_detail (quantity, contract_id, attach_service_id) values (92, 3, 4);
insert into contract_detail (quantity, contract_id, attach_service_id) values (92, 4, 3);
insert into contract_detail (quantity, contract_id, attach_service_id) values (92, 4, 1);
insert into contract_detail (quantity, contract_id, attach_service_id) values (23, 8, 6);

CREATE PROCEDURE show_customers (in row_start int, in row_end int) 
BEGIN
SELECT
    *
FROM
    customer
LIMIT
    row_start, row_end;
END

CREATE VIEW temporary as 
SELECT C.customer_id, C.customer_name, CT.contract_id, A.attach_service_name  FROM customer C
JOIN contract CT ON C.customer_id = CT.customer_id
JOIN contract_detail CD ON CD.contract_id = CT.contract_id
JOIN attach_service A on CD.attach_service_id = A.attach_service_id;

CREATE PROCEDURE show_temporary (in row_start int, in number_of_row int) 
BEGIN
SELECT
    *
FROM
    temporary
LIMIT
    row_start, number_of_row;
END


CREATE PROCEDURE show_search (in search_name VARCHAR(50), in search_address VARCHAR(50) ,in row_start int, in number_of_row int) 
BEGIN 
SELECT
    *
FROM
    customer
    WHERE customer_name like concat("%", search_name, "%") 
    AND customer_address LIKE concat("%", search_address, "%") 
LIMIT
    row_start, number_of_row;
END

CALL show_search ('a','',0,5);