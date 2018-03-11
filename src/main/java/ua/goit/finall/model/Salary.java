package ua.goit.finall.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "salaries")
public class Salary extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @Column(name = "MONTH")
    private Integer month;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "SALARY_SUM")
    private BigDecimal salarySum;

    public Salary() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Salary{");
        sb.append("id=").append(super.getId());
        sb.append("employee=").append(employee);
        sb.append(", month=").append(month);
        sb.append(", year=").append(year);
        sb.append(", salarySum=").append(salarySum);
        sb.append('}');
        return sb.toString();
    }

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
