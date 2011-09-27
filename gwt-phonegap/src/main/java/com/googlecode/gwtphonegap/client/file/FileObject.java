package com.googlecode.gwtphonegap.client.file;

import java.util.Date;

public interface FileObject {
	public String getName();

	public String getFullPath();

	public String getType();

	public Date getLastModifiedDate();

	public long size();
}
