# Write your MySQL query statement below
Select u.name  , COALESCE(r.total_distance,0) as travelled_distance 
From  Users u 
LEFT JOIN (
    Select user_id , Sum(distance) as total_distance
    From  Rides 
    Group By user_id  
) r
ON u.id = r.user_id
ORDER BY travelled_distance DESC , name
