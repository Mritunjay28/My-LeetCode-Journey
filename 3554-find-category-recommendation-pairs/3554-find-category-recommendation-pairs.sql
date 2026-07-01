# Write your MySQL query statement below
SELECT p1.category AS category1 , p2.category AS category2 , COUNT(DISTINCT p3.user_id) AS customer_count 
FROM  ProductInfo p1
JOIN ProductInfo p2 ON p1.category < p2.category
JOIN ProductPurchases p3 ON p3.product_id = p1.product_id 
JOIN ProductPurchases p4 ON p4.product_id = p2.product_id 
WHERE p3.user_id = p4.user_id  
GROUP BY p1.category , p2.category 
HAVING customer_count>=3
ORDER BY customer_count DESC , p1.category ,p2.category