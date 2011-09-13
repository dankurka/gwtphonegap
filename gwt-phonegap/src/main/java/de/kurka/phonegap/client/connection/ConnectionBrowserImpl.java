package de.kurka.phonegap.client.connection;

public class ConnectionBrowserImpl implements Connection {

	@Override
	public String getType() {
		return Connection.ETHERNET;
	}

}
