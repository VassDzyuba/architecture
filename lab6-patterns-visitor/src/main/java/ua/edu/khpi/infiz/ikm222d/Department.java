package ua.edu.khpi.infiz.ikm222d;

public class Department implements Visitable {

  private final String name;
  private final Employee[] employees;

  public Department(final String name, final Employee[] employees) {
    this.name = name;
    this.employees = employees;
  }

  public void accept(final Visitor visitor) {
    visitor.visit(this);
  }

  public Employee[] getEmployees() {
    return employees;
  }

  public String getName() {
    return name;
  }

}
