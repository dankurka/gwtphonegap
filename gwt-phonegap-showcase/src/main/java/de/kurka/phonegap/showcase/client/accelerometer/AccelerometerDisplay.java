package de.kurka.phonegap.showcase.client.accelerometer;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import de.kurka.phonegap.showcase.client.accelerometer.AccelerometerPresenter.Display;

public class AccelerometerDisplay extends Composite implements Display {

	private FlowPanel main;
	private Grid grid;
	private Label xLabel;
	private Label yLabel;
	private Label zLabel;
	private Button button;

	public AccelerometerDisplay() {

		main = new FlowPanel();

		main.add(new Label("GWT-Phonegap Accelerometer Demo"));

		grid = new Grid(3, 2);

		grid.setWidget(0, 0, new HTML("X-Axis"));
		grid.setWidget(1, 0, new HTML("Y-Axis"));
		grid.setWidget(2, 0, new HTML("Z-Axis"));

		xLabel = new Label();
		grid.setWidget(0, 1, xLabel);

		yLabel = new Label();
		grid.setWidget(1, 1, yLabel);
		zLabel = new Label();
		grid.setWidget(2, 1, zLabel);

		main.add(grid);

		button = new Button("start/stop");
		main.add(button);

		initWidget(main);

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

	public HasClickHandlers getStartStopButton() {
		return button;
	}

	@Override
	public Widget asWidget() {
		return this;
	}

}
