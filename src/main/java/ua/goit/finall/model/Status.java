package ua.goit.finall.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "statuses")
public class Status extends BaseEntity{

    @Column(name = "TYPE")
    private String type;

    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employeeList;

    public Status() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Status{");
        sb.append("id='").append(super.getId()).append('\'');
        sb.append("type='").append(type).append('\'');
        sb.append(", employeeList=").append(employeeList);
        sb.append('}');
        return sb.toString();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
