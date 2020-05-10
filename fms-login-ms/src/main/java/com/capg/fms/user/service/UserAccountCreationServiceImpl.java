package com.capg.fms.user.service;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.capg.fms.user.exceptions.InvalidInputException;
import com.capg.fms.user.model.User;
import com.capg.fms.user.repository.IUserJpaRepo;

@Service
public class UserAccountCreationServiceImpl implements IUserAccountCreationService {
	
	@Autowired
	IUserJpaRepo repo;
	
	@PostConstruct
	public void addSomeUsers() {
		User user1=new User("admin",125364125321L,"Keerthi23","keerthi@Capg23",9854235621L,"keerthi@gmail.com");
		User user2=new User("user",125364125325L,"Ramanuj88","ramanuj@Capg88",9854235625L,"ramanuj@gmail.com");
		repo.saveAll(Arrays.asList(user1,user2));
	}

	@Override
	public User addUser(User user) {
		if(repo.existsByUserName(user.getUserName()) || repo.existsByUserId(user.getUserId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return repo.save(user);
	}
	@Override
	public User getUserByUserName(String userName) {
		return repo.getUserByUserName(userName);
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
			
//		else if(repo.existsByUserId(p)==true) {
//			 throw new InvalidInputException("User with userId ["+p+"] already exists");
//		}
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
