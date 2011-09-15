package de.kurka.phonegap.client.capture;

import java.util.Date;

public interface MediaFile {
	public String getName();

	public String getFullPath();

	public String getType();

	public Date getLastModifiedDate();

	public long getSize();

	public void getFormatData(MediaFormatDataCallback callback);
}
