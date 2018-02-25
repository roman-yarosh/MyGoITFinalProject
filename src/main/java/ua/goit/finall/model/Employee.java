package ua.goit.finall.model;

import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Employee extends BaseEntity {

    private String name;
    private String surname;
    @ManyToOne
    private Department department;
    @ManyToOne
    private Position position;
    @OneToMany
    private List<Event> event;
    @OneToMany
    private List<Status> status;

    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime registred;
    private String email;
}
