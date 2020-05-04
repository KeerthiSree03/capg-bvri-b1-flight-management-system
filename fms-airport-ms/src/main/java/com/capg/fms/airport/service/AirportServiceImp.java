package com.capg.fms.airport.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.airport.exception.AirportAlreadyExistsException;
import com.capg.fms.airport.exception.AirportNotFoundException;
import com.capg.fms.airport.model.Airport;
import com.capg.fms.airport.repository.IAirportRepo;

//Author                : G.Harshitha
//Created/Modified Date : 22/04/2020
//Description           : AirportServiceImp class implements services for Airport management System
@Service
public class AirportServiceImp implements IAirportService {
	
	@Autowired(required=true)
    IAirportRepo airportRepo;

//	Function Name   : getAllAirports
//	Input Parameters: None
//  ReturnType      : Airport objects
//	Throws          : None
//  Author          : G.Harshitha
//  Creation Date   : 28/04/2020
//  Description     : getting all airports details stored in the database.
	@Override
	public List<Airport> getAllAirports() {
		return airportRepo.findAll();
	}
	
//	Function Name   : getAirportByCode
//	Input Parameters: String airportCode
//  ReturnType      : Airport
//  Throws          : AirportNotFoundException
//  Author          : G.Harshitha
//  Creation Date   : 28/04/2020
//  Description     : getting airport details from the database calls method getAirportByCode(String airportCode).
	@Override
	@Transactional
	public Airport getAirportByCode(String airportCode) {
		
		if(!airportRepo.existsById(airportCode)) {	
			System.out.println(airportCode);
			throw new AirportNotFoundException("Airport with code : ["+airportCode+"] Not Found");
        }
		return airportRepo.getOne(airportCode);
   }

//	Function Name   : addAirport
//	Input Parameters: Airport Object
//  ReturnType      : Airport
//  Throws          : RUntimeException
//  Author          : G.Harshitha
//  Creation Date   : 28/04/2020
//  Description     : adding airport to the database calls method addAirport(Airport)					
	@Override
	@Transactional
	public Airport addAirport(Airport airport) {
		System.out.println(airport);
		if(airportRepo.existsById(airport.getAirportCode())) {
			throw new AirportAlreadyExistsException("Airport already exists");
		}
			return airportRepo.save(airport);
	}
//	Function Name   : deleteAirport
//	Input Parameters: String airportCode
//  ReturnType      : None
//  Throws          : AirportNotFoundException
//  Author          : G.Harshitha
//  Creation Date   : 28/04/2020
//  Description     : deleting airport from the database calls method deleteAirport(String airportCode)
	@Override
	@Transactional
	public void deleteAirport(String airportCode) {
		if(!airportRepo.existsById(airportCode)){
			throw new AirportNotFoundException("Airport with code : ["+airportCode+"] Not Found");
		}
		airportRepo.deleteById(airportCode);
	}

	public Airport getAirportByName(String airportName) {
		
		return  airportRepo.findByAirportName(airportName);
	}
	
}




	