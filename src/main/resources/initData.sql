INSERT INTO department (id, name) VALUES (1, 'pokenons');
INSERT INTO position (id, hour_salary, name) VALUES (1,10,'rab');
INSERT INTO employee (id, name, surname, email, POSITION_ID, DEPARTMENT_ID) VALUES (1, '1', '1', 5, 1, 1);
INSERT INTO salary(id, month, salary_sum, year, employee_id) VALUES (1,1,0,0,1);
INSERT INTO event_type(id, rate, type) VALUES (1, 0.5, 'work');
INSERT INTO event (id, date, hour, type_id, created_by_id, employee_id) VALUES (1, 0, 3,1,1,1);
INSERT INTO event (id, date, hour, type_id, created_by_id, employee_id) VALUES (2, 0, 2,1,1,1);
INSERT INTO event (id, date, hour, type_id, created_by_id, employee_id) VALUES (3, 0, 2,1,1,1);
