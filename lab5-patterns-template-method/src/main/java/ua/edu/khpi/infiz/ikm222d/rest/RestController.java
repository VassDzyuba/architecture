package ua.edu.khpi.infiz.ikm222d.rest;

public abstract class RestController<E, B> {

  /**
   * <ul>
   * <li>2. Всі три сутності оновлюються за допомогою REST API.</li>
   * <li>3. Загальний процес складається з:</li>
   * </ul>
   * 
   * @param id
   * @param bean
   * @return
   */
  public PutResult put(final int id, final B bean) {
    final E entity = getEntity(id);// отримання объекта який треба оновити
    if (validate(bean, entity)) {// валідації вихідних даних
      storeEntity(bean, entity);// формування запиту на збереження інформації
      return putSuccessResult(entity);// формування відповіді - код відповіді та статус
    } else {
      whenNotValid(bean, entity);
    }
    return putErrorResult();// формування відповіді - код відповіді та статус
  }

  protected void whenNotValid(B bean, E entity) {
  }

  protected void storeEntity(B bean, E entity) {
  }

  protected abstract E getEntity(int id);

  protected PutResult putErrorResult() {
    return putResult(400, "Bad Request");
  }

  protected PutResult putSuccessResult(final E entity) {
    return putResult(200, "OK");
  }

  protected PutResult putResult(final int code, final String status) {
    return new PutResult(code, status);
  }

  protected boolean validate(B bean, E entity) {
    return true;
  }

  public class PutResult {

    private final int code;
    private final String status;
    private String body;

    public PutResult(final int code, final String status) {
      this.code = code;
      this.status = status;
    }

    public PutResult(final int code, final String status, final String body) {
      this.code = code;
      this.status = status;
      this.body = body;
    }

  }

}
