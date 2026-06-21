# Write your MySQL query statement below

SELECT person_name
FROM (
    SELECT person_name,
           turn,
           SUM(weight) OVER (ORDER BY turn) AS curr_sum
    FROM Queue
) t
WHERE curr_sum <= 1000
ORDER BY turn DESC
LIMIT 1;