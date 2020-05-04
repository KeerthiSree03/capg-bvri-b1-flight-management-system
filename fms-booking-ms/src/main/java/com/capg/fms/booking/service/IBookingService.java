package com.capg.fms.booking.service;

import java.util.List;

import com.capg.fms.booking.model.Booking;
import com.capg.fms.booking.model.BookingList;
import com.capg.fms.booking.model.Passenger;

public interface IBookingService{
	
	Booking addBooking(Booking booking) ;
	Booking viewBookingByBookingId(long bookingId);
	BookingList viewAllBookings();
	Booking modifyBooking(Booking booking);
	boolean deleteBooking(long bookingId);
	
	boolean validateBookingId(long bookingId);
	boolean validateUserId(long id);
	boolean validateNoOfPAssengers(int noOfPassengers);
	
	void validateBooking(Booking booking);
	void validatePassenger(Passenger passenger);
	
}
