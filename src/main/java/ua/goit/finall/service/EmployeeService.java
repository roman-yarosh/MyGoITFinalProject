package ua.goit.finall.service;

import ua.goit.finall.model.Employee;

import java.util.List;

public interface EmployeeService extends BaseService<Employee> {

    Employee findEmployeeByName(String name);

    void calculateSalary(Integer month, Integer year);

}
