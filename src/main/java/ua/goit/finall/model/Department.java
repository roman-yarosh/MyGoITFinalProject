package ua.goit.finall.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Department extends BaseEntity{
    private String name;
    @OneToMany
    private List<Employee> empl;
}
