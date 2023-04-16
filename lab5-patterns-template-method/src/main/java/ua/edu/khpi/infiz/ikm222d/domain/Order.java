package ua.edu.khpi.infiz.ikm222d.domain;

public class Order {

  private int orderId;

  public String toJson() {
    return "{orderId:" + orderId + "}";
  }

}
