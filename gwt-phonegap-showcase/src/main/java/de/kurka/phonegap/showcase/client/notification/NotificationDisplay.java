package de.kurka.phonegap.showcase.client.notification;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

import de.kurka.phonegap.showcase.client.notification.NotificationPresenter.Display;

public class NotificationDisplay implements Display {

	private FlowPanel main;
	private Button alertButton;
	private Button vibrateButton;
	private Button beepButton;

	public NotificationDisplay() {
		main = new FlowPanel();

		main.add(new HTML("Notification"));

		alertButton = new Button("Alert");
		main.add(alertButton);

		vibrateButton = new Button("Vibrate");
		main.add(vibrateButton);

		beepButton = new Button("Beep");
		main.add(beepButton);
	}

	@Override
	public HasClickHandlers getBeepButton() {
		return beepButton;
	}

	@Override
	public HasClickHandlers getAlertButton() {
		return alertButton;
	}

	@Override
	public HasClickHandlers getVibrateButton() {
		return vibrateButton;
	}

	@Override
	public Widget asWidget() {
		return main;
	}

}
