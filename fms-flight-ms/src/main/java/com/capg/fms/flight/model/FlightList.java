package com.capg.fms.flight.model;

import java.util.List;

public class FlightList {
	
	private List<Flight> flightList;

	public FlightList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlightList(List<Flight> flightList) {
		super();
		this.flightList = flightList;
	}

	public List<Flight> getFlightList() {
		return flightList;
	}

	public void setFlightList(List<Flight> flightList) {
		this.flightList = flightList;
	}
	
	

}
