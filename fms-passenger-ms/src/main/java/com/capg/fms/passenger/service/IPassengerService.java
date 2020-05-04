package com.capg.fms.passenger.service;

import java.util.List;

import com.capg.fms.passenger.model.Passenger;

public interface IPassengerService {


	Passenger addPassenger(Passenger passenger);
	boolean deletePassenger(long passengerNum);
	Passenger getPassenger(long passengerNum);
	List<Passenger> getAllPasssengers();
	Passenger updatePassenger(Passenger passenger);
//	 Passenger getByPassengerName(String passengerName);
}
