package com.googlecode.gwtphonegap.client.file;

public class Flags {
	private boolean create;

	private boolean exclusive;

	public Flags() {

	}

	public Flags(boolean create, boolean exclusive) {
		this.create = create;
		this.exclusive = exclusive;

	}

	public void setCreate(boolean create) {
		this.create = create;
	}

	public void setExclusive(boolean exclusive) {
		this.exclusive = exclusive;
	}

	public boolean isCreate() {
		return create;
	}

	public boolean isExclusive() {
		return exclusive;
	}

}
