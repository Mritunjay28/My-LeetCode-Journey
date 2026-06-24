# Write your MySQL query statement below
SELECT name as product_name , total_unit as unit
FROM (
    SELECT p.product_name as name , SUM(o.unit) as total_unit
    FROM Products p
    LEFT JOIN Orders o
    ON p.product_id = o.product_id  
    WHERE MONTH(o.order_date) = 2 AND YEAR(o.order_date) = 2020
    GROUP BY p.product_name
) t
WHERE total_unit >=100
