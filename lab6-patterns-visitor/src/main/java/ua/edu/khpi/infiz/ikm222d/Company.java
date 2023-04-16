package ua.edu.khpi.infiz.ikm222d;

public class Company implements Visitable {

  private final String name;
  private final Department[] departments;

  public Company(final String name, final Department[] departments) {
    this.name = name;
    this.departments = departments;
  }

  public void accept(final Visitor visitor) {
    visitor.visit(this);
  }

  public Department[] getDepartments() {
    return departments;
  }

  public String getName() {
    return name;
  }

}
