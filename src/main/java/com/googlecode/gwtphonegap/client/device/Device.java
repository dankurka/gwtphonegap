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
package com.googlecode.gwtphonegap.client.device;

public interface Device {

        /**
         * Get the device's model name.
         *
         * device.name returns the name of the device's model or product. This value is set by the device
         * manufacturer and may be different across versions of the same product.
         *
         * <h1>Supported Platforms</h1>
         *
         * <ul>
         * <li>Android</li>
         * <li>BlackBerry</li>
         * <li>BlackBerry Widgets (OS 5.0 and higher)</li>
         * <li>iPhone</li>
         * </ul>
         *
         *
         * <h1>Android Quirks</h1>
         *
         * <ul>
         * <li>Gets the product name instead of the model name.
         * <ul>
         * <li>The product name is often the code name given during production.</li>
         * <li>e.g. Nexus One returns "Passion", Motorola Droid returns "voles"</li>
         * </ul>
         * </li>
         * </ul>
         *
         *
         * <h1>iPhone Quirks</h1>
         *
         * <ul>
         * <li>Gets the device's custom name instead of the device model name.
         * <ul>
         * <li>The custom name is set by the owner in iTunes.</li>
         * <li>e.g. "Joe's iPhone"</li>
         * </ul>
         * </li>
         * </ul>
         *
         * @deprecated use {@link #getName()}
         *
         *
         * @return the models device name
         */
        @Deprecated
        public abstract String getName();

        /**
         * device.model returns the name of the device's model or product. This value is set by the device
         * manufacturer and may be different across versions of the same product.
         *
         * @return the device model
         */
        public abstract String getModel();

	/**
	 * Get the version of phonegap running on the device.
	 *
	 * <h1>Supported Platforms:</h1>
	 * <ul>
	 * <li>Android</li>
	 * <li>BlackBerry</li>
	 * <li>BlackBerry Widgets (OS 5.0 and higher)</li>
	 * <li>iPhone</li>
	 * </ul>
	 *
	 * @return the version of phonegap running on the device
	 */
	public abstract String getPhoneGapVersion();

	/**
	 * Get the device's operating system name.
	 *
	 * <h1>Supported Platforms:</h1>
	 * <ul>
	 * <li>Android</li>
	 * <li>BlackBerry</li>
	 * <li>BlackBerry Widgets (OS 5.0 and higher)</li>
	 * <li>iPhone</li>
	 * </ul>
	 *
	 * <h1>iPhone Quirks</h1>
	 * All devices return iPhone as the platform. This is inaccurate because
	 * Apple has rebranded the iPhone operating system as iOS.
	 *
	 * <h1>BlackBerry Quirks</h1>
	 *
	 * Devices may return the device platform version instead of the platform
	 * name. For example, the Storm2 9550 would return '2.13.0.95' or similar.
	 *
	 * @return the device's operating system name
	 */
	public abstract String getPlatform();

	/**
	 * Get the device's Universally Unique Identifier (UUID).
	 *
	 * The details of how a UUID is generated are determined by the device
	 * manufacturer and specific to the device's platform or model.
	 *
	 * <h1>Supported Platforms</h1>
	 *
	 * <ul>
	 * <li>Android</li>
	 * <li>BlackBerry</li>
	 * <li>BlackBerry Widgets (OS 5.0 and higher)</li>
	 * <li>iPhone</li>
	 * </ul>
	 *
	 * @return the uuid of the device as a String
	 */
	public abstract String getUuid();

	/**
	 * Get the operating system version.
	 *
	 * <h1>Supported Platforms</h1>
	 *
	 * <ul>
	 * <li>Android</li>
	 * <li>BlackBerry</li>
	 * <li>BlackBerry Widgets (OS 5.0 and higher)</li>
	 * <li>iPhone</li>
	 * </ul>
	 *
	 * @return the device's operating system version
	 */
	public abstract String getVersion();

	boolean isAvailable();

}