package ua.edu.khpi.infiz.ikm222d;

import java.math.BigDecimal;

public class Employee {

  private final String jobTitle;
  private final BigDecimal salary;

  public Employee(final String jobTitle, final double salary) {
    this.jobTitle = jobTitle;
    this.salary = BigDecimal.valueOf(salary);
  }

  public String getJobTitle() {
    return this.jobTitle;
  }

  public BigDecimal getSalary() {
    return this.salary;
  }

}
