package ua.goit.finall.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Event extends BaseEntity{
    private String type;
    @OneToOne
    private Employee employee;
    @OneToOne
    private Employee createdBy;
    private Date date;
    private Integer hour;

}
