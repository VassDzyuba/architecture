package ua.edu.khpi.infiz.ikm222d;

import ua.edu.khpi.infiz.ikm222d.component.Component;

public interface Mediator {

	void notifyComponent(Component component, String event);

}
