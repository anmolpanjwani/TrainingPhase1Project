package com.lockerapp.model;

public class FileLocker{
	private String filename;

	public FileLocker(String filename) {
		super();
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "File [filename=" + filename + "]";
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	
}
