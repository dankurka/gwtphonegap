package com.googlecode.gwtphonegap.client.storage;

public interface Database {
	
	public void executeTransaction(TransactionCallback callback);
	
	public void changeVersion(String current, String desired);

}
