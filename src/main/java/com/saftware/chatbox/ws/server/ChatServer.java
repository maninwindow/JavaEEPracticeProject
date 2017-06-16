package com.saftware.chatbox.ws.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.saftware.chatbox.ws.registry.UserSessionRegistry;
import com.saftware.chatbox.ws.registry.UserTokenRegistry;

@ServerEndpoint(value="/ws/chat")
public class ChatServer {

	public static final long ONE_MINUTE = 1000 * 60;
	
	@OnOpen
	public void onOpen(Session session) throws IOException {
		session.setMaxIdleTimeout(ONE_MINUTE*5);
		System.out.println("WebSocket opened: " + session.getId());
		String queryString  = session.getQueryString();
		Map<String, String> queryMap = parseQueryString(queryString);
		String userName = queryMap.get("name");
		String token = queryMap.get("token");
		if(validateRequest(token,userName)){
			session.getUserProperties().put("userName", userName);
			UserSessionRegistry.mapUserWithSession(userName, session);
		}else{
			session.close(new CloseReason(CloseReason.CloseCodes.VIOLATED_POLICY, "Not valid user"));
		}
		
	}
	@OnMessage
	public void onMessage(String txt, Session session) throws IOException {
		System.out.println("Message received: " + txt);
		String[] parsedMessage = parseMessage(txt);
		String fromUser = (String)session.getUserProperties().get("userName");
		String toUser = parsedMessage[0];
		String message = parsedMessage[1];
		Session toUserSession = UserSessionRegistry.getSession(toUser);
		if(toUserSession!=null){
			System.out.println("Message sent to "+toUser);
			toUserSession.getBasicRemote().sendText("From "+fromUser+" : "+message);
			session.getBasicRemote().sendText("To "+toUser+" :"+message);
		}
		else{
			session.getBasicRemote().sendText(toUser+" is not active at the moment...");
		}
	}

	@OnClose
	public void onClose(CloseReason reason, Session session) {
		System.out.println("Closing a WebSocket due to " + reason.getReasonPhrase());
		String userName= (String)session.getUserProperties().get("userName");
		UserSessionRegistry.removeUserWithSession(userName);
	}
	
	
	private Map<String,String> parseQueryString(String queryString){
		Map<String,String> outputMap = new HashMap<String,String>();
		String[] entries = queryString.split("&");
		for(String entry :  entries){
			String[] parsedEntry = entry.split("=");
			if(parsedEntry.length == 2)
			outputMap.put(parsedEntry[0], parsedEntry[1]);
		}
		return outputMap;
	}
	
	
	private String[] parseMessage(String message){
		return message.split(":");
	}
	
	
	private boolean validateRequest(String token,String userId){
		if(UserTokenRegistry.getToken(userId).equals(token))
			return true;
		else
			return false;
	}
}
