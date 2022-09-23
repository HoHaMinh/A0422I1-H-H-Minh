create database if not EXISTS student_management;
use student_management;
create table class (
    class_id int not null primary key AUTO_INCREMENT,
    class_name varchar (60) not null,
    start_date datetime not null,
    `status` bit
);
create table student (
    student_id int not null primary key AUTO_INCREMENT,
    student_name varchar (30) not null,
    address varchar (50),
    phone varchar (20),
    `status` bit,
    class_id int not null
);
create table `subject`(
    sub_id int not null primary key AUTO_INCREMENT,
    sub_name varchar (30) not null,
    `status` bit DEFAULT 1,
    credit Tinyint not null DEFAULT 1 CHECK (credit >= 1)
);
create table mark (
    mark_id int not null primary key AUTO_INCREMENT,
    sub_id int not null,
    student_id int not null,
    mark float DEFAULT 0 CHECK (0 < mark < 100),
    exam_times Tinyint DEFAULT 1,
    FOREIGN KEY (sub_id) REFERENCES subject (sub_id),
    FOREIGN KEY (student_id) REFERENCES student (student_id)
);
INSERT INTO
    `class`
VALUES
    (1, 'A1', '2008/12/20', 1);
INSERT INTO
    `class`
VALUES
    (2, 'A2', '2008/12/22', 1);
INSERT INTO
    `class`
VALUES
    (3, 'B3', CURRENT_DATE, 0);
INSERT INTO
    student (student_name, address, phone, status, class_id)
VALUES
    ('Hung', 'Ha noi', '0912113113', 1, 1),
    ('Hoa', 'Hai phong', NULL, 1, 1),
    ('Manh', 'HCM', '0123123123', 0, 2);
INSERT INTO
    subject (sub_name, credit, status)
VALUES
    ('CF', 5, 1),
    ('C', 6, 1),
    ('HDJ', 5, 1),
    ('RDBMS', 10, 1);
INSERT INTO
    mark (sub_id, student_id, mark, exam_times)
VALUES
    (1, 1, 8, 1),
    (1, 2, 10, 2),
    (2, 1, 12, 1);
SELECT
    *
FROM
    student;
SELECT
    *
FROM
    student
WHERE
    status = TRUE;
SELECT
    sub_name
FROM
    subject
WHERE
    credit < 10;
SELECT
    *
FROM
    student S
    JOIN `class` C ON S.class_id = C.class_id
WHERE
    C.class_id = 1;
SELECT
    S.student_name,
    S.student_id,
    M.mark,
    Sub.sub_name
FROM
    mark M
    JOIN student S ON M.student_id = S.student_id
    JOIN subject Sub on Sub.sub_id = M.sub_id
WHERE
    Sub.sub_name = 'CF';