package ua.edu.khpi.infiz.ikm222d;

public class SalaryReportVisitor implements Visitor {

  @Override
  public void visit(final Company company) {
    System.out.println("Company[" + company.getName() + "]");
    final Department[] departments = company.getDepartments();
    for (final Department department : departments) {
      visit(department);
    }
  }

  @Override
  public void visit(final Department department) {
    System.out.println("Department[" + department.getName() + "]");
    Employee[] employees = department.getEmployees();
    for (Employee employee : employees) {
      System.out.println(employee.getJobTitle() + ";" + employee.getSalary().stripTrailingZeros().toPlainString());
    }
  }

}
