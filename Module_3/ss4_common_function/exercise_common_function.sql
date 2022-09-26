USE student_management;
SELECT * FROM subject 
WHERE credit = (SELECT max(credit) FROM subject);
SELECT Sub.sub_id, Sub.sub_name, Sub.status,Sub.credit, M.mark as 'Max mark' FROM subject Sub
LEFT JOIN mark M on Sub.sub_id = M.sub_id
WHERE M.mark = (SELECT max(mark) FROM mark);
SELECT S.student_id,S.student_name,S.address,S.phone,S.status,S.class_id,ifnull(avg(M.mark),'no point') as 'Average mark' FROM student S
LEFT JOIN mark M ON M.student_id = S.student_id
GROUP BY S.student_id;