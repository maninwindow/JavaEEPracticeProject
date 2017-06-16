/**
 * 
 */
package com.saftware.chatbox.ws.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.saftware.chatbox.ws.model.Credential;
import com.saftware.chatbox.ws.registry.UserTokenRegistry;

/**
 * @author Sathiyaseelan_M01
 *
 */
@Path("/login")
public class LoginService{

	
	@POST
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LoginResponse login(Credential credential){
		LoginResponse response = new LoginResponse();
		if (credential.getUserId().equals(credential.getPassword())){
			String token = Credential.generateToken();
			UserTokenRegistry.addToken(credential.getUserId(), token);
			response.setStatus(true);
			response.setToken(token);
		}
		return response;
	}
	
	
	@GET
	//@Path("/logout")
	public Response logout(@QueryParam("name")String userId,@QueryParam("token")String token){
		Response response = null;
		if(UserTokenRegistry.getToken(userId).equals(token)){
			UserTokenRegistry.removeToken(userId);
			response = Response.status(Status.ACCEPTED).build();
		}else{
			response = Response.status(Status.UNAUTHORIZED).build();
		}
		return response;
	}
}
