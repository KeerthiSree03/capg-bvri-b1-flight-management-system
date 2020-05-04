package com.capg.fms.booking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.booking.exceptions.InvalidInputException;

@ControllerAdvice
@RestController
public class InvalidInputErrorController {
	@ExceptionHandler(InvalidInputException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid Input")

  public void handleInvalidInputException() { }
	
}


