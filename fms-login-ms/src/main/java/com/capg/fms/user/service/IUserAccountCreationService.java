package com.capg.fms.user.service;

import com.capg.fms.user.model.User;

public interface IUserAccountCreationService {
	
	public User addUser(User user);
	public boolean validateUserPhoneNo(long phoneNo);
	public boolean validateUserEmail(String email) ;
	public boolean validateUserId(long id);
	public boolean validateUserPassword(String password);
	public boolean validateUserType(String userType) ;
	public boolean validateUserName(String userName);
	public User getUserByUserName(String userName);

}
