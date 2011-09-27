package com.googlecode.gwtphonegap.showcase.client.contact;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ContactDisplay implements ContactPresenter.Display {

	private DisclosurePanel main;
	private FlowPanel content;

	private Button findButton;
	private HTML result;
	private TextBox findValue;
	private TextBox createValue;
	private Button createButton;
	private HTML createResult;

	public ContactDisplay() {
		main = new DisclosurePanel("Contact");

		content = new FlowPanel();

		findValue = new TextBox();
		content.add(findValue);

		findButton = new Button("find Contact");
		content.add(findButton);

		result = new HTML();
		content.add(result);

		main.add(content);

		FlowPanel createPanel = new FlowPanel();

		createValue = new TextBox();
		createPanel.add(createValue);

		createButton = new Button("create Contact");
		createPanel.add(createButton);

		createResult = new HTML();
		createPanel.add(createResult);

		content.add(createPanel);

	}

	@Override
	public Widget asWidget() {
		return main;
	}

	@Override
	public HasClickHandlers getFindButton() {
		return findButton;
	}

	@Override
	public HasValue<String> getFindValue() {
		return findValue;
	}

	@Override
	public HasHTML getFoundContacts() {
		return result;
	}

	@Override
	public HasClickHandlers getCreateButton() {
		return createButton;
	}

	@Override
	public HasValue<String> getCreateValue() {
		return createValue;
	}

	@Override
	public HasHTML getCreateFeedback() {
		return createResult;
	}

}
