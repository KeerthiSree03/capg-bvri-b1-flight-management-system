package com.capg.fms.passenger.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.passenger.exceptions.EmptyPassengerListException;
import com.capg.fms.passenger.exceptions.InvalidInputException;
import com.capg.fms.passenger.exceptions.PassengerNotFoundException;
import com.capg.fms.passenger.exceptions.PassengerAlreadyExistException;

/*******************************************************************************************************************************
-Author                   :     K.Srinidhi
-Created/Modified Date    :     01-05-2020
-Description              :     PassengerErrorController Class for handling Passenger Management System Exceptions
*******************************************************************************************************************************/


@RestController
@ControllerAdvice
public class PassengerErrorController {

	@ResponseStatus(code = HttpStatus.ALREADY_REPORTED, reason = "Passenger Already Exist", value = HttpStatus.ALREADY_REPORTED)
	@ExceptionHandler(PassengerAlreadyExistException.class)
	public void handlePassengerAlreadyExistException() {	
//		To handle Passenger Already Exist Exception
	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Passengeer Not Found", value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(PassengerNotFoundException.class)
	public void handlePassengerNotFoundException() {
//		To handle Passenger Not Found ExistException
		}

	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Passenger list is Empty", value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmptyPassengerListException.class)
	public void handleEmptyPassengerListException() {
//		To handle Empty Passenger List Exception
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid input", value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidInputException.class)
	public void handleInvaliInputtException() {
//		to handle Invalid Input Exception
			}

}
