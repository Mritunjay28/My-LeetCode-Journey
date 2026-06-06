# Write your MySQL query statement below
Select e.name,b.bonus
From Employee e 
Left Join Bonus b 
on e.empId = b.empId
Where b.bonus IS Null
OR b.bonus<1000;