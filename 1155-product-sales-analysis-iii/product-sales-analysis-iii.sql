# Write your MySQL query statement below
Select product_id, year as first_year, quantity, price 
From Sales
where (product_id, year) in (select product_id ,min(year) from Sales GROUP BY product_id);