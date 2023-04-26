package ua.edu.khpi.infiz.ikm222d;

public class Lab7PatternsSingleton {

  public static void main(final String[] args) {
    new Lab7PatternsSingleton().demo();
  }

  private void demo() {
    System.out.println(PostgreSQLSingleton.getInstance().queryAll());
    System.out.println(MongoDBSingleton.getInstance().queryAll());
  }

}
