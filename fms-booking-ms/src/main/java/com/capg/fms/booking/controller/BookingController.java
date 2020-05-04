package com.capg.fms.booking.controller;


import java.io.Console;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.fms.booking.model.Booking;
import com.capg.fms.booking.model.BookingList;
import com.capg.fms.booking.service.IBookingService;


@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	IBookingService service;

//Dummy Values for ref	
//	@PostConstruct
//	public void init() {
//		List<Long> lst=new ArrayList<Long>();	
//		long l1=478645387l;
//		long l2=478645387l;
//		lst.add(l1);
//		lst.add(l2);
//		Flight ft=new Flight(123456l,"flightModel","carrierName",100);
//		Booking bk=new Booking(101l,111l,LocalDate.of(2010,12,12),lst,4500.45,ft,40);
//        service.addBooking(bk);
//	}


	@GetMapping("/id/{bookingId}")
	public ResponseEntity<Booking> viewBooking(@PathVariable long bookingId) {
		Booking booking=service.viewBookingByBookingId(bookingId);
		
		if(!service.validateBookingId(bookingId)) {
			return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);
			}
		else
			return new ResponseEntity<Booking>(booking,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/all")
	public BookingList getAllBooking(){
		return service.viewAllBookings();	
	}
	
	@PostMapping("/add")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
		
	      booking=service.addBooking(booking); 
	      if(booking == null) 
	    	  return new ResponseEntity<Booking>(HttpStatus.BAD_REQUEST);
				
			else 
				return new ResponseEntity<Booking>(booking,HttpStatus.OK);	      
		
	}

	@PostMapping("/modify")
	public Booking modifyBooking(@RequestBody Booking booking) {
		return service.modifyBooking(booking);
	} 
	
	@DeleteMapping("/delete/{bookingId}")
	public ResponseEntity<Booking> deleteBooking(@PathVariable long bookingId) {

		if(service.validateBookingId(bookingId)) {
		   
			if(!service.deleteBooking(bookingId)) {return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND); }
			else {return new ResponseEntity<Booking>(HttpStatus.OK);}
		 
		}
		return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);
	}
	
}
