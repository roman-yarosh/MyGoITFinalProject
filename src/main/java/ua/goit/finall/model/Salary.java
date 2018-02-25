package ua.goit.finall.model;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Salary extends BaseEntity{
    private Employee employee;
    private Integer month;
    private Integer year;
    private BigDecimal salarySum;
}
