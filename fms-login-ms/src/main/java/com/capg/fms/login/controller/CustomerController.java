package com.capg.fms.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.login.model.Booking;
import com.capg.fms.login.model.BookingList;
import com.capg.fms.login.model.FlightList;
import com.capg.fms.login.service.ICustomerService;

@RestController
@RequestMapping("/users")
public class CustomerController {
	
	@Autowired
	ICustomerService service;
	
	@GetMapping("/u/flights/all")
	public FlightList checkAvailableFlights() {
		
		return service.checkAvailableFlights();
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
	@PostMapping("/u/modify")
	public Booking modifyBooking(@RequestBody Booking booking) {
		
		return service.modifyBooking(booking);
	}
	
}
