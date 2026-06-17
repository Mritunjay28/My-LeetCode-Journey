# Write your MySQL query statement below
Select Distinct c.class 
From Courses c
Join (
    select class , count(student) as no_of_student
from Courses 
group by class 
) t
On c.class = t.class And t.no_of_student >=5;

