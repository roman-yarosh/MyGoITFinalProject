package ua.goit.finall.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "status")
public class Status extends BaseEntity{

    private String type;

    @OneToOne
    private Employee employee;

    public Status() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
