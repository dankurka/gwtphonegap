package com.googlecode.gwtphonegap.showcase.client.media;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class MediaDisplay implements MediaPresenter.Display {

	private DisclosurePanel main;
	private FlowPanel content;

	private Button result;
	private HTML position;

	public MediaDisplay() {
		main = new DisclosurePanel("Media");

		content = new FlowPanel();

		position = new HTML("Make some events by pressing buttons or resume <br/>");
		content.add(position);

		result = new Button();
		content.add(result);

		main.add(content);

	}

	@Override
	public Widget asWidget() {
		return main;
	}

	@Override
	public HasHTML getPosition() {
		return position;
	}

	@Override
	public HasClickHandlers getPlayPauseButton() {
		return result;
	}

	@Override
	public HasText getPlayPauseButtonText() {
		return result;
	}

}
