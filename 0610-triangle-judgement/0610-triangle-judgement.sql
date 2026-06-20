# Write your MySQL query statement below
Select x,y,z,
        CASE
        When x+y<=z Then 'No'
        When z+y<=x Then 'No'
        When x+z<=y Then 'No'
        Else 'Yes'
    End As triangle 
From Triangle 