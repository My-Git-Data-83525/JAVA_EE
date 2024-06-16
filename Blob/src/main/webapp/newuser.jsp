<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register new user</title>
</head>
<body>
	<div style="text-align: center">
		<h2>Registration</h2>
		<form method="post" action="Registrationbean.jsp">
			First Name : <input type="text" name="fullName"/><br/><br/>
			Email : <input type="text" name="email"/><br/><br/>
			Password :<input type="password" name="password"/><br/><br/>
			Phone No: <input type="text" name="phoneNo"/><br/><br/> 		
			<input type="submit" style="margin-right: 20px" value="Register" >
			<a href="index.jsp">Login here</a>
		</form>
	</div>
</body>
</html>