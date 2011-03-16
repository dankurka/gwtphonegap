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

public interface ContactName {
	public void setFormatted(String formatted);

	public String getFormatted();

	public void setFamilyName(String name);

	public String getFamilyName();

	public void setGivenName(String name);

	public String getGivenName(String name);

	public void setMiddleName(String name);

	public String getMiddleName();

	public void setHonoricfPrefix(String prefix);

	public String getHonoricPrefix();

	public void setHonoricfSuffix(String suffix);

	public String getHonoricSuffix();
}
