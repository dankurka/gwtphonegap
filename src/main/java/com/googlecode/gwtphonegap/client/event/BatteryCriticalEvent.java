/*
 * Copyright 2012 Daniel Kurka
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
package com.googlecode.gwtphonegap.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class BatteryCriticalEvent extends BatteryBaseEvent<BatteryCriticalHandler> {

	public BatteryCriticalEvent(int level, boolean isPlugged) {
		super(level, isPlugged);
	}

	public static final GwtEvent.Type<BatteryCriticalHandler> TYPE = new GwtEvent.Type<BatteryCriticalHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<BatteryCriticalHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(BatteryCriticalHandler handler) {
		handler.onBatteryCritical(this);

	}

	public static GwtEvent.Type<BatteryCriticalHandler> getType() {
		return TYPE;
	}

}
