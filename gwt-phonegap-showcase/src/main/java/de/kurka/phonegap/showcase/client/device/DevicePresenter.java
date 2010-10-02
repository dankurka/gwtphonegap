package de.kurka.phonegap.showcase.client.device;

import com.google.gwt.user.client.ui.Widget;

import de.kurka.phonegap.client.PhoneGap;

public class DevicePresenter {

	private final Display display;
	private final PhoneGap phoneGap;

	public DevicePresenter(Display display, PhoneGap phoneGap) {
		this.display = display;
		this.phoneGap = phoneGap;

		getDeviceInfos();

	}

	private void getDeviceInfos() {

		display.setVersion(phoneGap.getDevice().getVersion());
		display.setName(phoneGap.getDevice().getName());
		display.setPhoneGapVersion(phoneGap.getDevice().getPhoneGapVersion());
		display.setPlatform(phoneGap.getDevice().getPlatform());
		display.setUUID(phoneGap.getDevice().getUuid());

	}

	public interface Display {
		public Widget asWidget();

		public void setUUID(String uuid);

		public void setPlatform(String platform);

		public void setPhoneGapVersion(String phoneGapVersion);

		public void setName(String name);

		public void setVersion(String version);
	}

	public Display getDisplay() {
		return display;
	}

}
