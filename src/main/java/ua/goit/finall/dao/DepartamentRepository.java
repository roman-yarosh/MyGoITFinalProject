package ua.goit.finall.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.goit.finall.model.Department;

@Repository
public interface DepartamentRepository extends CrudRepository<Department, Long>{

}
