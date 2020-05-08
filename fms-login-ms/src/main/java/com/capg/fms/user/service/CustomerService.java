package com.capg.fms.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.fms.user.model.Booking;
import com.capg.fms.user.model.BookingList;
import com.capg.fms.user.model.FlightList;

@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public FlightList checkAvailableFlights() {
		
		return restTemplate.getForObject("http://flight-ms/flights/all", FlightList.class);
	}
 
	@Override
	public Booking makeBooking(Booking booking) {
		
		return restTemplate.postForObject("http://booking-ms/booking/add",booking, Booking.class);
		
	}
    
	@Override
	public BookingList viewBookingList() {
		// TODO Auto-generated method stub
		return restTemplate.getForObject("http://booking-ms/booking/all", BookingList.class);
	}

	@Override
	public void cancelBooking(long bookingId) {
	
		 restTemplate.delete("http://booking-ms/booking/delete/"+bookingId);
	}

	@Override
	public Booking modifyBooking(Booking booking) {
	
		return restTemplate.postForObject("http://booking-ms/booking/modify", booking, Booking.class);
	}
	

}
