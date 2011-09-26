/*
 * Copyright 2011 Daniel Kurka
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
package de.kurka.phonegap.client.log;

import java.util.logging.Handler;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.logging.client.NullLogHandler;

/**
 * @author Daniel Kurka
 * 
 */
public class PhoneGapLogStandardImpl implements PhoneGapLog {

	private static final Logger rootLogger = Logger.getLogger("");

	private PhoneGapRemoteBatchLogHandler remoteHandler;

	public PhoneGapLogStandardImpl() {
		Handler consoleHandler = GWT.create(PhoneGapConsoleLogHandler.class);
		if (!(consoleHandler instanceof NullLogHandler)) {
			rootLogger.addHandler(consoleHandler);
		}

		Handler remoteHandler = GWT.create(PhoneGapRemoteBatchLogHandler.class);
		if (!(remoteHandler instanceof NullLogHandler)) {
			rootLogger.addHandler(remoteHandler);
		}

		if (remoteHandler instanceof PhoneGapRemoteBatchLogHandler) {
			this.remoteHandler = (PhoneGapRemoteBatchLogHandler) remoteHandler;
		}
	}

	@Override
	public void setRemoteLogServiceUrl(String url) {
		if (remoteHandler != null)
			remoteHandler.setServerUrl(url);
	}

	/**
	 * @param uuid
	 */
	public void setClientId(String uuid) {
		if (remoteHandler != null)
			remoteHandler.setClientId(uuid);

	}

}
