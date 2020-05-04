package com.capg.fms.airport.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.airport.model.Airport;
import com.capg.fms.airport.service.IAirportService;

//Author                : G.Harshitha
//Created/Modified Date : 22/04/2020
//Description           : AirportController class for Airport Management System 
@RestController
@RequestMapping("/airport")
public class AirportController {
	
	@Autowired
	IAirportService service;

	
	@GetMapping("/all")
	public ResponseEntity<List<Airport>> getAllAirports(){
		List<Airport> allAirports = service.getAllAirports();
		return new ResponseEntity<List<Airport>>(allAirports,HttpStatus.OK);
	}

	
	@GetMapping("/airport/{airportCode}")
	public ResponseEntity<Airport> getAirportByCode( @PathVariable String airportCode) {
		Airport airport=service.getAirportByCode(airportCode);	
		return new ResponseEntity<Airport>(airport,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Airport> addAirport( @RequestBody Airport airport) {
		service.addAirport(airport);
		return new ResponseEntity<Airport>(airport,HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{airportCode}")
	public ResponseEntity<Airport> deleteAirport( @PathVariable String airportCode) {
		 service.deleteAirport(airportCode);
		 return new ResponseEntity<Airport>(HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public String inValid(Exception e) {
		return e.getMessage();
	}
	
	@GetMapping("/airportname/{airportName}")
	public Airport getAirportByName(@PathVariable String airportName) {
		
		return service.getAirportByName(airportName);
		
	}
	
}
