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
		return restTemplate.postForObject("http://flight-ms/flights/add", flight, Flight.class);
	}

	@Override
	public Flight viewFlight(long flightNumber) {
		return restTemplate.getForObject("http://flight-ms/flights/id/" + flightNumber, Flight.class);
	}

	@Override
	public void cancelFlight(long flightNumber) {
		restTemplate.delete("http://flight-ms/flights/deleteById/" + flightNumber);
	}

	@Override
	public Flight modifyFlight(Flight flight) {
		return restTemplate.postForObject("http://flight-ms/flights/modify", flight, Flight.class);
	}

	@Override
	public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight) {
		return restTemplate.postForObject("http://schedule-ms/scheduleflight/add", scheduledFlight,
				ScheduledFlight.class);
	}

	@Override
	public ScheduledFlight viewScheduledFlight(long scheduledFlightId) {
		return restTemplate.getForObject("http://schedule-ms/scheduleflight/id/" + scheduledFlightId,
				ScheduledFlight.class);
	}

	@Override
	public void cancelScheduledFlight(long scheduledFlightId) {
		restTemplate.delete("http://schedule-ms/scheduleflight/delete/" + scheduledFlightId);
	}

	@Override
	public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight) {
		return restTemplate.postForObject("http://schedule-ms/scheduleflight/modify", scheduledFlight,
				ScheduledFlight.class);
	}

	public ScheduledFlightList viewAllScheduledFlight() {
		return restTemplate.getForObject("http://schedule-ms/scheduleflight/viewall", ScheduledFlightList.class);
	}

	@Override
	public AirportList getAllAirports() {
		return restTemplate.getForObject("http://airport-ms/airport/all", AirportList.class);
	}

	@Override
	public Airport getAirportByCode(String airportCode) {
		return restTemplate.getForObject("http://airport-ms/airport/airport/{airportCode}", Airport.class);
	}

	@Override
	public Airport addAirport(Airport airport) {
		return restTemplate.postForObject("http://airport-ms/airport/add", airport, Airport.class);
	}

	@Override
	public void deleteAirport(String airportCode) {
		restTemplate.delete("http://airport-ms/airport/delete/" + airportCode);

	}

}
