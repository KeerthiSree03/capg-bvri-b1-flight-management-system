package com.capg.fms.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.user.exceptions.InvalidUserNameAndPasswordException;
import com.capg.fms.user.model.User;
import com.capg.fms.user.service.ILoginService;


@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	@Autowired
	ILoginService service;
	
//	@PostMapping("/{userName}/{userPassword}")
//	public ResponseEntity<User> loginAsUser( @PathVariable("userName") String userName,@PathVariable("userPassword") String userPassword){
//		if(service.checkUserCredentials(userName,userPassword)) {
//			 return new ResponseEntity<User>(service.getUser(userName),HttpStatus.OK);
//		}
//		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//	}
	
	@GetMapping("/p/user-name/{userName}")
	public User getUserByUserName(@PathVariable String userName) {
		return service.getUser(userName);
	}
	
	@GetMapping("/p/message")
	public String getMessage() {
		return "Hello All";
	}
	

	
}
