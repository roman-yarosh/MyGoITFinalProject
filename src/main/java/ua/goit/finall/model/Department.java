package ua.goit.finall.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department extends BaseEntity{
    private String name;
    @OneToMany
    private List<Employee> employeeList;
}
