package ua.goit.finall.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Salary extends BaseEntity {
    @OneToOne
    private Employee employee;
    private Integer month;
    private Integer year;
    private BigDecimal salarySum;
}
