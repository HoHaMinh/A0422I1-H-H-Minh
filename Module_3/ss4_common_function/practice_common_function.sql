USE student_management;
SELECT address, COUNT(student_id) as 'Numbers of students' FROM student GROUP by address;
SELECT S.student_name, ifnull(AVG(M.mark),'no point') as 'Average mark' FROM student S
LEFT JOIN mark M ON M.student_id = S.student_id
GROUP BY S.student_name HAVING 'Average mark' >15;
SELECT S.student_name, AVG(M.mark) as 'Max average mark' FROM student S
JOIN mark M ON M.student_id = S.student_id
GROUP BY S.student_id
HAVING AVG(M.mark)>= all(SELECT AVG(M.mark) FROM mark M GROUP BY M.student_id);