package com.capg.fms.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.fms.user.model.Booking;
import com.capg.fms.user.model.BookingList;
import com.capg.fms.user.model.FlightList;
import com.capg.fms.user.model.Passenger;
import com.capg.fms.user.model.PassengerList;
import com.capg.fms.user.model.ScheduledFlightList;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public FlightList viewAllFlights() {
		return restTemplate.getForObject("http://flight-ms/flights/all", FlightList.class);
	}

	public String checkScheduledFlightById(long flightNumber) {
		return restTemplate.getForObject("http://schedule-ms/availabilityflight/" + flightNumber, String.class);
	}

	public String checkSeatAvailability(long flightNumber, int availableSeats) {
		return restTemplate.getForObject("http://schedule-ms/availabilityflight/" + flightNumber + "/" + availableSeats,
				String.class);
	}

	public String checkSource(long flightNumber, String sourceAirport) {
		return restTemplate.getForObject("http://schedule-ms/availabilityflight/" + flightNumber + sourceAirport,
				String.class);
	}

	public String checkDestination(long flightNumber, String destinationAirport) {
		return restTemplate.getForObject("http://schedule-ms/availabilityflight/" + flightNumber + destinationAirport,
				String.class);
	}

	public String checkSourceAndDestination(String sourceAirport, String destinationAirport) {
		return restTemplate.getForObject("http://schedule-ms/availabilityflight/" + sourceAirport + destinationAirport,
				String.class);
	}

	@Override
	public Booking makeBooking(Booking booking) {
		return restTemplate.postForObject("http://booking-ms/booking/add", booking, Booking.class);

	}

	@Override
	public BookingList viewBookingList() {
		return restTemplate.getForObject("http://booking-ms/booking/all", BookingList.class);
	}

	@Override
	public void cancelBooking(long bookingId) {
		restTemplate.delete("http://booking-ms/booking/delete/" + bookingId);
	}

	@Override
	public Booking modifyBooking(Booking booking) {
		return restTemplate.postForObject("http://booking-ms/booking/modify", booking, Booking.class);
	}

	@Override
	public Booking viewBookingByBookingId(long bookingId) {
		return restTemplate.getForObject("http://booking-ms/booking/id/" + bookingId, Booking.class);
	}

	@Override
	public Passenger addPassenger(Passenger passenger) {
		return restTemplate.postForObject("http://passenger-ms/passenger/add", passenger, Passenger.class);
	}

	@Override
	public void deletePassenger(long passengerNum) {
		restTemplate.delete("http://passenger-ms/passenger/delete/num/" + passengerNum);
	}

	@Override
	public Passenger getPassenger(long passengerNum) {
		return restTemplate.getForObject("http://passenger-ms/passenger/num/" + passengerNum, Passenger.class);
	}

	@Override
	public PassengerList getAllPasssengers() {
		return restTemplate.getForObject("http://passenger-ms/passenger/all", PassengerList.class);
	}

	@Override
	public Passenger updatePassenger(Passenger passenger) {
		return restTemplate.postForObject("http://passenger-ms/passenger/update", passenger, Passenger.class);
	}

	@Override
	public long getCountOfPassenger() {
		return restTemplate.getForObject("http://passenger-ms/passenger/getcount", long.class);
	}

	public ScheduledFlightList viewAllScheduledFlight() {
		return restTemplate.getForObject("http://schedule-ms/scheduleflight/viewall", ScheduledFlightList.class);
	}

}
