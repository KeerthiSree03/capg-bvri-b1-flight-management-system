package com.capg.fms.passenger.service;

import com.capg.fms.passenger.model.Passenger;
import com.capg.fms.passenger.model.PassengerList;

public interface IPassengerService {


	Passenger addPassenger(Passenger passenger);
	boolean deletePassenger(long passengerNum);
	Passenger getPassenger(long passengerNum);
	PassengerList getAllPasssengers();
	Passenger updatePassenger(Passenger passenger);
	public long getCountOfPassenger();
//	 Passenger getByPassengerName(String passengerName);
}
