package com.capg.fms.user.service;

import com.capg.fms.user.model.User;

public interface ILoginService {
	
	public boolean checkUserCredentials(String userName,String userPassword);
	
	public User getUser(String userName);

}
