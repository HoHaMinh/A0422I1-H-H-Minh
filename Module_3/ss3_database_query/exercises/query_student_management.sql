USER student_management;
SELECT * FROM student WHERE student_name LIKE 'h%';
SELECT * FROM `class` WHERE MONTH(start_date)=12;
SELECT * FROM subject WHERE credit in (3,4,5);
UPDATE student 
set class_id ='2'
WHERE student_name='Hung';
SELECT S.student_name,Sub.sub_name,M.mark FROM student S 
join mark M on S.student_id = M.student_id
JOIN subject Sub ON Sub.sub_id = M.sub_id
ORDER by M.mark DESC,S.student_name;