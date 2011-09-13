package de.kurka.phonegap.client.connection;

public interface Connection {

	public static String UNKNOWN = "unknown";
	public static String ETHERNET = "ethernet";
	public static String WIFI = "wifi";
	public static String CELL_2G = "2g";
	public static String CELL_3G = "3g";
	public static String CELL_4G = "4g";
	public static String NONE = "none";

	public String getType();
}
