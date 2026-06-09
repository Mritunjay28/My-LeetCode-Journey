# Write your MySQL query statement below

WITH q1 AS (
    Select s.user_id ,count(c.user_id) as total 
    from Signups s
    left join Confirmations c
    on s.user_id = c.user_id
    group by s.user_id
),
q2 AS (
    select user_id , count(action) as accept
    from Confirmations 
    where action = 'confirmed'
    group by user_id
)
Select q1.user_id ,
COALESCE(
ROUND(
    COALESCE(accept,0) * 1.0 /
        NULLIF(total,0),
        2
) , 0
) as confirmation_rate
From q1
left join q2
on q1.user_id = q2.user_id;
