# Write your MySQL query statement below
Select 
    Case 
        When id%2=1 And id != (Select Max(id) From Seat)
            Then id+1
        When id%2=0 
            Then id-1
        Else id
    End 
    AS id 
, student
From Seat
Order By id