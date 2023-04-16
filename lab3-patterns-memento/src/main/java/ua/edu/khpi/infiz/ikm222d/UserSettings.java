package ua.edu.khpi.infiz.ikm222d;

public class UserSettings implements Originator {

  private boolean notifyNews;
  private boolean notifyNewUsers;
  private boolean notifyOffers;

  public NotoficationSettings save() {
    return new NotoficationSettings(notifyNews, notifyNewUsers, notifyOffers);
  }

  public void restore(final NotoficationSettings memento) {
    this.notifyNews = memento.notifyNews;
    this.notifyNewUsers = memento.notifyNewUsers;
    this.notifyOffers = memento.notifyOffers;
  }

  public boolean isNotifyNews() {
    return notifyNews;
  }

  public void setNotifyNews(final boolean notifyNews) {
    this.notifyNews = notifyNews;
  }

  public boolean isNotifyNewUsers() {
    return notifyNewUsers;
  }

  public void setNotifyNewUsers(final boolean notifyNewUsers) {
    this.notifyNewUsers = notifyNewUsers;
  }

  public boolean isNotifyOffers() {
    return notifyOffers;
  }

  public void setNotifyOffers(final boolean notifyOffers) {
    this.notifyOffers = notifyOffers;
  }

  public class NotoficationSettings implements Memento {

    private final boolean notifyNews;
    private final boolean notifyNewUsers;
    private final boolean notifyOffers;

    public NotoficationSettings(final boolean notifyNews, final boolean notifyNewUsers, final boolean notifyOffers) {
      this.notifyNews = notifyNews;
      this.notifyNewUsers = notifyNewUsers;
      this.notifyOffers = notifyOffers;
    }

    public boolean isNotifyNews() {
      return notifyNews;
    }

    public boolean isNotifyNewUsers() {
      return notifyNewUsers;
    }

    public boolean isNotifyOffers() {
      return notifyOffers;
    }

  }
}
