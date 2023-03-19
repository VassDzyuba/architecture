package ua.edu.khpi.infiz.ikm222d;

import java.time.LocalTime;

import ua.edu.khpi.infiz.ikm222d.dialog.FlowerOrderingDialog;

public class Lab2PatternsMediator {

	public static void main(final String[] args) {
		new Lab2PatternsMediator().demo();
	}

	private void demo() {
		final FlowerOrderingDialog dialog = new FlowerOrderingDialog();
		// initial
		dialog.show();
		// set time to 19:00
		dialog.getDeliveryTime().setValue(LocalTime.of(19, 0));
		dialog.show();
	}

}
