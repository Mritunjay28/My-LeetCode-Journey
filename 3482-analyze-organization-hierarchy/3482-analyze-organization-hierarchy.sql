# Write your MySQL query statement below
WITH RECURSIVE level_cte AS
(
    SELECT employee_id,
           employee_name,
           manager_id,
           salary,
           1 AS level
    FROM Employees
    WHERE manager_id IS NULL

    UNION ALL

    SELECT e.employee_id,
           e.employee_name,
           e.manager_id,
           e.salary,
           l.level + 1
    FROM Employees e
    JOIN level_cte l
      ON e.manager_id = l.employee_id
),

hierarchy AS
(
    SELECT manager_id AS ancestor,
           employee_id AS descendant
    FROM Employees
    WHERE manager_id IS NOT NULL

    UNION ALL

    SELECT h.ancestor,
           e.employee_id
    FROM hierarchy h
    JOIN Employees e
      ON e.manager_id = h.descendant
),

team AS
(
    SELECT ancestor,
           COUNT(*) AS team_size
    FROM hierarchy
    GROUP BY ancestor
),

budget AS
(
    SELECT h.ancestor,
           SUM(e.salary) AS child_salary
    FROM hierarchy h
    JOIN Employees e
      ON h.descendant = e.employee_id
    GROUP BY h.ancestor
)

SELECT
    l.employee_id,
    l.employee_name,
    l.level,
    COALESCE(t.team_size,0) AS team_size,
    l.salary + COALESCE(b.child_salary,0) AS budget
FROM level_cte l
LEFT JOIN team t
ON l.employee_id=t.ancestor
LEFT JOIN budget b
ON l.employee_id=b.ancestor
ORDER BY
    l.level,
    budget DESC,
    l.employee_name;