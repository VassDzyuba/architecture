package ua.edu.khpi.infiz.ikm222d;

import ua.edu.khpi.infiz.ikm222d.FoodShipper.DeliveryType;

public class Lab4PatternsStrategy {

  public static void main(final String[] args) {
    new Lab4PatternsStrategy().demo();
  }

  private void demo() {
    FoodShipper foodShipper = new FoodShipper();

    foodShipper.setDeliveryType(DeliveryType.SELF);
    System.out.println("If DeliveryType = SELF then shippingCost is " + foodShipper.calculateShippingCost());

    foodShipper.setDeliveryType(DeliveryType.EXTERNAL);
    System.out.println("If DeliveryType = EXTERNAL then shippingCost is " + foodShipper.calculateShippingCost());

    foodShipper.setDeliveryType(DeliveryType.INTERNAL);
    System.out.println("If DeliveryType = INTERNAL then shippingCost is " + foodShipper.calculateShippingCost());
  }

}
