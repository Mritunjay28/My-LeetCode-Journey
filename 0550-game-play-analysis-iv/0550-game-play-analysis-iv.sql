# Write your MySQL query statement below

Select Round(count(*)/ (select count(distinct(player_id )) from Activity ),2) as fraction  
from Activity a
Join (
    SELECT player_id , MIN(event_date ) AS first_time
    FROM Activity 
    GROUP BY player_id 
) s
on a.player_id = s.player_id
and a.event_date = DATE_ADD(s.first_time, INTERVAL 1 DAY) ; 