# Write your MySQL query statement below
-- Select s.student_id,s.student_name,e.subject_name,Count()
-- from Students s
-- Cross Join Subjects su
-- Left Join Examinations e 
-- On s.student_id = e.student_id
-- Group By e.subject_name
-- Order by s.student_id,e.subject_name;

-- s.student_id,s.student_name,su.subject_name,count()

-- Select *
-- from Students s
-- Cross Join Subjects su
-- left join Examinations e on 
-- Order By s.student_id,su.subject_name;

SELECT
    s.student_id,
    s.student_name,
    su.subject_name,
    COUNT(e.subject_name) AS attended_exams
FROM Students s
CROSS JOIN Subjects su
LEFT JOIN Examinations e
    ON s.student_id = e.student_id
   AND su.subject_name = e.subject_name
GROUP BY
    s.student_id,
    s.student_name,
    su.subject_name
ORDER BY
    s.student_id,
    su.subject_name;