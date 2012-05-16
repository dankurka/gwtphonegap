package com.googlecode.gwtphonegap.client.storage;

public interface Storage {
	public Database openDatabase(String dbName, String dbVersion, int dbSize);
	
}
