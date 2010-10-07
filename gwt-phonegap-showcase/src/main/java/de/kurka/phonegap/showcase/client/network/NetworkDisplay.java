package de.kurka.phonegap.showcase.client.network;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import de.kurka.phonegap.showcase.client.network.NetworkPresenter.Display;

public class NetworkDisplay implements Display {

	private FlowPanel main;
	private TextBox textBox;
	private Button button;
	private HTML result;

	public NetworkDisplay() {
		main = new FlowPanel();
		main.add(new HTML("Network"));

		textBox = new TextBox();
		main.add(textBox);

		textBox.setValue("www.google.com");

		button = new Button("test network");
		main.add(button);

		result = new HTML();
		main.add(result);

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
	public HasValue<String> getHost() {
		return textBox;
	}

	@Override
	public HasHTML getOutput() {
		return result;
	}

}
