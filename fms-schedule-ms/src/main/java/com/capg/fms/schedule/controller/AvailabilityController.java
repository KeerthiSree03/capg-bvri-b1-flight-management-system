/*************************************************************************
 -Author                : Karthikeswar Rao 
 -Created/Modified Date : 28/04/2020
 -Description           : Controller for checking the availability of flights
***************************************************************************/

package com.capg.fms.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.schedule.service.IAvailabilityService;

@RestController
@RequestMapping("/availabilityflight")
public class AvailabilityController {

	@Autowired
	IAvailabilityService service;

	@GetMapping("/{flightNumber}")

	public String checkScheduledFlightById(@PathVariable long flightNumber) {
		
			return service.checkScheduledFlightById(flightNumber);
		
	}

	@GetMapping("/{flightNumber}/{availableSeats}")
	public boolean checkSeatAvailability(@PathVariable long flightNumber, @PathVariable int availableSeats) {
		return service.checkSeatAvailability(flightNumber, availableSeats);
	}

	@GetMapping("/{flightNumber}/source/{sourceAirport}")
	public String checkSource(@PathVariable long flightNumber, @PathVariable String sourceAirport) {
		return service.checkSource(flightNumber, sourceAirport);
	}

	@GetMapping("/{flightNumber}/destination/{destinationAirport}")
	public String checkDestination(@PathVariable long flightNumber, @PathVariable String destinationAirport) {
		return service.checkDestination(flightNumber, destinationAirport);
	}

	@GetMapping("/source/{sourceAirport}/destination/{destinationAirport}")
	public String checkSourceAndDestination(@PathVariable String sourceAirport,
			@PathVariable String destinationAirport) {
		return service.checkSourceAndDestination(sourceAirport, destinationAirport);
	}
}