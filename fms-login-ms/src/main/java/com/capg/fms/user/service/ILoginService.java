/***************************************************************
 -Author                : Keerthi Sree
 -Created/Modified Date : 28/04/2020
 -Description           : ILoginService interface for 
 						  User Management system
*******************************************************************/

package com.capg.fms.user.service;

import com.capg.fms.user.model.User;

public interface ILoginService {
		
	public User getUser(String userName);

}
