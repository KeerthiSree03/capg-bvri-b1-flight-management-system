package com.capg.fms.passenger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.capg.fms.passenger.exceptions.EmptyPassengerListException;
import com.capg.fms.passenger.exceptions.PassengerAlreadyExistException;
import com.capg.fms.passenger.exceptions.PassengerNotFoundException;
import com.capg.fms.passenger.model.Passenger;
import com.capg.fms.passenger.model.PassengerList;
import com.capg.fms.passenger.repository.IPassengerRepo;

@Service
	public class PassengerServiceImpl implements IPassengerService {

		@Autowired(required=false)
		IPassengerRepo passengerRepo;

		@Override
		@Transactional
		public Passenger addPassenger(Passenger passenger) {
			if(passengerRepo.existsById(passenger.getPassengerNum()))
				throw new PassengerAlreadyExistException("Passenger with Number: " +passenger.getPassengerNum()+" is already exist");
			return passengerRepo.save(passenger);
		}
		


		@Override
		@Transactional
		public boolean deletePassenger(long passengerNum) {
			if(!passengerRepo.existsById(passengerNum)) 
			{	
			   throw new PassengerNotFoundException("Passenger with Number "+passengerNum+" Not Found");
			}
			passengerRepo.deleteById(passengerNum);
			return !passengerRepo.existsById(passengerNum);

		}
		@Override
		@Transactional
		public Passenger getPassenger(long passengerNum) {
			if(!passengerRepo.existsById(passengerNum)) 
			{	
			   throw new PassengerNotFoundException("Passenger with Num "+passengerNum+" Not Found");
			}
		    return passengerRepo.getOne(passengerNum);

		}
		
		
		@Override
		@Transactional
		public PassengerList getAllPasssengers() {
			
			
			return new PassengerList(passengerRepo.findAll());
		}




		@Override
		@Transactional
		public Passenger updatePassenger(Passenger passenger) {
			if(!passengerRepo.existsById(passenger.getPassengerNum()))
				throw new PassengerNotFoundException("Passenger with Num : " +passenger.getPassengerNum()+" Not Found");
		
			Passenger newPassenger=passengerRepo.getOne(passenger.getPassengerNum());
			
			newPassenger.setPassengerName(passenger.getPassengerName());
			newPassenger.setPassengerAge(passenger.getPassengerAge());
			newPassenger.setPassengerUIN(passenger.getPassengerUIN());
			newPassenger.setLuggage(passenger.getLuggage());

		passengerRepo.save(newPassenger);
			return newPassenger;	
		}

		
		public long getCountOfPassenger() {
			
			return passengerRepo.count();
		}
}