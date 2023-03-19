package ua.edu.khpi.infiz.ikm222d.component.impl;

import java.time.LocalTime;

import ua.edu.khpi.infiz.ikm222d.Mediator;
import ua.edu.khpi.infiz.ikm222d.component.Component;

public class TimeComponent extends Component {

	private LocalTime value = LocalTime.now();

	public TimeComponent(Mediator mediator) {
		super(mediator);
	}

	public LocalTime getValue() {
		return value;
	}

	public void setValue(LocalTime value) {
		this.value = value;
		mediator.notifyComponent(this, VALUE_CHANGED);
	}

}
