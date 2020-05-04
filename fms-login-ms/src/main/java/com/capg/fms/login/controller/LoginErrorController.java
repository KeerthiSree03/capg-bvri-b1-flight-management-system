package com.capg.fms.login.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.login.exceptions.InvalidUserNameAndPasswordException;

@ControllerAdvice
@RestController
public class LoginErrorController {
	
	@ExceptionHandler(InvalidUserNameAndPasswordException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Invalid Login Credentials")
	public void handleInvalidUserNameAndPasswordExcetion() {
		
	}

}
