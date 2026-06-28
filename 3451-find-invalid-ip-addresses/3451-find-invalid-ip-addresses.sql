# Write your MySQL query statement below
WITH cte AS
(
SELECT *,
       SUBSTRING_INDEX(ip,'.',1) AS p1,
       SUBSTRING_INDEX(SUBSTRING_INDEX(ip,'.',2),'.',-1) AS p2,
       SUBSTRING_INDEX(SUBSTRING_INDEX(ip,'.',3),'.',-1) AS p3,
       SUBSTRING_INDEX(ip,'.',-1) AS p4
FROM Logs
)

-- SUBSTRING_INDEX(string, delimiter, count) = Cut the string at the delimiter and return everything from one side.
-- if count postive then give left part else right part 
-- But SELECT SUBSTRING_INDEX('192.168.001.1', '.', 2); give 192.168
-- so we extract that and does SUBSTRING_INDEX('192.168','.',-1) to get 168

SELECT ip,
       COUNT(*) AS invalid_count
FROM cte
WHERE
    LENGTH(ip)-LENGTH(REPLACE(ip,'.','')) <> 3 
    -- find no of '.' 
    -- <> is the not equal 
    -- cast covert to integer  but remove leading zeros
   OR CAST(p1 AS UNSIGNED)>255
   OR CAST(p2 AS UNSIGNED)>255
   OR CAST(p3 AS UNSIGNED)>255
   OR CAST(p4 AS UNSIGNED)>255

   OR (LENGTH(p1)>1 AND LEFT(p1,1)='0')
   OR (LENGTH(p2)>1 AND LEFT(p2,1)='0')
   OR (LENGTH(p3)>1 AND LEFT(p3,1)='0')
   OR (LENGTH(p4)>1 AND LEFT(p4,1)='0')

GROUP BY ip
ORDER BY invalid_count DESC, ip DESC;