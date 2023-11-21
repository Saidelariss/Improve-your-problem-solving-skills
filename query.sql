
select name 
from Customer
where referee_id!=2 || referee_id is null;

--      
select distinct author_id as id
from Views 
where author_id=viewer_id
order by author_id ASC;

-- 
select tweet_id
from Tweets
where LENGTH(content)>15;

-- 
select EmployeeUNI.unique_id,Employees.name
from Employees
left join EmployeeUNI on (Employees.id=EmployeeUNI.id);

--
select Product.product_name,Sales.year,
        Sales.price
from Sales
join Product on (Sales.product_id=Product.product_id)
group by Sales.sale_id;

--
select customer_id, count(*) as count_no_trans
from Visits
where visit_id not in (select visit_id from Transactions)
group by customer_id;

--
SELECT w1.id
FROM Weather w1
JOIN Weather w2 ON DATEDIFF(w1.recordDate, w2.recordDate) = 1
WHERE w1.temperature > w2.temperature;

-->self join
-- example
-- Si vous souhaitez obtenir une liste des employés 
-- et de leurs manager, vous pouvez utiliser un self-join comme ceci :
--
+----+-----------+---------+
| ID | Name      | Manager |
+----+-----------+---------+
| 1  | Alice     | 3       |
| 2  | Bob       | 1       |
| 3  | Carol     | NULL    |
| 4  | Dave      | 3       |
+----+-----------+---------+


SELECT e1.Name AS Employee, e2.Name AS Manager
FROM Employees e1
LEFT JOIN Employees e2 ON e1.Manager = e2.ID;


select e.name as name,b.bonus as bonus
from Employee e
left join Bonus b on (e.empID=b.empId)
where bonus<1000 || bonus is NULL;



select Students.student_id , Students.student_name, Examinations.subject_name, count(*) as attended_exams
from Students
left join Examinations on (Examinations.student_id=Students.student_id)
group by Examinations.student_id,Examinations.subject_name
order by Students.student_id,Examinations.subject_name;

