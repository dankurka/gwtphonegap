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
import java.util.logging.Level;
import java.util.logging.LogRecord;

import com.google.gwt.logging.client.TextLogFormatter;

/**
 * @author Daniel Kurka
 * 
 */
public class PhoneGapConsoleLogHandler extends Handler {

	public PhoneGapConsoleLogHandler() {
		setFormatter(new TextLogFormatter(true));
		setLevel(Level.ALL);
	}

	@Override
	public void close() {
		// No action needed

	}

	@Override
	public void flush() {
		// No action needed

	}

	@Override
	public void publish(LogRecord record) {
		if (!isSupported() || !isLoggable(record)) {
			return;
		}
		String msg = getFormatter().format(record);
		log(msg);

	}

	protected native boolean isSupported() /*-{
		return ((window.console != null) && (window.console.firebug == null)
				&& (window.console.log != null) && (typeof (window.console.log) == 'function'));

	}-*/;

	protected native void log(String message) /*-{
		window.console.log(message);
	}-*/;

}
