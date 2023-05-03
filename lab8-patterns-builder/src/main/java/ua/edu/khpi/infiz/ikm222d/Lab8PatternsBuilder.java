package ua.edu.khpi.infiz.ikm222d;

public class Lab8PatternsBuilder {

  public static void main(final String[] args) {
    new Lab8PatternsBuilder().demo();
  }

  private void demo() {
    // select unfiltered but limited from PG
    QueryBuilder pg = new PostgreSQLQueryBuilder();
    pg.select("lab8");
    pg.limit(15);
    System.out.println(pg.getSQL());
    // select filtered and limited from MySQL
    QueryBuilder ms = new MySQLQueryBuilder();
    ms.select("lab8");
    ms.where("m = 'M'");
    ms.limit(3);
    System.out.println(ms.getSQL());
  }

}
