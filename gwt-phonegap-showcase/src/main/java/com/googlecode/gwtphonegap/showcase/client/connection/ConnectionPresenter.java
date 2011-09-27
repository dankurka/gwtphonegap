package com.googlecode.gwtphonegap.showcase.client.connection;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtphonegap.client.PhoneGap;

public class ConnectionPresenter {

	private Display display;
	private PhoneGap phoneGap;

	public ConnectionPresenter(Display display, PhoneGap phoneGap) {
		this.display = display;
		this.phoneGap = phoneGap;

		bind();

	}

	public interface Display {
		public Widget asWidget();

		public HasClickHandlers getButton();

		public HasHTML getOutput();

	}

	private void bind() {
		display.getButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				display.getOutput().setHTML(phoneGap.getConnection().getType());

			}
		});

	}

	public Display getDisplay() {
		return display;
	}
}
