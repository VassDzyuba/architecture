package ua.edu.khpi.infiz.ikm222d.component.impl;

import ua.edu.khpi.infiz.ikm222d.Mediator;
import ua.edu.khpi.infiz.ikm222d.component.Component;

public class CheckboxComponent extends Component {


	private boolean checked;

	public CheckboxComponent(Mediator mediator) {
		super(mediator);
	}

	public void check() {
		checked = !checked;
		mediator.notifyComponent(this, VALUE_CHANGED);
	}

	public boolean isChecked() {
		return checked;
	}

}
