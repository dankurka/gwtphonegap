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

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import com.google.gwt.core.client.GWT;
import com.google.gwt.logging.client.RemoteLogHandlerBase;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import de.kurka.phonegap.client.log.shared.PhoneGapLogService;
import de.kurka.phonegap.client.log.shared.PhoneGapLogServiceAsync;

/**
 * @author Daniel Kurka
 * 
 */
public class PhoneGapRemoteBatchLogHandler extends RemoteLogHandlerBase {

	private static final PhoneGapLogConfig config = GWT.create(PhoneGapLogConfig.class);
	private LinkedList<LogRecord> logRecords = new LinkedList<LogRecord>();
	private PhoneGapLogServiceAsync service;

	private int maxEntries;
	private PhoneGapLogThreshold threshold;

	public PhoneGapRemoteBatchLogHandler() {
		service = GWT.create(PhoneGapLogService.class);

		maxEntries = config.getMaxEntries();
		threshold = GWT.create(PhoneGapLogThreshold.class);

		setLevel(Level.ALL);

	}

	public int getMaxEntries() {
		return maxEntries;
	}

	public void setMaxEntries(int maxEntries) {
		if (maxEntries < 1) {
			throw new IllegalArgumentException("maxEntires >= 1");
		}
		this.maxEntries = maxEntries;
	}

	@Override
	public void publish(LogRecord record) {
		if (logRecords.size() > maxEntries) {
			logRecords.removeLast();
		}

		logRecords.addFirst(record);

		if (shouldPostLogsToServer(record)) {
			postLogsToServer();

		}
	}

	public void setServerUrl(String url) {
		((ServiceDefTarget) service).setServiceEntryPoint(url);
		serviceUrlSet = true;
	}

	protected void postLogsToServer() {
		if (!isServiceUrlSet()) {
			return;
		}
		service.logOnServer(logRecords, new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				wireLogger.severe("can not post logrecords to server");
			}

			@Override
			public void onSuccess(String result) {
				if (wireLogger.isLoggable(Level.FINE)) {
					wireLogger.fine("posted log records to server");
				}

			}
		});
		logRecords.clear();

	}

	private boolean serviceUrlSet;

	private boolean isServiceUrlSet() {
		return serviceUrlSet;
	}

	protected boolean shouldPostLogsToServer(LogRecord record) {
		int thres = threshold.getLevel().intValue();
		if (record.getLevel().intValue() >= thres) {
			return true;
		}
		return false;
	}

}
