package ua.goit.finall.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employees")
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
    private LocalDateTime registred;
    private String email;
}
