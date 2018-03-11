package ua.goit.finall.service;

import ua.goit.finall.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getById(Long id);

    void save(Employee employee);

    void delete(Long id);

    List<Employee> getAll();

    Employee findEmployeeByName(String name);

    void calculateSalary(Integer month, Integer year);
}
