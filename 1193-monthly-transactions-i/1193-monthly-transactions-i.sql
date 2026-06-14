# Write your MySQL query statement below
SELECT DATE_FORMAT(trans_date , '%Y-%m') AS month,
       country,
       count(id) as trans_count,
       count( case when state='approved ' then 1 end) as approved_count,
       Sum(amount ) as trans_total_amount,
       Sum(case when state='approved ' then amount else 0 end ) as approved_total_amount 
FROM Transactions 
GROUP BY DATE_FORMAT(trans_date, '%Y-%m') , country;