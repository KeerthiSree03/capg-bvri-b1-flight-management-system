package com.capg.fms.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.gateway.config.JwtTokenUtil;
import com.capg.fms.gateway.model.AuthenticationResponse;
import com.capg.fms.gateway.model.UserCredentials;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {
	
	@Autowired
	AuthenticationManager auth;
	
	
	@Autowired
	UserDetailsService userDetailsService;
	
	
	@Autowired
	JwtTokenUtil jwtUtil;
	
	@PostMapping("/authenticate")
	public AuthenticationResponse authenticate(@RequestBody UserCredentials cred) {
		auth.authenticate(new UsernamePasswordAuthenticationToken(cred.getUsername(), cred.getPassword()));
		UserDetails userDetails=userDetailsService.loadUserByUsername(cred.getUsername());
		
		String token=jwtUtil.generateToken(userDetails);
		
		AuthenticationResponse tokenResponse=new AuthenticationResponse(token);
		
		return tokenResponse;
		
		
	}

}
