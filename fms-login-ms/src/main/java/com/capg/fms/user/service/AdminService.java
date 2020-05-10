package com.capg.fms.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.fms.user.model.Airport;
import com.capg.fms.user.model.AirportList;
import com.capg.fms.user.model.Flight;
import com.capg.fms.user.model.FlightList;
import com.capg.fms.user.model.ScheduledFlight;
import com.capg.fms.user.model.ScheduledFlightList;

@Service
public class AdminService implements IAdminService {
	
	@Autowired
	RestTemplate restTemplate;

	public FlightList viewAllFlights() {

		return restTemplate.getForObject("http://flight-ms/flights/all", FlightList.class);
	}
	
	@Override
	public Flight addFlight(Flight flight) {
		// TODO Auto-generated method stub
		return restTemplate.postForObject("http://flight-ms/flights/add", flight, Flight.class);
	}

	@Override
	public Flight viewFlight(long flightNumber) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject("http://flight-ms/flights/id/"+flightNumber ,Flight.class);
	}

	@Override
	public void cancelFlight(long flightNumber) {
		// TODO Auto-generated method stub
		 restTemplate.delete("http://flight-ms/flights/deleteById/"+flightNumber);;
	}

	@Override
	public Flight modifyFlight(Flight flight) {
		// TODO Auto-generated method stub
		return restTemplate.postForObject("http://flight-ms/flights/modify", flight, Flight.class);
	}

	@Override
	public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight) {
		
		System.err.println(scheduledFlight.getSchedule().getArrivalTime());
		// TODO Auto-generated method stub
		return restTemplate.postForObject("http://schedule-ms/scheduleflight/add", scheduledFlight, ScheduledFlight.class);
	}

	@Override
	public ScheduledFlight viewScheduledFlight(long scheduledFlightId) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject("http://schedule-ms/scheduleflight/id/"+scheduledFlightId, ScheduledFlight.class);
	}

	@Override
	public void cancelScheduledFlight(long  scheduledFlightId) {
		// TODO Auto-generated method stub
		restTemplate.delete("http://schedule-ms/scheduleflight/delete/"+scheduledFlightId);
	}

	@Override
	public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight) {
		// TODO Auto-generated method stub
		return restTemplate.postForObject("http://schedule-ms/scheduleflight/modify", scheduledFlight , ScheduledFlight.class);
	}
	public ScheduledFlightList viewAllScheduledFlight() {
		
		return restTemplate.getForObject("http://schedule-ms/scheduleflight/viewall", ScheduledFlightList.class);
	}

	@Override
	public AirportList getAllAirports() {
		// TODO Auto-generated method stub
		return restTemplate.getForObject("http://airport-ms/airport/all", AirportList.class);
	}

	@Override
	public Airport getAirportByCode(String airportCode) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject("http://airport-ms/airport/airport/{airportCode}", Airport.class);
	}

	@Override
	public Airport addAirport(Airport airport) {
		// TODO Auto-generated method stub
		return restTemplate.postForObject("http://airport-ms/airport/add", airport, Airport.class);
	}

	@Override
	public void deleteAirport(String airportCode) {
		// TODO Auto-generated method stub
		System.err.println("admin" + airportCode);
		restTemplate.delete("http://airport-ms/airport/delete/"+airportCode);
	}

}
