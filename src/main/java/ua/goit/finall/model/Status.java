package ua.goit.finall.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "status")
public class Status extends BaseEntity{
    private String type;
    @OneToOne
    private Employee employee;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}
