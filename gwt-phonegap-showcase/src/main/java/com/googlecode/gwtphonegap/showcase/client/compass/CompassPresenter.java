package com.googlecode.gwtphonegap.showcase.client.compass;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.compass.CompassCallback;
import com.googlecode.gwtphonegap.client.compass.CompassHeading;
import com.googlecode.gwtphonegap.client.compass.CompassOptions;
import com.googlecode.gwtphonegap.client.compass.CompassWatcher;

public class CompassPresenter {

	private final Display display;
	private final PhoneGap phoneGap;
	private boolean start;
	private CompassWatcher watcher;

	public CompassPresenter(Display display, PhoneGap phoneGap) {
		this.display = display;
		this.phoneGap = phoneGap;
		this.start = true;

		bind();
	}

	private void bind() {

		display.getStartStopText().setText("Start");

		display.getStartStopButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				start = !start;
				if (start) {
					display.getStartStopText().setText("Start");
					display.compassValue().setHTML("");

					if (watcher != null) {
						phoneGap.getCompass().clearWatcher(watcher);
					}

				} else {
					display.getStartStopText().setText("Stop");

					watcher = phoneGap.getCompass().watchHeading(new CompassOptions(), new CompassCallback() {

						@Override
						public void onSuccess(CompassHeading heading) {
							display.compassValue().setHTML("value: " + heading.getMagneticHeading());

						}

						@Override
						public void onError() {
							display.compassValue().setHTML("Error");

						}
					});
				}

			}
		});

	}

	public interface Display {

		public Widget asWidget();

		public HasClickHandlers getStartStopButton();

		public HasText getStartStopText();

		public HasHTML compassValue();

	}

	public Widget getDisplay() {
		return display.asWidget();
	}

}
