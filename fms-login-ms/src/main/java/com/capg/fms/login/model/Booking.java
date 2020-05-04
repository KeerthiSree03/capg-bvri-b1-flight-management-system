package com.capg.fms.login.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;



public class Booking {
    
	
	private long bookingId;
    private long userId;                  //private User userId;
    //@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate bookingDate;
	//@ElementCollection
	private List<Long> passengerList;     //private List<Passenger> passengerList;
	private double ticketCost;
	private long flightNumber;            //private Flight flight;
	private int noOfPassengers;

	public Booking() {	}
	
	public Booking(long bookingId, long userId, LocalDate bookingDate, List<Long> passengerList, double ticketCost,
			long flightNumber, int noOfPassengers) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.bookingDate = bookingDate;
		this.passengerList = passengerList;
		this.ticketCost = ticketCost;
		this.flightNumber = flightNumber;
		this.noOfPassengers = noOfPassengers;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

    public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public List<Long> getPassengerList() {
		return passengerList;
	}
	
	public void setPassengerList(List<Long> passengerList) {
		this.passengerList = passengerList;
	}
	
	public double getTicketCost() {
		return ticketCost;
	}


	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}

	
	public long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(long flightNumber) {
		this.flightNumber = flightNumber;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", userId=" + userId + ", bookingDate=" + bookingDate
				+ ", passengerList=" + passengerList + ", ticketCost=" + ticketCost + ", flightNumber=" + flightNumber
				+ ", noOfPassengers=" + noOfPassengers + "]";
	}

}
