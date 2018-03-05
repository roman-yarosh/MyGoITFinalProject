package ua.goit.finall.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class Status extends BaseEntity{
    private String type;
    @OneToOne
    private Employee employee;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}
