package com.capg.fms.user.service;

import com.capg.fms.user.model.Booking;
import com.capg.fms.user.model.BookingList;
//github.com/KeerthiSree03/capg-bvri-b1-flight-management-system.git
import com.capg.fms.user.model.FlightList;
import com.capg.fms.user.model.Passenger;
import com.capg.fms.user.model.PassengerList;

public interface ICustomerService {
	
	FlightList viewAllFlights();
	public String checkScheduledFlightById(long flightNumber);
	public String checkSeatAvailability(long flightNumber, int availableSeats);
	public String checkSource(long flightNumber,String sourceAirport);
	public String checkDestination(long flightNumber,String destinationAirport);
	public String checkSourceAndDestination(String sourceAirport, String destinationAirport);
	
	Booking makeBooking(Booking booking);
	BookingList viewBookingList();
	void cancelBooking(long booking);
	Booking modifyBooking(Booking booking);
	public Booking viewBookingByBookingId(long bookingId);
	

	Passenger addPassenger(Passenger passenger);
	void deletePassenger(long passengerNum);
	Passenger getPassenger(long passengerNum);
	PassengerList getAllPasssengers();
	Passenger updatePassenger(Passenger passenger);
	public long getCountOfPassenger();

}
