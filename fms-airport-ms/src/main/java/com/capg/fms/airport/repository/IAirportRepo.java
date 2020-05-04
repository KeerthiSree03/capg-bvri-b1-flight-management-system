package com.capg.fms.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.fms.airport.model.Airport;

//Author                : G.Harshitha
//Created/Modified Date : 22/04/2020
//Description           : IAirportRepo interface for Airport Management System
@Repository
public interface IAirportRepo extends JpaRepository<Airport,String> {

	//@Query("from Airport where airportName =:airportName")
	public Airport findByAirportName(String airportName);
	
	
}
