package com.googlecode.gwtphonegap.client.file;

public interface FileTransferProgressEvent {
	
	public boolean isLengthComputable();
	
	public long getLoadedBytes();
	
	public long getTotalBytes();
}
