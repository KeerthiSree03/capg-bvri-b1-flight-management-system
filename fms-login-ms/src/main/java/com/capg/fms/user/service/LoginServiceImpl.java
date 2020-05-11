/*************************************************************************
 -Author                : Keerthi Sree 
 -Created/Modified Date : 28/04/2020
 -Description           : AdminServiceImpl implements services for IAdminService
 						  for User Management System
***************************************************************************/

package com.capg.fms.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.fms.user.model.User;
import com.capg.fms.user.repository.IUserJpaRepo;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	IUserJpaRepo repo;

	/*************************************************************************
	 -FunctionName          : getUser
	 -Input Parameters      : String userName
	 -Return Type           : USer
	 -Author				: Keerthi Sree 
	 -Creation Date			: 28/04/2020
	***************************************************************************/
	@Override
	public User getUser(String userName) {
		return repo.getUserByUserName(userName);
	}

	
	
}
