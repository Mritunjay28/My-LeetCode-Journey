# Write your MySQL query statement below

Select id,Sum(num) as num
From (
    Select requester_id as id, count(requester_id ) as num
    From RequestAccepted 
    Group By requester_id

    UNION ALL

    Select accepter_id as id , count(accepter_id  ) as num
    From RequestAccepted 
    Group By accepter_id 
) t
Group By id
Order By num DESC
Limit 1;




