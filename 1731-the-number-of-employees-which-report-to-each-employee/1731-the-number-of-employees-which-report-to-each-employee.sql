# Write your MySQL query statement below
Select e.employee_id ,e.name, 
       count(t.employee_id) as reports_count , Round(Avg(t.age),0) average_age 
From Employees e
Join Employees t
On e.employee_id = t.reports_to 
group By e.employee_id
Order bY e.employee_id