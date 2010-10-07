package de.kurka.phonegap.showcase.client.notification;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

import de.kurka.phonegap.client.PhoneGap;

public class NotificationPresenter {
	private final Display display;
	private final PhoneGap phoneGap;

	public NotificationPresenter(Display display, PhoneGap phoneGap) {
		this.display = display;
		this.phoneGap = phoneGap;

		bind();

	}

	private void bind() {
		display.getAlertButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				phoneGap.getNotification().alert("daniel says hi", "gwt-phonegap", "buttonText");

			}
		});

		display.getBeepButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				phoneGap.getNotification().beep(2);

			}
		});

		display.getVibrateButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				phoneGap.getNotification().vibrate(2500);

			}
		});

	}

	public interface Display {

		public Widget asWidget();

		public HasClickHandlers getBeepButton();

		public HasClickHandlers getAlertButton();

		public HasClickHandlers getVibrateButton();

	}

	public Display getDisplay() {
		return display;
	}
}
