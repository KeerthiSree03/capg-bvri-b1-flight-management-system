package com.capg.fms.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.fms.user.model.User;
import com.capg.fms.user.service.IUserAccountCreationService;

@RestController
@RequestMapping("/users")
public class AccountCreationController {
	
	@Autowired
	IUserAccountCreationService service;
	
	@PostMapping("/p/add")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		if(service.validateUserPhoneNo(user.getUserPhone()) && service.validateUserEmail(user.getUserEmail()) && service.validateUserId(user.getUserId()) && service.validateUserPassword(user.getUserPassword()) && service.validateUserType(user.getUserType()) && service.validateUserName(user.getUserName())) {
			return new ResponseEntity<User>(service.addUser(user),HttpStatus.CREATED);
		}
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);		
	}
	
	@GetMapping("/p/{username}")
	public User getUserByUserName(@PathVariable String username) {
		return service.getUserByUserName(username);			
	}
	
	

}
