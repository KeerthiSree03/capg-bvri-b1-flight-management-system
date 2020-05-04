  
/***************************************************************
 -Author                         : Geetha and Meghana
 -Created/Modified Date          : 28/04/2020
 -Description                    : IFlightService interface for 
 						           Flight Management system
*******************************************************************/



package com.capg.fms.flight.service;

import java.util.List;

import com.capg.fms.flight.model.Flight;
import com.capg.fms.flight.model.FlightList;



public interface IFlightService {
	

	public Flight addFlight(Flight flight);
	
	public Flight modifyFlight(Flight flight);
	
	public void deleteFlight(long flightNumber);
		
	 public Flight getFlightById(long flightNumber);
	 
	public FlightList getAll();
	
	

}
