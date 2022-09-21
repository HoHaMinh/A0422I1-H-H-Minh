create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;
create table class (
classId int not null primary key AUTO_INCREMENT,
className varchar (60) not null,
startDate datetime not null,
`status` bit);
create table student (
studentId int not null primary key AUTO_INCREMENT,
studentName varchar (30) not null,
address varchar (50),
phone varchar (20),
`status` bit,
classId int not null);
create table `subject` (
subID int not null primary key AUTO_INCREMENT,
subName varchar (30) not null,
`status` bit DEFAULT 1,
credit Tinyint not null DEFAULT 1 CHECK (credit>=1));
create table mark (
markId int not null primary key AUTO_INCREMENT,
subId int not null unique,
studentId int not null unique,
mark float DEFAULT 0 CHECK (0<mark<100),
examTimes Tinyint DEFAULT 1);