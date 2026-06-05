# Write your MySQL query statement below
select w.id 
from Weather w
Join Weather m
on w.recordDate  = m.recordDate + INTERVAL 1 DAY
where w.temperature > m.temperature ;