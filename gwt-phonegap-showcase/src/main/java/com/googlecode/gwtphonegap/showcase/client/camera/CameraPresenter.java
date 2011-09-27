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
package com.googlecode.gwtphonegap.showcase.client.camera;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.camera.PictureCallback;
import com.googlecode.gwtphonegap.client.camera.PictureOptions;


public class CameraPresenter {

	private final Display display;
	private final PhoneGap phoneGap;

	public CameraPresenter(Display display, PhoneGap phoneGap) {
		this.display = display;
		this.phoneGap = phoneGap;

		bind();
	}

	private void bind() {
		display.getButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				takePicture();
			}
		});
	}

	private void takePicture() {

		PictureOptions options = new PictureOptions(25);
		options.setDestinationType(PictureOptions.DESTINATION_TYPE_DATA_URL);
		options.setSourceType(PictureOptions.PICTURE_SOURCE_TYPE_CAMERA);

		phoneGap.getCamera().getPicture(options, new PictureCallback() {

			@Override
			public void onSuccess(String data) {
				display.setImageData("data:image/jpeg;base64," + data);
			}

			@Override
			public void onFailure() {
				Window.alert("failure");

			}
		});
	}

	public interface Display {
		public Widget asWidget();

		public HasClickHandlers getButton();

		public void setImageData(String data);
	}

	public Display getDisplay() {
		return display;
	}
}
