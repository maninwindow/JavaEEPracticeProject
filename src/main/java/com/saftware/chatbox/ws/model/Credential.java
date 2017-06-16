package com.saftware.chatbox.ws.model;

import java.util.Calendar;
import java.util.UUID;

public class Credential {

	private String userId;
	
	private String password;
	
	private UUID token;
	
	private Calendar tokenGeneratedOn;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UUID getToken() {
		return token;
	}

	public void setToken(UUID token) {
		this.token = token;
	}

	public Calendar getTokenGeneratedOn() {
		return tokenGeneratedOn;
	}

	public void setTokenGeneratedOn(Calendar tokenGeneratedOn) {
		this.tokenGeneratedOn = tokenGeneratedOn;
	}

	public static String generateToken() {
		return UUID.randomUUID().toString();
		
	}
	
	
	
	
}
