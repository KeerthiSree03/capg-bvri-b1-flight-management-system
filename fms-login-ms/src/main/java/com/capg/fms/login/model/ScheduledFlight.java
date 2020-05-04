package com.capg.fms.login.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


public class ScheduledFlight {
	
	private int scheduledFlightId;

	
	private int availableSeats;

	
	private long flightNumber;


	private Schedule schedule;

	public ScheduledFlight() {
		super();

	}

	public ScheduledFlight(int scheduleFlightId, int availableSeats, long flightNumber, Schedule schedule) {
		super();
		this.scheduledFlightId = scheduleFlightId;
		this.availableSeats = availableSeats;
		this.flightNumber = flightNumber;
		this.schedule = schedule;

	}

	public int getScheduledFlightId() {
		return scheduledFlightId;
	}

	public void setScheduledFlightId(int scheduledFlightId) {
		this.scheduledFlightId = scheduledFlightId;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(long flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "ScheduledFlight [scheduledFlightId=" + scheduledFlightId + ", availableSeats=" + availableSeats
				+  ", flightNumber=" + flightNumber + ", schedule=" + schedule
				+ "]";
	}

}
