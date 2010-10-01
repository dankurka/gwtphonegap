package de.kurka.phonegap.client.device;

/**
 * The Device class represents the Device from the phonegap API:
 * 
 * http://docs.phonegap.com/phonegap_device_device.md.html
 * 
 * @author Daniel Kurka
 * 
 */
public class Device {

	/**
	 * Get the device's Universally Unique Identifier (UUID).
	 * 
	 * The details of how a UUID is generated are determined by the device
	 * manufacturer and specific to the device's platform or model.
	 * 
	 * @return the uuid of the device as a String
	 */
	public native String getUuid()/*-{
		if(typeof($wnd.device) == "undefined")
		{
		return "id";
		}

		return $wnd.device.uuid;
	}-*/;

	/**
	 * Get the device's model name.
	 * 
	 * device.name returns the name of the device's model or product. This value
	 * is set by the device manufacturer and may be different across versions of
	 * the same product.
	 * 
	 * Supported Platforms:
	 * <ul>
	 * <li>Android 2.1+</li>
	 * <li>BlackBerry</li>
	 * <li>iPhone</li>
	 * <ul>
	 * 
	 * @return the models device name
	 */
	public native String getName()/*-{
		if(typeof($wnd.device) == "undefined")
		{
		return "name";
		}

		return $wnd.device.name;
	}-*/;

	/**
	 * Get the version of phonegap running on the device.
	 * 
	 * Supported Platforms:
	 * <ul>
	 * <li>Android 2.1+</li>
	 * <li>BlackBerry</li>
	 * <li>iPhone</li>
	 * <ul>
	 * 
	 * @return the version of phonegap running on the device
	 */
	public native String getPhoneGapVersion()/*-{
		if(typeof($wnd.device) == "undefined")
		{
		return "name";
		}

		return $wnd.device.phonegap;
	}-*/;

	/**
	 * Get the device's operating system name.
	 * 
	 * <ul>
	 * <li>Android 2.1+</li>
	 * <li>iPhone</li>
	 * <ul>
	 * 
	 * @return the device's operating system name
	 */
	public native String getPlatform()/*-{
		if(typeof($wnd.device) == "undefined")
		{
		return "name";
		}

		return $wnd.device.platform;
	}-*/;

	/**
	 * Get the operating system version.
	 * 
	 * <ul>
	 * <li>Android 2.1+</li>
	 * <li>iPhone</li>
	 * <ul>
	 * 
	 * @return the device's operating system version
	 */
	public native String getVersion()/*-{
		if(typeof($wnd.device) == "undefined")
		{
		return "name";
		}

		return $wnd.device.version;
	}-*/;

}
