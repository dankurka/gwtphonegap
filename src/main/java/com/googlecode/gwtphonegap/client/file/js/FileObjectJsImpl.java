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

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.file.FileObject;

public final class FileObjectJsImpl extends JavaScriptObject implements FileObject {

	protected FileObjectJsImpl() {

	}

	@Override
	public native String getName() /*-{
		return this.name;
	}-*/;

	@Override
	public native String getFullPath() /*-{
		return this.fullPath;
	}-*/;

	@Override
	public native String getType() /*-{
		return this.type;
	}-*/;

	@Override
	public native Date getLastModifiedDate() /*-{
		return @com.googlecode.gwtphonegap.client.file.js.FileObjectJsImpl::createDate(D)(this.lastModifiedDate.getTime());
	}-*/;

	public static final Date createDate(double value) {
		long time = Math.round(value);
		return new Date(time);
	}

	@Override
	public long size() {
		return Math.round(size0());
	}

	public native double size0() /*-{
		return this.size;
	}-*/;

}
