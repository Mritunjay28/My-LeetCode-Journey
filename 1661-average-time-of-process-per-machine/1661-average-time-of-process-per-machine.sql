# Write your MySQL query statement below
Select a.machine_id , Round(Avg(b.timestamp -a.timestamp),3) as processing_time
From activity a
Inner Join activity b
ON a.machine_id = b.machine_id AND 
a.process_id = b.process_id And 
a.activity_type = 'start' And 
b.activity_type = 'end' 
Group by a.machine_id; 
;




