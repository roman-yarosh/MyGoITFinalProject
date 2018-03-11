package ua.goit.finall.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "positions")
public class Position extends BaseEntity{

    @Column(name = "NAME")
    private String name;

    @Column(name = "HOUR_SALARY")
    private BigDecimal hourSalary;

    @OneToMany(mappedBy = "position", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employeeList;

    public Position() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Position{");
        sb.append("id='").append(super.getId()).append('\'');
        sb.append("name='").append(name).append('\'');
        sb.append(", hourSalary=").append(hourSalary);
        sb.append(", employeeList=").append(employeeList);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getHourSalary() {
        return hourSalary;
    }

    public void setHourSalary(BigDecimal hourSalary) {
        this.hourSalary = hourSalary;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
