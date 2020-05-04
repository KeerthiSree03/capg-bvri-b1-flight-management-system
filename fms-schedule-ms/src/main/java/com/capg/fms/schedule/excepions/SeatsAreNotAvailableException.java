package com.capg.fms.schedule.excepions;

public class SeatsAreNotAvailableException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public SeatsAreNotAvailableException(String message) {
		super(message);
	}

}
