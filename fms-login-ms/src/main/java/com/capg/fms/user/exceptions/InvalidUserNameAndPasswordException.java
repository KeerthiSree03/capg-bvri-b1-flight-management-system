package com.capg.fms.user.exceptions;

public class InvalidUserNameAndPasswordException extends RuntimeException{
	
	public InvalidUserNameAndPasswordException(String message) {
		super(message);
	}

}
