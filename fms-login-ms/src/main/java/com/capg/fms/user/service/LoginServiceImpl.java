package com.capg.fms.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.user.exceptions.InvalidUserNameAndPasswordException;
import com.capg.fms.user.model.User;
import com.capg.fms.user.repository.IUserJpaRepo;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	IUserJpaRepo repo;
	
	
	@Override
	public boolean checkUserCredentials(String userName, String userPassword) {
		// TODO Auto-generated method stub
		return true;
	}
	
	

//	@Override
//	public boolean checkUserCredentials(String userName,String userPassword) {
//		
////		if(!repo.existsByUserName(userName))  {
////			throw new InvalidUserNameAndPasswordException("user with userName ["+userName+"] NOT Found");
////		}
////		if(repo.existsByUserName(userName)) {
////			if(!userPassword.equals(repo.getUserByUserName(userName).getUserPassword())) {
////				throw new InvalidUserNameAndPasswordException("Password mismatch");
////			}
////		}
////		return true;
////	}

	@Override
	public User getUser(String userName) {
//		if(!repo.existsByUserName(userName))  {
//			throw new InvalidUserNameAndPasswordException("user with userName ["+userName+"] NOT Found");
//		}
		return repo.getUserByUserName(userName);
	}

	
	
}
