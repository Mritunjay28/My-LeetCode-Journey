-- # Write your MySQL query statement below
-- Select managerid,Count(managerId) from Employee
-- group by managerId ;

-- Select managerId,Count(managerId) as idCount from Employee
-- group by managerId

With emp2 as (
Select managerId,Count(managerId) as idCount from Employee
group by managerId
)
Select e.name from Employee e
join emp2 
On e.id = emp2.managerId
ANd emp2.idCount >=5;
