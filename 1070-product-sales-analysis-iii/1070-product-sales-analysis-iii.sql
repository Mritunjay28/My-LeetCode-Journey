# Write your MySQL query statement below
Select s.product_id , s.year as first_year , s.quantity , s.price 
from Sales s
Join  (
    select product_id ,min(year) AS first_year
    from Sales 
    group by product_id
) t
ON s.product_id = t.product_id
AND s.year = t.first_year;

