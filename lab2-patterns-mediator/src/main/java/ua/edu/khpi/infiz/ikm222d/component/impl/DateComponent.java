package ua.edu.khpi.infiz.ikm222d.component.impl;

import java.time.LocalDate;

import ua.edu.khpi.infiz.ikm222d.Mediator;
import ua.edu.khpi.infiz.ikm222d.component.Component;

public class DateComponent extends Component {

	private LocalDate value = LocalDate.now();

	public DateComponent(Mediator mediator) {
		super(mediator);
	}

	public void setValue(LocalDate value) {
		this.value = value;
		mediator.notifyComponent(this, VALUE_CHANGED);
	}

	public LocalDate getValue() {
		return value;
	}

}
