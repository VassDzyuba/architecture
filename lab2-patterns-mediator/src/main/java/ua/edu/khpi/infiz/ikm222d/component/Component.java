package ua.edu.khpi.infiz.ikm222d.component;

import ua.edu.khpi.infiz.ikm222d.Mediator;

public abstract class Component {

	public static final String VALUE_CHANGED = "value_changed";

	protected final Mediator mediator;
	protected boolean visible;

	public Component(final Mediator mediator) {
		this.mediator = mediator;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(final boolean visible) {
		this.visible = visible;
	}

}
