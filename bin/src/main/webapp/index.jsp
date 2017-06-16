<!DOCTYPE HTML>
<html>
<head>
<link type="text/css" rel="stylesheet" href="login.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>
<script type="text/javascript">
      function login_req(){
    	  
    	  
    	  $(document).ready(function() {
    		var  name = $("#name").val();
				
				var request = $.ajax({
					  url: "rest/login",
					  type: "POST",
					  data: JSON.stringify({userId :  $("#name").val() , password : $("#password").val() }),
					  contentType: "application/json; charset=utf-8",
					    dataType: "json",
					  success: function (data) {
						  	
			             	if (data.status == true) {
			             		var token = data.token;
			             		$("#token").val(token);
			             		$("#form1").submit();
			             		//window.location.href = "/new_chat.jsp?token="+token+"&name="+name;
			             	}else{
			             		alert("Invalid Login");
			             	}
			            }
					});
    			
    			});
      }
         
      </script>

</head>
<body>

	<div class="container">
		<div class="login">
			<h1>Login</h1>
			<form method="post" id="form1" action="/new_chat.jsp">
				<p>
					<input type="text" id="name" name="name" value=""
						placeholder="Username or Email">
				</p>
				<p>
					<input type="password" name="password" id="password" value=""
						placeholder="Password">
				</p>
				<!-- <p class="remember_me">
					<label> <input type="checkbox" name="remember_me"
						id="remember_me"> Remember me on this computer
					</label>
					
				</p> -->
				<%
				if(request.getParameter("action")!=null && request.getParameter("action").equals("logout"))
					session.removeAttribute("token");
					session.removeAttribute("name");
				%>
				<input type="hidden" name="token" id="token"/>
				
				<p class="submit">
					<input type="button" name="commit" value="Login" onclick="login_req()">
				</p>
			</form>
		</div>

		<div class="login-help">
			<p>
				Forgot your password? <a href="#">Click here to reset it</a>.
			</p>
		</div>
	</div>

</body>
</html>
