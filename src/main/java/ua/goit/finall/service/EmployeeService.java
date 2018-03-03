package ua.goit.finall.service;

import ua.goit.finall.model.Employee;

import java.util.List;

public interface EmployeeService {
    Iterable<Employee> getAll();
    Employee findEmployeeByName(String name);
}
