package ua.edu.khpi.infiz.ikm222d;

public class MySQLQueryBuilder implements QueryBuilder {

  private String sql = "";

  @Override
  public String getSQL() {
    return sql;
  }

  @Override
  public void select(String tableName) {
    sql += "SELECT m, y, s, q, l FROM " + tableName;
  }

  @Override
  public void where(String clause) {
    sql += " WHERE " + clause;
  }

  @Override
  public void limit(int limit) {
    sql += " LIMIT " + limit;
  }

  @Override
  public void reset() {
    sql = "";
  }
}