package com.capg.fms.gateway.model;

public class UserCred {
	
	private String username;
	private String password;
	
	public UserCred() {
		// TODO Auto-generated constructor stub
	}

	public UserCred(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
