package com.capg.fms.user.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.capg.fms.user.model.Booking;
import com.capg.fms.user.model.BookingList;
import com.capg.fms.user.model.Flight;
import com.capg.fms.user.model.FlightList;

public interface ICustomerService {
	
	FlightList viewAllFlights();
	public String checkScheduledFlightById(long flightNumber);
	public boolean checkSeatAvailability(long flightNumber, int availableSeats);
	public String checkSource(long flightNumber,String sourceAirport);
	public String checkDestination(long flightNumber,String destinationAirport);
	public String checkSourceAndDestination( long flightNumber,  String sourceAirport, String destinationAirport);
	
	Booking makeBooking(Booking booking);
	BookingList viewBookingList();
	void cancelBooking(long booking);
	Booking modifyBooking(Booking booking);

}
