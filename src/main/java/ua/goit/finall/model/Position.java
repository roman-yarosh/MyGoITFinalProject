package ua.goit.finall.model;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Position extends BaseEntity{
    private String name;
    private BigDecimal hourSalary;
}
