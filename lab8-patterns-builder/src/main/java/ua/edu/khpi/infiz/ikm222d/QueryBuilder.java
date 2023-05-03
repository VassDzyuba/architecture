package ua.edu.khpi.infiz.ikm222d;

public interface QueryBuilder {
  void select(String tableName);

  void where(String clause);

  void limit(int limit);

  String getSQL();

  void reset();
}
