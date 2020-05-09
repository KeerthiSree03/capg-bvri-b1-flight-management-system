/*************************************************************************
 -Author                : Karthikeswar Rao 
 -Created/Modified Date : 28/04/2020
 -Description           : AvailabilityServiceImpl implements services for IAvailabilityService
 						  for Schedule Management System
***************************************************************************/

package com.capg.fms.schedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.capg.fms.schedule.excepions.FlightNotFoundException;
import com.capg.fms.schedule.excepions.InvalidInputException;
import com.capg.fms.schedule.excepions.SeatsAreNotAvailableException;
import com.capg.fms.schedule.repository.IAvailabilityScheduleRepo;
import com.capg.fms.schedule.repository.IAvailabilityScheduledFlightRepo;

@Service
public class AvailabilityServiceImpl implements IAvailabilityService {

	@Autowired
	IAvailabilityScheduledFlightRepo flightRepository;
	
	/*
	 * @Autowired RestTemplate restTemplate;
	 */
	@Autowired
	IAvailabilityScheduleRepo scheduleRepo;
	
	/*************************************************************************
	 -FunctionName          : checkScheduledFlightById
	 -Input Parameters      : long flightNumber
	 -Return Type           : String
	 -Throws				: FlightNotFoundException
	 -Author				: Karthikeswar Rao 
	 -Creation Date			: 28/04/2020
	***************************************************************************/

	@Override
	public String checkScheduledFlightById(long flightNumber) {

		if(!flightRepository.existsByFlightNumber(flightNumber)) {
			
			throw new InvalidInputException("No availability");
		}
		return "The flight is available";
	}
	
	/*************************************************************************
	 -FunctionName          : checkSeatAvailability
	 -Input Parameters      : long flightNumber, int availableSeats
	 -Return Type           : boolean
	 -Throws				: SeatsAreNotAvailableException
	 -Author				: Karthikeswar Rao 
	 -Creation Date			: 28/04/2020
	***************************************************************************/
	
	@Override
	public boolean checkSeatAvailability(long flightNumber, int availableSeats) {
		
		if (!flightRepository.existsByFlightNumber(flightNumber)) {
			throw new InvalidInputException("Please Check Flight Number");
		}
		else if (flightRepository.existsAvailableSeats(availableSeats) != flightRepository.exists(availableSeats)|| availableSeats <= 0) {
			throw new InvalidInputException("No availability");
		}	
		return true;
	}

	/*************************************************************************
	 -FunctionName          : checkSource
	 -Input Parameters      : long flightNumber,String sourceAirport
	 -Return Type           : String
	 -Throws				: InvalidInputException
	 -Author				: Karthikeswar Rao 
	 -Creation Date			: 28/04/2020
	***************************************************************************/	
	
	@Override
	public String checkSource(long flightNumber,String sourceAirport) {
		if(flightRepository.existsByFlightNumber(flightNumber)) {
			if(!scheduleRepo.findAll().contains(scheduleRepo.existsSourceAirport(sourceAirport))) {
				throw new InvalidInputException("Source Airport is not valid");
			}
		}	
		return "Source Airport is valid";
	}
	
	/*************************************************************************
	 -FunctionName          : checkDestination
	 -Input Parameters      : long flightNumber, String destinationAirport
	 -Return Type           : String
	 -Throws				: InvalidInputException
	 -Author				: Karthikeswar Rao 
	 -Creation Date			: 28/04/2020
	***************************************************************************/
	
	@Override
	public String checkDestination(long flightNumber, String destinationAirport) {
		if(flightRepository.existsByFlightNumber(flightNumber)) {
			if(!scheduleRepo.findAll().contains(scheduleRepo.existsDestinationAirport(destinationAirport))) {
				throw new InvalidInputException("Destination Airport is not valid");
			}
		}	
		return "Destination Airport is valid";
	}
	
	/*************************************************************************
	 -FunctionName          : checkSourceAndDestination
	 -Input Parameters      : long flightNumber, String sourceAirport, String destinationAirport
	 -Return Type           : String
	 -Throws				: InvalidInputException
	 -Author				: Karthikeswar Rao 
	 -Creation Date			: 28/04/2020
	***************************************************************************/

	@Override
	public String checkSourceAndDestination( String sourceAirport, String destinationAirport) {
		
			if(!scheduleRepo.findAll().contains(scheduleRepo.existsSourceAirport(sourceAirport))) {
				throw new InvalidInputException("Flight is not available");
			}
			else if(flightRepository.findAll().contains(scheduleRepo.existsDestinationAirport(destinationAirport))) {
				throw new InvalidInputException("Flight is not available");
			}
		
		return "Flight is available";
}
	
	@Override
	public boolean validateFlightId(long flightNumber) {

		int count=0;
		while(flightNumber>0) {
			count++;
			flightNumber=flightNumber/10;
		}
		
		if(count<12 || count>12) {
			throw new InvalidInputException("ID should be of 12 digits");	
		}
		return true;
	}
}