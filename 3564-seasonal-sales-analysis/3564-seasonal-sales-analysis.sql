# Write your MySQL query statement below
WITH cte AS (
    SELECT 
        s.quantity,
        s.price,
        p.category,
        CASE
            WHEN EXTRACT(MONTH FROM sale_date) IN (12, 1, 2)
            THEN 'Winter'
            WHEN EXTRACT(MONTH FROM sale_date) IN (3, 4, 5)
            THEN 'Spring'
            WHEN EXTRACT(MONTH FROM sale_date) IN (6, 7, 8)
            THEN 'Summer'
            WHEN EXTRACT(MONTH FROM sale_date) IN (9, 10, 11)
            THEN 'Fall'
        END AS season
    FROM sales s
    INNER JOIN products p ON s.product_id = p.product_id
),
cte2 AS (
    SELECT 
        season,
        category,
        SUM(quantity) AS total_quantity,
        SUM(quantity*price) AS total_revenue,
        RANK() OVER(
            PARTITION BY season 
            ORDER BY SUM(quantity) DESC, SUM(quantity*price) DESC
        ) AS ranking  
    FROM cte
    GROUP BY 
        season, 
        category
)
SELECT 
    season,
    category,
    total_quantity,
    total_revenue
FROM cte2
WHERE ranking = 1
ORDER BY season ASC