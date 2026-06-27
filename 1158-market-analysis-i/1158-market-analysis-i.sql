SELECT
    user_id AS buyer_id,
    join_date,
    SUM(CASE
            WHEN YEAR(order_date) = 2019 THEN 1
            ELSE 0
        END) AS orders_in_2019
FROM Users
LEFT JOIN Orders
ON user_id = buyer_id
GROUP BY user_id, join_date;