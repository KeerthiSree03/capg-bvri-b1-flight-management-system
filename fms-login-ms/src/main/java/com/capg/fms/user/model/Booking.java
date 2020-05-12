package com.capg.fms.user.model;

import java.util.List;



public class Booking {
    
	
	private String  bookingId;
    private String userId;                    
	private String bookingDate;
	private List<String> passengerList;     
	private String  ticketCost;
	private String flightNumber;            
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
