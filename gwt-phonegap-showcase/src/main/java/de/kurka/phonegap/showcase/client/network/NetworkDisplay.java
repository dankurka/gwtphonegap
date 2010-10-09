/*
 * Copyright 2010 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package de.kurka.phonegap.showcase.client.network;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import de.kurka.phonegap.showcase.client.network.NetworkPresenter.Display;

public class NetworkDisplay implements Display {

	private DisclosurePanel main;
	private FlowPanel content;
	private TextBox textBox;
	private Button button;
	private HTML result;

	public NetworkDisplay() {
		main = new DisclosurePanel("Network");

		content = new FlowPanel();

		textBox = new TextBox();
		content.add(textBox);

		textBox.setValue("www.google.com");

		button = new Button("test network");
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
	public HasValue<String> getHost() {
		return textBox;
	}

	@Override
	public HasHTML getOutput() {
		return result;
	}

}
