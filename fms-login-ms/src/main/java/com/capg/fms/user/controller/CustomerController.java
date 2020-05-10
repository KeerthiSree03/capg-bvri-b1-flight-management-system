package com.capg.fms.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.user.model.Booking;
import com.capg.fms.user.model.BookingList;
import com.capg.fms.user.model.FlightList;
import com.capg.fms.user.service.ICustomerService;

@RestController
@RequestMapping("/users")
public class CustomerController {

	@Autowired
	ICustomerService service;

	@GetMapping("/u/flights/all")
	public FlightList viewAllFlights() {

		return service.viewAllFlights();
	}

	@GetMapping("/u/availability/{flightNumber}")
	public String checkScheduledFlightById(@PathVariable long flightNumber) {
		return service.checkScheduledFlightById(flightNumber);
	}

	@GetMapping("/u/availability/{flightNumber}/{availableSeats}")
	public boolean checkSeatAvailability(@PathVariable long flightNumber, @PathVariable int availableSeats) {
		return service.checkSeatAvailability(flightNumber, availableSeats);
	}

	@GetMapping("/u/availability/{flightNumber}/source/{availableSeats}")
	public String checkSource(@PathVariable long flightNumber, @PathVariable String sourceAirport) {
		return service.checkDestination(flightNumber, sourceAirport);
	}

	@GetMapping("/u/availability/{flightNumber}/destination/{availableSeats}")
	public String checkDestination(@PathVariable long flightNumber, @PathVariable String destinationAirport) {
		return service.checkDestination(flightNumber, destinationAirport);
	}

	@GetMapping("/u/source/{sourceAirport}/destination/{destinationAirport}")
	public String checkSourceAndDestination(@PathVariable String sourceAirport,
			@PathVariable String destinationAirport) {

		return service.checkSourceAndDestination(sourceAirport, destinationAirport);
	}

	@PostMapping("/u/booking/add")
	public Booking makeBooking(@RequestBody Booking booking) {

		return service.makeBooking(booking);

	}

	@GetMapping("/u/booking/all")
	public BookingList viewBookingList() {

		return service.viewBookingList();
	}

	@DeleteMapping("/u/delete/{bookingId}")
	public void cancelBooking(@PathVariable long bookingId) {

		service.cancelBooking(bookingId);
	}

	@PostMapping("/u/booking/modify")
	public Booking modifyBooking(@RequestBody Booking booking) {

		return service.modifyBooking(booking);
	}

	@GetMapping("/u/booking/id/{bookingId}")
	public Booking viewBookingByBookingId(long bookingId) {
	return service.viewBookingByBookingId(bookingId);	
		
	}
}
