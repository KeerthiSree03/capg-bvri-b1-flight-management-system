package com.capg.fms.flight.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


public class ScheduledFlight {
	
	private int scheduleFlightId;

	private int availableSeats;
	

	private long flightNumber;

	private Schedule sourceAirport;

	private Schedule destinationAirport;

	private Schedule arrivalTime;

	private Schedule departureTime;

	private long ticketcost;

	public ScheduledFlight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScheduledFlight(int scheduleFlightId, int availableSeats, long flightNumber, Schedule sourceAirport,
			Schedule destinationAirport, Schedule arrivalTime, Schedule departureTime, long ticketcost) {
		super();
		this.scheduleFlightId = scheduleFlightId;
		this.availableSeats = availableSeats;
		this.flightNumber = flightNumber;
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.ticketcost = ticketcost;
	}

	public int getScheduleFlightId() {
		return scheduleFlightId;
	}

	public void setScheduleFlightId(int scheduleFlightId) {
		this.scheduleFlightId = scheduleFlightId;
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

	public Schedule getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(Schedule sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public Schedule getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(Schedule destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public Schedule getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Schedule arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Schedule getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Schedule departureTime) {
		this.departureTime = departureTime;
	}

	public long getTicketcost() {
		return ticketcost;
	}

	public void setTicketcost(long ticketcost) {
		this.ticketcost = ticketcost;
	}

	@Override
	public String toString() {
		return "ScheduledFlight [scheduleFlightId=" + scheduleFlightId + ", availableSeats=" + availableSeats
				+ ", flightNumber=" + flightNumber + ", sourceAirport=" + sourceAirport + ", destinationAirport="
				+ destinationAirport + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime
				+ ", ticketcost=" + ticketcost + "]";
	}

}
