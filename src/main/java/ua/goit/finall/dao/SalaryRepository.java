package ua.goit.finall.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.goit.finall.model.Salary;

@Repository
public interface SalaryRepository extends CrudRepository<Salary, Long> {

}
