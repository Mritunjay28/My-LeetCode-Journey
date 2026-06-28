# Write your MySQL query statement below
SELECT * ,
        CASE 
            WHEN LEFT(dna_sequence,3) = 'ATG' THEN 1
            ELSE 0
        END AS has_start ,
        CASE 
            WHEN RIGHT(dna_sequence,3) = 'TAA' THEN 1
            WHEN RIGHT(dna_sequence,3) = 'TAG' THEN 1
            WHEN RIGHT(dna_sequence,3) = 'TGA' THEN 1
            ELSE 0
        END AS has_stop ,
        CASE 
            WHEN dna_sequence LIKE '%ATAT%'  THEN 1
            ELSE 0
        END AS has_atat ,
        CASE 
            WHEN dna_sequence LIKE '%GGG%' THEN 1
            ELSE 0
        END AS has_ggg 
FROM Samples 
ORDER BY sample_id 