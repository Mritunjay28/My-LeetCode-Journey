
WITH ranked AS
(
    SELECT employee_id,
           review_date,
           rating,
           ROW_NUMBER() OVER(
               PARTITION BY employee_id
               ORDER BY review_date DESC
           ) AS rn
    FROM performance_reviews
)

SELECT
    e.employee_id,
    e.name,
    r1.rating - r3.rating AS improvement_score
FROM employees e

JOIN ranked r1
ON e.employee_id = r1.employee_id
AND r1.rn = 1

JOIN ranked r2
ON e.employee_id = r2.employee_id
AND r2.rn = 2

JOIN ranked r3
ON e.employee_id = r3.employee_id
AND r3.rn = 3

WHERE r1.rating > r2.rating
  AND r2.rating > r3.rating

ORDER BY improvement_score DESC,e.name;






