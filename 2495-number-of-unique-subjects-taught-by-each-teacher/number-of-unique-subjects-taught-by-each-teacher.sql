# Write your MySQL query statement below
Select teacher_id, COUNT(DISTINCT subject_id) as cnt
From Teacher GROUP BY teacher_id;