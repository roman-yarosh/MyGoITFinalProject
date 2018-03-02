package ua.goit.finall.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Status extends BaseEntity{
    private String type;
    @OneToOne
    private Employee employee;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}
