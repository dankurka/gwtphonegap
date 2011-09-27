package com.googlecode.gwtphonegap.showcase.client.connection;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.Widget;

public class ConnectionDisplay implements ConnectionPresenter.Display {

	private DisclosurePanel main;
	private FlowPanel content;

	private Button button;
	private HTML result;

	public ConnectionDisplay() {
		main = new DisclosurePanel("Connection");

		content = new FlowPanel();

		button = new Button("test connection");
		content.add(button);

		result = new HTML();
		content.add(result);

		main.add(content);

	}

	@Override
	public Widget asWidget() {
		return main;
	}

	@Override
	public HasClickHandlers getButton() {
		return button;
	}

	@Override
	public HasHTML getOutput() {
		return result;
	}

}
