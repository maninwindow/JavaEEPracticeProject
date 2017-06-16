package com.saftware.chatbox.ws.registry;

import java.util.HashMap;
import java.util.Map;

public class UserTokenRegistry {

	
	private static Map<String,String> map = new HashMap<String,String>();
	
	
	private UserTokenRegistry(){
		
	}
	
	
	public static void addToken(String userId,String token){
		
		map.put(userId, token);
	}
	
	
	public static String removeToken(String userId){
		return map.remove(userId);
	}
	

	public static String getToken(String userId){
		return map.getOrDefault(userId,"");
	}
	
}
