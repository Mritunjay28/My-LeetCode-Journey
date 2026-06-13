# Write your MySQL query statement below
With total_user as (
    select count(user_id) as total from Users
)
Select r.contest_id , Round((count(user_id)/t.total)*100,2) as percentage 
from Register r
Join total_user t
Group By r.contest_id
Order by percentage Desc , r.contest_id ;
