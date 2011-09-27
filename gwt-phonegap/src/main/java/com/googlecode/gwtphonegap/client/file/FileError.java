package com.googlecode.gwtphonegap.client.file;

public interface FileError {

	public static final int NOT_FOUND_ERR = 1;
	public static final int SECURITY_ERR = 2;
	public static final int ABORT_ERR = 3;
	public static final int NOT_READABLE_ERR = 4;
	public static final int ENCODING_ERR = 5;
	public static final int NO_MODIFICATION_ALLOWED_ERR = 6;
	public static final int INVALID_STATE_ERR = 7;
	public static final int SYNTAX_ERR = 8;
	public static final int INVALID_MODIFICATION_ERR = 9;
	public static final int QUOTA_EXCEEDED_ERR = 10;
	public static final int TYPE_MISMATCH_ERR = 11;
	public static final int PATH_EXISTS_ERR = 12;

	public int getErrorCode();
}
