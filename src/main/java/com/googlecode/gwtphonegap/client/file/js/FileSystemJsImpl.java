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
import com.googlecode.gwtphonegap.client.file.FileSystem;

public class FileSystemJsImpl implements FileSystem {

	private final JavaScriptObject system;

	public FileSystemJsImpl(JavaScriptObject system) {
		this.system = system;
	}

	public JavaScriptObject getSystem() {
		return system;
	}

	@Override
	public native String getName() /*-{
		var system = this.@com.googlecode.gwtphonegap.client.file.js.FileSystemJsImpl::system;
		return system.name;
	}-*/;

	@Override
	public DirectoryEntry getRoot() {
		return getRoot0().getAsDirectoryEntry();
	}

	private native EntryBase getRoot0() /*-{
		var system = this.@com.googlecode.gwtphonegap.client.file.js.FileSystemJsImpl::system;
		return system.root;
	}-*/;

}
