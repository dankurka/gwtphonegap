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
package de.kurka.phonegap.client.connection;

/**
 * The connection object gives access to the device's cellular and wifi
 * connection information.
 * 
 * @author Daniel Kurka
 * 
 */
public interface Connection {

	public static String UNKNOWN = "unknown";
	public static String ETHERNET = "ethernet";
	public static String WIFI = "wifi";
	public static String CELL_2G = "2g";
	public static String CELL_3G = "3g";
	public static String CELL_4G = "4g";
	public static String NONE = "none";

	/**
	 * This is a fast way to determine the device's network connection state,
	 * and type of connection.
	 * 
	 * @return the current device network state
	 */
	public String getType();
}
