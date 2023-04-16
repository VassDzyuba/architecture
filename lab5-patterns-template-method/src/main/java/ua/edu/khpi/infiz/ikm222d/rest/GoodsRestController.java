package ua.edu.khpi.infiz.ikm222d.rest;

import ua.edu.khpi.infiz.ikm222d.domain.Goods;

public class GoodsRestController extends RestController<Goods, GoodsBean> {

  private Messenger messenger = new Messenger();

  @Override
  protected Goods getEntity(int id) {
    return new Goods();
  }

  @Override
  protected void whenNotValid(GoodsBean bean, Goods entity) {
    // у випадку якщо в Товар в процесі оновлення не пройшов валідацію адміністратор
    // має отримати сповіщення у мессенджер
    messenger.sendMessageToAdmin("Goods is not valid");
  }

}
