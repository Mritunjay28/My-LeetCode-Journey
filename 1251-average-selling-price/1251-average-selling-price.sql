-- # Write your MySQL query statement below
with No_Of_Product_Sold as (
    Select product_id , Sum(units) as total
from UnitsSold 
group by product_id
),
Total_Price as(
Select p.product_id , COALESCE(Sum(p.price*u.units) , 0) as total_product
from Prices p
Left Join UnitsSold u
On p.product_id=u.product_id 
AND u.purchase_date BETWEEN p.start_date AND p.end_date 
Group by p.product_id 
)
Select t.product_id , COALESCE(Round(t.total_product/n.total,2), 0) as average_price
from Total_Price t
Left Join No_Of_Product_Sold n
on t.product_id=n.product_id;

