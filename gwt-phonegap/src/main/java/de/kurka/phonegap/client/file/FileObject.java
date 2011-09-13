package de.kurka.phonegap.client.file;

import java.util.Date;

public interface FileObject {
	public String getName();

	public String getFullPath();

	public String getType();

	public Date getLastModifiedDate();

	public long size();
}
