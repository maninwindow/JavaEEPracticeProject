package com.saftware.chatbox.ws.service;

public class LoginResponse {

	private boolean status;
	
	private String token;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
