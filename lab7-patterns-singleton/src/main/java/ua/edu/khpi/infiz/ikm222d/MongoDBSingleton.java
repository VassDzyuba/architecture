package ua.edu.khpi.infiz.ikm222d;

public class MongoDBSingleton implements Quariable {

  private static MongoDBSingleton INSTANCE = new MongoDBSingleton();

  private MongoDBSingleton() {
  }

  public static MongoDBSingleton getInstance() {
    return INSTANCE;
  }

  @Override
  public String queryAll() {
    return "All from MongoDB";
  }

}
