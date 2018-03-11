package ua.goit.finall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.goit.finall.model.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {

}
