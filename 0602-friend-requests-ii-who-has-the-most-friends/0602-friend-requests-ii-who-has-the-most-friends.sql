# Write your MySQL query statement below

Select id,Count(*) as num
From (
    Select requester_id as id
    From RequestAccepted 
    

    UNION ALL

    Select accepter_id as id 
    From RequestAccepted 
    
) t
Group By id
Order By num DESC
Limit 1;




