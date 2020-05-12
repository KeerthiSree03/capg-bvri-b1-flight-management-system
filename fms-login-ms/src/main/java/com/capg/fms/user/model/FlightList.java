package com.capg.fms.user.model;

import java.util.List;

public class FlightList {

	private List<Flight> flightList;

	public FlightList(List<Flight> flightList) {
		super();
		this.flightList = flightList;
	}

	public FlightList() {
		super();
		
	}

	public List<Flight> getFlightList() {
		return flightList;
	}

	public void setFlightList(List<Flight> flightList) {
		this.flightList = flightList;
	}
	
	
	
}
