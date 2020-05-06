package com.capg.fms.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.fms.login.model.Flight;
import com.capg.fms.login.model.ScheduledFlight;

import net.bytebuddy.description.ModifierReviewable.OfAbstraction;

@Service
public class AdminService implements IAdminService {
	
	@Autowired
	RestTemplate restTemplate;

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

}
