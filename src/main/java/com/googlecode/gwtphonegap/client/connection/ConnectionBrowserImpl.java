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
package com.googlecode.gwtphonegap.client.connection;

/**
 * 
 * @author Daniel Kurka
 * 
 */
public class ConnectionBrowserImpl implements ConnectionMock {

	private String type;

	public ConnectionBrowserImpl() {
		type = Connection.ETHERNET;
	}

	@Override
	public String getType() {
		return type;
	}

        /**
         * Sets the connection type that will be mocked for browser implementation.
         * @param type
         */
        @Override
	public void setType(String type) {
		if (type == null) {
			throw new IllegalArgumentException("type can not be null");
		}
		if (!Connection.CELL_2G.equals(type) && !Connection.CELL_3G.equals(type) && !Connection.CELL_4G.equals(type) && !Connection.ETHERNET.equals(type) && !Connection.NONE.equals(type)
				&& !Connection.UNKNOWN.equals(type) && !Connection.WIFI.equals(type) && !Connection.CELL.equals(type)) {
			throw new IllegalArgumentException("unknown type");
		}

		this.type = type;
	}

}
