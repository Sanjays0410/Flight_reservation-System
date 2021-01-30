package com.cruds.frs.exception;

public class FRSException extends RuntimeException {
	
	private String info;

	public FRSException(String info) {
		super();
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	

}
