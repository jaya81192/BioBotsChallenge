<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
<title>User Home</title>
</head>
<body>
	<form class="form-inline" action="UserHome" method="post">
		<table>
			<tr>	
				<td><input type="submit" class="button1" name = "first" value="Find user data"></td>
			</tr>
			<tr>	
				<td><input type="submit" class="button1" name = "second" value="Get user stats"></td>
			</tr>
		</table>
		<div style="text-align:center;">
			<input type="submit" class="button1" name = "third" value="Log out">
		</div>
	</form>
</body>
</html>