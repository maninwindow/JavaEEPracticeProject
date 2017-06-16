package com.saftware.chatbox.ws.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.saftware.chatbox.ws.registry.UserSessionRegistry;

@Path("/users/")
public class UserService {

	@GET
	@Path("active")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getActiveUsers(){
		return UserSessionRegistry.getActiveUsers();
	}
	
	
}
