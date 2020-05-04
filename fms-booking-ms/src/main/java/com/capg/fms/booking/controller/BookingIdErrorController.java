package com.capg.fms.booking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.capg.fms.booking.exceptions.BookingIdNotFoundException;


@ControllerAdvice
@RestController
public class BookingIdErrorController {

	@ExceptionHandler(BookingIdNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "BOOKING-ID NOT FOUND")
    public void handleBookingIdNotFoundException() { }
		
	}

