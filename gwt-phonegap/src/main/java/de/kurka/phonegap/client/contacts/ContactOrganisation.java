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
 * Contains organization properties of a Contact object.
 * 
 * @author Daniel Kurka
 * 
 */
public interface ContactOrganisation {
	/**
	 * The name of the organization. (DOMString)
	 * 
	 * @param name
	 */
	public void setName(String name);

	/**
	 * The name of the organization. (DOMString)
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * The department the contract works for. (DOMString)
	 * 
	 * @param department
	 */
	public void setDepartment(String department);

	/**
	 * The department the contract works for. (DOMString)
	 * 
	 * @return
	 */
	public String getDepartment();

	/**
	 * The contacts title at the organization. (DOMString)
	 * 
	 * @param title
	 */
	public void setTitle(String title);

	/**
	 * The contacts title at the organization. (DOMString)
	 * 
	 * @return
	 */
	public String getTitle();
}
