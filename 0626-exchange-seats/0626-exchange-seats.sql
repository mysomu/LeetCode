# Write your MySQL query statement below
select 
    case
        when
            id = (select max(id) from seat) and mod(id,2)=1
            then id
        when 
            MOD(id,2)=1
            then id+1
        else
            id-1
    end as id, student
from Seat
order by id