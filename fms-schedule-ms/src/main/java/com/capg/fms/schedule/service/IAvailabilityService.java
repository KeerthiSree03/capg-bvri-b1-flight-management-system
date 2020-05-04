/***************************************************************
 -Author                : Karthikeswar Rao
 -Created/Modified Date : 28/04/2020
 -Description           : IAvailabilityService interface for 
 						  Schedule Management system
*******************************************************************/

package com.capg.fms.schedule.service;

import com.capg.fms.schedule.excepions.SeatsAreNotAvailableException;

public interface IAvailabilityService {

	
	String checkScheduledFlightById(long flightNumber);



	//boolean checkScheduledFlightById(long flightNumber);

	boolean checkSeatAvailability(long flightNumber,int availableSeats) throws SeatsAreNotAvailableException;
	String checkSource(long flightNumber, String sourceAirport);
	String checkDestination(long flightNumber, String destinationAirport);
	String checkSourceAndDestination(long flightNumber,String sourceAirport, String destinationAirport);
	boolean validateFlightId(long flightNumber);

}