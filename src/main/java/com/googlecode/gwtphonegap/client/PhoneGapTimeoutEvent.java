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
package com.googlecode.gwtphonegap.client;

import com.google.gwt.event.shared.GwtEvent;

/**
 * This event is fired if phonegap was not successfully initialized in a given time period
 * @author Daniel Kurka
 *
 */
public class PhoneGapTimeoutEvent extends GwtEvent<PhoneGapTimeoutHandler> {

	public static final GwtEvent.Type<PhoneGapTimeoutHandler> TYPE = new Type<PhoneGapTimeoutHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<PhoneGapTimeoutHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(PhoneGapTimeoutHandler handler) {
		handler.onPhoneGapTimeout(this);

	}

}
