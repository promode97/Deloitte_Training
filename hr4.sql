SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  n_salary EMPLOYEE_SALARY.NET_SALARY%TYPE;
  n_name EMPLOYEE_SALARY.NAME%TYPE:='&name';
  v_msg    NUMBER(20);
BEGIN
  SELECT net_salary
  INTO n_salary
  FROM employee_salary
  WHERE name=n_name;
  
CASE
     WHEN n_salary < 20000 THEN
      v_msg:=0.1*n_salary;
     else
      v_msg:=0.2*n_salary;
end case;
  DBMS_OUTPUT.PUT_LINE(n_name);
  DBMS_OUTPUT.PUT_LINE(v_msg);
END;
/
commit;
select * from employee_salary;

insert into employee_salary(emp_no,name,basic,hra,da,total_deduction,net_salary,column5)
Values(6,'mark',14000,4000,1000,5000,16000,189000);

SET SERVEROUTPUT ON SIZE 10000000;
DECLARE
 BEGIN
  INSERT INTO Employee_salary(Emp_no,Basic,HRA,DA,Total_deduction,Net_salary,column5,name)
  VALUES(8,18000,4000,1000,5000,76000,73000,'promo');
  DECLARE
   n_name EMPLOYEE_SALARY.NAME%TYPE:='&ename';
   n_salary EMPLOYEE_SALARY.COLUMN5%TYPE;
   tax_pct NUMBER(20);
   tax NUMBER(20);
  BEGIN
  SELECT column5
  INTO n_salary
  FROM EMPLOYEE_SALARY
  WHERE name = n_name;
 CASE
  WHEN n_salary < 20000 THEN
    tax_pct := 0.1*n_salary;
  ELSE
    tax_pct := 0.2*n_salary;
 END CASE;
 tax:=tax_pct*n_salary/100;
 DBMS_OUTPUT.PUT_LINE(n_name||' has to pay tax '||tax);
 END;
END;
/



 



  r_chief cur_chief%ROWTYPE;
BEGIN
  OPEN cur_chief;
  LOOP
    -- fetch information from cursor into record
    FETCH cur_chief INTO r_chief;
 
    EXIT WHEN cur_chief%NOTFOUND;
 
    -- print department - chief
    DBMS_OUTPUT.PUT_LINE(r.role_id || ' - ' ||
                         r.user_name);
  END LOOP;
  -- close cursor cur_chief
  CLOSE cur_chief;
END;
/


SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  -- declare a cursor
  CURSOR cur_chief IS
      SELECT user_name,
      role_id
      FROM users u
      INNER JOIN roles r ON r.role_id = u.role_id;
 r_chief cur_chief%ROWTYPE;
BEGIN
  OPEN cur_chief;
  LOOP
    -- fetch information from cursor into record
    FETCH cur_chief INTO r_chief;
    
    EXIT WHEN cur_chief%NOTFOUND;
    
    --print user-chief
    DBMS_OUTPUT.PUT_LINE(r_chief.user_name || ', role is ' || r_chief.role_id);
   END LOOP;
   --close cursor cur_chief
   CLOSE cur_chief;
END;
/
 
 
 
 SET SERVEROUTPUT ON SIZE 100000;
DECLARE
--declare a cursor
 CURSOR cur_chief IS
     SELECT user_name, role_name
     FROM users u
     INNER JOIN roles r ON r.role_id = u.role_id;
     
 r_chief cur_chief%ROWTYPE;
BEGIN
  OPEN cur_chief;
  LOOP
    -- fetch information from cursor into record
    FETCH cur_chief INTO r_chief;
    
    EXIT WHEN cur_chief%NOTFOUND;
    
    --print user-chief
    DBMS_OUTPUT.PUT_LINE(r_chief.user_name || ', role is ' || r_chief.role_name);
   END LOOP;
   --close cursor cur_chief
   CLOSE cur_chief;
END;
/



delete from t1;







SET SERVEROUTPUT ON SIZE 100000;
DECLARE
--declare a cursor
 CURSOR cur_chief IS
     SELECT a,b
     FROM T1;
 r_chief cur_chief%ROWTYPE;
 tem T1.a%TYPE;
 BEGIN
  OPEN cur_chief;
  LOOP
   FETCH cur_chief INTO r_chief;
   EXIT WHEN cur_chief%NOTFOUND;
   
   tem := r_chief.a;
   UPDATE T1 SET a = r_chief.b WHERE b=r_chief.b;
   UPDATE T1 SET b = tem WHERE a=r_chief.b;
  END LOOP;
END; 
 /
   
 
 select * from t1;
 
 
 
 
 DECLARE
  i NUMBER := 1;
BEGIN
  LOOP
    INSERT INTO T1 VALUES(i,i+1);
    i := i+1;
    EXIT WHEN i>100;
  END LOOP;
END;
/


select * from copy_employee;
rollback;



SET SERVEROUTPUT ON SIZE 100000;
DECLARE
--declare a cursor
 CURSOR cur_chief IS
     SELECT first_name,hire_date,salary
     FROM copy_employee 
     where Extract(YEAR FROM hire_date)>='05';
  r_chief cur_chief%ROWTYPE;
 
 BEGIN
  OPEN cur_chief;
  LOOP
   FETCH cur_chief INTO r_chief;
   EXIT WHEN cur_chief%NOTFOUND;

   
   UPDATE copy_employee SET salary = r_chief.salary+(0.1*r_chief.salary);
   
  END LOOP;
END; 
 /
   
   
   
   
   
   
   
   
   
     SET SERVEROUTPUT ON SIZE 100000;
DECLARE
--declare a cursor
 CURSOR cur_chief IS
     SELECT first_name,last_name
     FROM copy_employee
     Order by hire_date;
  r_chief cur_chief%ROWTYPE;
 
 BEGIN
  OPEN cur_chief;
  LOOP
   FETCH cur_chief INTO r_chief;
   EXIT WHEN cur_chief%NOTFOUND;

   
   SELECT first_name,last_name,hire_date
     FROM copy_employee 
     Order by hire_date;
   
     
     
     DBMS_OUTPUT.PUT_LINE( r_chief.first_name ||' '||r_chief.last_name);
   
  END LOOP;
END; 
 /
 

   
   





SQL> declare
oldest_hire_date date;
lname employee.last_name%type;
fname employee.first_name%type;
 cursor find_old_b_day is select min(hire_date) from
copy_employee;
 cursor copy_employee is select last_name, first_name
 from copy_employee
 where hire_date =
oldest_hire_date;
 begin
 open hire_date;
 fetch hire_date into oldest_hire_date;
 close hire_date;
 open copy_employee;
 fetch copy_employee into last_name, first_name;
 close copy_employee;
 dbms_output.put_line ('The Oldest Employee Is’
 ||last_name||', '||first_name);
 end;
 /
 
 
 SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  r_emp employees%ROWTYPE;
  n_emp_id  employees.employee_id%TYPE := 200;
BEGIN
  SELECT *
  INTO r_emp
  FROM employees
  WHERE employee_id = n_emp_id;
  -- print out the employee's first name
  DBMS_OUTPUT.PUT_LINE(r_emp.first_name);
END;
/









SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  TYPE t_name IS RECORD(
     first_name employees.first_name%TYPE,
     last_name  employees.last_name%TYPE
  );
  r_name   t_name; -- name record
  n_emp_id employees.employee_id%TYPE := 200;
BEGIN
  SELECT first_name,
         last_name
  INTO r_name
  FROM employees
  WHERE employee_id = n_emp_id;
  -- print out the employee's name
  DBMS_OUTPUT.PUT_LINE(r_name.first_name || ',' || r_name.last_name );
END;
/







declare
cursor cur_chief is select u.name,r.role_name from users u join roles r on u.role_id=r.role_id;
type t_users is record(
user_name users.name%TYPE,
role_name roles.role_name%TYPE
);
r_users t_users;
begin
open cur_chief;
loop
fetch cur_chief into r_users;
exit when cur_chief%NOTFOUND;
dbms_output.put_line(r_users.user_name||' - '||r_users.role_name);
end loop;
end;
/
