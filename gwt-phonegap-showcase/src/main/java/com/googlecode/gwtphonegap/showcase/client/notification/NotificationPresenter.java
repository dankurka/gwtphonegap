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

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.notification.AlertCallback;
import com.googlecode.gwtphonegap.client.notification.ConfirmCallback;


public class NotificationPresenter {
	private final Display display;
	private final PhoneGap phoneGap;

	public NotificationPresenter(Display display, PhoneGap phoneGap) {
		this.display = display;
		this.phoneGap = phoneGap;

		bind();

	}

	private void bind() {
		display.getAlertButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				phoneGap.getNotification().alert("daniel says hi", new AlertCallback() {

					@Override
					public void onOkButtonClicked() {

					}
				}, "gwt-phonegap", "buttonText");

			}
		});

		display.getBeepButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				phoneGap.getNotification().beep(2);

			}
		});

		display.getVibrateButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				phoneGap.getNotification().vibrate(2500);

			}
		});

		display.getConfirmButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				phoneGap.getNotification().confirm("question?", new ConfirmCallback() {

					@Override
					public void onConfirm(int button) {

					}
				}, "gwt-phonegap");

			}
		});

	}

	public interface Display {

		public Widget asWidget();

		public HasClickHandlers getBeepButton();

		public HasClickHandlers getAlertButton();

		public HasClickHandlers getConfirmButton();

		public HasClickHandlers getVibrateButton();

	}

	public Display getDisplay() {
		return display;
	}
}
