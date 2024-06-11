<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New user</title>
</head>
<body>
<h1>Registration</h1>
<form method="post" action="Registerbean.jsp">
First Name: <input type="text" name="fname"/><br/><br/>
Last Name: <input type="text" name="lname"/><br/><br/>
Email: <input type="email" name="email"/><br/><br/>
Password: <input type="password" name="password"/><br/><br/>
DOB: <input type="date" name="date"/><br/><br/>
<input type="submit" name="Sign-Up"/><br/><br/>
</form>
</body>
</html>