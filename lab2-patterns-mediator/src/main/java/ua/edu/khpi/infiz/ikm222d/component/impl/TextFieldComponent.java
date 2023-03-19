package ua.edu.khpi.infiz.ikm222d.component.impl;

import ua.edu.khpi.infiz.ikm222d.Mediator;
import ua.edu.khpi.infiz.ikm222d.component.Component;

public class TextFieldComponent extends Component {

	private String value = "";

	public TextFieldComponent(Mediator mediator) {
		super(mediator);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
		mediator.notifyComponent(this, VALUE_CHANGED);
	}

}
