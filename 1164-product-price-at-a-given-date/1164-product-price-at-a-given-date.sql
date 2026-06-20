-- # Write your MySQL query statement below

SELECT p.product_id , p.new_price as price 
FROM Products p
WHERE ( product_id , change_date) IN (
    SELECT product_id , MAX(change_date) as change_date
    FROM Products
    WHERE change_date <= '2019-08-16'
    GROUP BY product_id
)

UNION 

SELECT  p.product_id , 10 as price 
FROM Products p
WHERE product_id NOT IN (
    SELECT product_id
    FROM Products
    WHERE change_date<="2019-08-16"
)




