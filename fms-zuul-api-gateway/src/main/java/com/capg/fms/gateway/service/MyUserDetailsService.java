package com.capg.fms.gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.fms.gateway.model.UserCredentials;
import com.capg.fms.gateway.model.UserInfo;
import com.capg.fms.gateway.util.TokenUtil;

@Service
public class MyUserDetailsService{
	
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	TokenUtil tokenUtil;
	
	public UserInfo  loadUserByUserCrenditials(UserCredentials cred) {
		UserInfo userInfo=null;
		try {
		userInfo = restTemplate.postForObject("http://user-ms/users/authenticate",cred, UserInfo.class);
		}
		catch (Exception e) {
			//throw new ResponseStatusException(HttpStatus.FORBIDDEN,e.getMessage());
			return null;
			}
		if(userInfo==null) {
			return null;
		}
		return userInfo;
		
	}
}
