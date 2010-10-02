package de.kurka.phonegap.showcase.client.device;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

import de.kurka.phonegap.showcase.client.device.DevicePresenter.Display;

public class DeviceDisplay implements Display {

	private FlowPanel main;
	private Grid grid;
	private HTML uuidLabel;
	private HTML nameLabel;
	private HTML platformLabel;
	private HTML versionLabel;
	private HTML phoneGapVersionLabel;

	public DeviceDisplay() {
		main = new FlowPanel();

		main.add(new HTML("Device Info"));

		grid = new Grid(5, 2);

		grid.setWidget(0, 0, new HTML("UUID: "));
		grid.setWidget(1, 0, new HTML("Name: "));
		grid.setWidget(2, 0, new HTML("Platform: "));
		grid.setWidget(3, 0, new HTML("Version: "));
		grid.setWidget(4, 0, new HTML("PhoneGap Version: "));

		uuidLabel = new HTML();
		grid.setWidget(0, 1, uuidLabel);
		nameLabel = new HTML();
		grid.setWidget(1, 1, nameLabel);
		platformLabel = new HTML();
		grid.setWidget(2, 1, platformLabel);
		versionLabel = new HTML();
		grid.setWidget(3, 1, versionLabel);
		phoneGapVersionLabel = new HTML();
		grid.setWidget(4, 1, phoneGapVersionLabel);

		main.add(grid);
	}

	@Override
	public Widget asWidget() {
		return main;
	}

	@Override
	public void setUUID(String id) {
		uuidLabel.setHTML(id);

	}

	@Override
	public void setPlatform(String platform) {
		platformLabel.setHTML(platform);

	}

	@Override
	public void setPhoneGapVersion(String phoneGapVersion) {
		phoneGapVersionLabel.setHTML(phoneGapVersion);

	}

	@Override
	public void setName(String name) {
		nameLabel.setHTML(name);

	}

	@Override
	public void setVersion(String version) {
		versionLabel.setHTML(version);

	}
}
