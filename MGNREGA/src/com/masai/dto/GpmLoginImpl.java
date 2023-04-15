package com.masai.dto;

public class GpmLoginImpl implements GpmLogin{
	private String username;
	private String password;

	public GpmLoginImpl(String username, String password) {
		super();
		this.username = "Admin";
		this.password = "Admin";
		
		
	}
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "BDO [username=" + username + ", password=" + password + "]";
	}

}
