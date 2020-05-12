package com.capg.fms.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.fms.booking.exceptions.BookingIdNotFoundException;
import com.capg.fms.booking.exceptions.InvalidInputException;
import com.capg.fms.booking.model.Booking;
import com.capg.fms.booking.repository.IBookingRepo;
import com.capg.fms.booking.service.IBookingService;

@SpringBootTest
class FmsBookingMsApplicationTests {
	
	@Autowired
	IBookingService service;
	
    @Autowired
    IBookingRepo repo;
    List<Long> lst=new ArrayList<Long>(){
    	{
    	  add(123345l);
    	  add(233345l); 
    	   
    }
    };
   Booking bk=new Booking();
 
   Booking bk1=new Booking(106l,100000000006l,LocalDate.of(2020,10,10),lst,3400.56,12345l,40);
   
	@Test
	public void testValidBookingId()  throws BookingIdNotFoundException{
		assertEquals(true,service.validateBookingId(106l));		
	}
	
	@Test
	public void validateNoOfPassengers() {
		assertEquals(true,service.validateNoOfPAssengers(40));
	}
	
	@Test
	public void validateUserId() {
		assertEquals(true,service.validateUserId(100000000001l));
	}
	
//	@Test
//	public void testValidateBooking() throws BookingIdNotFoundException, InvalidInputException{
//		assertEquals(true,service.validateBooking(bk1));
//	}
	
	@Test
	public void testDeleteBooking() {
		assertEquals(true, service.deleteBooking(104l));
	}
	
	@Test
	public void testAddBooking( ) throws BookingIdNotFoundException,InvalidInputException {
		assertEquals(bk1,service.addBooking(bk1));
		
		
	}
}