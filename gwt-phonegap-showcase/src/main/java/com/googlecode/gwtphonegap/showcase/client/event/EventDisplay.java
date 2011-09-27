package com.googlecode.gwtphonegap.showcase.client.event;

import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.Widget;

public class EventDisplay implements EventPresenter.Display {

	private DisclosurePanel main;
	private FlowPanel content;

	private HTML result;

	public EventDisplay() {
		main = new DisclosurePanel("Event");

		content = new FlowPanel();

		HTML label = new HTML("Make some events by pressing buttons or resume <br/>");
		content.add(label);

		result = new HTML();
		content.add(result);

		main.add(content);

	}

	@Override
	public Widget asWidget() {
		return main;
	}

	@Override
	public HasHTML getHTML() {
		return result;
	}

}
