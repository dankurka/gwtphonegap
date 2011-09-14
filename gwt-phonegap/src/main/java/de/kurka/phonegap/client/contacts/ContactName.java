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

/**
 * Contains name properties of a Contact object.
 * 
 * @author Daniel Kurka
 * 
 */
public interface ContactName {
	/**
	 * The complete name of the contact. (DOMString)
	 * 
	 * @param formatted
	 */
	public void setFormatted(String formatted);

	/**
	 * The complete name of the contact. (DOMString)
	 * 
	 * @return
	 */
	public String getFormatted();

	/**
	 * The contacts family name. (DOMString)
	 * 
	 * @param name
	 */
	public void setFamilyName(String name);

	/**
	 * The contacts family name. (DOMString)
	 * 
	 * @return
	 */
	public String getFamilyName();

	/**
	 * The contacts given name. (DOMString)
	 * 
	 * @param name
	 */
	public void setGivenName(String name);

	/**
	 * The contacts given name. (DOMString)
	 * 
	 * @param name
	 * @return
	 */
	public String getGivenName();

	/**
	 * The contacts middle name. (DOMString)
	 * 
	 * @param name
	 */
	public void setMiddleName(String name);

	/**
	 * The contacts middle name. (DOMString)
	 * 
	 * @return
	 */
	public String getMiddleName();

	/**
	 * The contacts prefix (example Mr. or Dr.) (DOMString)
	 * 
	 * @param prefix
	 */
	public void setHonoricfPrefix(String prefix);

	/**
	 * The contacts prefix (example Mr. or Dr.) (DOMString)
	 * 
	 * @return
	 */
	public String getHonoricPrefix();

	/**
	 * The contacts suffix (example Esq.). (DOMString)
	 * 
	 * @param suffix
	 */
	public void setHonoricfSuffix(String suffix);

	/**
	 * The contacts suffix (example Esq.). (DOMString)
	 * 
	 * @return
	 */
	public String getHonoricSuffix();
}
