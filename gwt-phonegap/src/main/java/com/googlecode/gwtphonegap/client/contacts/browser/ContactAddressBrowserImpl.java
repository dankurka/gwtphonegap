package com.googlecode.gwtphonegap.client.contacts.browser;

import com.googlecode.gwtphonegap.client.contacts.ContactAddress;

public class ContactAddressBrowserImpl implements ContactAddress {

	private String formatted;
	private String streedAddress;
	private String locality;
	private String region;
	private String postalCode;
	private String country;

	@Override
	public void setFormatted(String formatted) {
		this.formatted = formatted;

	}

	@Override
	public String getFormatted() {
		return formatted;
	}

	@Override
	public void setStreetAddress(String address) {
		this.streedAddress = address;

	}

	@Override
	public String getStreetAddress() {
		return streedAddress;
	}

	@Override
	public void setLocality(String locality) {
		this.locality = locality;

	}

	@Override
	public String getLocality() {
		return locality;
	}

	@Override
	public void setRegion(String region) {
		this.region = region;

	}

	@Override
	public String getRegion() {
		return region;
	}

	@Override
	public void setPostalCode(String code) {
		this.postalCode = code;

	}

	@Override
	public String getPostalCode() {
		return this.postalCode;
	}

	@Override
	public void setCountry(String country) {
		this.country = country;

	}

	@Override
	public String getCountry() {
		return country;
	}

}
