# Write your MySQL query statement below

SELECT s1.student_id ,s1.subject , s1.score AS first_score ,s2.score AS latest_score 
FROM Scores s1
LEFT JOIN Scores s2
ON s1.student_id = s2.student_id 
AND s1.subject  = s2.subject 
LEFT JOIN (
    SELECT s1.student_id , s1.subject , MIN(s1.exam_date) AS mindate , MAX(s2.exam_date) AS maxdate
    FROM Scores s1
    LEFT JOIN Scores s2
    ON s1.student_id = s2.student_id 
    AND s1.subject  = s2.subject 
    WHERE s1.exam_date < s2.exam_date 
    GROUP BY s1.student_id , s1.subject 
) t
ON s1.student_id = t.student_id 
AND s1.subject  = t.subject 
WHERE s1.exam_date < s2.exam_date
AND s1.exam_date = t.mindate
AND s2.exam_date = t.maxdate
AND s1.score < s2.score
ORDER BY s1.student_id , s1.subject 


