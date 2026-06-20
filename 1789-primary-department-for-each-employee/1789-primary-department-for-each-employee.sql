# Write your MySQL query statement below
Select employee_id , department_id 
From Employee 
Where primary_flag = 'Y'

Union 

Select employee_id , department_id 
From Employee
Group By employee_id
Having Count(employee_id )=1
