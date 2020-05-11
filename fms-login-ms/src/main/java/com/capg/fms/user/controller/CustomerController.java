package com.capg.fms.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.capg.fms.user.model.Passenger;
import com.capg.fms.user.model.PassengerList;
import com.capg.fms.user.model.ScheduledFlightList;
import com.capg.fms.user.service.ICustomerService;

@RestController
@RequestMapping("/users/customer")

public class CustomerController {

	@Autowired
	ICustomerService service;

	@GetMapping("/flights/all")
	public FlightList viewAllFlights() {

		return service.viewAllFlights();
	}

	@GetMapping("/availability/{flightNumber}")
	public String checkScheduledFlightById(@PathVariable long flightNumber) {
		return service.checkScheduledFlightById(flightNumber);
	}

	@GetMapping("/availability/{flightNumber}/{availableSeats}")
	public String checkSeatAvailability(@PathVariable long flightNumber, @PathVariable int availableSeats) {
		System.err.println("Customer controller"+flightNumber+availableSeats);
		return service.checkSeatAvailability(flightNumber, availableSeats);
	}

	@GetMapping("/availability/{flightNumber}/source/{availableSeats}")
	public String checkSource(@PathVariable long flightNumber, @PathVariable String sourceAirport) {
		return service.checkDestination(flightNumber, sourceAirport);
	}

	@GetMapping("/availability/{flightNumber}/destination/{availableSeats}")
	public String checkDestination(@PathVariable long flightNumber, @PathVariable String destinationAirport) {
		return service.checkDestination(flightNumber, destinationAirport);
	}

	@GetMapping("/source/{sourceAirport}/destination/{destinationAirport}")
	public String checkSourceAndDestination(@PathVariable String sourceAirport,
			@PathVariable String destinationAirport) {

		return service.checkSourceAndDestination(sourceAirport, destinationAirport);
	}

	@PostMapping("/booking/add")
	public Booking makeBooking(@RequestBody Booking booking) {

		return service.makeBooking(booking);
 
	}

	@GetMapping("/booking/all")
	public BookingList viewBookingList() {

		return service.viewBookingList();
	}

	@DeleteMapping("/delete/{bookingId}")
	public void cancelBooking(@PathVariable long bookingId) {

		service.cancelBooking(bookingId);
	}

	@PostMapping("/booking/modify")
	public Booking modifyBooking(@RequestBody Booking booking) {

		return service.modifyBooking(booking);
	}

	@GetMapping("/booking/id/{bookingId}")
	public Booking viewBookingByBookingId(long bookingId) {
		return service.viewBookingByBookingId(bookingId);

	}

	@PostMapping("/passenger/add")
	Passenger addPassenger(Passenger passenger) {
		return service.addPassenger(passenger);
	}

	@DeleteMapping("/passenger/delete/num/{passengerNum}")
	void deletePassenger(long passengerNum) {
		service.deletePassenger(passengerNum);
	}

	@GetMapping("/passenger/num/{passengerNum}")
	Passenger getPassenger(long passengerNum) {
		return service.getPassenger(passengerNum);
	}

	@GetMapping("/passenger/all")
	PassengerList getAllPasssengers() {
		return service.getAllPasssengers();
	}

	@PostMapping("/passenger/update")
	Passenger updatePassenger(Passenger passenger) {
		return service.updatePassenger(passenger);
	}

	@GetMapping("/passenger/getcount")
	public long getCountOfPassenger() {
		return service.getCountOfPassenger();
	}
	
	@GetMapping("/scheduledflights/all")
	public ScheduledFlightList viewAllScheduledFlight() {
		
		return service.viewAllScheduledFlight();
	}

}
