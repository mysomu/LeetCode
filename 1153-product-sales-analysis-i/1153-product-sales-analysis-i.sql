# Write your MySQL query statement below
select pr.Product_name,sl.year,sl.price
from sales as sl
inner join product as pr
on sl.product_id = pr.product_id