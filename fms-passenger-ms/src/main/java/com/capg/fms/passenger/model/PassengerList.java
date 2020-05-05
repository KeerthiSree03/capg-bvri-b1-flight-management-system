package com.capg.fms.passenger.model;

import java.util.List;

public class PassengerList {

	private List<Passenger> passengerList ;

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	public PassengerList(List<Passenger> passengerList) {
		super();
		this.passengerList = passengerList;
	}

	public PassengerList() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PassengerList [passengerList=" + passengerList + "]";
	}
	
	
	
	
}
