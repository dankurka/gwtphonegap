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
package com.googlecode.gwtphonegap.showcase.client.notification;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtphonegap.showcase.client.notification.NotificationPresenter.Display;


public class NotificationDisplay implements Display {

	private DisclosurePanel main;
	private FlowPanel content;
	private Button alertButton;
	private Button vibrateButton;
	private Button beepButton;
	private Button confirmButton;

	public NotificationDisplay() {
		main = new DisclosurePanel("Notification");

		content = new FlowPanel();

		content.add(new HTML("Notification"));

		alertButton = new Button("Alert");
		content.add(alertButton);

		confirmButton = new Button("Confirm");
		content.add(confirmButton);

		vibrateButton = new Button("Vibrate");
		content.add(vibrateButton);

		beepButton = new Button("Beep");
		content.add(beepButton);

		main.add(content);
	}

	@Override
	public HasClickHandlers getBeepButton() {
		return beepButton;
	}

	@Override
	public HasClickHandlers getAlertButton() {
		return alertButton;
	}

	@Override
	public HasClickHandlers getVibrateButton() {
		return vibrateButton;
	}

	@Override
	public Widget asWidget() {
		return main;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.gwtphonegap.showcase.client.notification.NotificationPresenter.Display#getConfirmButton()
	 */
	@Override
	public HasClickHandlers getConfirmButton() {
		return confirmButton;
	}

}
