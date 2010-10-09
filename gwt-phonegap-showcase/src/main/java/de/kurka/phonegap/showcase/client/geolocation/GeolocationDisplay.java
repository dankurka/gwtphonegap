package de.kurka.phonegap.showcase.client.geolocation;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

import de.kurka.phonegap.showcase.client.geolocation.GeolocationPresenter.Display;

public class GeolocationDisplay implements Display {

	private FlowPanel main;
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
		main = new FlowPanel();

		main.add(new HTML("Geolocation: "));

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

		main.add(grid);

		button = new Button();
		main.add(button);

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
	 * @see de.kurka.phonegap.showcase.client.geolocation.GeolocationPresenter.Display#setTime(java.lang.String)
	 */
	@Override
	public void setTime(String time) {
		timeLabel.setHTML(time);

	}

}
