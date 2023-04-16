package ua.edu.khpi.infiz.ikm222d;

public class Lab6PatternsVisitor {

  public static void main(final String[] args) {
    new Lab6PatternsVisitor().demo();
  }

  private void demo() {
    final Employee employee1 = new Employee("jobTitle1", 100.10);
    final Employee employee2 = new Employee("jobTitle2", 110.20);
    final Employee employee3 = new Employee("jobTitle3", 120.30);
    final Employee employee4 = new Employee("jobTitle4", 130.50);
    final Employee employee5 = new Employee("jobTitle5", 140.70);

    final Department department1 = new Department("Department1", new Employee[] { employee1, employee2 });
    final Department department2 = new Department("Department2", new Employee[] { employee3 });
    final Department department3 = new Department("Department3", new Employee[] { employee4, employee5 });

    final Company company1 = new Company("Company1", new Department[] { department1, department2 });
    final Company company2 = new Company("Company2", new Department[] { department3 });

    // “клієнтський код” в якому буде відображено яким саме чином можно отримати
    // репорт для компанії
    final SalaryReportVisitor salaryReportVisitor = new SalaryReportVisitor();
    company1.accept(salaryReportVisitor);
    // і окремо для одного з відділів компанії.
    company1.getDepartments()[1].accept(salaryReportVisitor);
  }

}
