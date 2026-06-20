# Write your MySQL query statement below
Select Distinct l1.num as ConsecutiveNums 
from Logs l1
Left Join Logs l2
on l2.id=l1.id+1 And l2.num=l1.num
Left Join Logs l3
on l3.id=l1.id+2 And l3.num=l1.num
where l2.id IS Not Null And l3.id IS Not Null
