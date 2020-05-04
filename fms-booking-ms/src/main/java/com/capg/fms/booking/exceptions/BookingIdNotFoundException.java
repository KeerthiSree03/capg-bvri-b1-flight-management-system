package com.capg.fms.booking.exceptions;


public class BookingIdNotFoundException extends RuntimeException{

	public BookingIdNotFoundException(String message) {
		super(message);
	}
}
