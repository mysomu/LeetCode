# Write your MySQL query statement below
select st.student_id,st.student_name,sub.subject_name,
count(exam.subject_name) as attended_exams
from students st
cross join subjects sub
left join Examinations exam
on st.student_id = exam.student_id 
and sub.subject_name = exam.subject_name
group by st.student_id,st.student_name,sub.subject_name
order by st.student_id,sub.subject_name
