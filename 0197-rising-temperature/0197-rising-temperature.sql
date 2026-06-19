# Write your MySQL query statement below
select w1.id
from weather w1
inner join weather w2
on datediff(w1.recordDate,w2.recordDate)=1
and w1.temperature > w2.temperature