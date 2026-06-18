# Write your MySQL query statement below
Select customer_id 
From Customer 
Where product_key IN (
    Select product_key 
    From Product
)
Group By customer_id 
Having Count(Distinct product_key ) = (
    Select Count(product_key )
    From Product
);