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
