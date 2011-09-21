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
package de.kurka.phonegap.server.file;

import java.io.File;
import java.util.logging.Logger;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.kurka.phonegap.client.file.FileError;
import de.kurka.phonegap.client.file.browser.FileErrorException;
import de.kurka.phonegap.client.file.browser.FileSystemBrowserImpl;
import de.kurka.phonegap.client.file.browser.service.FileRemoteService;

/**
 * This remote servlet simulates the file API of phonegap in dev mode
 * 
 * the implemenentation is extremely insecure and has to be enabled by starting
 * hosted mode with -XinsecurePhoneGapFileApi=
 * 
 * @author Daniel Kurka
 * 
 */
public class FileRemoteServiceServlet extends RemoteServiceServlet implements FileRemoteService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3911396342592183802L;

	private Logger logger = Logger.getLogger(getClass().getName());

	private boolean useInsecureApi;

	private String path;

	public FileRemoteServiceServlet() {
		path = System.getProperty("phonegapFilePath");

		String property = System.getProperty("insecurePhoneGapFileApi");
		useInsecureApi = "true".equals(property);
		if (useInsecureApi) {
			logger.warning("insecure file api is enabled - only use this in dev mode");
			logger.warning("using path: '" + path + "'");
		}

	}

	@Override
	public FileSystemBrowserImpl requestFileSystem(int fileSystemType, int size) throws FileErrorException {
		if (!useInsecureApi) {
			throw new FileErrorException(FileError.SECURITY_ERR);
		}

		File file = new File(path);
		if (!file.exists()) {
			throw new FileErrorException(FileError.PATH_EXISTS_ERR);
		}

		return new FileSystemBrowserImpl();
	}

}
