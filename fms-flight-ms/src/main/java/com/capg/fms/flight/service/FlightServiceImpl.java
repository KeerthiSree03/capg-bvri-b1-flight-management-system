
/*************************************************************************
 -Author                            : Geetha and Meghana
 -Created/Modified Date             : 28/04/2020
 -Description                       : FlightServiceImpl implements IFlightService
 						               for Flight Management System
***************************************************************************/


package com.capg.fms.flight.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.flight.exception.FlightAlreadyExistException;
import com.capg.fms.flight.exception.FlightNotFoundException;
import com.capg.fms.flight.exception.InvalidInputException;
import com.capg.fms.flight.model.Flight;
import com.capg.fms.flight.model.FlightList;
import com.capg.fms.flight.repo.IFlightRepo;

@Service
public class FlightServiceImpl implements IFlightService {


	@Autowired(required = true)
	IFlightRepo flightRepo;
	

	/*************************************************************************
	 -FunctionName                     : addFlight
	 -Input Parameters                 : Flight Object
	 -Return Type                      : flight
	 -Throws				           : FlightAlreadyExistException
	 -Author				           : Geetha
	 -Creation Date			           : 28/04/2020
	 -Description			           : Adding Flight to database
	***************************************************************************/
	
	 @Override
	 //@Transactional
	  public Flight addFlight (Flight flight) {
		  System.out.println(flight);
		  if(flightRepo.existsById(flight.getFlightNumber())) {
			 throw new FlightAlreadyExistException("Flight Already Exits");
		  }
		 return flightRepo.save(flight);
	  }	
	  
	 /*************************************************************************
	 -FunctionName                      : deleteScheduleFlight
	 -Input Parameters                  : flightNumber
	 -Return Type                       : Void
	 -Throws				            : FlightNotFoundException
	 -Author				            : Geetha
	 -Creation Date			            : 28/04/2020
	 -Description			            : delete Flight based on Id
	***************************************************************************/

	 @Override
		@Transactional
		public void deleteFlight(long flightNumber) {
		 if(!flightRepo.existsById(flightNumber)) {
			 throw new FlightNotFoundException("flightNumber with "+flightNumber+" is NOT FOUND");
		 }
		 flightRepo.deleteById(flightNumber);
	 }
	 
	 
	 /*************************************************************************
	 -FunctionName                       : modifyScheduleFlight
	 -Input Parameters                   : flightNumber, filghtModel, carrierName, seatCapacity
	 -Return Type                        : newFlight
	 -Throws				             : FlightNotFoundException
	 -Author				             : Meghana 
	 -Creation Date			             : 28/04/2020
	 -Description			             : Modify Flight 
	***************************************************************************/
	 
	 @Override
		@Transactional
		public Flight modifyFlight(Flight flight) {
			if(!flightRepo.existsById(flight.getFlightNumber()))
				throw new FlightNotFoundException("flight with Num : " +flight.getFlightNumber()+" Not Found");
		
			Flight newFlight=flightRepo.getOne(flight.getFlightNumber());
			
			newFlight.setFlightModel(flight.getFlightModel());
			newFlight.setCarrierName(flight.getCarrierName());
			newFlight.setSeatCapacity(flight.getSeatCapacity());
			

		flightRepo.save(newFlight);
			return newFlight;	
		}
	 
	 
	 
	 /*************************************************************************
	 -FunctionName                       : viewScheduleFlight
	 -Input Parameters                   : flightNumber
	 -Return Type                        : flightNumber
	 -Throws			               	 : FlightNotFoundException
	 -Author				             : Meghana 
	 -Creation Date			             : 28/04/2020
	 -Description			             : Viewing Flight based on Number
	***************************************************************************/
	 
	 
	  @Override
	 		public Flight getFlightById(long flightNumber) {
	 			// TODO Auto-generated method stub
	 			if (!flightRepo.existsById(flightNumber)) {
	 				throw new FlightNotFoundException(" Flight not found");
	 			}
	 			return flightRepo.findById(flightNumber).get();
	 		}

	
	  /*************************************************************************
		 -FunctionName                    : getAll
		 -Input Parameters                : None
		 -Return Type                     : flight
		 -Throws				          : None
		 -Author				          : Geetha 
		 -Creation Date			          : 28/04/2020
		 -Description			          : Viewing Flight List
		***************************************************************************/

	 @Override
	
		public FlightList getAll(){	
			return new FlightList(flightRepo.findAll());
		}
	 



	}
		

	
	

