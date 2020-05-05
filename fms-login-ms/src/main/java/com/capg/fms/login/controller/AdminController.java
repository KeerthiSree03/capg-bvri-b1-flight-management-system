package com.capg.fms.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.login.model.Flight;
import com.capg.fms.login.model.ScheduledFlight;
import com.capg.fms.login.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService service;
	
	@PostMapping("/flights/add")
	public Flight addFlight(@RequestBody Flight flight) {
		
		return service.addFlight(flight);
	}
	@GetMapping("/flights/id/{flightNumber}")
	public Flight viewFlight(@PathVariable long flightNumber) {
		
		return service.viewFlight(flightNumber);
	}
	@DeleteMapping("/flights/deleteById/{flightNumber}")
	public void cancelFlight(@PathVariable long flightNumber) {
		
		service.cancelFlight(flightNumber);
	}
	@PostMapping("/flights/modify")
	public Flight modifyFlight(@RequestBody Flight flight) {
		
		return service.modifyFlight(flight);
	}
	@PostMapping("scheduleflight/add")
	public ScheduledFlight addScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {
		
		
		
		return service.addScheduledFlight(scheduledFlight);
	}
	@GetMapping("scheduleflight/id/{scheduledFlightId}")
	public ScheduledFlight viewScheduledFlight(@PathVariable long scheduledFlightId) {
		
		return service.viewScheduledFlight(scheduledFlightId);
	}
	@DeleteMapping("scheduleflight/delete/{scheduledFlightId}")
	public void cancelScheduledFlight(@PathVariable long scheduledFlightId) {
		service.cancelScheduledFlight(scheduledFlightId);
		
	}
	@PostMapping("scheduleflight/modify")
	public ScheduledFlight modifyScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {
		
		return service.modifyScheduledFlight(scheduledFlight);
	}
	
	
}
