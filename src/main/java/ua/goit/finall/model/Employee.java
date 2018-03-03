package ua.goit.finall.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
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
}
