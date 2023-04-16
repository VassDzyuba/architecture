package ua.edu.khpi.infiz.ikm222d.rest;

import ua.edu.khpi.infiz.ikm222d.domain.User;

public class UsersRestController extends RestController<User, UserBean> {

  @Override
  protected User getEntity(int id) {
    return new User();
  }

  @Override
  protected boolean validate(UserBean bean, User entity) {
    // У Користувача заборонено змінювати значення у полі email, хоча таке поле у
    // сутності є і в умовній таблиці валідації(на яку дивиться метод “валідації
    // вихідних даних”) відмічено я дозволене.
    if (!bean.getEmail().equals(entity.getEmail())) {
      return false;
    }
    return true;
  }

}
