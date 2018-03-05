package ua.goit.finall.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.goit.finall.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Employee findEmployeeByName(String name);
}