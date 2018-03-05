package ua.goit.finall.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "salary")
public class Salary extends BaseEntity {
    @OneToOne
    private Employee employee;
    private Integer month;
    private Integer year;
    private BigDecimal salarySum;
}
