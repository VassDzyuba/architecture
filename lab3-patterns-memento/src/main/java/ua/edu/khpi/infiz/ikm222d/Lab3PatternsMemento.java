package ua.edu.khpi.infiz.ikm222d;

public class Lab3PatternsMemento {

  public static void main(final String[] args) {
    new Lab3PatternsMemento().demo();
  }

  private void demo() {
    final Cabinet cabinet = new Cabinet();

    boolean undoVisible = cabinet.isUndoVisible();
    if (undoVisible) {
      throw new IllegalStateException("undo control must not be visible");
    }

    boolean notifyNewUsers = cabinet.isNotifyNewUsers();
    if (notifyNewUsers) {
      throw new IllegalStateException("notifyNewUsers must be false");
    }
    cabinet.setNotifyNewUsers(true);
    undoVisible = cabinet.isUndoVisible();
    if (!undoVisible) {
      throw new IllegalStateException("undo control must be visible");
    }

    cabinet.undo();
    notifyNewUsers = cabinet.isNotifyNewUsers();
    if (notifyNewUsers) {
      throw new IllegalStateException("notifyNewUsers must be false");
    }
    undoVisible = cabinet.isUndoVisible();
    if (undoVisible) {
      throw new IllegalStateException("undo control must not be visible");
    }

  }

}
