package ua.goit.finall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.finall.dao.EmployeeRepository;
import ua.goit.finall.model.*;
import ua.goit.finall.service.EmployeeService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.delete(id);
    }

    @Override
    public Employee update(Employee entity) {
        return null;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeByName(String name) {
        return employeeRepository.findEmployeeByName(name);
    }

    @Override
    public Employee findEmployeeByUser(User user) {
        return employeeRepository.findEmployeeByUser(user);
    }

    @Override
    public void calculateSalary(Integer month, Integer year) {
        for (Employee employee : employeeRepository.findAllWithDeps()) {
            double salary = getSalaryInRange(month, year, employee);

            List<Salary> salariesInDate = employee.getSalary().stream()
                    .filter(s -> s.getMonth().equals(month) && s.getYear().equals(year))
                    .collect(Collectors.toList());

            if (salariesInDate.isEmpty()) {
                employee.getSalary().add(new Salary(employee, month, year, BigDecimal.valueOf(salary)));
            } else {
                salariesInDate.forEach(s -> s.setSalarySum(new BigDecimal(salary)));
            }

            employeeRepository.save(employee);
        }
    }

    private double getSalaryInRange(Integer month, Integer year, Employee employee) {
        double salarySum = 0;
        double hourSalary = employee.getPosition().getHourSalary().doubleValue();
        for (Event event : employee.getEventList()) {
            if (event.getType().getType().equals(EventType.Types.WORK.getName()) && isDateInRange(event.getEventDate(), month, year)) {
                salarySum += event.getType().getRate() * hourSalary;
            }
        }
        return salarySum;
    }

    private boolean isDateInRange(Date eventDate, Integer month, Integer year) {
        int eventYear = LocalDateTime.ofInstant(eventDate.toInstant(), ZoneId.systemDefault()).toLocalDate().getYear();
        int eventMonth = LocalDateTime.ofInstant(eventDate.toInstant(), ZoneId.systemDefault()).toLocalDate().getMonth().getValue();
        return year == eventYear && month == eventMonth;
    }
}