# Write your MySQL query statement below
SELECT *
FROM Users 
WHERE LEFT(mail, LOCATE('@', mail)-1) REGEXP '^[A-Za-z][A-Za-z0-9_.-]*$'
AND BINARY SUBSTRING(mail,LOCATE('@',mail)) = '@leetcode.com'