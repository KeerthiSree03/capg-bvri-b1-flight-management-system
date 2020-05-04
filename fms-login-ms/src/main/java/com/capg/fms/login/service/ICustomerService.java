package com.capg.fms.login.service;

import java.util.List;

import com.capg.fms.login.model.Booking;
import com.capg.fms.login.model.BookingList;
import com.capg.fms.login.model.Flight;
import com.capg.fms.login.model.FlightList;

public interface ICustomerService {
	
	FlightList checkAvailableFlights();
	Booking makeBooking(Booking booking);
	BookingList viewBookingList();
	void cancelBooking(long booking);
	Booking modifyBooking(Booking booking);

}
