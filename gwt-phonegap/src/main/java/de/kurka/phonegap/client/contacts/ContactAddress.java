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
package de.kurka.phonegap.client.contacts;

public interface ContactAddress {
	/**
	 * The full address formatted for display. (DOMString)
	 * 
	 * @param formatted
	 */
	public void setFormatted(String formatted);

	/**
	 * The full address formatted for display. (DOMString)
	 * 
	 * @return
	 */
	public String getFormatted();

	/**
	 * The full street address. (DOMString)
	 * 
	 * @param address
	 */
	public void setStreetAddress(String address);

	/**
	 * The full street address. (DOMString)
	 * 
	 * @return
	 */
	public String getStreetAddress();

	/**
	 * The city or locality. (DOMString)
	 * 
	 * @param locality
	 */
	public void setLocality(String locality);

	/**
	 * The city or locality. (DOMString)
	 * 
	 * @return
	 */
	public String getLocality();

	/**
	 * The state or region. (DOMString)
	 * 
	 * @param region
	 */
	public void setRegion(String region);

	/**
	 * The state or region. (DOMString)
	 * 
	 * @return
	 */
	public String getRegion();

	/**
	 * The zip code or postal code. (DOMString)
	 * 
	 * @param code
	 */
	public void setPostalCode(String code);

	/**
	 * The zip code or postal code. (DOMString)
	 * 
	 * @return
	 */
	public String getPostalCode();

	/**
	 * The country name. (DOMString)
	 * 
	 * @param country
	 */
	public void setCountry(String country);

	/**
	 * The country name. (DOMString)
	 * 
	 * @return
	 */
	public String getCountry();
}
