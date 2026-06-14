# Write your MySQL query statement below
with poor_query as (
    Select query_name , count(rating) as poor
    from Queries 
    where rating < 3 
    group by query_name 
)
Select q.query_name ,
    Round(Avg(q.rating /q.position),2) as quality ,
    Round(COALESCE(p.poor / count(rating) *100 ,0 ),
     2) as poor_query_percentage 
From Queries q
left join poor_query p
ON q.query_name = p.query_name
Group By q.query_name ;

