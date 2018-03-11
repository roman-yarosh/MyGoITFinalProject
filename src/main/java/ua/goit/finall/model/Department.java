package ua.goit.finall.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department extends BaseEntity{

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employeeList;


}
