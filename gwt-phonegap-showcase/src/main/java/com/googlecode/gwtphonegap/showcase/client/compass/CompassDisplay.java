package com.googlecode.gwtphonegap.showcase.client.compass;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class CompassDisplay implements CompassPresenter.Display {

	private DisclosurePanel main;
	private FlowPanel content;
	private Button button;
	private HTML value;

	public CompassDisplay() {
		main = new DisclosurePanel("Compass");

		content = new FlowPanel();

		button = new Button();
		content.add(button);

		value = new HTML();
		content.add(value);
		main.add(content);
	}

	@Override
	public Widget asWidget() {
		return main;
	}

	@Override
	public HasClickHandlers getStartStopButton() {
		return button;
	}

	@Override
	public HasText getStartStopText() {
		return button;
	}

	@Override
	public HasHTML compassValue() {
		return value;
	}

}
