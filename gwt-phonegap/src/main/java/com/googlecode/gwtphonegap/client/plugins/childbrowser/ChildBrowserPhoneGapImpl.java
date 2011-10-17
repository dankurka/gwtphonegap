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
package com.googlecode.gwtphonegap.client.plugins.childbrowser;

import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ChildBrowserPhoneGapImpl implements ChildBrowser {

	private EventBus handlerManager = new SimpleEventBus();
	private boolean initialized;
	private JavaScriptObject cb;

	@Override
	public void initialize() {

		try {
			cb = initializeNative();
			initialized = true;
		} catch (JavaScriptException e) {
			throw new IllegalStateException("could not initialize Childbrowser plugin");
		}

	}

	public native JavaScriptObject initializeNative() throws JavaScriptException/*-{
		var instance = this;
		var cb = null;
		//ios
		if (typeof ($wnd.ChildBrowser) != "undefined"
				&& $wnd.ChildBrowser != null) {
			if (typeof ($wnd.ChildBrowser.install) == "function") {
				cb = $wnd.ChildBrowser.install();
			}
		}

		//android
		if (cb == null) {
			if (typeof ($wnd.plugins) != "undefined" && $wnd.plugins != null) {
				if (typeof ($wnd.plugins.childBrowser) != "undefined"
						&& $wnd.plugins.childBrowser != null) {
					cb = $wnd.plugins.childBrowser;
				}
			}
		}

		// no init found throw....
		if (cb == null) {
			throw "no child browser plugin found";
		}

		cb.onLocationChange = $entry(function(loc) {
			instance.@com.googlecode.gwtphonegap.client.plugins.childbrowser.ChildBrowserPhoneGapImpl::onLocationChange(Ljava/lang/String;)(loc);
		});
		cb.onClose = $entry(function() {
			instance.@com.googlecode.gwtphonegap.client.plugins.childbrowser.ChildBrowserPhoneGapImpl::onClose()();
		});
		cb.onOpenExternal = $entry(function() {
			instance.@com.googlecode.gwtphonegap.client.plugins.childbrowser.ChildBrowserPhoneGapImpl::onOpenExternal()();
		});

		return cb;

	}-*/;

	@Override
	public void showWebPage(String url) {
		if (!initialized) {
			throw new IllegalStateException("you have to initialize Childbrowser before using it");
		}

		showWebPageNative(cb, url);

	}

	private native void showWebPageNative(JavaScriptObject cb, String url)/*-{
		cb.showWebPage(url);
	}-*/;

	@Override
	public void close() {
		if (!initialized) {
			throw new IllegalStateException("you have to initialize Childbrowser before using it");
		}

		closeNative(cb);
	}

	private native void closeNative(JavaScriptObject cb)/*-{
		cb.close();
	}-*/;

	@Override
	public HandlerRegistration addLocationChangeHandler(ChildBrowserLocationChangedHandler handler) {
		return handlerManager.addHandler(ChildBrowserLocationChangedEvent.getType(), handler);
	}

	@Override
	public HandlerRegistration addCloseHandler(ChildBrowserCloseHandler handler) {
		return handlerManager.addHandler(ChildBrowserCloseEvent.getType(), handler);
	}

	@Override
	public HandlerRegistration addOpenExternalHandler(ChildBrowserOpenExternalHandler handler) {
		return handlerManager.addHandler(ChildBrowserOpenExternalEvent.getType(), handler);
	}

	private void onClose() {
		handlerManager.fireEvent(new ChildBrowserCloseEvent());
	}

	private void onOpenExternal() {
		handlerManager.fireEvent(new ChildBrowserOpenExternalEvent());
	}

	private void onLocationChange(String url) {
		handlerManager.fireEvent(new ChildBrowserLocationChangedEvent(url));
	}

}
