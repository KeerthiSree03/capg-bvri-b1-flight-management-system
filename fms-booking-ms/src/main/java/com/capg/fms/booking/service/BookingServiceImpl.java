package com.capg.fms.booking.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.booking.exceptions.BookingIdNotFoundException;
import com.capg.fms.booking.exceptions.InvalidInputException;
import com.capg.fms.booking.model.Booking;
import com.capg.fms.booking.model.BookingList;
import com.capg.fms.booking.model.Passenger;
import com.capg.fms.booking.repository.IBookingRepo;


@Service
public class BookingServiceImpl implements IBookingService  {

	@Autowired
	IBookingRepo repo;
	
	@Override
	public Booking addBooking(Booking booking) {
		return repo.save(booking);
	}

	@Override
	public Booking viewBookingByBookingId(long bookingId) {
		return repo.getOne(bookingId);
	}

	@Override
	public BookingList viewAllBookings() {
		return new BookingList(repo.findAll());
	}

	@Override
	public Booking modifyBooking(Booking newBooking) {
		Booking booking=repo.getOne(newBooking.getBookingId());
		booking.setUserId(newBooking.getUserId());
		booking.setBookingDate(newBooking.getBookingDate());
		booking.setPassengerList(newBooking.getPassengerList());
		booking.setTicketCost(newBooking.getTicketCost());
		booking.setFlightNumber(newBooking.getFlightNumber());
		booking.setNoOfPassengers(newBooking.getNoOfPassengers());
		return booking;
	}

	@Override
	public boolean deleteBooking(long bookingId) {
		repo.deleteById(bookingId);
		return !repo.existsById(bookingId);
	}
	
	@Override
	public void validateBooking(Booking booking) {
		//VALIDATE BOOKING ID
		long bookingId=booking.getBookingId();
	    this.validateBookingId(bookingId);
	    
	    //VALIDATE USER ID
		long id=booking.getUserId();
		this.validateUserId(id);
		
	    // VALIDATE NO.OFPASSENGERS 	
	  	int noOfPassengers=booking.getNoOfPassengers();
		this.validateNoOfPAssengers(noOfPassengers);  
		
		
	}
	@Override
	public void validatePassenger(Passenger passenger) {
		
		
	}
	
    @Override
	public boolean validateUserId(long id) {
		int count=0;
		long p=id;
		long d;
		while(id>0) {
			d=id % 10;
			count++;
			id=id/10;
		}
		if(count!=3)
			throw new InvalidInputException("USER-ID should be of 3 digits");	
			
		else if(!repo.existsById(p)==true) {
			 throw new InvalidInputException("User with userId ["+p+"] doesn't exists");
		}
		return true;
			
	}
	
    @Override
	public boolean validateBookingId(long bookingId) {
		int count=0;
		long p=bookingId;
		long d;
		while(bookingId>0) {
			d=bookingId % 10;
			count++;
			bookingId=bookingId/10;
		}
		if(count!=3)
			throw new BookingIdNotFoundException("ID should be of 3 digits");	
			
		else if(!repo.existsById(p)==true) {
			 throw new BookingIdNotFoundException("Booking with bookingId ["+p+"] doesn't exists");
		}
		return true;
	}
    
    
    @Override
    public boolean validateNoOfPAssengers(int noOfPassengers) {
    	int availableSeats=100;
    	if(noOfPassengers==0) {
    		throw new InvalidInputException("Atleast 1 passenger is required to book a flight");
    	}
    	else if(noOfPassengers>availableSeats) {
    		throw new InvalidInputException("The Capacity of flight is limited: i.e 100(hundred seats only available)");
    	}
    	return true;
    }
	
}
