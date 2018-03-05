package ua.goit.finall.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class Employee extends BaseEntity {

    private String name;
    private String surname;
    @ManyToOne
    private Department department;
    @ManyToOne
    private Position position;
    @OneToOne
    private Event event;
    @OneToOne
    private Status status;
    @OneToOne
    private Salary salary;

    //@Temporal(TemporalType.TIMESTAMP)
    private Date registred;
    private String email;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", department=").append(department);
        sb.append(", position=").append(position);
        sb.append(", event=").append(event);
        sb.append(", status=").append(status);
        sb.append(", salary=").append(salary);
        sb.append(", registred=").append(registred);
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Date getRegistred() {
        return registred;
    }

    public void setRegistred(Date registred) {
        this.registred = registred;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
