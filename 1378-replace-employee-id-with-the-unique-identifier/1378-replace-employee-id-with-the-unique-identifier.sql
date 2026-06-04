# Write your MySQL query statement below
SELECT unique_id,name 
FROM EmployeeUNI E1
RIGHT JOIN Employees E2
ON E1.id=E2.id;