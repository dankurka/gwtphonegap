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
package com.googlecode.gwtphonegap.showcase.client.geolocation;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtphonegap.showcase.client.geolocation.GeolocationPresenter.Display;


public class GeolocationDisplay implements Display {

	private DisclosurePanel main;
	private FlowPanel content;
	private Grid grid;
	private HTML lontitudeLabel;
	private HTML latitudeLabel;
	private HTML altitudeLabel;
	private HTML horizontalAccuracyLabel;
	private HTML verticalAccuracyLabel;
	private HTML altitudeAccuracyLabel;
	private HTML headingLabel;
	private HTML speedLabel;
	private HTML timeLabel;
	private Button button;

	public GeolocationDisplay() {

		main = new DisclosurePanel("Geolocation");

		content = new FlowPanel();

		grid = new Grid(9, 2);

		grid.setWidget(0, 0, new HTML("Longitude: "));
		grid.setWidget(1, 0, new HTML("Latitude: "));
		grid.setWidget(2, 0, new HTML("Altitude: "));
		grid.setWidget(3, 0, new HTML("Horizontal Accuracy: "));
		grid.setWidget(4, 0, new HTML("Vertical Accuracy: "));
		grid.setWidget(5, 0, new HTML("Altitude Accuracy: "));
		grid.setWidget(6, 0, new HTML("Heading: "));
		grid.setWidget(7, 0, new HTML("Speed: "));
		grid.setWidget(8, 0, new HTML("Time: "));

		lontitudeLabel = new HTML();
		grid.setWidget(0, 1, lontitudeLabel);
		latitudeLabel = new HTML();
		grid.setWidget(1, 1, latitudeLabel);
		altitudeLabel = new HTML();
		grid.setWidget(2, 1, altitudeLabel);
		horizontalAccuracyLabel = new HTML();
		grid.setWidget(3, 1, horizontalAccuracyLabel);
		verticalAccuracyLabel = new HTML();
		grid.setWidget(4, 1, verticalAccuracyLabel);
		altitudeAccuracyLabel = new HTML();
		grid.setWidget(5, 1, altitudeAccuracyLabel);
		headingLabel = new HTML();
		grid.setWidget(6, 1, headingLabel);
		speedLabel = new HTML();
		grid.setWidget(7, 1, speedLabel);
		timeLabel = new HTML();
		grid.setWidget(8, 1, timeLabel);

		content.add(grid);

		button = new Button();
		content.add(button);

		main.add(content);

	}

	@Override
	public Widget asWidget() {
		return main;
	}

	@Override
	public void setSpeed(double speed) {
		speedLabel.setHTML("" + speed);

	}

	@Override
	public void setLongitude(double longitude) {
		lontitudeLabel.setHTML("" + longitude);

	}

	@Override
	public void setLatitude(double latitude) {
		latitudeLabel.setHTML("" + latitude);

	}

	@Override
	public void setHeading(double heading) {
		headingLabel.setHTML("" + heading);

	}

	@Override
	public void setAltitudeAccuracy(double altitudeAccuracy) {
		altitudeAccuracyLabel.setHTML("" + altitudeAccuracy);

	}

	@Override
	public void setAltitude(double altitude) {
		altitudeLabel.setHTML("" + altitude);

	}

	@Override
	public HasClickHandlers getStartStopButton() {
		return button;
	}

	@Override
	public void setButtonText(String string) {
		button.setText(string);

	}

	@Override
	public void setVerticalAccuracy(double verticalAccuracy) {
		verticalAccuracyLabel.setHTML("" + verticalAccuracy);

	}

	@Override
	public void setHorizontalAccuracy(double horizontalAccuracy) {
		horizontalAccuracyLabel.setHTML("" + horizontalAccuracy);

	}

	/* (non-Javadoc)
	 * @see com.googlecode.gwtphonegap.showcase.client.geolocation.GeolocationPresenter.Display#setTime(java.lang.String)
	 */
	@Override
	public void setTime(String time) {
		timeLabel.setHTML(time);

	}

}
