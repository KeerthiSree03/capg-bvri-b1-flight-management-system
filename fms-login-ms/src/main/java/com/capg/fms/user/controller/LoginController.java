package com.capg.fms.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capg.fms.user.exceptions.InvalidUserNameAndPasswordException;
import com.capg.fms.user.model.User;
import com.capg.fms.user.model.UserCredentials;
import com.capg.fms.user.service.ILoginService;


@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	@Autowired
	ILoginService service;
	
	
	
	@GetMapping("/p/user-name/{userName}")
	public User getUserByUserName(@PathVariable String userName) {
		return service.getUser(userName);
	}
	
	@GetMapping("/p/message")
	public String getMessage() {
		return "Hello All";
	}
	
	@PostMapping("/authenticate")
	public User authenticateUser(@RequestBody UserCredentials credentials) {
		User user=service.getUser(credentials.getUsername());
		System.err.println(user);
		if(user==null) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		else if(!(credentials.getPassword()).equals(user.getUserPassword())) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED) ;
		}
		else 
			return user;
		
	}
	

	
}
