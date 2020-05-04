/***************************************************************
 -Author                : Geetha and Meghana
 -Created/Modified Date : 28/04/2020
 -Description           : Controller For Flight
 
*******************************************************************/


package com.capg.fms.flight.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.flight.model.Flight;
import com.capg.fms.flight.model.FlightList;
import com.capg.fms.flight.service.FlightServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/flights")
public class FlightController {
	/*
	 * http://localhost:9089/flights/add POSTMAN (Post : body{ "flightModel" :
	 * "SpiceJet", "carrierName" : "air", "seatCapacity" : 50 }) Don't insert
	 * number, number is :@GeneratedValue(strategy =GenerationType.SEQUENCE)
	 */

	@Autowired
	FlightServiceImpl flightservice;

	

	@PostMapping("/add")
	public Flight addFlight( @RequestBody Flight flight) {
		
		return flightservice.addFlight(flight);
	}

	/*
	 * This deleteFlightById(long flightNumber) method will removes a particular
	 * flight
	 */

	@DeleteMapping("/deleteById/{flightNumber}")
	public ResponseEntity<Flight> deleteFlight(@Valid @PathVariable long flightNumber) {
		flightservice.deleteFlight(flightNumber);
		return new ResponseEntity<Flight>(HttpStatus.OK);

	}

	/*
	 * This showAll() method will view the details of all flights
	 */
	
	@GetMapping("/all")
	public ResponseEntity<FlightList> getAllFlights() {
		FlightList allFlights = flightservice.getAll();
		return new ResponseEntity<FlightList>(allFlights, HttpStatus.OK);
	}

	/*
	 * This modifyFlight method will update Particular Flight
	 */
	@PostMapping("/modify")
	public ResponseEntity<Flight> modifyFlight(@Valid @RequestBody Flight flight) {
		Flight newFlight = flightservice.modifyFlight(flight);
		return new ResponseEntity<Flight>(flight, HttpStatus.OK);
	}

	@GetMapping("/id/{flightNumber}")
	public ResponseEntity<Flight> getFlightById(@PathVariable int flightNumber) {

		Flight flight = flightservice.getFlightById(flightNumber);

		return new ResponseEntity<Flight>(flight, HttpStatus.OK);
	}

	@ExceptionHandler(Exception.class)
	public String inValid(Exception e) {
		return e.getMessage();
	}

}
