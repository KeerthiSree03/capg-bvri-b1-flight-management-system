package com.capg.fms.schedule.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.schedule.excepions.NotFound;

@RestController
@ControllerAdvice
public class AvailabilityErrorController {
	
	@ExceptionHandler(NotFound.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No availability", code = HttpStatus.NOT_FOUND)
	public void AvailabilityNotFoundException() {
		
	}

}
