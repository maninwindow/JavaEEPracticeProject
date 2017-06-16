<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- All the files that are required -->
<link href="css/stylesheet.css" rel="stylesheet">
<script src="js/scriptsheet.js"></script>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<title>Insert title here</title>
</head>
<body>

<!-- LOGIN FORM -->
<div class="text-center" style="padding:50px 0">
	<div class="logo">login</div>
	<!-- Main Form -->
	<div class="login-form-1">
		<form id="register-form" name="form" onsubmit="return validateForm()" action="/Java_EE_Login_App/RegisterChecker" class="text-left" method="POST">
			<div class="login-form-main-message"></div>
			<div class="main-login-form">
				<div class="login-group">
					<div class="form-group">
						<label for="lg_username" class="sr-only">Username</label>
						<input type="text" class="form-control" id="lg_username" name="user">
					</div>
					<div class="form-group">
						<label for="lg_password" class="sr-only">Password</label>
						<input type="password" class="form-control" id="lg_password01" name="pass">
					</div>
					<div class="form-group">
						<label for="lg_password" class="sr-only">Confirm Password</label>
						<input type="password" class="form-control" id="lg_password02" onkeyup="checkPass(); return false;" name="rpass">
						<span id="confirmMessage" class="confirmMessage"></span>
					</div>
				</div>
				<button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
			</div>
		</form>
	</div>
	<!-- end:Main Form -->
</div>

<script>
//Login Validation
   	function validateForm() {
	    var x = document.form.user.value;
	    var y = document.form.pass.value;
	    if (x == "") {
	        alert("Please enter a username");
	        return false;
	    }
	    if (y == "") {
	        alert("Please enter a password");
	        return false;
	    }
	}
	
   	function checkPass()
   	{
   	    //Store the password field objects into variables ...
   	    var pass1 = document.getElementById('lg_password01');
   	    var pass2 = document.getElementById('lg_password02');
   	    //Store the Confimation Message Object ...
   	    var message = document.getElementById('confirmMessage');
   	    //Set the colors we will be using ...
   	    var goodColor = "#66cc66";
   	    var badColor = "#ff6666";
   	    //Compare the values in the password field 
   	    //and the confirmation field
   	    if(pass1.value == pass2.value){
   	        //The passwords match. 
   	        //Set the color to the good color and inform
   	        //the user that they have entered the correct password 
   	        pass2.style.backgroundColor = goodColor;
   	        message.style.color = goodColor;
   	        message.innerHTML = "Passwords Match!"
   	    }else{
   	        //The passwords do not match.
   	        //Set the color to the bad color and
   	        //notify the user.
   	        pass2.style.backgroundColor = badColor;
   	        message.style.color = badColor;
   	        message.innerHTML = "Passwords Do Not Match!"
   	    }
   	}  
</script>

</body>
</html>