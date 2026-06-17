# Write your MySQL query statement below
Select activity_date as day , count(Distinct(user_id)) as active_users 
from Activity 
where activity_date BETWEEN DATE_SUB('2019-07-27', INTERVAL 29 DAY)
                  AND '2019-07-27'
Group By activity_date ;