package com.capg.fms.schedule.excepions;

public class FlightNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public FlightNotFoundException(String message) {
		super(message);
	}
}
