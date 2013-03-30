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
package com.googlecode.gwtphonegap.server.file;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import com.googlecode.gwtphonegap.client.file.FileError;
import com.googlecode.gwtphonegap.client.file.browser.FileErrorException;
import com.googlecode.gwtphonegap.client.file.browser.dto.FileObjectDTO;
import com.googlecode.gwtphonegap.client.file.browser.dto.FileSystemDTO;
import com.googlecode.gwtphonegap.client.file.browser.dto.FileSystemEntryDTO;
import com.googlecode.gwtphonegap.client.file.browser.dto.FileWriterDTO;
import com.googlecode.gwtphonegap.client.file.browser.dto.FlagsDTO;
import com.googlecode.gwtphonegap.client.file.browser.dto.MetaDataDTO;
import com.googlecode.gwtphonegap.client.file.browser.service.FileRemoteService;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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

	private Map<String, String> mimeTypes;

	public FileRemoteServiceServlet() {
		path = System.getProperty("phonegapFilePath");

		String property = System.getProperty("insecurePhoneGapFileApi");
		useInsecureApi = "true".equals(property);
		if (useInsecureApi) {
			logger.warning("insecure file api is enabled - only use this in dev mode");
			logger.warning("using path: '" + path + "'");
		}

		mimeTypes = initMimeTypes();

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
	 * @see com.googlecode.gwtphonegap.client.file.browser.service.FileRemoteService#getParent(java.lang.String)
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
	 * @see com.googlecode.gwtphonegap.client.file.browser.service.FileRemoteService#readAsText(java.lang.String)
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

	@Override
	public String readAsDataUrl(String relativePath) throws FileErrorException {
		File basePath = new File(path);
		File file = new File(basePath, relativePath);
		ensureLocalRoot(basePath, file);

		try {
			byte[] binaryData = FileUtils.readFileToByteArray(file);
			byte[] base64 = Base64.encodeBase64(binaryData);

			String base64String = new String(base64, "UTF-8");
			String mimeType = guessMimeType(file);
			return "data:" + mimeType + ";base64," + base64String;

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
	 * @see com.googlecode.gwtphonegap.client.file.browser.service.FileRemoteService#createWriter(java.lang.String)
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
	 * @see com.googlecode.gwtphonegap.client.file.browser.service.FileRemoteService#writeFile(com.googlecode.gwtphonegap.client.file.browser.dto.FileWriterDTO)
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
      fileWriter.write(buffer.toString());
			fileWriter.close();

			fileWriterDTO.setPosition(position);
			fileWriterDTO.setSize(file.length());

			return fileWriterDTO;
		} catch (IOException e) {
			throw new FileErrorException(FileError.NO_MODIFICATION_ALLOWED_ERR);
		}

	}

	@Override
	public MetaDataDTO getMetaData(String fullPath) throws FileErrorException {
		File basePath = new File(path);

		File file = new File(basePath, fullPath);

		ensureLocalRoot(basePath, file);

		return new MetaDataDTO(new Date(file.lastModified()));
	}

	@Override
	public FileSystemEntryDTO getFile(String absPath, FlagsDTO flagsDTO) throws FileErrorException {
		File basePath = new File(path);

		File file = new File(basePath, absPath);

		ensureLocalRoot(basePath, file);

		if (flagsDTO.isCreate()) {
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					throw new FileErrorException(FileError.INVALID_MODIFICATION_ERR);
				}
			}
		}

		if (!file.exists()) {
			throw new FileErrorException(FileError.NOT_FOUND_ERR);
		}

		FileSystemEntryDTO dto = new FileSystemEntryDTO();
		dto.setFile(true);
		dto.setFullPath(absPath);
		dto.setName(file.getName());

		return dto;
	}

	@Override
	public Boolean removeDirectory(String fullPath) throws FileErrorException {
		File basePath = new File(path);

		File file = new File(basePath, fullPath);

		ensureLocalRoot(basePath, file);

		if (!file.isDirectory()) {
			throw new FileErrorException(FileError.INVALID_MODIFICATION_ERR);
		}

		file.delete();
		if (logger.isLoggable(Level.INFO)) {
			logger.info("Deleted: '" + file.getAbsolutePath() + "'");
		}

		return Boolean.TRUE;

	}

	/* (non-Javadoc)
	 * @see com.googlecode.gwtphonegap.client.file.browser.service.FileRemoteService#removeFile(java.lang.String)
	 */
	@Override
	public Boolean removeFile(String fullPath) throws FileErrorException {
		File basePath = new File(path);

		File file = new File(basePath, fullPath);

		ensureLocalRoot(basePath, file);

		if (!file.isFile()) {
			throw new FileErrorException(FileError.INVALID_MODIFICATION_ERR);
		}

		file.delete();
		if (logger.isLoggable(Level.INFO)) {
			logger.info("Deleted: '" + file.getAbsolutePath() + "'");
		}

		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.gwtphonegap.client.file.browser.service.FileRemoteService#moveFile(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public FileSystemEntryDTO moveFile(String fileFullPath, String directoryFullPath, String newName) throws FileErrorException {
		File basePath = new File(path);

		File directory = new File(basePath, directoryFullPath);

		ensureLocalRoot(basePath, directory);

		File oldFile = new File(basePath, fileFullPath);
		ensureLocalRoot(basePath, oldFile);

		File newFile = new File(directory, newName);
		ensureLocalRoot(basePath, newFile);

		if (newFile.exists()) {
			newFile.delete();
		}

		oldFile.renameTo(newFile);

		FileSystemEntryDTO entryDTO = new FileSystemEntryDTO();
		entryDTO.setFile(true);
		String absolutePath = newFile.getAbsolutePath();
		String fullPath = absolutePath.substring(path.length(), absolutePath.length());
		entryDTO.setFullPath(fullPath);
		entryDTO.setName(newFile.getName());

		if (logger.isLoggable(Level.INFO)) {
			logger.info("Moved: '" + fileFullPath + "' to '" + fullPath + "'");
		}

		return entryDTO;

	}

	@Override
	public FileSystemEntryDTO copyFile(String filePath, String dirPath, String newName) throws FileErrorException {
		File basePath = new File(path);

		File directory = new File(basePath, dirPath);

		ensureLocalRoot(basePath, directory);

		File oldFile = new File(basePath, filePath);
		ensureLocalRoot(basePath, oldFile);

		File newFile = new File(directory, newName);
		ensureLocalRoot(basePath, newFile);

		try {
			FileUtils.copyFile(oldFile, newFile);

			FileSystemEntryDTO entryDTO = new FileSystemEntryDTO();
			entryDTO.setFile(true);
			String absolutePath = newFile.getAbsolutePath();
			String fullPath = absolutePath.substring(path.length(), absolutePath.length());
			entryDTO.setFullPath(fullPath);
			entryDTO.setName(newFile.getName());

			if (logger.isLoggable(Level.INFO)) {
				logger.info("Copied: '" + filePath + "' to '" + fullPath + "'");
			}

			return entryDTO;

		} catch (IOException e) {
			logger.log(Level.WARNING, "error copying file", e);
			throw new FileErrorException(FileError.NO_MODIFICATION_ALLOWED_ERR);
		}

	}

	/* (non-Javadoc)
	 * @see com.googlecode.gwtphonegap.client.file.browser.service.FileRemoteService#getFileObject(java.lang.String)
	 */
	@Override
	public FileObjectDTO getFileObject(String fullPath) throws FileErrorException {
		File basePath = new File(path);

		File file = new File(basePath, fullPath);

		ensureLocalRoot(basePath, file);

		FileObjectDTO dto = new FileObjectDTO();
		dto.setFullPath(fullPath);
		dto.setLastModified(new Date(file.lastModified()));
		dto.setName(file.getName());
		dto.setSize(file.length());
		dto.setType(guessMimeType(file));
		return dto;

	}

	private String guessMimeType(File file) {
		String name = file.getName();

		int indexOf = name.lastIndexOf(".");

		if (indexOf == -1) {
			return "unknown/unknown";
		}

		String ending = name.substring(indexOf, name.length());

		String value = mimeTypes.get(ending);
		if (value == null) {
			return "unknown/unknown";
		}
		return value;

	}

	@Override
	public FileSystemEntryDTO getDirectory(String absPath, FlagsDTO flagsDTO) throws FileErrorException {
		File basePath = new File(path);

		File directory = new File(basePath, absPath);
		ensureLocalRoot(basePath, directory);

		if (!flagsDTO.isCreate()) {
			if (!directory.exists()) {
				throw new FileErrorException(FileError.INVALID_STATE_ERR);
			}
		} else {
			if (!directory.exists()) {
				directory.mkdir();
				if (logger.isLoggable(Level.INFO)) {
					logger.log(Level.INFO, "created directory: '" + absPath + "'");
				}
			}
		}

		FileSystemEntryDTO dto = new FileSystemEntryDTO();

		dto.setFile(false);
		dto.setFullPath(absPath);
		dto.setName(directory.getName());
		return dto;

	}

	@Override
	public Boolean removeRecursively(String fullPath) throws FileErrorException {
		File basePath = new File(path);

		File directory = new File(basePath, fullPath);
		ensureLocalRoot(basePath, directory);

		if (!directory.isDirectory()) {
			throw new FileErrorException(FileError.INVALID_STATE_ERR);
		}

		try {
			FileUtils.deleteDirectory(directory);
			if (logger.isLoggable(Level.INFO)) {
				logger.info("Deleted directory: '" + fullPath + "'");
			}

			return Boolean.TRUE;
		} catch (IOException e) {
			logger.log(Level.SEVERE, "can not delete directory", e);
			throw new FileErrorException(FileError.INVALID_STATE_ERR);
		}
	}

	@Override
	public FileSystemEntryDTO moveDirectory(String fullPath, String newParent, String newName) throws FileErrorException {
		File basePath = new File(path);

		File directory = new File(basePath, fullPath);
		ensureLocalRoot(basePath, directory);

		ensureLocalRoot(basePath, directory);

		File baseDir = new File(basePath, newParent);

		ensureLocalRoot(basePath, baseDir);

		File newDir = new File(baseDir, newParent);

		try {
			FileUtils.moveDirectoryToDirectory(directory, newDir, true);

			FileSystemEntryDTO dto = new FileSystemEntryDTO();

			dto.setFile(false);
			String absolutePath = newDir.getAbsolutePath();
			String tmpPath = absolutePath.substring(path.length(), absolutePath.length());
			dto.setFullPath(tmpPath);
			dto.setName(directory.getName());
			return dto;

		} catch (IOException e) {
			logger.log(Level.SEVERE, "can not move directory", e);
			throw new FileErrorException(FileError.INVALID_STATE_ERR);
		}

	}

	@Override
	public FileSystemEntryDTO copyDiretory(String fullPath, String newParent, String newName) throws FileErrorException {
		File basePath = new File(path);

		File directory = new File(basePath, fullPath);
		ensureLocalRoot(basePath, directory);

		ensureLocalRoot(basePath, directory);

		File baseDir = new File(basePath, newParent);

		ensureLocalRoot(basePath, baseDir);

		File newDir = new File(baseDir, newParent);

		try {
			FileUtils.copyDirectory(directory, newDir);

			FileSystemEntryDTO dto = new FileSystemEntryDTO();

			dto.setFile(false);
			String absolutePath = newDir.getAbsolutePath();
			String tmpPath = absolutePath.substring(path.length(), absolutePath.length());
			dto.setFullPath(tmpPath);
			dto.setName(directory.getName());
			return dto;

		} catch (IOException e) {
			logger.log(Level.SEVERE, "can not copy directory", e);
			throw new FileErrorException(FileError.INVALID_STATE_ERR);
		}

	}

	// map with mimetypes
	private Map<String, String> initMimeTypes() {

		HashMap<String, String> map = new HashMap<String, String>();

		map.put(".pfunk", "audio/make.my.funk");
		map.put(".niff", "image/x-niff");
		map.put(".wsc", "text/scriplet");
		map.put(".ras", "image/x-cmu-raster");
		map.put(".mrc", "application/marc");
		map.put(".bcpio", "application/x-bcpio");
		map.put(".isu", "video/x-isvideo");
		map.put(".bz", "application/x-bzip");
		map.put(".bmp", "image/x-windows-bmp");
		map.put(".aip", "text/x-audiosoft-intra");
		map.put(".aim", "application/x-aim");
		map.put(".bm", "image/bmp");
		map.put(".xl", "application/excel");
		map.put(".dvi", "application/x-dvi");
		map.put(".aif", "audio/x-aiff");
		map.put(".ani", "application/x-navi-animation");
		map.put(".el", "text/x-script.elisp");
		map.put(".p10", "application/x-pkcs10");
		map.put(".qif", "image/x-quicktime");
		map.put(".p12", "application/x-pkcs12");
		map.put(".xpix", "application/x-vnd.ls-xpix");
		map.put(".css", "text/css");
		map.put(".csh", "text/x-script.csh");
		map.put(".pm5", "application/x-pagemaker");
		map.put(".pm4", "application/x-pagemaker");
		map.put(".pdf", "application/pdf");
		map.put(".es", "application/x-esrehber");
		map.put(".pm", "text/x-script.perl-module");
		map.put(".pl", "text/x-script.perl");
		map.put(".htt", "text/webviewhtml");
		map.put(".htx", "text/html");
		map.put(".xmz", "xgl/movie");
		map.put(".htc", "text/x-component");
		map.put(".hta", "application/hta");
		map.put(".py", "text/x-script.phyton");
		map.put(".xml", "text/xml");
		map.put(".cha", "application/x-chat");
		map.put(".ps", "application/postscript");
		map.put(".htm", "text/html");
		map.put(".wav", "audio/x-wav");
		map.put(".prt", "application/pro_eng");
		map.put(".fif", "image/fif");
		map.put(".sid", "audio/x-psid");
		map.put(".gsp", "application/x-gsp");
		map.put(".tsv", "text/tab-separated-values");
		map.put(".gss", "application/x-gss");
		map.put(".ltx", "application/x-latex");
		map.put(".tsp", "audio/tsplayer");
		map.put(".w6w", "application/msword");
		map.put(".gsm", "audio/x-gsm");
		map.put(".sit", "application/x-stuffit");
		map.put(".gsd", "audio/x-gsm");
		map.put(".cat", "application/vnd.ms-pki.seccat");
		map.put(".ief", "image/ief");
		map.put(".xm", "audio/xm");
		map.put(".texinfo", "application/x-texinfo");
		map.put(".naplps", "image/naplps");
		map.put(".ccad", "application/clariscad");
		map.put(".fpx", "image/vnd.net-fpx");
		map.put(".viv", "video/vnd.vivo");
		map.put(".nvd", "application/x-navidoc");
		map.put(".sbk", "application/x-tbook");
		map.put(".arc", "application/octet-stream");
		map.put(".w61", "application/wordperfect6.1");
		map.put(".w60", "application/wordperfect6.0");
		map.put(".exe", "application/octet-stream");
		map.put(".qd3", "x-world/x-3dmf");
		map.put(".xls", "application/x-msexcel");
		map.put(".help", "application/x-helpfile");
		map.put(".xpm", "image/xpm");
		map.put(".mpeg", "video/mpeg");
		map.put(".spr", "application/x-sprite");
		map.put(".ram", "audio/x-pn-realaudio");
		map.put(".sgml", "text/x-sgml");
		map.put(".spc", "text/x-speech");
		map.put(".lma", "audio/x-nspaudio");
		map.put(".spl", "application/futuresplash");
		map.put(".tex", "application/x-tex");
		map.put(".rexx", "text/x-script.rexx");
		map.put(".m2v", "video/mpeg");
		map.put(".art", "image/x-jg");
		map.put(".nif", "image/x-niff");
		map.put(".m2a", "audio/mpeg");
		map.put(".nix", "application/x-mix-transfer");
		map.put(".xbm", "image/xbm");
		map.put(".txt", "text/plain");
		map.put(".arj", "application/octet-stream");
		map.put(".sprite", "application/x-sprite");
		map.put(".tr", "application/x-troff");
		map.put(".uil", "text/x-uil");
		map.put(".smil", "application/smil");
		map.put(".xif", "image/vnd.xiff");
		map.put(".s3m", "audio/s3m");
		map.put(".wrz", "x-world/x-vrml");
		map.put(".cer", "application/x-x509-ca-cert");
		map.put(".pvu", "paleovu/x-pv");
		map.put(".smi", "application/smil");
		map.put(".bsh", "application/x-bsh");
		map.put(".etx", "text/x-setext");
		map.put(".iges", "model/iges");
		map.put(".jcm", "application/x-java-commerce");
		map.put(".png", "image/png");
		map.put(".mhtml", "message/rfc822");
		map.put(".tar", "application/x-tar");
		map.put(".pnm", "image/x-portable-anymap");
		map.put(".rnx", "application/vnd.rn-realplayer");
		map.put(".rng", "application/vnd.nokia.ringing-tone");
		map.put(".dxf", "image/x-dwg");
		map.put(".qcp", "audio/vnd.qcelp");
		map.put(".3dm", "x-world/x-3dmf");
		map.put(".hpgl", "application/vnd.hp-hpgl");
		map.put(".rast", "image/cmu-raster");
		map.put(".turbot", "image/florian");
		map.put(".mzz", "application/x-vnd.audioexplosion.mzz");
		map.put(".dwg", "image/x-dwg");
		map.put(".conf", "text/plain");
		map.put(".cc", "text/x-c");
		map.put(".mcf", "text/mcf");
		map.put(".rpm", "audio/x-pn-realaudio-plugin");
		map.put(".mcd", "application/x-mathcad");
		map.put(".vql", "audio/x-twinvq-plugin");
		map.put(".stp", "application/step");
		map.put(".crt", "application/x-x509-user-cert");
		map.put(".vqf", "audio/x-twinvq");
		map.put(".vqe", "audio/x-twinvq-plugin");
		map.put(".crl", "application/pkix-crl");
		map.put(".stl", "application/x-navistyle");
		map.put(".mcp", "application/netmc");
		map.put(".m1v", "video/mpeg");
		map.put(".avi", "video/x-msvideo");
		map.put(".jut", "image/jutvision");
		map.put(".avs", "video/avs-video");
		map.put(".xsr", "video/x-amt-showrun");
		map.put(".hpg", "application/vnd.hp-hpgl");
		map.put(".mc$", "application/x-magic-cap-package-1.0");
		map.put(".mjpg", "video/x-motion-jpeg");
		map.put(".wml", "text/vnd.wap.wml");
		map.put(".mht", "message/rfc822");
		map.put(".wmf", "windows/metafile");
		map.put(".imap", "application/x-httpd-imap");
		map.put(".pwz", "application/vnd.ms-powerpoint");
		map.put(".idc", "text/plain");
		map.put(".omcd", "application/x-omcdatamaker");
		map.put(".omcr", "application/x-omcregerator");
		map.put(".jpeg", "image/pjpeg");
		map.put(".gtar", "application/x-gtar");
		map.put(".p7m", "application/x-pkcs7-mime");
		map.put(".tbk", "application/x-tbook");
		map.put(".sdml", "text/plain");
		map.put(".p7c", "application/x-pkcs7-mime");
		map.put(".p7a", "application/x-pkcs7-signature");
		map.put(".def", "text/plain");
		map.put(".der", "application/x-x509-ca-cert");
		map.put(".p7s", "application/pkcs7-signature");
		map.put(".p7r", "application/x-pkcs7-certreqresp");
		map.put(".eps", "application/postscript");
		map.put(".hh", "text/x-h");
		map.put(".pdb", "chemical/x-pdb");
		map.put(".wmlsc", "application/vnd.wap.wmlscriptc");
		map.put(".c++", "text/plain");
		map.put(".ssm", "application/streamingmedia");
		map.put(".wri", "application/x-wri");
		map.put(".ssi", "text/x-server-parsed-html");
		map.put(".wrl", "x-world/x-vrml");
		map.put(".hgl", "application/vnd.hp-hpgl");
		map.put(".acgi", "text/html");
		map.put(".gif", "image/gif");
		map.put(".sst", "application/vnd.ms-pki.certstore");
		map.put(".cdf", "application/x-netcdf");
		map.put(".fdf", "application/vnd.fdf");
		map.put(".elc", "application/x-elc");
		map.put(".unis", "text/uri-list");
		map.put(".wbmp", "image/vnd.wap.wbmp");
		map.put(".pas", "text/pascal");
		map.put(".rtx", "text/richtext");
		map.put(".mod", "audio/x-mod");
		map.put(".rtf", "text/richtext");
		map.put(".mov", "video/quicktime");
		map.put(".movie", "video/x-sgi-movie");
		map.put(".wmls", "text/vnd.wap.wmlscript");
		map.put(".qt", "video/quicktime");
		map.put(".sv4cpio", "application/x-sv4cpio");
		map.put(".nap", "image/naplps");
		map.put(".com", "text/plain");
		map.put(".vdo", "video/vdo");
		map.put(".wiz", "application/msword");
		map.put(".vcd", "application/x-cdlink");
		map.put(".vcs", "text/x-vcalendar");
		map.put(".psd", "application/octet-stream");
		map.put(".midi", "x-music/x-midi");
		map.put(".tiff", "image/x-tiff");
		map.put(".texi", "application/x-texinfo");
		map.put(".oda", "application/oda");
		map.put(".ustar", "multipart/x-ustar");
		map.put(".sea", "application/x-sea");
		map.put(".set", "application/set");
		map.put(".text", "text/plain");
		map.put(".mpc", "application/x-project");
		map.put(".iv", "application/x-inventor");
		map.put(".mpa", "video/mpeg");
		map.put(".mpg", "video/mpeg");
		map.put(".mpe", "video/mpeg");
		map.put(".pov", "model/x-pov");
		map.put(".pot", "application/vnd.ms-powerpoint");
		map.put(".g3", "image/g3fax");
		map.put(".nsc", "application/x-conference");
		map.put(".mpp", "application/vnd.ms-project");
		map.put(".mpv", "application/x-project");
		map.put(".mpt", "application/x-project");
		map.put(".wmlc", "application/vnd.wap.wmlc");
		map.put(".moov", "video/quicktime");
		map.put(".pko", "application/vnd.ms-pki.pko");
		map.put(".ivy", "application/x-livescreen");
		map.put(".gl", "video/x-gl");
		map.put(".ivr", "i-world/i-vrml");
		map.put(".gzip", "multipart/x-gzip");
		map.put(".swf", "application/x-shockwave-flash");
		map.put(".mp3", "video/x-mpeg");
		map.put(".mp2", "video/x-mpeq2a");
		map.put(".gz", "application/x-gzip");
		map.put(".vda", "application/vda");
		map.put(".rm", "audio/x-pn-realaudio");
		map.put(".src", "application/x-wais-source");
		map.put(".ra", "audio/x-realaudio");
		map.put(".rf", "image/vnd.rn-realflash");
		map.put(".word", "application/msword");
		map.put(".book", "application/book");
		map.put(".zoo", "application/octet-stream");
		map.put(".talk", "text/x-speech");
		map.put(".rp", "image/vnd.rn-realpix");
		map.put(".rv", "video/vnd.rn-realvideo");
		map.put(".rt", "text/vnd.rn-realtext");
		map.put(".skd", "application/x-koan");
		map.put(".cco", "application/x-cocoa");
		map.put(".skm", "application/x-koan");
		map.put(".skt", "application/x-koan");
		map.put(".skp", "application/x-koan");
		map.put(".for", "text/x-fortran");
		map.put(".hqx", "application/x-mac-binhex40");
		map.put(".pre", "application/x-freelance");
		map.put(".tsi", "audio/tsp-audio");
		map.put(".doc", "application/msword");
		map.put(".uu", "text/x-uuencode");
		map.put(".shar", "application/x-shar");
		map.put(".ksh", "text/x-script.ksh");
		map.put(".dot", "application/msword");
		map.put(".vos", "video/vosaic");
		map.put(".o", "application/octet-stream");
		map.put(".vox", "audio/voxware");
		map.put(".wsrc", "application/x-wais-source");
		map.put(".ico", "image/x-icon");
		map.put(".voc", "audio/x-voc");
		map.put(".uri", "text/uri-list");
		map.put(".dwf", "model/vnd.dwf");
		map.put(".c", "text/x-c");
		map.put(".vivo", "video/vnd.vivo");
		map.put(".abc", "text/vnd.abc");
		map.put(".list", "text/plain");
		map.put(".ip", "application/x-ip2");
		map.put(".mpga", "audio/mpeg");
		map.put(".it", "audio/it");
		map.put(".hdf", "application/x-hdf");
		map.put(".pkg", "application/x-newton-compatible-pkg");
		map.put(".boo", "application/book");
		map.put(".log", "text/plain");
		map.put(".cxx", "text/plain");
		map.put(".boz", "application/x-bzip2");
		map.put(".pbm", "image/x-portable-bitmap");
		map.put(".vrml", "x-world/x-vrml");
		map.put(".step", "application/step");
		map.put(".xdr", "video/x-amt-demorun");
		map.put(".vrt", "x-world/x-vrt");
		map.put(".aps", "application/mime");
		map.put(".mbd", "application/mbedlet");
		map.put(".wq1", "application/x-lotus");
		map.put(".kar", "music/x-karaoke");
		map.put(".aiff", "audio/x-aiff");
		map.put(".aifc", "audio/x-aiff");
		map.put(".vew", "application/groupwise");
		map.put(".flx", "text/vnd.fmi.flexstor");
		map.put(".ice", "x-conference/x-cooltalk");
		map.put(".xgz", "xgl/drawing");
		map.put(".jfif", "image/pjpeg");
		map.put(".flo", "image/florian");
		map.put(".fli", "video/x-fli");
		map.put(".ins", "application/x-internett-signup");
		map.put(".ppz", "application/mspowerpoint");
		map.put(".sol", "application/solids");
		map.put(".ppt", "application/x-mspowerpoint");
		map.put(".pps", "application/vnd.ms-powerpoint");
		map.put(".ppm", "image/x-portable-pixmap");
		map.put(".lzh", "application/x-lzh");
		map.put(".inf", "application/inf");
		map.put(".latex", "application/x-latex");
		map.put(".uris", "text/uri-list");
		map.put(".ppa", "application/vnd.ms-powerpoint");
		map.put(".zsh", "text/x-script.zs");
		map.put(".frl", "application/freeloader");
		map.put(".dcr", "application/x-director");
		map.put(".pict", "image/pict");
		map.put(".igs", "model/iges");
		map.put(".qti", "image/x-quicktime");
		map.put(".tcl", "text/x-script.tcl");
		map.put(".x-png", "image/png");
		map.put(".qtc", "video/x-qtc");
		map.put(".jam", "audio/x-jam");
		map.put(".bz2", "application/x-bzip2");
		map.put(".jav", "text/x-java-source");
		map.put(".mv", "video/x-sgi-movie");
		map.put(".f90", "text/x-fortran");
		map.put(".ms", "application/x-troff-ms");
		map.put(".rgb", "image/x-rgb");
		map.put(".saveme", "application/octet-stream");
		map.put(".my", "audio/make");
		map.put(".me", "application/x-troff-me");
		map.put(".mm", "application/x-meme");
		map.put(".afl", "video/animaflex");
		map.put(".svr", "x-world/x-svr");
		map.put(".dl", "video/x-dl");
		map.put(".pgm", "image/x-portable-greymap");
		map.put(".xyz", "chemical/x-pdb");
		map.put(".svf", "image/x-dwg");
		map.put(".dp", "application/commonground");
		map.put(".roff", "application/x-troff");
		map.put(".aos", "application/x-nokia-9000-communicator-add-on-software");
		map.put(".dv", "video/x-dv");
		map.put(".map", "application/x-navimap");
		map.put(".mar", "text/plain");
		map.put(".qtif", "image/x-quicktime");
		map.put(".jfif-tbnl", "image/jpeg");
		map.put(".man", "application/x-troff-man");
		map.put(".lam", "audio/x-liveaudio");
		map.put(".pyc", "applicaiton/x-bytecode.python");
		map.put(".cpio", "application/x-cpio");
		map.put(".lst", "text/plain");
		map.put(".lsp", "text/x-script.lisp");
		map.put(".lsx", "text/x-la-asf");
		map.put(".tcsh", "text/x-script.tcsh");
		map.put(".funk", "audio/make");
		map.put(".scm", "video/x-scm");
		map.put(".mpx", "application/x-project");
		map.put(".htmls", "text/html");
		map.put(".xwd", "image/x-xwindowdump");
		map.put(".qd3d", "x-world/x-3dmf");
		map.put(".aab", "application/x-authorware-bin");
		map.put(".aam", "application/x-authorware-map");
		map.put(".evy", "application/x-envoy");
		map.put(".js", "application/x-javascript");
		map.put(".aas", "application/x-authorware-seg");
		map.put(".sdp", "application/x-sdp");
		map.put(".sdr", "application/sounder");
		map.put(".3dmf", "x-world/x-3dmf");
		map.put(".shtml", "text/x-server-parsed-html");
		map.put(".wtk", "application/x-wintalk");
		map.put(".tgz", "application/x-compressed");
		map.put(".lha", "application/x-lha");
		map.put(".lhx", "application/octet-stream");
		map.put(".plx", "application/x-pixclscript");
		map.put(".jps", "image/x-jps");
		map.put(".wb1", "application/x-qpro");
		map.put(".pcl", "application/x-pcl");
		map.put(".jpe", "image/pjpeg");
		map.put(".jpg", "image/pjpeg");
		map.put(".cpp", "text/x-c");
		map.put(".pct", "image/x-pict");
		map.put(".wp", "application/wordperfect");
		map.put(".pcx", "image/x-pcx");
		map.put(".zip", "multipart/x-zip");
		map.put(".wk1", "application/x-123");
		map.put(".asp", "text/asp");
		map.put(".m3u", "audio/x-mpequrl");
		map.put(".vst", "application/x-visio");
		map.put(".vsw", "application/x-visio");
		map.put(".class", "application/x-java-class");
		map.put(".mme", "application/base64");
		map.put(".asx", "video/x-ms-asf-plugin");
		map.put(".iefs", "image/ief");
		map.put(".asf", "video/x-ms-asf");
		map.put(".vsd", "application/x-visio");
		map.put(".hlb", "text/x-script");
		map.put(".uue", "text/x-uuencode");
		map.put(".asm", "text/x-asm");
		map.put(".sh", "text/x-script.sh");
		map.put(".xlk", "application/x-excel");
		map.put(".unv", "application/i-deas");
		map.put(".sl", "application/x-seelogo");
		map.put(".xll", "application/x-excel");
		map.put(".xlm", "application/x-excel");
		map.put(".xlb", "application/x-excel");
		map.put(".xlc", "application/x-excel");
		map.put(".xla", "application/x-msexcel");
		map.put(".xld", "application/x-excel");
		map.put(".lzx", "application/x-lzx");
		map.put(".xlv", "application/x-excel");
		map.put(".xlw", "application/x-msexcel");
		map.put(".xlt", "application/x-excel");
		map.put(".la", "audio/x-nspaudio");
		map.put(".deepv", "application/x-deepv");
		map.put(".ima", "application/x-ima");
		map.put(".html", "text/html");
		map.put(".mjf", "audio/x-vnd.audioexplosion.mjuicemediafile");
		map.put(".mime", "www/mime");
		map.put(".sgm", "text/x-sgml");
		map.put(".tif", "image/x-tiff");
		map.put(".rmi", "audio/mid");
		map.put(".wp5", "application/wordperfect6.0");
		map.put(".rmm", "audio/x-pn-realaudio");
		map.put(".wp6", "application/wordperfect");
		map.put(".f77", "text/x-fortran");
		map.put(".pic", "image/pict");
		map.put(".rmp", "audio/x-pn-realaudio-plugin");
		map.put(".nc", "application/x-netcdf");
		map.put(".bin", "application/x-macbinary");
		map.put(".drw", "application/drafting");
		map.put(".h", "text/x-h");
		map.put(".m", "text/x-m");
		map.put(".cpt", "application/x-cpt");
		map.put(".a", "application/octet-stream");
		map.put(".ai", "application/postscript");
		map.put(".part", "application/pro_eng");
		map.put(".f", "text/x-fortran");
		map.put(".g", "text/plain");
		map.put(".z", "application/x-compressed");
		map.put(".wpd", "application/x-wpwin");
		map.put(".au", "audio/x-au");
		map.put(".p", "text/x-pascal");
		map.put(".s", "text/x-asm");
		map.put(".t", "application/x-troff");
		map.put(".web", "application/vnd.xara");
		map.put(".dxr", "application/x-director");
		map.put(".env", "application/x-envoy");
		map.put(".sv4crc", "application/x-sv4crc");
		map.put(".mid", "x-music/x-midi");
		map.put(".mif", "application/x-mif");
		map.put(".chat", "application/x-chat");
		map.put(".ncm", "application/vnd.nokia.configuration-message");
		map.put(".dump", "application/octet-stream");
		map.put(".dif", "video/x-dv");
		map.put(".uni", "text/uri-list");
		map.put(".fmf", "video/x-atomic3d-feature");
		map.put(".dir", "application/x-director");
		map.put(".omc", "application/x-omc");
		map.put(".vmf", "application/vocaltec-media-file");
		map.put(".vmd", "application/vocaltec-media-desc");
		map.put(".snd", "audio/x-adpcm");
		map.put(".java", "text/x-java-source");
		map.put(".hlp", "application/x-winhelp");

		return Collections.unmodifiableMap(map);

	}

}
