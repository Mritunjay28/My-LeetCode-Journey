# Write your MySQL query statement below
Select Distinct(customer_id),Count(customer_id) as count_no_trans
from Visits v
LEFT Join Transactions t
ON v.visit_id=t.visit_id 
Where transaction_id IS NULL
Group by customer_id;