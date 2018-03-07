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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public BigDecimal getSalarySum() {
        return salarySum;
    }

    public void setSalarySum(BigDecimal salarySum) {
        this.salarySum = salarySum;
    }
}
