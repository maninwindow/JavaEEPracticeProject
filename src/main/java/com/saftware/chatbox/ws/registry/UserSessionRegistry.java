package com.saftware.chatbox.ws.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.websocket.Session;

public class UserSessionRegistry {

	private static HashMap<String,Session> userSessionMap = new HashMap<String,Session>(); 
	
	private UserSessionRegistry(){
		
	}
	
	public static boolean mapUserWithSession(String userName,Session session){
		if(session!=null && userName!=null && userSessionMap.get(userName)==null){
			userSessionMap.put(userName, session);
			return true;
		}
		return false;
	}
	
	public static boolean removeUserWithSession(String userName){
		if( userName!=null && userSessionMap.get(userName)!=null){
			userSessionMap.remove(userName);
			return true;
		}
		return false;
	}
	
	public static Session getSession(String userName){
		return userSessionMap.get(userName);
	}
	
	public static List<String> getActiveUsers(){
		List<String> activeUsers = new ArrayList<String>(); 
		Iterator<Entry<String,Session>> userSessionIterator = userSessionMap.entrySet().iterator();
		while(userSessionIterator.hasNext()){
			Entry<String,Session> entry = userSessionIterator.next();
			if(entry.getValue()!=null)
				activeUsers.add(entry.getKey());
		}
		return activeUsers;
	}
}
