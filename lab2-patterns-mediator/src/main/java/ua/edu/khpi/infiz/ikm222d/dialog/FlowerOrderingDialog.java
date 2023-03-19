package ua.edu.khpi.infiz.ikm222d.dialog;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import ua.edu.khpi.infiz.ikm222d.Mediator;
import ua.edu.khpi.infiz.ikm222d.component.Component;
import ua.edu.khpi.infiz.ikm222d.component.impl.ButtonComponent;
import ua.edu.khpi.infiz.ikm222d.component.impl.CheckboxComponent;
import ua.edu.khpi.infiz.ikm222d.component.impl.DateComponent;
import ua.edu.khpi.infiz.ikm222d.component.impl.TextFieldComponent;
import ua.edu.khpi.infiz.ikm222d.component.impl.TimeComponent;

public class FlowerOrderingDialog implements Mediator {

	private final DateComponent deliveryDate = new DateComponent(this);
	private final TimeComponent deliveryTime = new TimeComponent(this);
	private final CheckboxComponent isRecipientNotMe = new CheckboxComponent(this);
	private final TextFieldComponent recipientName = new TextFieldComponent(this);
	private final TextFieldComponent recipientPhoneNumber = new TextFieldComponent(this);
	private final CheckboxComponent isSelfDelivery = new CheckboxComponent(this);
	private final ButtonComponent submitButton = new ButtonComponent(this);

	public FlowerOrderingDialog() {
		deliveryDate.setVisible(true);
		deliveryTime.setVisible(true);
		isRecipientNotMe.setVisible(true);
		isSelfDelivery.setVisible(true);
		submitButton.setVisible(true);
	}

	public DateComponent getDeliveryDate() {
		return deliveryDate;
	}

	public TimeComponent getDeliveryTime() {
		return deliveryTime;
	}

	public CheckboxComponent getIsRecipientNotMe() {
		return isRecipientNotMe;
	}

	public TextFieldComponent getRecipientName() {
		return recipientName;
	}

	public TextFieldComponent getRecipientPhoneNumber() {
		return recipientPhoneNumber;
	}

	public CheckboxComponent getIsSelfDelivery() {
		return isSelfDelivery;
	}

	public ButtonComponent getSubmitButton() {
		return submitButton;
	}

	public void notifyComponent(final Component component, final String event) {
		if (component == deliveryDate) {
			notifyDeliveryDateTime();
		} else if (component == deliveryTime) {
			notifyDeliveryDateTime();
		} else if (component == isRecipientNotMe) {
			notifyRecipientNotMe();
		} else if (component == isSelfDelivery) {
			notifySelfDelivery();
		} else if (component == submitButton) {
			notifySubmitButton();
		}
	}

	private void notifySubmitButton() {
		if (isSelfDelivery.isChecked() == false && isRecipientNotMe.isChecked()) {
			if (recipientName.getValue().isEmpty() || recipientPhoneNumber.getValue().isEmpty()) {
				// error
			}
		}
	}

	private void notifySelfDelivery() {
		if (isSelfDelivery.isChecked()) {
			deliveryDate.setVisible(false);
			deliveryTime.setVisible(false);
			isRecipientNotMe.setVisible(false);
			recipientName.setVisible(false);
			recipientPhoneNumber.setVisible(false);
		} else {
			deliveryDate.setVisible(true);
			deliveryTime.setVisible(true);
			isRecipientNotMe.setVisible(true);
			notifyRecipientNotMe();
		}
	}

	private void notifyRecipientNotMe() {
		if (isRecipientNotMe.isChecked()) {
			recipientName.setVisible(true);
			recipientPhoneNumber.setVisible(true);
		} else {
			recipientName.setVisible(false);
			recipientPhoneNumber.setVisible(false);
		}
	}

	private void notifyDeliveryDateTime() {
		final LocalDate value = deliveryDate.getValue();
		if (isWeekend(value)) {
			final LocalTime weekendTimeFrom = LocalTime.of(10, 0);
			final LocalTime weekendTimeTo = LocalTime.of(16, 0);
			if (deliveryTime.getValue().isBefore(weekendTimeFrom)) {
				deliveryTime.setValue(weekendTimeFrom);
			}
			if (deliveryTime.getValue().isAfter(weekendTimeTo)) {
				deliveryTime.setValue(weekendTimeTo);
			}
		} else {
			final LocalTime timeFrom = LocalTime.of(8, 0);
			final LocalTime timeTo = LocalTime.of(20, 0);
			if (deliveryTime.getValue().isBefore(timeFrom)) {
				deliveryTime.setValue(timeFrom);
			}
			if (deliveryTime.getValue().isAfter(timeTo)) {
				deliveryTime.setValue(timeTo);
			}
		}
	}

	private boolean isWeekend(final LocalDate value) {
		return value.getDayOfWeek() == DayOfWeek.SATURDAY || value.getDayOfWeek() == DayOfWeek.SUNDAY;
	}

	public void show() {
		System.out.println("FlowerOrderingDialog");
		if (deliveryDate.isVisible()) {
			System.out.println("DeliveryDate: " + deliveryDate.getValue());
		}
		if (deliveryTime.isVisible()) {
			System.out.println("DeliveryTime: " + deliveryTime.getValue());
		}
		if (isRecipientNotMe.isVisible()) {
			System.out.println("Is recipient not me: " + isRecipientNotMe.isChecked());
		}
		if (recipientName.isVisible()) {
			System.out.println("Recipient name: " + recipientName.getValue());
		}
		if (recipientPhoneNumber.isVisible()) {
			System.out.println("Recipient phone number: " + recipientPhoneNumber.getValue());
		}
		if (isSelfDelivery.isVisible()) {
			System.out.println("Is self delivery: " + isSelfDelivery.isChecked());
		}
	}

}
