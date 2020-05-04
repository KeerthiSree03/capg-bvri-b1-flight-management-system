package com.capg.fms.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.fms.login.model.User;

@Repository
public interface IUserJpaRepo extends JpaRepository<User, Integer>{
	
	@Query(value = "from User where userName=:userName")
	public User getUserByUserName(String userName);
	
	@Query(value = "SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM User c WHERE c.userId = :userId")
	public boolean existsByUserId(long userId);
	
	@Query(value = "SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM User c WHERE c.userName = :userName")
	public boolean existsByUserName(String userName);
	
}
