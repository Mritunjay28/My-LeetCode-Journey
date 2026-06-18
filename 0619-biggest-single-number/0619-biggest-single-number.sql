# Write your MySQL query statement below
Select Max(num) as num
from MyNumbers
Where num in (
    Select num
From MyNumbers 
Group By num 
Having count(num)=1
);



