package ua.goit.finall.service;

import ua.goit.finall.model.Salary;

import java.util.List;

public interface SalaryService {

    Salary getById(Long id);

    void save(Salary salary);

    void delete(Long id);

    List<Salary> getAll();
}
