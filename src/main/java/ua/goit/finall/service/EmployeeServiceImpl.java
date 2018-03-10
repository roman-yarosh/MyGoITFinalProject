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
    public void calculateSalary(Integer month, Integer year) {

        //Настя надо подправить расчет, чтобы рассчитывалась зарплата только за дни месяца, ане всего рабочего периода

        for (Employee employee : employeeRepository.findAllWithDeps()) {
            double salarySum = 0;
            double hourSalary = employee.getPosition().getHourSalary().doubleValue();
            for (Event event : employee.getEvents()) {
                salarySum += event.getType().getRate() * hourSalary;
            }

           // Надо проверить нет ли в списке зарплаты за данный месяц и год, если есть, перезаписать сумму, если нет,
            // то добавить в коллекцию новыую зарплату с месяцем и годом
          //!!!!!!  employee.getSalary().setSalarySum(BigDecimal.valueOf(salarySum));
            System.out.println(salarySum);
        }
    }
}