package com.capg.fms.login.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.login.exceptions.InvalidInputException;

@ControllerAdvice
@RestController
public class AccountCreationErrorController {

	@ExceptionHandler(InvalidInputException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid Input")
	public void handleInvalidInputException() {
		
	}
}
