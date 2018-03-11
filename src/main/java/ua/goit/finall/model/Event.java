package ua.goit.finall.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
public class Event extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "TYPE_ID")
    private EventType type;

    @ManyToMany(mappedBy = "event")
    private List<Employee> employeeList;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User createdByUser;

    @Column(name = "EVENT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventDate;

    @Column(name = "HOURS")
    private Integer hours;

    public Event() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Event{");
        sb.append("id=").append(super.getId());
        sb.append("type=").append(type);
        sb.append(", employeeList=").append(employeeList);
        sb.append(", createdByUser=").append(createdByUser);
        sb.append(", eventDate=").append(eventDate);
        sb.append(", hours=").append(hours);
        sb.append('}');
        return sb.toString();
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public User getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(User createdByUser) {
        this.createdByUser = createdByUser;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }
}
