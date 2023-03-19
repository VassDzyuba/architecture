package ua.edu.khpi.infiz.ikm222d.component.impl;

import ua.edu.khpi.infiz.ikm222d.Mediator;
import ua.edu.khpi.infiz.ikm222d.component.Component;

public class ButtonComponent extends Component {

	public static final String CLICKED = "clicked";

	public ButtonComponent(Mediator mediator) {
		super(mediator);
	}

	public void click() {
		mediator.notifyComponent(this, CLICKED);
	}

}
