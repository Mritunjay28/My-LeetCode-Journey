# Write your MySQL query statement below
Select activity_date as day , count(Distinct(user_id)) as active_users 
from Activity 
where DATEDIFF('2019-07-27', activity_date) BETWEEN 0 AND 29
Group By activity_date ;