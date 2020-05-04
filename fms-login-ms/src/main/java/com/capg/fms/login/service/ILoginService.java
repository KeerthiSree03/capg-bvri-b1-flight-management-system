package com.capg.fms.login.service;

import com.capg.fms.login.model.User;

public interface ILoginService {
	
	public boolean checkUserCredentials(String userName,String userPassword);
	
	public User getUser(String userName);

}
