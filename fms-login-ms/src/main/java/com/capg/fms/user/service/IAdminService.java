package com.capg.fms.user.service;


import com.capg.fms.user.model.Airport;
import com.capg.fms.user.model.AirportList;
import com.capg.fms.user.model.Flight;
import com.capg.fms.user.model.ScheduledFlight;
import com.capg.fms.user.model.ScheduledFlightList;

public interface IAdminService {
	
	Flight addFlight(Flight flight);
	Flight viewFlight(long flightId);
	void cancelFlight(long flightId);
	Flight modifyFlight(Flight flight);
	
	ScheduledFlight addScheduledFlight (ScheduledFlight  flight);
	ScheduledFlight  viewScheduledFlight (long scheduledFlightId);
	void cancelScheduledFlight (long scheduledFlightId);
	ScheduledFlight modifyScheduledFlight(ScheduledFlight  flight);
	public ScheduledFlightList viewAllScheduledFlight();

	
	AirportList getAllAirports();
	Airport getAirportByCode(String airportCode);
	Airport addAirport(Airport airport);
	void deleteAirport(String airportCode);
}
