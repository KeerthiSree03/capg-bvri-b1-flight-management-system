package com.capg.fms.login;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.fms.login.exceptions.InvalidInputException;
import com.capg.fms.login.exceptions.InvalidUserNameAndPasswordException;
import com.capg.fms.login.model.User;
import com.capg.fms.login.repository.IUserJpaRepo;
import com.capg.fms.login.service.ILoginService;
import com.capg.fms.login.service.IUserAccountCreationService;

@SpringBootTest
class FmsLoginMsApplicationTests {
	
	@Autowired
	IUserAccountCreationService userService;
	@Autowired
	ILoginService loginService;
	
	@Autowired
	IUserJpaRepo repo;

	@Test
	public void testValidUserId() throws InvalidInputException{
		assertEquals(true, userService.validateUserId(123434567890L));
	}
	
	@Test
	public void testUserIdWithLessDigits() throws InvalidInputException{
		
		 Exception exception = assertThrows(InvalidInputException.class, () -> {
			 userService.validateUserId(4567890L);
		    });
		 
		    String expectedMessage = "ID should be of 12 digits";
		    String actualMessage = exception.getMessage();
		 
		    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void testUserIdWithMoreDigits() throws InvalidInputException{
		
		Exception exception = assertThrows(InvalidInputException.class, () -> {
			 userService.validateUserId(1234345678907856L);
		    });
		 
		    String expectedMessage = "ID should be of 12 digits";
		    String actualMessage = exception.getMessage();
		 
		    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	
	@Test
	public void testValidUserEmail() throws InvalidInputException{
		assertEquals(true, userService.validateUserEmail("keerthi@gmail.com"));
	}
	
	@Test
	public void testInvalidUserEmail(){
		 Exception exception = assertThrows(InvalidInputException.class, () -> {
			 userService.validateUserEmail("keerthi");
		    });
		 
		    String expectedMessage = "Email Id NOT valid";
		    String actualMessage = exception.getMessage();
		 
		    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void testValidUserPhoneNo() throws InvalidInputException{
		assertEquals(true, userService.validateUserPhoneNo(9876543210L));
	}
	
	@Test
	public void testUserPhoneNoWithLessDigits() throws InvalidInputException{
		
		Exception exception = assertThrows(InvalidInputException.class, () -> {
			userService.validateUserPhoneNo(8743210L);
		    });
		 
		    String expectedMessage = "Phone number should be of 10 digits";
		    String actualMessage = exception.getMessage();
		 
		    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void testUserPhoneNoWithMoreDigits() throws InvalidInputException{
		
		Exception exception = assertThrows(InvalidInputException.class, () -> {
			userService.validateUserPhoneNo(87432234565810L);
		    });
		 
		    String expectedMessage = "Phone number should be of 10 digits";
		    String actualMessage = exception.getMessage();
		 
		    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void testValidUserName() {
		assertEquals(true, userService.validateUserName("Keerthi2Sree3"));
	}
	
	@Test
	public void testLoginCredentials() {
		assertTrue(loginService.checkUserCredentials("Keerthi23", "123@Keerthi"));
	}
	
	@Test
	public void testInvalidLoginPassword() {
	
		Exception exception = assertThrows(InvalidUserNameAndPasswordException.class, () -> {
			loginService.checkUserCredentials("Keerthi23", "123@Kreethi");
		    });
		 
		    String expectedMessage = "Password mismatch";
		    String actualMessage = exception.getMessage();
		 
		    assertTrue(actualMessage.contains(expectedMessage));
	}
	@Test
	public void testInvalidLoginUserName() {
	
		Exception exception = assertThrows(InvalidUserNameAndPasswordException.class, () -> {
			loginService.checkUserCredentials("Keerth1i23", "123@Kreethi");
		    });
		 
		    String expectedMessage = "user with userName [Keerth1i23] NOT Found";
		    String actualMessage = exception.getMessage();
		 
		    assertTrue(actualMessage.contains(expectedMessage));
	}
	
}
