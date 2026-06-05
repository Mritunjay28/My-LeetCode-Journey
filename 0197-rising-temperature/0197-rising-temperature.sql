# Write your MySQL query statement below
select w.id as id
from Weather w
left Join Weather m
on w.recordDate  = m.recordDate + INTERVAL 1 DAY
where w.temperature > m.temperature ;