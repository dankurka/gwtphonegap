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
package com.googlecode.gwtphonegap.showcase.client.accelerometer;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtphonegap.showcase.client.accelerometer.AccelerometerPresenter.Display;


public class AccelerometerDisplay implements Display {

	private DisclosurePanel main;
	private FlowPanel content;
	private Grid grid;
	private Label xLabel;
	private Label yLabel;
	private Label zLabel;
	private Button button;
	private Label timeLabel;

	public AccelerometerDisplay() {

		main = new DisclosurePanel("Accelerometer");

		content = new FlowPanel();

		grid = new Grid(4, 2);

		grid.setWidget(0, 0, new HTML("X-Axis"));
		grid.setWidget(1, 0, new HTML("Y-Axis"));
		grid.setWidget(2, 0, new HTML("Z-Axis"));
		grid.setWidget(3, 0, new HTML("Time"));

		xLabel = new Label();
		grid.setWidget(0, 1, xLabel);

		yLabel = new Label();
		grid.setWidget(1, 1, yLabel);
		zLabel = new Label();
		grid.setWidget(2, 1, zLabel);

		timeLabel = new Label();
		grid.setWidget(3, 1, timeLabel);

		content.add(grid);

		button = new Button("start/stop");
		content.add(button);

		main.add(content);

	}

	public void setXValue(String string) {
		xLabel.setText(string);

	}

	public void setYValue(String string) {
		yLabel.setText(string);

	}

	public void setZValue(String string) {
		zLabel.setText(string);

	}

	public void setTimeValue(String value) {
		timeLabel.setText(value);
	}

	public HasClickHandlers getStartStopButton() {
		return button;
	}

	@Override
	public Widget asWidget() {
		return main;
	}

}
