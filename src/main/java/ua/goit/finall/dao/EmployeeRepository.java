package ua.goit.finall.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.goit.finall.model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Employee findEmployeeByName(String name);

//    @Query("select e from Employee e join fetch e.events es join fetch e.salary")
    @Query("select e from Employee e")
    List<Employee> findAllWithDeps();
}