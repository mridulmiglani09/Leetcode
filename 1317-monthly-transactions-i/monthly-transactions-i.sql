# Write your MySQL query statement below
Select SUBSTR(trans_date,1,7) as month, country, 
count(id) as trans_count,
SUM(Case when state = "approved" then 1 else 0 end) as approved_count,
SUM(amount) as trans_total_amount,
SUM(Case when state = "approved" then amount else 0 end) as approved_total_amount 
From Transactions
GROUP BY month, country;