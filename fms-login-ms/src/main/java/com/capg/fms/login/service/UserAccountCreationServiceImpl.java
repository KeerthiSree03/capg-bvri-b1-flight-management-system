package com.capg.fms.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.login.exceptions.InvalidInputException;
import com.capg.fms.login.model.User;
import com.capg.fms.login.repository.IUserJpaRepo;

@Service
public class UserAccountCreationServiceImpl implements IUserAccountCreationService {
	
	@Autowired
	IUserJpaRepo repo;

	@Override
	public User addUser(User user) {
		return repo.save(user);
	}
	
	public boolean validateUserPhoneNo(long phoneNo) {
		String s=Long.toString(phoneNo);
		if(!(s.length()==10 && s.charAt(0)!=0)) {
			throw new InvalidInputException("Phone number should be of 10 digits");
		}
		return true;	
	}

	
	public boolean validateUserEmail(String email)  {
	      String regex = "[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z]{2,4}";
	      if(email.matches(regex))
	    	  return true;
	      else
	    	  throw new InvalidInputException("Email Id NOT valid");
	   }


	public boolean validateUserId(long id) {
		int count=0;
		long p=id;
		long d;
		while(id>0) {
			d=id % 10;
			count++;
			id=id/10;
		}
		if(count!=12)
			throw new InvalidInputException("ID should be of 12 digits");	
			
		else if(repo.existsByUserId(p)==true) {
			 throw new InvalidInputException("User with userId ["+p+"] already exists");
		}
		return true;
			
	}
	
	public boolean validateUserPassword(String password) {
		String regex="[(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$])]{8,}";
		if(password.matches(regex)) {
			return true;
		}
		else 
			throw new InvalidInputException("Password should contain:- [uppercase ,lowercase ,numeric ,any of these characters={'@','$','#'} ,should contain atleast 8 characters]");
	}
	
	public boolean validateUserName(String userName) {
		
		String regex="[(?=.*[A-Za-z])(?=.*[0-9].{2,4})]{8,}";
		if(!userName.matches(regex)) {
			throw new InvalidInputException("Username should contain atleast 8 alphanumeric characters");
			
		}
		else if(repo.existsByUserName(userName))
			throw new InvalidInputException("Username ["+userName+"] already exists");
		else
			return true;
	}
	
	public boolean validateUserType(String userType) {
		if((userType.toLowerCase()).equals("admin") || (userType.toLowerCase()).equals("user")){
			return true;
		}
		else 
			throw new InvalidInputException("UserType should be either USER or ADMIN");
	}

}
