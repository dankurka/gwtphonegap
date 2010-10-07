package de.kurka.phonegap.showcase.client.network;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

import de.kurka.phonegap.client.PhoneGap;
import de.kurka.phonegap.client.network.Network;
import de.kurka.phonegap.client.network.NetworkReachable;
import de.kurka.phonegap.client.network.NetworkReachableCallback;
import de.kurka.phonegap.client.network.NetworkReachableOptions;

public class NetworkPresenter {

	private final Display display;
	private final PhoneGap phoneGap;

	public NetworkPresenter(Display display, PhoneGap phoneGap) {
		this.display = display;
		this.phoneGap = phoneGap;

		bind();

	}

	public interface Display {
		public Widget asWidget();

		public HasClickHandlers getButton();

		public HasValue<String> getHost();

		public HasHTML getOutput();

	}

	private void bind() {
		display.getButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String value = display.getHost().getValue();

				NetworkReachableOptions options = new NetworkReachableOptions();

				options.setHostname(value);

				display.getOutput().setHTML("testing");
				phoneGap.getNetwork().isNetWorkReachable(options, new NetworkReachableCallback() {

					@Override
					public void onSuccess(NetworkReachable networkReachable) {

						int networkCode = networkReachable.getLocalWiFiConnectionStatus();

						switch (networkCode) {
						case Network.NETWORK_STATUS_NOT_REACHABLE:
							display.getOutput().setHTML("not reachable");
							break;

						case Network.NETWORK_STATUS_REACHABLE_VIA_CARRIER_DATA_NETWORK:
							display.getOutput().setHTML("reachable by carrier");
							break;

						case Network.NETWORK_STATUS_REACHABLE_VIA_WIFI_NETWORK:
							display.getOutput().setHTML("reachable by wifi");
							break;

						default:
							display.getOutput().setHTML("error");
							break;
						}

					}
				});
			}
		});

	}

	public Display getDisplay() {
		return display;
	}
}
