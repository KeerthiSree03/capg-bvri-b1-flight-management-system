package com.capg.fms.login.model;

import java.util.List;

public class FlightList {

	private List<Flight> flightList;

	public FlightList(List<Flight> flightList) {
		super();
		this.flightList = flightList;
	}

	public FlightList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Flight> getFlightList() {
		return flightList;
	}

	public void setFlightList(List<Flight> flightList) {
		this.flightList = flightList;
	}
	
	
	
}
