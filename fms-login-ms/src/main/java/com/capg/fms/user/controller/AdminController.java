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

import com.capg.fms.user.model.Airport;
import com.capg.fms.user.model.AirportList;
import com.capg.fms.user.model.Flight;
import com.capg.fms.user.model.ScheduledFlight;
import com.capg.fms.user.model.ScheduledFlightList;
import com.capg.fms.user.service.AdminService;

@RestController
@RequestMapping("/users")
public class AdminController {

	@Autowired
	AdminService service;
	
	@PostMapping("/a/flights/add")
	public Flight addFlight(@RequestBody Flight flight) {
		
		return service.addFlight(flight);
	}
	@GetMapping("/a/flights/id/{flightNumber}")
	public Flight viewFlight(@PathVariable long flightNumber) {
		
		return service.viewFlight(flightNumber);
	}
	@DeleteMapping("/a/flights/deleteById/{flightNumber}")
	public void cancelFlight(@PathVariable long flightNumber) {
		
		service.cancelFlight(flightNumber);
	}
	@PostMapping("/a/flights/modify")
	public Flight modifyFlight(@RequestBody Flight flight) {
		
		return service.modifyFlight(flight);
	}
	@PostMapping("/a/scheduleflight/add")
	public ScheduledFlight addScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {
		
		
		
		return service.addScheduledFlight(scheduledFlight);
	}
	@GetMapping("/a/scheduleflight/id/{scheduledFlightId}")
	public ScheduledFlight viewScheduledFlight(@PathVariable long scheduledFlightId) {
		
		return service.viewScheduledFlight(scheduledFlightId);
	}
	@DeleteMapping("/a/scheduleflight/delete/{scheduledFlightId}")
	public void cancelScheduledFlight(@PathVariable long scheduledFlightId) {
		service.cancelScheduledFlight(scheduledFlightId);
		
	}

	@PostMapping("/a/scheduleflight/modify")
	public ScheduledFlight modifyScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {
		
		return service.modifyScheduledFlight(scheduledFlight);
	}
	@GetMapping("/a/scheduleflight/viewall")
	public ScheduledFlightList viewAllScheduledFlight() {
		
		return service.viewAllScheduledFlight();
	}
	
	@GetMapping("/a/airport/all")
	AirportList getAllAirports() {
		return service.getAllAirports();
	}
	@GetMapping("/a/airport/{airportCode}")
	Airport getAirportByCode(@PathVariable String airportCode) {
		return service.getAirportByCode(airportCode);
	}
	@PostMapping("/a/airport/add")
	Airport addAirport(@RequestBody Airport airport) {
		return service.addAirport(airport);
	}
	@DeleteMapping("/a/airport/delete/{airportCode}")
	void deleteAirport(@PathVariable String airportCode) {
		service.deleteAirport(airportCode);
	}

	
	
}
