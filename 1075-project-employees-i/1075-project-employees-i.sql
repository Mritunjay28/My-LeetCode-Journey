# Write your MySQL query statement below

Select p.project_id,Round(Sum(e.experience_years )/Count(e.employee_id),2) as average_years 
From Project p
Left Join Employee e 
On p.employee_id = e.employee_id
Group by p.project_id;