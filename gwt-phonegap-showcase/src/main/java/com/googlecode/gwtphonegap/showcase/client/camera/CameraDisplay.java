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

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtphonegap.showcase.client.camera.CameraPresenter.Display;


public class CameraDisplay implements Display {

	private Button button;
	private DisclosurePanel main;
	private FlowPanel content;
	private Image image;

	public CameraDisplay() {
		main = new DisclosurePanel("Camera");

		content = new FlowPanel();
		main.add(content);
		button = new Button("take foto");
		content.add(button);
		image = new Image();

		content.add(image);

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
	public void setImageData(String data) {
		image.setUrl(data);

	}

}
