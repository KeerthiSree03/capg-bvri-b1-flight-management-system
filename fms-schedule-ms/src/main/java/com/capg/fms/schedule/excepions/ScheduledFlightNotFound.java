package com.capg.fms.schedule.excepions;

public class ScheduledFlightNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ScheduledFlightNotFound(String message) {
		
		super(message);
		
	}

}
