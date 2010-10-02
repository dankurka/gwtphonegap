package de.kurka.phonegap.showcase.client;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import de.kurka.phonegap.showcase.client.MainPresenter.Display;

public class MainDisplay implements Display {

	private FlowPanel main;

	public MainDisplay() {
		main = new FlowPanel();

		main.add(new HTML("GWT Phonegap Showcase"));
	}

	@Override
	public Widget asWidget() {

		return main;
	}

	@Override
	public HasWidgets getContainer() {
		return main;
	}

}
