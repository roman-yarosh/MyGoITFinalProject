package ua.goit.finall.service;

import ua.goit.finall.model.Department;

import java.util.List;

public interface DepartmentService {

    Department getById(Long id);

    void save(Department department);

    void delete(Long id);

    List<Department> getAll();

}
