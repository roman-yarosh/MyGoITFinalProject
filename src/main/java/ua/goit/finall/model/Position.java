package ua.goit.finall.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "position")
public class Position extends BaseEntity{
    private String name;
    private BigDecimal hourSalary;
}
