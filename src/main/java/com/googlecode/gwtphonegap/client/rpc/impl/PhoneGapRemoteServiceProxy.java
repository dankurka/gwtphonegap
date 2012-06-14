/*
 * Copyright 2008 Google Inc.
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
package com.googlecode.gwtphonegap.client.rpc.impl;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.Serializer;
import com.googlecode.gwtphonegap.client.rpc.PhonegapRPCService;

/**
 * Superclass for client-side
 * {@link com.google.gwt.user.client.rpc.RemoteService RemoteService} proxies.
 * 
 * For internal use only.
 */
public abstract class PhoneGapRemoteServiceProxy extends RemoteServiceProxy implements PhonegapRPCService {

	protected PhoneGapRemoteServiceProxy(String moduleBaseURL, String remoteServiceRelativePath, String serializationPolicyName, Serializer serializer) {
		super(moduleBaseURL, remoteServiceRelativePath, serializationPolicyName, serializer);
	}

	@Override
	//since the field is private we just use jsni to set it....
	//lets move this into gwt asap...
	public native void setModuleBaseUrl(String moduleBase)/*-{
		this.@com.google.gwt.user.client.rpc.impl.RemoteServiceProxy::moduleBaseURL = moduleBase;
	}-*/;

}
