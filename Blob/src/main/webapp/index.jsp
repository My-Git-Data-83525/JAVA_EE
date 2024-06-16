<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page</title>
</head>
<body>
<div style="text-align: center;">
<h2>Login </h2>
<form method="post" action="Loginbean.jsp">
Email        :<input type="text" name="email"/><br/><br/>
Password:<input type="password" name="password"><br/><br/>
<input type="submit" value="Login" ><br/><br/>
Don't have an account? <a href="newuser.jsp">Register Here</a>

</form>
</div>
</body>
</html>