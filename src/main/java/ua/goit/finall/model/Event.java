package ua.goit.finall.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Date;

@Entity
public class Event extends BaseEntity{
    private String type;
    @ManyToMany
    private Employee employee;
    @ManyToMany
    private Employee createdBy;
    private Date date;
    private Integer hour;

}
