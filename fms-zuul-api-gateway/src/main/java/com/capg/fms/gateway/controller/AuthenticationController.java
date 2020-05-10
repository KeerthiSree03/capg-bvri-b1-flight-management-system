package com.capg.fms.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capg.fms.gateway.model.AuthenticationResponse;
import com.capg.fms.gateway.model.UserCredentials;
import com.capg.fms.gateway.model.UserInfo;
import com.capg.fms.gateway.service.MyUserDetailsService;
import com.capg.fms.gateway.util.TokenUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders ="*" )
public class AuthenticationController {
	
	@Autowired
	MyUserDetailsService userDetailsService;
	
	
	@Autowired
	TokenUtil tokenUtil;
	
	@PostMapping("/authenticate")
	public AuthenticationResponse authenticate(@RequestBody UserCredentials cred) {
		try {
		UserInfo authenticatedUser=userDetailsService.loadUserByUserCrenditials(cred);
		System.err.println(authenticatedUser);
		 if(authenticatedUser==null) {
			 throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		 }
			String token=tokenUtil.generateToken(cred.getUsername(), cred.getPassword());
			
			AuthenticationResponse tokenResponse=new AuthenticationResponse(token);
		
			return tokenResponse;
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
	}
	
}
