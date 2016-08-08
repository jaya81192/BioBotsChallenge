<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
<title>Login</title>
</head>
<body>
	<h1>Welcome to BioBots</h1>
    <br>
    <br>
	<div id= "left" style="text-align:center;">
			<h1 class="headerStyle" style="color:#000066">Login</h1>
    		<form class="form-inline" role="form" action="Login" method="post">
    			<input type="text" name="username" class="form-control" placeholder="Printer Serial number" required autofocus>
    			<br>
    			<input type="password" name="userpassword" class="form-control" placeholder="Password" required>
    			<br>
    			<button class="button1" type="submit">Log in</button>
    		</form>
    </div>
    <div id = "right" style="text-align:center;">
    	<h1 class=headerStyle style="color:#000066">Not a user?</h1>
    	<form class="form-inline" role="form" action="SignUp" method="post">
    		<input type="text" name="username" class="form-control" placeholder="Printer Serial number" required autofocus>
    		<br>
    		<input type="password" name="userpassword" class="form-control" placeholder="Password" required>
    		<br>
    		<input type="text" name="email" class="form-control" placeholder="User Email" required>
    		<br>
    		<button class="button1" type="submit">Sign up</button>
    	</form>   		
    </div>
</body>
</html>