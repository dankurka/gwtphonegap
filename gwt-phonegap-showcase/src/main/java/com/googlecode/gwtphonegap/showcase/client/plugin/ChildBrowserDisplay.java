package com.googlecode.gwtphonegap.showcase.client.plugin;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class ChildBrowserDisplay implements ChildBrowserPresenter.Display {

	private DisclosurePanel main;
	private FlowPanel content;
	private Button button;

	public ChildBrowserDisplay() {
		main = new DisclosurePanel("ChildBrowser Plugin");

		content = new FlowPanel();
		main.add(content);

		button = new Button("browser");
		content.add(button);
	}

	@Override
	public Widget asWidget() {
		return main;
	}

	@Override
	public HasClickHandlers getShowButton() {
		return button;
	}

}
