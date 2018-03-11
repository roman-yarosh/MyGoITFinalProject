package ua.goit.finall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "positions")
public class Position extends BaseEntity{

    @Column(name = "NAME")
    private String name;

    @Column(name = "HOUR_SALARY")
    private BigDecimal hourSalary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getHourSalary() {
        return hourSalary;
    }

    public void setHourSalary(BigDecimal hourSalary) {
        this.hourSalary = hourSalary;
    }
}
