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
package de.kurka.phonegap.server.log;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.google.gwt.logging.server.RemoteLoggingServiceUtil;
import com.google.gwt.logging.server.RemoteLoggingServiceUtil.RemoteLoggingException;
import com.google.gwt.logging.server.StackTraceDeobfuscator;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.kurka.phonegap.client.log.shared.PhoneGapLogService;

/**
 * @author Daniel Kurka
 * 
 */
public class PhoneGapLogServiceStandardImpl extends RemoteServiceServlet implements PhoneGapLogService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 736258979764201565L;

	@Override
	public String logOnServer(List<LogRecord> record) {
		String strongName = getPermutationStrongName();
		try {
			for (LogRecord logRecord : record) {

				RemoteLoggingServiceUtil.logOnServer(logRecord, strongName, deobfuscator, loggerNameOverride);
			}

		} catch (RemoteLoggingException e) {
			logger.log(Level.SEVERE, "Remote logging failed", e);
			return "Remote logging failed, check stack trace for details.";
		}
		return null;
	}

	// No deobfuscator by default
	private static StackTraceDeobfuscator deobfuscator = null;

	private static Logger logger = Logger.getLogger(RemoteServiceServlet.class.getName());

	private static String loggerNameOverride = null;

	/**
	 * By default, messages are logged to a logger that has the same name as the
	 * logger that created them on the client. If you want to log all messages
	 * from the client to a logger with another name, you can set the override
	 * using this method.
	 */
	public void setLoggerNameOverride(String override) {
		loggerNameOverride = override;
	}

	/**
	 * By default, this service does not do any deobfuscation. In order to do
	 * server side deobfuscation, you must copy the symbolMaps files to a
	 * directory visible to the server and set the directory using this method.
	 * 
	 * @param symbolMapsDir
	 */
	public void setSymbolMapsDirectory(String symbolMapsDir) {
		if (deobfuscator == null) {
			deobfuscator = new StackTraceDeobfuscator(symbolMapsDir);
		} else {
			deobfuscator.setSymbolMapsDirectory(symbolMapsDir);
		}
	}

}
