package ua.goit.finall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.finall.dao.EmployeeRepository;
import ua.goit.finall.model.Employee;
import ua.goit.finall.model.Event;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeByName(String name) {
        return employeeRepository.findEmployeeByName(name);
    }

    @Override
    public void calculateSalary() {

        for (Employee employee : employeeRepository.findAllWithDeps()) {
            double salarySum = 0;
            double hourSalary = employee.getPosition().getHourSalary().doubleValue();
            for (Event event : employee.getEvents()) {
                salarySum += event.getType().getRate() * hourSalary;
            }
            employee.getSalary().setSalarySum(BigDecimal.valueOf(salarySum));
            System.out.println(salarySum);
        }
    }
}