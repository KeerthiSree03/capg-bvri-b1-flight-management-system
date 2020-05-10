package com.capg.fms.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.fms.user.model.User;
import com.capg.fms.user.repository.IUserJpaRepo;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	IUserJpaRepo repo;

	@Override
	public User getUser(String userName) {
		return repo.getUserByUserName(userName);
	}

	
	
}
