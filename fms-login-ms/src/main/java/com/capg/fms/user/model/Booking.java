package com.capg.fms.user.model;

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
    
	
	private String  bookingId;
    private String userId;                  //private User userId;
    //@JsonFormat(pattern="yyyy-MM-dd")
	private String bookingDate;
	//@ElementCollection
	private List<String> passengerList;     //private List<Passenger> passengerList;
	private String  ticketCost;
	private String flightNumber;            //private Flight flight;
	private String noOfPassengers;

	public Booking() {	}
	
	public Booking(String bookingId, String userId, String bookingDate, List<String> passengerList, String ticketCost,
			String flightNumber, String noOfPassengers) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.bookingDate = bookingDate;
		this.passengerList = passengerList;
		this.ticketCost = ticketCost;
		this.flightNumber = flightNumber;
		this.noOfPassengers = noOfPassengers;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public List<String> getPassengerList() {
		return passengerList;
	}
	
	public void setPassengerList(List<String> passengerList) {
		this.passengerList = passengerList;
	}
	
	public String getTicketCost() {
		return ticketCost;
	}


	public void setTicketCost(String ticketCost) {
		this.ticketCost = ticketCost;
	}

	
	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(String noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", userId=" + userId + ", bookingDate=" + bookingDate
				+ ", passengerList=" + passengerList + ", ticketCost=" + ticketCost + ", flightNumber=" + flightNumber
				+ ", noOfPassengers=" + noOfPassengers + "]";
	}

}
