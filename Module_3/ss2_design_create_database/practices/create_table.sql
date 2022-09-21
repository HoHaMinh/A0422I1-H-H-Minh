create database quan_ly_diem_thi;
use quan_ly_diem_thi;
create table hoc_sinh (
MaHS int not null unique primary key,
TenHS varchar(45) not null,
NgaySinh date,
Lop varchar(45) not null,
Gioitinh varchar(45) not null);
create table mon_hoc (
MaMH int not null unique primary key,
TenMH varchar(45) not null);
create table bang_diem(
MaHS int,
MaMH int,
Diemthi double not null,
Ngaykt datetime,
primary key (MaHS, MaMH),
foreign key (MaHS) references hoc_sinh (MaHS),
foreign key (MaMH) references mon_hoc (MaMH));
create table GiaoVien (
MaGV int not null unique primary key,
TenGV varchar(45) not null,
SDT int);
alter table mon_hoc add MaGV int;
alter table mon_hoc add constraint foreign key (MaGV) references GiaoVien (MaGV);