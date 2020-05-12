/*************************************************************************
 -Author                : Keerthi Sree 
 -Created/Modified Date : 28/04/2020
 -Description           : UserAccountCreationServiceImpl implements services for IUserAccountCreationService
 						  for User Management System
***************************************************************************/

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
	
	/*************************************************************************
	 -FunctionName          : addUser
	 -Input Parameters      : User user
	 -Return Type           : User
	 -Throw					: ResponseStatusException
	 -Author				: Keerthi Sree 
	 -Creation Date			: 28/04/2020
	***************************************************************************/
	@Override
	public User addUser(User user) {
		if(repo.existsByUserName(user.getUserName()) || repo.existsByUserId(user.getUserId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return repo.save(user);
	}
	
	/*************************************************************************
	 -FunctionName          : getUserByUserName
	 -Input Parameters      : String userName
	 -Return Type           : User
	 -Author				: Keerthi Sree 
	 -Creation Date			: 28/04/2020
	***************************************************************************/

	@Override
	public User getUserByUserName(String userName) {
		return repo.getUserByUserName(userName);
	}
	/*************************************************************************
	 -FunctionName          : validateUserPhoneNo
	 -Input Parameters      : long phoneNo
	 -Return Type           : boolean
	 -Throw					: InvalidInputException
	 -Author				: Keerthi Sree 
	 -Creation Date			: 28/04/2020
	***************************************************************************/
	public boolean validateUserPhoneNo(long phoneNo) {
		String s=Long.toString(phoneNo);
		if(!(s.length()==10 && s.charAt(0)!=0)) {
			throw new InvalidInputException("Phone number should be of 10 digits");
		}
		return true;	
	}

	/*************************************************************************
	 -FunctionName          : validateUserEmail
	 -Input Parameters      : String email
	 -Return Type           : boolean
	 -Throw					: InvalidInputException
	 -Author				: Keerthi Sree 
	 -Creation Date			: 28/04/2020
	***************************************************************************/
	
	public boolean validateUserEmail(String email)  {
	      String regex = "[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z]{2,4}";
	      if(email.matches(regex))
	    	  return true;
	      else
	    	  throw new InvalidInputException("Email Id NOT valid");
	   }

	/*************************************************************************
	 -FunctionName          : validateUserId
	 -Input Parameters      : long id
	 -Return Type           : boolean
	 -Throw					: InvalidInputException
	 -Author				: Keerthi Sree 
	 -Creation Date			: 28/04/2020
	***************************************************************************/
		
	public boolean validateUserId(long id) {
		int count=0;

		long d;
		while(id>0) {
			d=id % 10;
			count++;
			id=id/10;
		}
		if(count!=12)
			throw new InvalidInputException("ID should be of 12 digits");	

		return true;
			
	}
	
	/*************************************************************************
	 -FunctionName          : validateUserPassword
	 -Input Parameters      : String password
	 -Return Type           : boolean
	 -Throw					: InvalidInputException
	 -Author				: Keerthi Sree 
	 -Creation Date			: 28/04/2020
	***************************************************************************/
	
	public boolean validateUserPassword(String password) {
		String regex="[(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$])]{8,}";
		if(password.matches(regex)) {
			return true;
		}
		else 
			throw new InvalidInputException("Password should contain:- [uppercase ,lowercase ,numeric ,any of these characters={'@','$','#'} ,should contain atleast 8 characters]");
	}
	/*************************************************************************
	 -FunctionName          : validateUserName
	 -Input Parameters      : String userName
	 -Return Type           : boolean
	 -Throw					: InvalidInputException
	 -Author				: Keerthi Sree 
	 -Creation Date			: 28/04/2020
	***************************************************************************/
	
	public boolean validateUserName(String userName) {
		
		String regex="[(?=.*[A-Za-z])(?=.*[0-9].{2,4})]{8,}";
		if(!userName.matches(regex)) {
			throw new InvalidInputException("Username should contain atleast 8 alphanumeric characters");
			
		}
		return true;
	}
	
	/*************************************************************************
	 -FunctionName          : validateUserType
	 -Input Parameters      : String userType
	 -Return Type           : boolean
	 -Throw					: InvalidInputException
	 -Author				: Keerthi Sree 
	 -Creation Date			: 28/04/2020
	***************************************************************************/
	
	public boolean validateUserType(String userType) {
		if((userType.toLowerCase()).equals("admin") || (userType.toLowerCase()).equals("user")){
			return true;
		}
		else 
			throw new InvalidInputException("UserType should be either USER or ADMIN");
	}

}
