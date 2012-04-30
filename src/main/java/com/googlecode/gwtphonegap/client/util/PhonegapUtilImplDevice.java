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
package com.googlecode.gwtphonegap.client.util;

import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.rpc.RpcRequestBuilder;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class PhonegapUtilImplDevice implements PhonegapUtilImpl {

	@Override
	public void prepareService(ServiceDefTarget service, final String moduleUrl, String relativeServiceUrl) {
		service.setServiceEntryPoint(moduleUrl + relativeServiceUrl);

		service.setRpcRequestBuilder(new RpcRequestBuilder() {

			@Override
			protected void doFinish(RequestBuilder rb) {
				super.doFinish(rb);

				rb.setHeader(MODULE_BASE_HEADER, moduleUrl);
			}

		});

	}

}
