package com.capg.fms.user.service;

import java.util.List;

import com.capg.fms.user.model.Booking;
import com.capg.fms.user.model.BookingList;
import com.capg.fms.user.model.Flight;
import com.capg.fms.user.model.FlightList;

public interface ICustomerService {
	
	FlightList checkAvailableFlights();
	Booking makeBooking(Booking booking);
	BookingList viewBookingList();
	void cancelBooking(long booking);
	Booking modifyBooking(Booking booking);

}
