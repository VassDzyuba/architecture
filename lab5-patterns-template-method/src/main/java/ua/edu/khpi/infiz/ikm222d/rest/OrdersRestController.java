package ua.edu.khpi.infiz.ikm222d.rest;

import ua.edu.khpi.infiz.ikm222d.domain.Order;

public class OrdersRestController extends RestController<Order, OrderBean> {

  @Override
  protected Order getEntity(int id) {
    return new Order();
  }

  @Override
  protected RestController<Order, OrderBean>.PutResult putSuccessResult(Order entity) {
//    Для сутності Замовлення необхідно повертаті у відповіді не лише код і статус, а й JSON-подання сутності Замовлення.
    return new PutResult(200, "OK", entity.toJson());
  }

}
