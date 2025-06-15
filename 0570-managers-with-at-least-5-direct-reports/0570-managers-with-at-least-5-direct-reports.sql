# Write your MySQL query statement below
SELECT name From Employee
WHERE id in
(SELECT managerId FROM Employee
GROUP BY managerId
Having COUNT(*) >= 5)