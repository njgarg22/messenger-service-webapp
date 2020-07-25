package com.neeraj.messenger.exception;

public class DataNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -3612884227889799065L;
	
	public DataNotFoundException(String message) {
		super(message);
	}

}
