# Write your MySQL query statement below
Select class 
From Courses 
GROUP BY class
Having COUNT(student) >= 5;