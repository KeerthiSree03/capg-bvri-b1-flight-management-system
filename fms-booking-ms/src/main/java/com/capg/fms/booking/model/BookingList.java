package com.capg.fms.booking.model;

import java.util.List;

public class BookingList {

	private List<Booking> bookingList;

	
	public BookingList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingList(List<Booking> bookingList) {
		super();
		this.bookingList = bookingList;
	}

	public List<Booking> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<Booking> bookingList) {
		this.bookingList = bookingList;
	}
	
	
	
}
