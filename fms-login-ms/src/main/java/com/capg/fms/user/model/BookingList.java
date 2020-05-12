package com.capg.fms.user.model;

import java.util.List;

public class BookingList {

	private List<Booking> BookingList;

	public BookingList(List<Booking> bookingList) {
		super();
		BookingList = bookingList;
	}

	public List<Booking> getBookingList() {
		return BookingList;
	}

	public void setBookingList(List<Booking> bookingList) {
		BookingList = bookingList;
	}

	public BookingList() {
		super();
	}
	
	
}
