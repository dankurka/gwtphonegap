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
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.kurka.phonegap.client.file.FileError;
import de.kurka.phonegap.client.file.browser.FileErrorException;
import de.kurka.phonegap.client.file.browser.dto.FileSystemDTO;
import de.kurka.phonegap.client.file.browser.dto.FileSystemEntryDTO;
import de.kurka.phonegap.client.file.browser.dto.FileWriterDTO;
import de.kurka.phonegap.client.file.browser.dto.MetaDataDTO;
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
	public FileSystemDTO requestFileSystem(int fileSystemType, int size) throws FileErrorException {

		ensureHostedMode();

		File file = new File(path);
		if (!file.exists()) {
			throw new FileErrorException(FileError.PATH_EXISTS_ERR);
		}

		FileSystemEntryDTO entryDTO = new FileSystemEntryDTO();
		entryDTO.setFile(false);
		entryDTO.setFullPath("/");
		entryDTO.setName("root");
		return new FileSystemDTO(entryDTO, "root");

	}

	/**
	 * @throws FileErrorException
	 */
	private void ensureHostedMode() throws FileErrorException {
		if (!useInsecureApi) {
			logger.severe("trying to use insecure phonegap api - but its not enabled -> start VM with -DinsecurePhoneGapFileApi=true -DphonegapFilePath=<path>");
			throw new FileErrorException(FileError.SECURITY_ERR);
		}

		logger.warning("using insecure phonegap file api, you should only use this in dev mode, never in production!");
	}

	@Override
	public ArrayList<FileSystemEntryDTO> readDirectory(String relativePath) throws FileErrorException {
		ensureHostedMode();
		File basePath = new File(path);

		File file = new File(basePath, relativePath);

		if (!file.isDirectory()) {
			throw new FileErrorException(FileErrorException.PATH_EXISTS_ERR);
		}

		File[] listFiles = file.listFiles();

		ArrayList<FileSystemEntryDTO> entries = new ArrayList<FileSystemEntryDTO>();

		for (int i = 0; i < listFiles.length; i++) {
			File listedFile = listFiles[i];

			FileSystemEntryDTO entry = new FileSystemEntryDTO();
			entry.setFile(listedFile.isFile());
			entry.setName(listedFile.getName());
			String absolutePath = listedFile.getAbsolutePath();
			String fullPath = absolutePath.substring(path.length(), absolutePath.length());
			entry.setFullPath(fullPath);
			entries.add(entry);
		}

		return entries;
	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.file.browser.service.FileRemoteService#getParent(java.lang.String)
	 */
	@Override
	public FileSystemEntryDTO getParent(String relativePath) throws FileErrorException {
		ensureHostedMode();
		File basePath = new File(path);

		File file = new File(basePath, relativePath);

		File parentFile = file.getParentFile();

		ensureLocalRoot(basePath, parentFile);

		try {
			String canonicalPath = parentFile.getCanonicalPath();
			String baseString = basePath.getCanonicalPath();

			FileSystemEntryDTO entry = new FileSystemEntryDTO();
			entry.setFile(parentFile.isFile());
			entry.setName(parentFile.getName());

			if (baseString.length() == canonicalPath.length()) {
				entry.setFullPath("/");
			} else {
				String fullPath = canonicalPath.substring(baseString.length(), canonicalPath.length());
				entry.setFullPath(fullPath);
			}
			return entry;
		} catch (IOException e) {
			throw new FileErrorException(FileError.INVALID_MODIFICATION_ERR);
		}

	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.file.browser.service.FileRemoteService#readAsText(java.lang.String)
	 */
	@Override
	public String readAsText(String relativePath) throws FileErrorException {
		File basePath = new File(path);

		File file = new File(basePath, relativePath);

		ensureLocalRoot(basePath, file);

		try {

			String fileContent = FileUtils.readFileToString(file);
			return fileContent;
		} catch (FileNotFoundException e) {
			logger.log(Level.WARNING, "error while reading file", e);
			throw new FileErrorException(FileError.NOT_FOUND_ERR);
		} catch (IOException e) {
			logger.log(Level.WARNING, "error while reading file", e);
			throw new FileErrorException(FileError.NOT_READABLE_ERR);
		}

	}

	private void ensureLocalRoot(File root, File newFile) throws FileErrorException {

		try {
			String canonicalPath = newFile.getCanonicalPath();
			String baseString = root.getCanonicalPath();
			if (!canonicalPath.startsWith(baseString)) {
				throw new FileErrorException(FileError.INVALID_MODIFICATION_ERR);
			}
		} catch (IOException e) {
			throw new FileErrorException(FileError.INVALID_MODIFICATION_ERR);
		}

	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.file.browser.service.FileRemoteService#createWriter(java.lang.String)
	 */
	@Override
	public FileWriterDTO createWriter(String relativePath, String name) throws FileErrorException {
		File basePath = new File(path);

		File file = new File(basePath, relativePath);

		ensureLocalRoot(basePath, file);

		if (!file.exists()) {
			throw new FileErrorException(FileError.NOT_FOUND_ERR);
		}

		long fileLength = file.length();
		long position = 0;

		return new FileWriterDTO(relativePath, name, fileLength, position);
	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.file.browser.service.FileRemoteService#writeFile(de.kurka.phonegap.client.file.browser.dto.FileWriterDTO)
	 */
	@Override
	public FileWriterDTO writeFile(FileWriterDTO fileWriterDTO, String content) throws FileErrorException {
		File basePath = new File(path);

		File file = new File(basePath, fileWriterDTO.getFullPath());

		ensureLocalRoot(basePath, file);

		if (!file.exists()) {
			throw new FileErrorException(FileError.NOT_FOUND_ERR);
		}

		try {

			String fileInString = FileUtils.readFileToString(file);

			StringBuffer buffer = new StringBuffer(fileInString);

			int position;

			if (fileWriterDTO.getPosition() == 0) {
				buffer.append(content);
				if (fileInString.length() > content.length()) {
					buffer.append(fileInString.substring(content.length()));
				}
				position = content.length();
			} else {
				int end = (int) fileWriterDTO.getPosition();
				if (end > fileInString.length()) {
					end = fileInString.length();
				}
				String start = fileInString.substring(0, end);
				buffer.append(start);

				buffer.append(content);

				int oldIndex = buffer.length();
				if (oldIndex < fileInString.length()) {
					buffer.append(fileInString.substring(oldIndex));
				}
				position = oldIndex;
			}

			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(content);
			fileWriter.close();

			fileWriterDTO.setPosition(position);
			fileWriterDTO.setSize(file.length());

			return fileWriterDTO;
		} catch (IOException e) {
			throw new FileErrorException(FileError.NO_MODIFICATION_ALLOWED_ERR);
		}

	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.file.browser.service.FileRemoteService#getMetaData(java.lang.String)
	 */
	@Override
	public MetaDataDTO getMetaData(String fullPath) throws FileErrorException {
		File basePath = new File(path);

		File file = new File(basePath, fullPath);

		ensureLocalRoot(basePath, file);

		return new MetaDataDTO(new Date(file.lastModified()));
	}
}
