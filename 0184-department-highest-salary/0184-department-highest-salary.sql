# Write your MySQL query statement below
SELECT Department, Employee ,  Salary 
FROM (
    SELECT d.name AS Department, e.name AS Employee , salary AS Salary ,
        RANK() OVER(
            Partition BY d.name
            ORDER BY e.salary DESC
        ) AS ranking
    FROM Employee e
    LEFT JOIN Department d
    ON e.departmentId = d.id
) t
WHERE t.ranking = 1


