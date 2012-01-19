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
package com.googlecode.gwtphonegap.client.file.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.file.DirectoryEntry;
import com.googlecode.gwtphonegap.client.file.EntryBase;
import com.googlecode.gwtphonegap.client.file.FileEntry;

public final class EntryBaseJsImpl extends JavaScriptObject implements EntryBase {

	protected EntryBaseJsImpl() {

	}

	@Override
	public native boolean isFile() /*-{
		return this.isFile;
	}-*/;

	@Override
	public native boolean isDirectory()/*-{
		return this.isDirectory;
	}-*/;

	@Override
	public FileEntry getAsFileEntry() {
		if (!isFile()) {
			throw new IllegalStateException("attempt to convert a EntryBase to FileEntry, but its not a FileEntry");
		}

		return new FileEntryJsImpl(this);
	}

	@Override
	public DirectoryEntry getAsDirectoryEntry() {
		if (!isDirectory()) {
			throw new IllegalStateException("attempt to convert a EntryBase to DirectoryEntry, but its not a DirectoryEntry");
		}

		return new DirectoryEntryJsImpl(this);
	}

}
