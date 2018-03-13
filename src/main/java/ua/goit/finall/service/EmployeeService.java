package ua.goit.finall.service;

import ua.goit.finall.model.Employee;
import ua.goit.finall.model.User;

import java.util.List;

public interface EmployeeService extends BaseService<Employee> {

    Employee findEmployeeByName(String name);

    Employee findEmployeeByUser(User user);

    void calculateSalary(Integer month, Integer year);

}
