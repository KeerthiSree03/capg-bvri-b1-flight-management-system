package com.capg.fms.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.capg.fms.user.model.Booking;
import com.capg.fms.user.model.BookingList;
import com.capg.fms.user.model.Flight;
import com.capg.fms.user.model.FlightList;

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

	public boolean checkSeatAvailability(long flightNumber, int availableSeats) {
		return restTemplate.getForObject("http://schedule-ms/availabilityflight/" + flightNumber + availableSeats,
				boolean.class);
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

		return restTemplate.getForObject(
				"http://schedule-ms/availabilityflight/"+ sourceAirport + destinationAirport,
				String.class);
	}

	@Override
	public Booking makeBooking(Booking booking) {

		return restTemplate.postForObject("http://booking-ms/booking/add", booking, Booking.class);

	}

	@Override
	public BookingList viewBookingList() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return restTemplate.getForObject("http://booking-ms/booking/id/"+bookingId, Booking.class);
	}

}
