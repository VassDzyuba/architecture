package ua.edu.khpi.infiz.ikm222d;

public class PostgreSQLSingleton implements Quariable {

  private static PostgreSQLSingleton INSTANCE = new PostgreSQLSingleton();

  private PostgreSQLSingleton() {
  }

  public static PostgreSQLSingleton getInstance() {
    return INSTANCE;
  }

  @Override
  public String queryAll() {
    return "All from PostgreSQL";
  }

}
