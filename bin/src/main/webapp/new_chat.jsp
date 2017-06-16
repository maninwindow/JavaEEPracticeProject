<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Chat - Customer Module</title>
<link type="text/css" rel="stylesheet" href="style.css" />
<link type="text/css" rel="stylesheet" href="login.css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>
<script type="text/javascript">


<%
	if(session.getAttribute("name") == null || request.getParameter("name")!=null && request.getParameter("name")!= session.getAttribute("name")){
	String username = request.getParameter("name");
	session.setAttribute("name", username);
	}
	if(session.getAttribute("token") == null || request.getParameter("token")!=null &&  request.getParameter("token")!= session.getAttribute("token")){
	String token = (String)request.getParameter("token");
	session.setAttribute("token", token);
	}
%>
	var ws;
	
	function connect()
	{
	name = "<%=session.getAttribute("name")%>";
	token = "<%=session.getAttribute("token")%>";
	if (name && "WebSocket" in window)
    {
       
      // Let us open a web socket
      ws = new WebSocket("ws://localhost:8080/ws/chat?name="+name+"&token="+token);
      
    }else
    	alert("Web socket is not supported or name is empty");
		
	ws.onopen = function()
    {
       // Web Socket is connected, send data using send()
       //alert("Connected"); 
    };
		
    ws.onmessage = function (evt) 
    { 
       var received_msg = evt.data;
       document.getElementById("chatbox").innerHTML += "<br/>"+ received_msg;
       var element = document.getElementById("chatbox");
       element.scrollTop = element.scrollHeight;
    };
		
    ws.onclose = function()
    { 
       // websocket is closed.
       alert("Connection is closed...Please Reconnect...."); 
    };
 
		
	}
	function logout(){
		ws.close();
		name = document.getElementById("name").value;
		token = document.getElementById("token").value;
		request = $.ajax({
			  url: "rest/login?name="+name+"&token="+token,
			  type: "GET",
			  dataType: "json",
			  success: function (data) {				  	
				  		 
	            },complete: function(e,xhr,settings){
	            	if(e.status === 202){
	            		window.location.href = "/index.jsp?action=logout";
	                }
	            }
			});
		
	}
	function sendMessage(){
		
		message = document.getElementById("usermsg").value;
		to_user = document.getElementById("to_user").value;
		ws.send(to_user+":"+message);	
	}
	
	function get_active_users(){
   	 var list;
   	 request = $.ajax({
			  url: "rest/users/active",
			  type: "GET",
			  //contentType: "application/json; charset=utf-8",
			  dataType: "json",
			  success: function (data) {
				  	//alert("received response");
				  	$("#active_users ul").empty();
				  $.each(data, function( index, value ) {
			 		//alert( index + ": " + value );
			 		$("#active_users ul").append("<li><a href='#' onclick='javascript:set_to_user(this)'>"+value+"</a></li>");
			 		});
				  
				 
	            },complete: function(){
	            	
	            }
			});
		
   	 
    }
	
	function set_to_user(to_user){
		document.getElementById("to_user").value = to_user.innerText;
	}
	$(document).ready(function() {

		connect();
		get_active_users();
		setInterval(get_active_users,30000);
		//setTimeout(get_active_users(),5000);
	$('#usermsg').keydown(function(e) {
		var key = e.which;
		if (key == 13) {
		// As ASCII code for ENTER key is "13"
		//$('#message_form').submit(); // Submit form code
			sendMessage();
		}
		});
	});
</script>

</head>
<body>

	<div id="wrapper">
		<div id="menu">
			<p class="welcome">
				Welcome, <b><label id="display_name"><%=session.getAttribute("name")%></label></b>
			</p>
			<!-- <p class="welcome"><input type="text" id="user_name"/></p> -->
			<p class="logout">
				<a id="exit" href="javascript:logout()">Exit Chat</a>
			</p>
			<div style="clear: both"></div>
		</div>
		<input type="hidden" name="token" id="token"
			value="<%=session.getAttribute("token")%>" />
		<div id="active_users">
			<ul class="user_list">
				<li><a href='#' onclick="javascript:set_to_user(this)"><%=session.getAttribute("name")%></a></li>
				
			</ul>
		</div>
		<div id="chatbox"></div>

		<form id="message_form" action="javascript:send();">

				<input name="name" type="hidden" id="name" value="<%=session.getAttribute("name")%>"/> 
				<input name="to_user" type="hidden" id="to_user" /> 
			<input name="usermsg" type="text" id="usermsg" size="63"
				placeholder="Message"  />
			<!--  <input name="submitmsg" type="submit"  id="submitmsg" value="Send" /> -->
		</form>
	</div>
</body>
</html>
