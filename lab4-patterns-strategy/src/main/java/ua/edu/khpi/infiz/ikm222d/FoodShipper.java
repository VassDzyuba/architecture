package ua.edu.khpi.infiz.ikm222d;

public class FoodShipper {

  private Strategy delivery = new SelfDelivery();

  public void setDeliveryType(final DeliveryType deliveryType) {
    switch (deliveryType) {
      case EXTERNAL:
        delivery = new ExternalDelivery();
        break;
      case INTERNAL:
        delivery = new InternalDelivery();
        break;
      case SELF:
        delivery = new SelfDelivery();
        break;
      default:
        break;
    }
  }

  public double calculateShippingCost() {
    return delivery.calculateShippingCost();
  }

  public enum DeliveryType {
    SELF, INTERNAL, EXTERNAL,;
  }

}
