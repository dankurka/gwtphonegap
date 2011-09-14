package de.kurka.phonegap.client.contacts.js;

import com.google.gwt.core.client.JavaScriptObject;

import de.kurka.phonegap.client.contacts.ContactName;

public final class ContactNameJsoImpl extends JavaScriptObject implements ContactName {

	protected ContactNameJsoImpl() {

	}

	@Override
	public native void setFormatted(String formatted) /*-{
		this.formatted = formatted;

	}-*/;

	@Override
	public native String getFormatted() /*-{
		return this.formatted;
	}-*/;

	@Override
	public native void setFamilyName(String name) /*-{
		this.familyName = name;

	}-*/;

	@Override
	public native String getFamilyName() /*-{
		return this.familyName;
	}-*/;

	@Override
	public native void setGivenName(String name) /*-{
		this.givenName = name;

	}-*/;

	@Override
	public native String getGivenName() /*-{
		return this.givenName;
	}-*/;

	@Override
	public native void setMiddleName(String name) /*-{
		this.middleName = name;

	}-*/;

	@Override
	public native String getMiddleName() /*-{
		return this.middleName;
	}-*/;

	@Override
	public native void setHonoricfPrefix(String prefix) /*-{
		this.honorificPrefix = prefix;

	}-*/;

	@Override
	public native String getHonoricPrefix() /*-{
		return this.honorificPrefix;
	}-*/;

	@Override
	public native void setHonoricfSuffix(String suffix) /*-{
		this.honorificSuffix = suffix;

	}-*/;

	@Override
	public native String getHonoricSuffix() /*-{
		return this.honorificSuffix;
	}-*/;

}
