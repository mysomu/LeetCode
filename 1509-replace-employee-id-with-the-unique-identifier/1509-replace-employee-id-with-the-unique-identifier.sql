# Write your MySQL query statement below
select empu.unique_id,emp.name
from Employees emp
left join employeeUNI empu
on emp.id = empu.id