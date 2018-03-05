package ua.goit.finall.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "event")
public class Event extends BaseEntity{
    private String type;
    @OneToOne
    private Employee employee;
    @OneToOne
    private Employee createdBy;
    private Date date;
    private Integer hour;


}
