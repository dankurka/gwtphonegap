package de.kurka.phonegap.client.connection;

public class ConnectionMobileImpl implements Connection {

	@Override
	public native String getType() /*-{
		return $wnd.navigator.network.connection.type;
	}-*/;

}
