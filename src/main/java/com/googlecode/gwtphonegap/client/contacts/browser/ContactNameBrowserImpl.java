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
package com.googlecode.gwtphonegap.client.contacts.browser;

import com.googlecode.gwtphonegap.client.contacts.ContactName;

public class ContactNameBrowserImpl implements ContactName {

	private String formatted;
	private String familyName;
	private String givenName;
	private String middleName;
	private String prefix;
	private String suffix;

	@Override
	public void setFormatted(String formatted) {
		this.formatted = formatted;

	}

	@Override
	public String getFormatted() {
		return formatted;
	}

	@Override
	public void setFamilyName(String name) {
		this.familyName = name;

	}

	@Override
	public String getFamilyName() {
		return familyName;
	}

	@Override
	public void setGivenName(String name) {
		this.givenName = name;

	}

	@Override
	public String getGivenName() {
		return givenName;
	}

	@Override
	public void setMiddleName(String name) {
		this.middleName = name;

	}

	@Override
	public String getMiddleName() {
		return middleName;
	}


        /**
         * The contacts prefix (example Mr. or Dr.) (DOMString)
         *
         * @param prefix
         */
        @Override
        public void setHonorificPrefix(String prefix) {
                this.prefix = prefix;

        }

        /**
         * The contacts prefix (example Mr. or Dr.) (DOMString)
         *
         * @return
         */
         @Override
         public String getHonorificPrefix() {
                return prefix;
         }

        /**
         * The contacts suffix (example Esq.). (DOMString)
         *
         * @param suffix
         */
         @Override
         public void setHonorificSuffix(String suffix) {
                this.suffix = suffix;

         }

        /**
         * The contacts suffix (example Esq.). (DOMString)
         *
         * @return
         */
         @Override
         public String getHonorificSuffix() {
                return suffix;
         }

}
