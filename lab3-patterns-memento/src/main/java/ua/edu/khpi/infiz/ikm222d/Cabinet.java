package ua.edu.khpi.infiz.ikm222d;

import java.util.Stack;

import ua.edu.khpi.infiz.ikm222d.UserSettings.NotoficationSettings;

public class Cabinet implements Caretaker {

  private final UserSettings originator = new UserSettings();
  private final Stack<NotoficationSettings> history = new Stack<>();

  public UserSettings getUserSettings() {
    return originator;
  }

  public void undo() {
    final NotoficationSettings memento = history.pop();
    originator.restore(memento);
  }

  private void backup() {
    final NotoficationSettings memento = originator.save();
    history.push(memento);
  }

  public void setNotifyNews(final boolean notifyNews) {
    backup();
    originator.setNotifyNews(notifyNews);
  }

  public void setNotifyNewUsers(final boolean notifyNewUsers) {
    backup();
    originator.setNotifyNewUsers(notifyNewUsers);
  }

  public void setNotifyOffers(final boolean notifyOffers) {
    backup();
    originator.setNotifyOffers(notifyOffers);
  }

  public boolean isNotifyNews() {
    return originator.isNotifyNews();
  }

  public boolean isNotifyNewUsers() {
    return originator.isNotifyNewUsers();
  }

  public boolean isNotifyOffers() {
    return originator.isNotifyOffers();
  }

  public boolean isUndoVisible() {
    return !history.isEmpty();
  }

}
