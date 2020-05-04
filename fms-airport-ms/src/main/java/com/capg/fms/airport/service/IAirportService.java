package com.capg.fms.airport.service;

import java.util.List;

import com.capg.fms.airport.model.Airport;

//Author                : G.Harshitha
//Created/Modified Date : 22/04/2020
//Description           : IAirportService interface for Airport Management system
public interface IAirportService {
	
	List<Airport> getAllAirports();
	Airport getAirportByCode(String airportCode);
	Airport addAirport(Airport airport);
	void deleteAirport(String airportCode);
	public Airport getAirportByName(String airportName);
	
}
